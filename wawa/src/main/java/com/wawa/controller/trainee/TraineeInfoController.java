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

import com.wawa.bean.trainee.TraineeInfoBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "学员信息")
@RestController
@RequestMapping(value = "/trainee",produces = MediaType.APPLICATION_JSON_VALUE)
public class TraineeInfoController {
	
	private final Logger logger = LoggerFactory.getLogger( TraineeInfoController.class );
	
	@ApiOperation(value = "学员信息更新", notes = "在APP个人中心修改学员信息")
	@ApiImplicitParam(name = "traineeInfoParam", value = "学员信息", required = true, dataType = "TraineeInfoBean")
	@RequestMapping(value = "/updateTraineeInfo", method = RequestMethod.POST)
	public Map<String, String> updateTraineeInfo(@RequestBody TraineeInfoBean traineeInfoParam ){
		
		String phoneNumber=traineeInfoParam.getPhoneNumber();
		String name=traineeInfoParam.getName();
		String trainerId=traineeInfoParam.getTrainerId();
		String traineeId = traineeInfoParam.getTraineeId();
		String gender=traineeInfoParam.getGender();
		String img=traineeInfoParam.getImg();
	
		
		logger.info("/updateTraineeInfo : name: " + name + ", phoneNumber:" + phoneNumber + ", trainerId:" + trainerId + ", gender:" + gender + ", img:" + img +" ,traineeId:"+traineeId); 
		
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "学员信息更新成功.");
		return resultMap;
		
	}
	
	
	@ApiOperation(value = "根据学员id查看详细信息", notes = "根据学员id查看详细信息")
	@ApiImplicitParam(name = "traineeInfoParam", value = "学员信息", required = true, dataType = "TraineeInfoBean")
	@RequestMapping(value = "/getTraineeInfoById", method = RequestMethod.POST)
	public TraineeInfoBean getTraineeInfoById(@RequestBody TraineeInfoBean traineeInfoParam){
		String traineeId = traineeInfoParam.getTraineeId();
		logger.info("/getTraineeInfoById :{ traineeId: " + traineeId +"}"); 
		TraineeInfoBean bean1 = new TraineeInfoBean();
		bean1.setTraineeId("1");
		bean1.setName("刘德华");
		bean1.setPhoneNumber("13511118888");
		bean1.setPracticeScore("99");
		bean1.setExamsDate("2017-03-02");
		bean1.setTrainerId("99");
		bean1.setImg("a.img");
		return bean1;
	}
	

	@ApiOperation(value = "根据教练id查询所有学员", notes = "根据教练id查询所有学员")
	@ApiImplicitParam(name = "traineeInfoParam", value = "学员信息", required = true, dataType = "TraineeInfoBean")
	@RequestMapping(value = "/getTraineesByTrainerid", method = RequestMethod.POST)
	public List<TraineeInfoBean> getTraineesByTrainerid(@RequestBody TraineeInfoBean traineeInfoParam){
		String trainerId = traineeInfoParam.getTrainerId();//教练id
		logger.info("/getTraineesByTrainerid :{ trainerId: " + trainerId +"}"); 
		List<TraineeInfoBean> resultList = new ArrayList<>();
		TraineeInfoBean bean1 = new TraineeInfoBean();
		bean1.setTraineeId("1");
		bean1.setName("刘德华");
		bean1.setPhoneNumber("13511118888");
		bean1.setPracticeScore("99");
		bean1.setExamsDate("2017-03-02");
		bean1.setTrainerId("99");
		bean1.setImg("a.img");
		resultList.add(bean1);
		return resultList;
	}
}
