package com.srw.proxy;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2021/3/17 16:51
 */
@Component
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("业务逻辑...");
    }

    @Override
    public void request2() {
        System.out.println("业务逻辑2...");
    }

}
