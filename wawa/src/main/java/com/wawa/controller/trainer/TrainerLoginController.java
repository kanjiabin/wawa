package com.wawa.controller.trainer;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wawa.bean.trainer.TrainerLoginBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "教练登录")
@RestController
@RequestMapping(value = "/trainer",produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainerLoginController {

	private final Logger logger = LoggerFactory.getLogger(TrainerLoginController.class);

	@ApiOperation(value = "教练登录", notes = "根据用户名和验证码来注册")
	@ApiImplicitParam(name = "loginParam", value = "注册教练信息", required = true, dataType = "TrainerLoginBean")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, String> login(@RequestBody TrainerLoginBean loginParam) {
		String phoneNumber =loginParam.getPhoneNumber();
		String verifyCode =loginParam.getVerifyCode();
		logger.info("/phoneNumber :" + phoneNumber + ", verifyCode:" + verifyCode);
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "教练成功.");
		return resultMap;
	}

}
