package com.chayton.dynamic.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-04 15:53
 */

public class DynamicDataSourceContextHolder {

    /**
     * 线程本地环境
     */
    private static final ThreadLocal<String> contextHolders = new ThreadLocal<>();

    /**
     * 数据源列表
     */
    public static List<String> dataSourceIds = new ArrayList<>();

    /**
     * 设置数据源
     *
     * @param customerType
     */
    public static void setDataSource(String customerType) {
        contextHolders.set(customerType);
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static String getDataSource() {
        return contextHolders.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDataSource() {
        contextHolders.remove();
    }

    /**
     * 判断指定DataSrouce当前是否存在
     *
     * @param dataSourceId
     * @return
     * @author SHANHY
     * @create 2016年1月24日
     */
    public static boolean containsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }
}