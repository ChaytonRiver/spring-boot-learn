package com.chayton.dynamic.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-04 15:23
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    /**
     * 每次请求动态请求哪一个数据源
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSource();
    }
}