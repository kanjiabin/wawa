package com.wawa.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestResultGenerator {
	
	private final Logger logger = LoggerFactory.getLogger(RestResultGenerator.class);
	
	 /**
     * 生成响应成功的(不带正文)的结果
     *
     * @param message 成功提示信息
     * @return ResponseResult
     */
    public static ResponseResult genResult(String message) {

        ResponseResult responseResult = ResponseResult.newInstance();
        responseResult.setMessage(message);

        return responseResult;
    }

    /**
     * 生成响应成功(带正文)的结果
     *
     * @param data    结果正文
     * @param message 成功提示信息
     * @return ResponseResult<T>
     */
    public static <T> ResponseResult<T> genResult(T data, String message) {

        ResponseResult<T> result = ResponseResult.newInstance();
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    /**
     * 生成响应失败的结果
     *
     * @param message 自定义错误信息
     * @return ResponseResult
     */
    public static ResponseResult genErrorResult(String message) {

        ResponseResult result = ResponseResult.newInstance();
        result.setMessage(message);
        return result;
    }

    /**
     * 生成响应失败(带errorCode)的结果
     *
     * @param responseErrorEnum 失败信息
     * @return ResponseResult
     */
    public static ResponseResult genErrorResult(String errorCode,String errorMessage) {

        ResponseResult result = ResponseResult.newInstance();
        result.setErrorInfo(errorCode,errorMessage);
        return result;
    }
}
