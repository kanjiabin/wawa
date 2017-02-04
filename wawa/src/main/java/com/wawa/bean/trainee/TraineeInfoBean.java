package com.wawa.bean.trainee;

public class TraineeInfoBean {
	
	private String phoneNumber;//学员手机号
	private String name;//学员姓名
	private String trainerId;//教练id
	private String traineeId;//学员id
	private String gender;//学员性别
	private String img;//学员头像
	private String practiceScore;//学员系统打分
	private String examsDate;//考试日期

	public String getExamsDate() {
		return examsDate;
	}
	public void setExamsDate(String examsDate) {
		this.examsDate = examsDate;
	}
	public String getPracticeScore() {
		return practiceScore;
	}
	public void setPracticeScore(String practiceScore) {
		this.practiceScore = practiceScore;
	}
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
	public String getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(String traineeId) {
		this.traineeId = traineeId;
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

}
