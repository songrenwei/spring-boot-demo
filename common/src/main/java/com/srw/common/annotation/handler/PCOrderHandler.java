package com.srw.common.annotation.handler;

import com.srw.common.annotation.OrderHandlerType;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2020/12/31 17:11
 */
@OrderHandlerType(source = "pc")
@Component
public class PCOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("处理PC端订单");
    }
}