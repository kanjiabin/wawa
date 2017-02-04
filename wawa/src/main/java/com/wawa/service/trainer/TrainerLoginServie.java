package com.wawa.service.trainer;

import java.util.Map;

public interface TrainerLoginServie {
	Map<String,String> login(String phoneNumber,String verifyCode);
}
