package com.wawa.bean.common;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class VerifyCodeBean {
	
	@NotEmpty
	@Length(min=8,max = 11, message = "只能输入11个数字")
	private String phoneNumber;//手机号码

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
