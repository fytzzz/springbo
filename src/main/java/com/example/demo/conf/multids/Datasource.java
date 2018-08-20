package com.example.demo.conf.multids;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: chaiz
 * @Description: TODO
 * @date: 2018年5月25日 上午11:31:44
 * @version: v1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Datasource {
    String value() default "datasource1";
}
