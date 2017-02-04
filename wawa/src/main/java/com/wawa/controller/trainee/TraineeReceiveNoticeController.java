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

import com.wawa.bean.trainee.TraineeReceiveNoticeBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "学员收到的练车邀请通知")
@RestController
@RequestMapping(value = "/trainee",produces = MediaType.APPLICATION_JSON_VALUE)
public class TraineeReceiveNoticeController {
	
	private final Logger logger = LoggerFactory.getLogger( TraineeReceiveNoticeController.class );
	
	@ApiOperation(value = "学员练车通知", notes = "学员收到的练车邀请通知 ")
	@ApiImplicitParam(name = "noticeReceiveParam", value = "约车通知列表", required = true, dataType = "TraineeReceiveNoticeBean")
	@RequestMapping(value = "/receiveNotice", method = RequestMethod.POST)
	public List<Map<String, String>> receiveNotice(@RequestBody TraineeReceiveNoticeBean noticeReceiveParam ){
		String traineeId = noticeReceiveParam.getTraineeId();//学员id
		logger.info("/receiveNotice : {traineeId: " + traineeId  +"}"); 
		
		List<Map<String, String>> resultList = new ArrayList<>();
		Map<String, String> resultMap1 = new HashMap<>();
		resultMap1.put("traineeId", "111");
		resultMap1.put("praceDate", "2017-03-03");
		resultMap1.put("status", "未读");
		resultMap1.put("noticeContent", "来练车吧.");
		resultList.add(resultMap1);
		Map<String, String> resultMap2 = new HashMap<>();
		resultMap2.put("traineeId", "111");
		resultMap2.put("praceDate", "2017-03-0322");
		resultMap1.put("status", "已读");
		resultMap2.put("noticeContent", "来练车吧.");
		resultList.add(resultMap2);
		return resultList;
	}
	
}
