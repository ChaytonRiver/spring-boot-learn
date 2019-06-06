package com.chayton.dynamic.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-04 17:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD
})
public @interface DynamicDataSource {
    String name() default "master";
}
