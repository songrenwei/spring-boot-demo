package com.srw.common.exception;

import com.srw.common.constant.Constants;

/**
 * @Description: 运行时异常基类
 * @Author: songrenwei
 * @Date: 2020/10/14/15:27
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 8695520150333346203L;

    BaseException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * @return 自定义异常code
     */
    public String getErrorCode() {
        if (Constants.EXCEPTION_CODE_MAP.containsKey(getClass().getSimpleName())) {
            return Constants.EXCEPTION_CODE_MAP.get(getClass().getSimpleName()).toString();
        } else {
            return null;
        }
    }

}
