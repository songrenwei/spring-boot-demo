package com.srw.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 多值注解
 * @Author: renwei.song
 * @Date: 2020/12/31 16:06
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiValueAnnotation {
    String name();
    int num() default 0;
}
