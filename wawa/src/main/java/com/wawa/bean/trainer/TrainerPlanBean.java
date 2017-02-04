package com.wawa.bean.trainer;

public class TrainerPlanBean {
	
	private String trainerId;//教练id
	private String practiceDate;//练车日期
	private String traineeId;//学员id
	private String traineeName;//学员姓名
	private String traineePhoneNumber;//学员手机号
	private String traineeImg;//学员头像
	private String traineePracticeScore;//学员得分
	private String traineeExamsDate;//学员考试日期
	private String planStatus;//约车状态
	
	public String getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(String traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineePhoneNumber() {
		return traineePhoneNumber;
	}
	public void setTraineePhoneNumber(String traineePhoneNumber) {
		this.traineePhoneNumber = traineePhoneNumber;
	}
	public String getTraineeImg() {
		return traineeImg;
	}
	public void setTraineeImg(String traineeImg) {
		this.traineeImg = traineeImg;
	}
	public String getTraineePracticeScore() {
		return traineePracticeScore;
	}
	public void setTraineePracticeScore(String traineePracticeScore) {
		this.traineePracticeScore = traineePracticeScore;
	}
	public String getTraineeExamsDate() {
		return traineeExamsDate;
	}
	public void setTraineeExamsDate(String traineeExamsDate) {
		this.traineeExamsDate = traineeExamsDate;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getPracticeDate() {
		return practiceDate;
	}
	public void setPracticeDate(String practiceDate) {
		this.practiceDate = practiceDate;
	}

	
}
