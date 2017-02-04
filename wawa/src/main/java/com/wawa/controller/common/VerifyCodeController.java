package com.wawa.controller.common;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wawa.bean.common.VerifyCodeBean;
import com.wawa.service.common.VerifyCodeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "验证码发送")
@RestController
@RequestMapping(value = "/common",produces = MediaType.APPLICATION_JSON_VALUE)
public class VerifyCodeController {
	
	private final Logger logger = LoggerFactory.getLogger(VerifyCodeController.class);
	
	@Autowired
	VerifyCodeService verifyCodeService;
	
	@ApiOperation(value = "发送验证码", notes = "根据手机号来发送验证码")
	@ApiImplicitParam(name = "verifyCodeParam", value = "需要验证码的手机号", required = true, dataType = "VerifyCodeBean")
	@PostMapping("/getVerifyCode")
	public Map<String, String> getVerifyCode(@Valid @RequestBody VerifyCodeBean verifyCodeParam) {
		String phoneNumber =verifyCodeParam.getPhoneNumber();
		logger.info("/getVerifyCode :{phoneNumber: " + phoneNumber+"}");
		Map<String, String> resultMap = new HashMap<>();
		String resCode = "0001";
		String resDes = "验证码发送失败。";
		boolean result = verifyCodeService.sendVerifyCode(phoneNumber);
		if(result){
			resCode = "0000";
			resDes = "验证码发送成功。";
		}
		resultMap.put("resCode",resCode);
		resultMap.put("resDes", resDes);
		return resultMap;
	}

}
