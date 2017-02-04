package com.wawa.bean.trainer;

public class UpdatePlanBean {
	private String practiceDate;//练车日期
	private String oldTraineeId;//学员id
	private String newTraineeId;//学员id
	public String getPracticeDate() {
		return practiceDate;
	}
	public void setPracticeDate(String practiceDate) {
		this.practiceDate = practiceDate;
	}
	public String getOldTraineeId() {
		return oldTraineeId;
	}
	public void setOldTraineeId(String oldTraineeId) {
		this.oldTraineeId = oldTraineeId;
	}
	public String getNewTraineeId() {
		return newTraineeId;
	}
	public void setNewTraineeId(String newTraineeId) {
		this.newTraineeId = newTraineeId;
	}

}
