package com.wawa.controller.trainer;

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

import com.wawa.bean.trainer.DeletePlanBean;
import com.wawa.bean.trainer.TrainerPlanBean;
import com.wawa.bean.trainer.UpdatePlanBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api( value = "练车排班")
@RestController
@RequestMapping(value = "/trainer",produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainerPlanController {

	private final Logger logger = LoggerFactory.getLogger( TrainerPlanController.class );
	
	@ApiOperation(value = "练车排班查询", notes = "在教练APP首页展示系统推荐的排班计划")
	@ApiImplicitParam(name = "trainerPlanParam", value = "教练id及查询日期", required = true, dataType = "TrainerPlanBean")
	@RequestMapping(value = "/fetchPlan", method = RequestMethod.POST)
	public List<TrainerPlanBean> fetchPlan(@RequestBody TrainerPlanBean trainerPlanParam){
		String trainerId = trainerPlanParam.getTrainerId();//教练id
		String practiceDate = trainerPlanParam.getPracticeDate();//练车日期
		logger.info("/fetchPlan : {trainerId: " + trainerId+" ,practiceDate:"+practiceDate+"}"); 
		List<TrainerPlanBean> resultList = new ArrayList<>();
		TrainerPlanBean bean1 = new TrainerPlanBean();
		bean1.setTraineeId("1");
		bean1.setTraineeName("刘德华");
		bean1.setTraineePhoneNumber("13511118888");
		bean1.setTraineePracticeScore("99");
		bean1.setTraineeExamsDate("2017-03-02");
		bean1.setTrainerId("99");
		bean1.setTraineeImg("a.img");
		bean1.setPlanStatus("0");//0 未处理 1 邀请中 2已接受 3已拒绝
		resultList.add(bean1);
		
		TrainerPlanBean bean2 = new TrainerPlanBean();
		bean2.setTraineeId("2");
		bean2.setTraineeName("张学友");
		bean2.setTraineePhoneNumber("13899995555");
		bean2.setTraineePracticeScore("98");
		bean2.setTraineeExamsDate("2017-03-02");
		bean2.setTrainerId("99");
		bean2.setTraineeImg("b.img");
		bean2.setPlanStatus("2");//0 未处理 1 邀请中 2已接受 3已拒绝
		resultList.add(bean2);
		
		return resultList;
	}
	
	
	@ApiOperation(value = "换一个学员,由系统指定", notes = "按学员得分高低来选择")
	@ApiImplicitParam(name = "trainerPlanParam", value = "学员id及练车日期", required = true, dataType = "TrainerPlanBean")
	@RequestMapping(value = "/changeTrainee", method = RequestMethod.POST)
	public TrainerPlanBean changeTrainee (@RequestBody TrainerPlanBean trainerPlanParam){
		String traineeId = trainerPlanParam.getTraineeId();//学员id
		String practiceDate = trainerPlanParam.getPracticeDate();//练车日期
		logger.info("/changeTrainee : {traineeId: " + traineeId+" ,practiceDate:"+practiceDate+"}"); 
		TrainerPlanBean bean1 = new TrainerPlanBean();
		bean1.setTraineeId("3");
		bean1.setTraineeName("李若彤");
		bean1.setTraineePhoneNumber("13688888888");
		bean1.setTraineePracticeScore("99");
		bean1.setTraineeExamsDate("2017-03-02");
		bean1.setTrainerId("99");
		bean1.setTraineeImg("c.img");
		bean1.setPlanStatus("0");//0 未处理 1 邀请中 2已接受 3已拒绝
		return bean1;
	}
	
	@ApiOperation(value = "教练指定一个学员", notes = "教练自主选择")
	@ApiImplicitParam(name = "planParam", value = "旧学员、新学员、练车日期", required = true, dataType = "UpdatePlanBean")
	@RequestMapping(value = "/updatePlanWithAnotherTrainee", method = RequestMethod.POST)
	public Map<String,String> updatePlanWithAnotherTrainee(@RequestBody UpdatePlanBean planParam){
		String oldTraineeId = planParam.getOldTraineeId();//学员id
		String newTraineeId = planParam.getNewTraineeId();//学员id
		String practiceDate  = planParam.getPracticeDate();//练车日期
		logger.info("/updatePlanWithAnotherTrainee : {oldTraineeId: " + oldTraineeId+"newTraineeId: " + newTraineeId+" ,practiceDate:"+practiceDate+"}"); 
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "更换指定学员成功.");
		return resultMap;
	}
	
	@ApiOperation(value = "关闭一个位置", notes = "在某个排班中关闭一个位置")
	@ApiImplicitParam(name = "planParam", value = "学员、练车日期", required = true, dataType = "DeletePlanBean")
	@RequestMapping(value = "/deleteTraineeInPlan", method = RequestMethod.POST)
	public Map<String,String> deleteTraineeInPlan(@RequestBody DeletePlanBean planParam){
		String traineeId = planParam.getTraineeId();
		String practiceDate  = planParam.getPracticeDate();//练车日期
		logger.info("/deleteTraineeInPlan : {traineeId: " + traineeId + " ,practiceDate:"+practiceDate+"}"); 
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("resCode", "0000");
		resultMap.put("resDes", "关闭该位置成功.");
		return resultMap;
	}
}
