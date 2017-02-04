package com.wawa.bean.trainee;

/**
 * 预约练车
 * @author blany
 *
 */
public class TraineeAppointmentBean {
	
	private String appointmentDate;//预约练车日期
	private String traineeId;//学员id
	private String examsType;//考试科目
	private String appointmentSequence;//预约编号
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAppointmentSequence() {
		return appointmentSequence;
	}
	public void setAppointmentSequence(String appointmentSequence) {
		this.appointmentSequence = appointmentSequence;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(String traineeId) {
		this.traineeId = traineeId;
	}
	public String getExamsType() {
		return examsType;
	}
	public void setExamsType(String examsType) {
		this.examsType = examsType;
	}

}
