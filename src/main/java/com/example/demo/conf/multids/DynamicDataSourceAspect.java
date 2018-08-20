package com.example.demo.conf.multids;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * @author: chaiz
 * @Description: 使用AOP切面方式动态的切换数据源
 * @date: 2018年5月25日 下午1:51:27
 * @version: v1.0.0
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(Datasource)")
    public void beforeSwitchDS(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@Datasource注解
            if (method.isAnnotationPresent(Datasource.class)) {
                Datasource annotation = method.getAnnotation(Datasource.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("@annotation(Datasource)")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
