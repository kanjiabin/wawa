package com.wawa.controller.trainee;

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

import com.wawa.bean.trainee.PracticeItem;
import com.wawa.bean.trainee.TraineePracticeScoreBean;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "学员自己打分")
@RestController
@RequestMapping(value = "/trainee",produces = MediaType.APPLICATION_JSON_VALUE)
public class TraineeUpdatePracticeScoreController {
	
	private final Logger logger = LoggerFactory.getLogger( TraineeUpdatePracticeScoreController.class );
	
	@ApiOperation(value = "学员自己打分", notes = "根据当日练车情况自己打分")
	@ApiImplicitParam(name = "practiceScoreParam", value = "学员练习科目细分", required = true, dataType = "TraineePracticeScoreBean")
	@RequestMapping(value = "/updatePracticeScore", method = RequestMethod.POST)
	public Map<String,String> updatePracticeScore(@RequestBody TraineePracticeScoreBean practiceScoreParam){
		logger.info("/updatePracticeScore : [");
		List<PracticeItem> items = practiceScoreParam.getItems();
		for(PracticeItem item : items){
			String examsType = item.getExamsType();
			String examsName = item.getExamsName();
			String traineeId = item.getTraineeId();
			String practiceDate = item.getPracticeDate();
			String practiceScore=item.getPracticeScore();
			logger.info("  { examsType:"+examsType+" ,examsName:"+examsName+ " ,traineeId:"+traineeId+" ,practiceDate:"+practiceDate+" ,practiceScore:"+practiceScore+" }");
		}
		logger.info("]");
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "打分成功.");
		return resultMap;
	}
}
