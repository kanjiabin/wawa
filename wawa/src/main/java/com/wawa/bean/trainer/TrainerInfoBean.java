package com.wawa.bean.trainer;

public class TrainerInfoBean {
	
	private String phoneNumber;//教练手机号
	private String name;//教练姓名
	private String trainerId;//教练id
	private String gender;//教练性别
	private String img;//教练头像
	private String carCount;//教练拥有的车辆数目 默认是1
	private String defaultCountOneCar;//一台教练车安排的长次数 默认是2
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCarCount() {
		return carCount;
	}
	public void setCarCount(String carCount) {
		this.carCount = carCount;
	}
	public String getDefaultCountOneCar() {
		return defaultCountOneCar;
	}
	public void setDefaultCountOneCar(String defaultCountOneCar) {
		this.defaultCountOneCar = defaultCountOneCar;
	}

}
