package com.wawa.controller.trainer;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wawa.bean.trainer.TrainerInviteBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "练车邀请")
@RestController
@RequestMapping(value = "/trainer",produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainerInviteController {
	
	
	private final Logger logger = LoggerFactory.getLogger( TrainerInviteController.class );
	
	@ApiOperation(value = "发送练车邀请", notes = "发送练车邀请")
	@ApiImplicitParam(name = "trainerInviteParam", value = "学员id及练车日期", required = true, dataType = "TrainerInviteBean")
	@RequestMapping(value = "/inviteTrainee", method = RequestMethod.POST)
	public Map<String,String> inviteTrainee(@RequestBody TrainerInviteBean trainerInviteParam){
		
		String traineeId = trainerInviteParam.getTraineeId();//学员id
		String practiceDate = trainerInviteParam.getPracticeDate();//练车日期
		
		logger.info("/inviteTrainee : {traineeId: " + traineeId+" ,practiceDate:"+practiceDate+"}"); 
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "发送练车邀请成功.");
		return resultMap;
		
	}
	
	

}
