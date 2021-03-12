package com.srw;

import com.srw.common.annotation.handler.Order;
import com.srw.common.annotation.handler.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: renwei.song
 * @Date: 2020/12/31 17:21
 */
@SpringBootTest
public class StrategyTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        Order order = new Order();
        order.setSource("pc");
        orderService.orderService(order);

    }

}
