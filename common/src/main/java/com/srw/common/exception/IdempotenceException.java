package com.srw.common.exception;

/**
 * @Description: 幂等异常
 * @Author: songrenwei
 * @Date: 2020/12/10/11:23
 */
public class IdempotenceException extends BaseException {

    public IdempotenceException(String errorMessage) {
        super(errorMessage);
    }
}
