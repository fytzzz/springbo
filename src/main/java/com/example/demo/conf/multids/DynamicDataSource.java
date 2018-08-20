package com.example.demo.conf.multids;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author: chaiz
 * @Description: TODO
 * @date: 2018年5月25日 上午11:57:36
 * @version: v1.0.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为"+DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
