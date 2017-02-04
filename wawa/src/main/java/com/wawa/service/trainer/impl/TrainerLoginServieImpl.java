package com.wawa.service.trainer.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wawa.service.trainer.TrainerLoginServie;

@Service
public class TrainerLoginServieImpl implements TrainerLoginServie {

	private final Logger logger = LoggerFactory.getLogger( TrainerLoginServieImpl.class );

	@Transactional
	@Override
	public Map<String, String> login(String phoneNumber, String verifyCode) {
		
		return null;
	}
	
	
}
