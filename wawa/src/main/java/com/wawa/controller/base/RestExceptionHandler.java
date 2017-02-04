package com.wawa.controller.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
	
    /**
     * bean校验未通过异常
     *
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> ResponseResult<T> illegalParamsExceptionHandler(MethodArgumentNotValidException e) {
    	List<ObjectError> errors = e.getBindingResult().getAllErrors();
    	String message="";
    	for(ObjectError item : errors){
    		message =  item.getDefaultMessage()+","+message;
    	}
    	int length = message.length();
    	if(1<length){
    		message = message.substring(0, length-1);
    	}
    	logger.info("error message is :" + message);
        return RestResultGenerator.genErrorResult("0001",message);
    }
	
	 /**
     * 统一的rest接口异常处理器
     *
     * @param e 捕获的异常
     * @return 异常信息
     */
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private <T> ResponseResult<T> globalExceptionHandler(Exception e) {
    	System.out.println(e.getMessage());
        return RestResultGenerator.genErrorResult("9999","内部错误");
    }


}
