package com.wawa.service.common.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wawa.dao.common.VerifyCodeDAO;
import com.wawa.service.common.VerifyCodeService;
import com.wawa.util.VerifyCodeUtil;

@Service
@Transactional
public class VerifyCodeServiceImpl implements VerifyCodeService {
	
	private final Logger logger = LoggerFactory.getLogger( VerifyCodeServiceImpl.class );

	@Autowired
	VerifyCodeDAO verifyCodeDAO;
	
	/**
	 * 1、生成验证码
	 * 2、存储数据库
	 * 3、发送短信
	 */
	@Override
	public boolean sendVerifyCode(String phoneNumber) {
		String verifyCode = VerifyCodeUtil.verifyCode(6);
		logger.info("sendVerifyCode : { phoneNumber:"+phoneNumber+" ,verifyCode:"+verifyCode+"}");
		Map<String, Object> param = new HashMap<>();
		param.put("phoneNumber", phoneNumber);
		param.put("verifyCode", verifyCode);
		int dbResult =  verifyCodeDAO.insertVerifyCode(param);
		logger.info("dbResult : " + dbResult);
		boolean sendResult = false;
		if(1== dbResult){
			String msgContent =  "您的验证码为：" + verifyCode + "，验证码切勿告知他人。";
			sendResult = VerifyCodeUtil.sendMessage("86"+phoneNumber, msgContent);
		}
		return sendResult;
	}

}
