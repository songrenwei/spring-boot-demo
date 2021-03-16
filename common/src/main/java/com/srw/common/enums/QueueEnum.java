package com.srw.common.enums;

import lombok.Getter;

/**
 * 消息队列枚举配置
 */
@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("order.direct", "order.cancel", "order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("order.direct.ttl", "order.cancel.ttl", "order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String queueName;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String queueName, String routeKey) {
        this.exchange = exchange;
        this.queueName = queueName;
        this.routeKey = routeKey;
    }

}
