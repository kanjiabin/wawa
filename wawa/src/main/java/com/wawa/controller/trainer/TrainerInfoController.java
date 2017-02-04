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

import com.wawa.bean.trainer.TrainerInfoBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "教练信息")
@RestController
@RequestMapping(value = "/trainer",produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainerInfoController {

	private final Logger logger = LoggerFactory.getLogger(TrainerInfoController.class );
	
	
	@ApiOperation(value = "教练信息更新", notes = "在APP个人中心修改教练信息")
	@ApiImplicitParam(name = "trainerInfoParam", value = "教练信息", required = true, dataType = "TrainerInfoBean")
	@RequestMapping(value = "/updateTrainerInfo", method = RequestMethod.POST)
	public Map<String, String> updateTrainerInfo(@RequestBody TrainerInfoBean trainerInfoParam ){
		
		String phoneNumber=trainerInfoParam.getPhoneNumber();
		String name=trainerInfoParam.getName();
		String trainerId=trainerInfoParam.getTrainerId();
		String gender=trainerInfoParam.getGender();
		String img=trainerInfoParam.getImg();
		String carCount=trainerInfoParam.getCarCount();
		String defaultCountOneCar=trainerInfoParam.getDefaultCountOneCar();
		
		logger.info("/updateTrainerInfo : name: " + name + ", phoneNumber:" + phoneNumber + ", trainerId:" + trainerId + ", gender:" + gender + ", img:" + img +" ,carCount:"+carCount+ " ,defaultCountOneCar:"+defaultCountOneCar); 
		
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "教练信息更新成功.");
		return resultMap;
		
	}
	
}
