package com.srw.common.annotation.handler;

import com.srw.common.annotation.MultiValueAnnotation;
import com.srw.common.annotation.service.TestService;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2020/12/31 16:14
 */
public class AnnotationHandler {

    public static void track(Class<?> c) {

        for (Method m : c.getDeclaredMethods()) {
            MultiValueAnnotation annotation = m.getAnnotation(MultiValueAnnotation.class);
            if (annotation != null) {
                System.out.println("name:" + annotation.name() +
                        "\n num:" + annotation.num());
            }
        }
    }

    public static void main(String[] args) {
        track(TestService.class);
    }

}
