package com.wawa.controller.trainee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( value = "学员练车记录")
@RestController
@RequestMapping(value = "/trainee",produces = MediaType.APPLICATION_JSON_VALUE)
public class TraineePracticeRecordsController {

	private final Logger logger = LoggerFactory.getLogger( TraineePracticeRecordsController.class );
	
	@ApiOperation(value = "学员练车记录查询", notes = "学员练车记录查询")
	@RequestMapping(value = "/getPracticeRecords", method = RequestMethod.POST)
	public List<Map<String,String>> getPracticeRecords(){
		logger.info("/getPracticeRecords : { } ");
		
		List<Map<String,String>> resultLists = new ArrayList<>();
		Map<String,String> data1 = new HashMap<>();
		data1.put("examsType", "科目2");
		data1.put("examsName", "侧方位停车");
		data1.put("traineeId", "1");
		data1.put("practiceScore", "80");
		data1.put("status", "待处理");
		resultLists.add(data1);
		Map<String,String> data2 = new HashMap<>();
		data2.put("examsType", "科目2");
		data2.put("examsName", "倒车入库");
		data2.put("traineeId", "1");
		data2.put("practiceScore", "90");
		data2.put("status", "待处理");
		resultLists.add(data2);
		return resultLists;
	}
}
