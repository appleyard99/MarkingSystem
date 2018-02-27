package com.education.controller;

import com.education.service.IRpcenterScoreRankingService;
import com.education.service.IRpcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 报表中心模块
 *
 * @author YangShuan
 * @create 2018/2/1
 */
@RestController
@RequestMapping(value = "/", produces = "application/json")
public class RpcenterController {

	@Autowired
	private IRpcenterService iRpcenterService;

	@Autowired
	private IRpcenterScoreRankingService iRpcenterScoreRankingService;

	/**
	 * 返回报表中心 科目-班级集合.
	 *
	 * @param id       报表主键ID
	 * @param schoolId 学校ID
	 * @return
	 */
	@GetMapping("/rpcenter/get-sub-class/{id}/{schoolId}")
	public Map<String, Object> getSC(@PathVariable Integer id, @PathVariable Integer schoolId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result = this.iRpcenterService.getSubjectClass(id, schoolId);

		map.put("code", "200");
		map.put("msg", "");
		map.put("data", result);
		return map;
	}

	/**
	 * [测试方法2]返回报表中心 科目-班级集合.
	 *
	 * @param id       报表主键ID
	 * @param schoolId 学校ID
	 * @return
	 */
	@GetMapping("/rpcenter/get-sub-class2/{id}/{schoolId}")
	public Map<String, Object> testCS(@PathVariable Integer id, @PathVariable Integer schoolId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result = this.iRpcenterService.getSubjectClass2(id, schoolId);

		map.put("code", "200");
		map.put("msg", "");
		map.put("data", result);
		return map;
	}

	/**
	 * @Description: 获取成绩排名汇总 数据.
	 * @author YangShuan
	 * @date 2018/2/5 10:03
	 */
	@GetMapping("/rpcenter/get-score-ranking/{rpcid}/{subjectId}/{classId}")
	public Map<String, Object> getScoreRanking(@PathVariable Integer rpcid, @PathVariable String subjectId, @PathVariable String classId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> result = this.iRpcenterScoreRankingService.getScoreList(rpcid, subjectId, classId);

		map.put("code", "200");
		map.put("msg", "");
		map.put("data", result);
		return map;
	}
}