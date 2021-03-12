package com.srw.common.annotation.handler;

import com.srw.common.annotation.OrderHandlerType;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2020/12/31 17:11
 */
@OrderHandlerType(source = "mobile")
@Component
public class MobileOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("处理移动端订单");
    }
}