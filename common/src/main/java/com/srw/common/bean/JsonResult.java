package com.srw.common.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.srw.common.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 实体类转化
 * @Author: songrenwei
 * @Date: 2020/10/14/15:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = -113486665877014274L;
    private static String successMsg = "success";

    @JsonProperty("code")
    private String status;

    @JsonProperty("msg")
    private String message;

    private T data;

    public static <T> JsonResult<T> successResponse(T data) {
        return new JsonResult<>(Constants.RESULT_SUCCESS_CODE, successMsg, data);
    }

    public static <T> JsonResult<T> errorResponse(String errorMessage) {
        return new JsonResult<>(Constants.RESULT_ERROR_CODE, errorMessage, null);
    }

    public static <T> JsonResult<T> errorResponse(String status, String errorMessage) {
        return new JsonResult<>(status, errorMessage, null);
    }

}
