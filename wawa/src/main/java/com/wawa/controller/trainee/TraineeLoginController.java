package com.wawa.controller.trainee;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wawa.bean.trainee.TraineeLoginBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@Api( value = "学员登录")
@RestController
@RequestMapping(value = "/trainee",produces = MediaType.APPLICATION_JSON_VALUE)
public class TraineeLoginController {


	private final Logger logger = LoggerFactory.getLogger(TraineeLoginController.class);

	@ApiOperation(value = "学员登录", notes = "根据用户名和验证码来注册")
	@ApiImplicitParam(name = "loginParam", value = "注册学员信息", required = true, dataType = "TraineeLoginBean")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, String> login(@RequestBody TraineeLoginBean loginParam) {
		String phoneNumber =loginParam.getPhoneNumber();
		String verifyCode =loginParam.getVerifyCode();
		logger.info("/phoneNumber :" + phoneNumber + ", verifyCode:" + verifyCode);
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "学员成功.");
		return resultMap;
	}


}
