package com.chayton.dynamic.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-04 17:11
 */
@Aspect
/**
 * 保证该AOP在@Transactional之前执行
 */
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /**
     *
     * @param point
     * @param dataSource
     * @throws Throwable
     */
    @Before(value = "@annotation(dataSource)")
    public void changeDataSource(JoinPoint point, DynamicDataSource dataSource) throws Throwable {
        String dsId = dataSource.name();
        if (!DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", dataSource.name(), point.getSignature());
        } else {
            logger.debug("Use DynamicDataSource : {} > {}", dataSource.name(), point.getSignature());
            DynamicDataSourceContextHolder.setDataSource(dataSource.name());
        }
    }

    @After(value = "@annotation(dataSource)")
    public void restoreDataSource(JoinPoint point, DynamicDataSource dataSource) {
        logger.debug("Revert DynamicDataSource : {} > {}", dataSource.name(), point.getSignature());
        DynamicDataSourceContextHolder.clearDataSource();
    }
}