package com.wawa.controller.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 统一请求返回结果model
 *
 * @author kui.liu
 * @since 2014/09/24 下午10:27
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult<T> {

	private String errorCode;
    private String message;
    private T data;

    /* 不提供直接设置errorCode的接口，只能通过setErrorInfo方法设置错误信息 */
    

    private ResponseResult() {
    }

    public static <T> ResponseResult<T> newInstance() {
        return new ResponseResult<>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    // 设置错误信息
    public void setErrorInfo(String errorCode,String errorMessage) {
        this.errorCode = errorCode;
        this.message =errorMessage;
    }
}
