package com.srw.common.annotation.service;

import com.srw.common.annotation.MultiValueAnnotation;
import com.srw.common.annotation.MyAnnotation;
import com.srw.common.annotation.SingleValueAnnotation;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2020/12/31 15:59
 */
public class TestService {

    @MyAnnotation
    public void runTest() {
        System.out.println("annotation test");
    }

    @SingleValueAnnotation(name = "test")
    public void testSingleValue() {

    }

    @MultiValueAnnotation(name = "test")
    public void testMultiValue() {

    }

    public static void main(String[] args) {
        TestService test = new TestService();
        test.testMultiValue();
    }

}
