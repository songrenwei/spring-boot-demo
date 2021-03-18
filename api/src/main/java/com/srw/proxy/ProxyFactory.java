package com.srw.proxy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2021/3/17 16:52
 */
@Component
@RequiredArgsConstructor
public class ProxyFactory {

    private final Subject target;// 维护一个目标对象

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("jdk proxy:执行目标对象方法前增强！！！");
                    // 执行目标对象方法
                    method.invoke(target, args);
                    System.out.println("jdk proxy:执行目标对象方法后增强！！！");
                    return null;
                });
    }
}
