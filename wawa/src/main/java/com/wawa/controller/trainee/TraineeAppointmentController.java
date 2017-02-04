package com.wawa.controller.trainee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wawa.bean.trainee.TraineeAppointmentBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "学员约车")
@RestController
@RequestMapping(value = "/trainee",produces = MediaType.APPLICATION_JSON_VALUE)
public class TraineeAppointmentController {

	private final Logger logger = LoggerFactory.getLogger( TraineeAppointmentController.class) ;
	
	@ApiOperation(value = "学员申请约车", notes = "在APP预约练车页输入预约时间及练习科目")
	@ApiImplicitParam(name = "traineeAppointmentParam", value = "约车信息", required = true, dataType = "TraineeAppointmentBean")
	@RequestMapping(value = "/appointment", method = RequestMethod.POST)
	public Map<String, String> appointment(@RequestBody TraineeAppointmentBean traineeAppointmentParam ){
		String appointmentDate = traineeAppointmentParam.getAppointmentDate();//预约练车日期
		String traineeId = traineeAppointmentParam.getTraineeId();//学员id
		String examsType = traineeAppointmentParam.getExamsType();//考试科目
		logger.info("/traineeAppointment : {traineeId: " + traineeId + ", examsType:" + examsType + ", appointmentDate:" + appointmentDate +"}"); 
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "学员约车成功.");
		return resultMap;
	}
	
	@ApiOperation(value = "学员取消申请预约", notes = "在APP预约练车记录中选择预约记录进行取消")
	@ApiImplicitParam(name = "traineeAppointmentParam", value = "约车信息", required = true, dataType = "TraineeAppointmentBean")
	@RequestMapping(value = "/cancelAppointment", method = RequestMethod.POST)
	public Map<String, String> cancelAppointment(@RequestBody TraineeAppointmentBean traineeAppointmentParam ){
		String appointmentSequence = traineeAppointmentParam.getAppointmentSequence();//预约编号
	    logger.info("/cancelAppointment : {appointmentSequence: " + appointmentSequence+"}"); 
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "约车申请取消成功.");
		return resultMap;
	}
	
	@ApiOperation(value = "学员预约记录列表", notes = "在APP中查询学员预约记录")
	@RequestMapping(value = "/appointmentList", method = RequestMethod.GET)
	public List<TraineeAppointmentBean> appointmentList(){
	    logger.info("/appointmentList : { }"); 
	    List<TraineeAppointmentBean> result = new ArrayList<>();
		TraineeAppointmentBean bean1 = new TraineeAppointmentBean();
		bean1.setTraineeId("1");
		bean1.setExamsType("科目2");
		bean1.setAppointmentDate("2017-02-20");
		bean1.setAppointmentSequence("sequence1");
		bean1.setStatus("0");
		TraineeAppointmentBean bean2 = new TraineeAppointmentBean();
		bean2.setTraineeId("1");
		bean2.setExamsType("科目2");
		bean2.setAppointmentDate("2017-02-21");
		bean2.setAppointmentSequence("sequence2");
		bean2.setStatus("0");
		TraineeAppointmentBean bean3 = new TraineeAppointmentBean();
		bean3.setTraineeId("1");
		bean3.setExamsType("科目2");
		bean3.setAppointmentDate("2017-02-22");
		bean3.setAppointmentSequence("sequence3");
		bean3.setStatus("0");
		TraineeAppointmentBean bean4 = new TraineeAppointmentBean();
		bean4.setTraineeId("1");
		bean4.setExamsType("科目2");
		bean4.setAppointmentDate("2017-02-24");
		bean4.setAppointmentSequence("sequence4");
		bean4.setStatus("0");
		result.add(bean1);
		result.add(bean2);
		result.add(bean3);
		result.add(bean4);
		return result;
	}
	
	
}
