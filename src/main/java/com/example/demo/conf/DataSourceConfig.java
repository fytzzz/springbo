package com.example.demo.conf;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author: chaiz
 * @Description: 多数据源配置
 * @date: 2018年5月25日上午11:33:33
 * @version: v1.0.0
 */
@Configuration
public class DataSourceConfig {
    //数据源1
    @Bean(name = "datasource1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource dataSource1() {
    	DataSource ds = DataSourceBuilder.create().type(DruidDataSource.class).build();
        return ds;
    }
}
