package com.srw.common.exception;

/**
 * @Description: 业务异常
 * @Author: songrenwei
 * @Date: 2020/10/14/15:35
 */
public class BusinessException extends BaseException {

    public BusinessException(String errorMessage) {
        super(errorMessage);
    }
}
