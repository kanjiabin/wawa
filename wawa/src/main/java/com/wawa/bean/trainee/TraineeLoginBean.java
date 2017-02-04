package com.wawa.bean.trainee;

public class TraineeLoginBean {
	
	private String verifyCode;//短信验证码
	private String phoneNumber;//手机号码
	
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}
