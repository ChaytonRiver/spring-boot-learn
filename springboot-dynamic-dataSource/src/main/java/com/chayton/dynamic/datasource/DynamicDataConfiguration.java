package com.chayton.dynamic.datasource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-05 14:39
 */
@Configuration
@Import(DynamicDataSourceRegister.class)
@ComponentScan(basePackages = "com.chayton.dynamic.datasource")
public class DynamicDataConfiguration {
}
