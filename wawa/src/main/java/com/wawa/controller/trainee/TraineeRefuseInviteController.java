package com.wawa.controller.trainee;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wawa.bean.trainee.TraineeAcceptInviteBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "学员拒绝练车邀请")
@RestController
@RequestMapping(value = "/trainee",produces = MediaType.APPLICATION_JSON_VALUE)
public class TraineeRefuseInviteController {
	
	private final Logger logger = LoggerFactory.getLogger( TraineeRefuseInviteController.class );
	

	@ApiOperation(value = "学员拒绝教练的练车通知", notes = "学员拒绝教练的练车通知")
	@ApiImplicitParam(name = "refuseInviteParam", value = "学员拒绝教练的练车通知", required = true, dataType = "TraineeAcceptInviteBean")
	@RequestMapping(value = "/refuseInvite", method = RequestMethod.POST)
	public Map<String,String> refuseInvite(@RequestBody TraineeAcceptInviteBean refuseInviteParam){
		String traineeId = refuseInviteParam.getTraineeId();//学员id
		String trainerNotifySequence = refuseInviteParam.getTrainerNotifySequence();//练车通知编号
		logger.info("/acceptInvite : {traineeId : " + traineeId + ", trainerNotifySequence:" + trainerNotifySequence+"}");
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "学员已拒绝该次练车的邀请.");
		return resultMap;
	}
}
