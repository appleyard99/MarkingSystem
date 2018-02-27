package com.education.service.impl;

import com.education.domain.RpcenterScoreRanking;
import com.education.domain.vo.RpcenterSubjectVo;
//import com.education.domain.vo.RpcenterSubjectVo;
import com.education.mapper.RpcenterScoreRankingMapper;
import com.education.service.IRpcenterScoreRankingService;
//import com.sun.xml.internal.bind.v2.util.QNameMap;
//import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 成绩报表--学生成绩排名汇总
 *
 * @author YangShuan
 * @create 2018/2/5
 */
@Service
public class RpcenterScoreRankingService implements IRpcenterScoreRankingService {

	@Autowired
	RpcenterScoreRankingMapper scoreRankingMapper;

	@Override
	public Map<String, Object> getScoreList(Integer rpcid, String subjectId, String classId) {
		Map<String, Object> errorMap = new HashMap<String, Object>(0);
		Map<String, Object> resultMap = new HashMap<String, Object>(0);

		//排序方式
		String orderBy = "score DESC ";
		/*
		if (subjectId.equals("all")) {
			//全科总分
			orderBy = " grade_ranking ASC ";
		} else if (subjectId.equals("ysw")) {
			//总分-语数外.
			orderBy = " grade_ranking ASC ";
		} else {
			orderBy = " score DESC ";
		}
		*/

		//step1:获取要显示的科目数据.
		List<RpcenterSubjectVo> subjectList = this.getSubject(rpcid, subjectId, classId);
		if (subjectList.isEmpty()) {
			errorMap.put("status", false);
			errorMap.put("msg", "科目为空");
			return errorMap;
		}

		//step2:获取表格标题.
		List<String> headerCell = this.getTitle(subjectList);
		//step3:获取学生数据集合.
		LinkedHashMap<Integer, Object> stuMap = this.getStu(rpcid, subjectId, classId, orderBy);
		//step4:获取学生-科目数据集合.
		Map<Integer, List<Map<String, Object>>> stuSubMap = this.getStuSubjectRelation(rpcid, subjectId, classId);

		List<Object> dataList = new ArrayList<>();

		//循环学生
		for (Map.Entry<Integer, Object> entry : stuMap.entrySet()) {

			Map<String, Object> tmpDataMap = new HashMap();//临时变量--存储result键值对下的数据（学生基本信息+科目成绩信息）.
			List<Map<String, Object>> tmpSubjectScoreList = new ArrayList<>();//临时变量--（存储科目成绩信息集合）

			Integer stuKey = entry.getKey();//学生ID.
			//dataList.add("学生ID=" + entry.getKey());

			tmpDataMap.put("userid", stuKey + "");
			tmpDataMap.put("usercode", "");
			tmpDataMap.put("gender", "");
			tmpDataMap.put("username", "");
			tmpDataMap.put("classname", "");

			//循环科目
			for (int i = 0; i < subjectList.size(); i++) {

				Map<String, Object> tmpSubjectScoreMap = new HashMap();//临时变量--（存储科目成绩信息）

				String subjectKey = subjectList.get(i).getSubjectid();//科目ID.

				//记录学生当前科目分数等信息.
				if (stuSubMap.containsKey(stuKey)) {

					List<Map<String, Object>> subList = (List<Map<String, Object>>) stuSubMap.get(stuKey);
					for (int j = 0; j < subList.size(); j++) {

						Map<String, Object> dataMap = (Map<String, Object>) subList.get(i);
						if (dataMap.containsKey(subjectKey)) {
							//判断是否有该科目的数据.
							RpcenterScoreRanking stuObj = (RpcenterScoreRanking) dataMap.get(subjectKey);
							System.out.println(" stuid=" + stuKey + "--gradeRanking==" + stuObj.getGradeRanking());

							tmpSubjectScoreMap.put("subjectId", subjectKey + "");
							tmpSubjectScoreMap.put("score", stuObj.getScore() + "");
							tmpSubjectScoreMap.put("ranking", stuObj.getRanking() + "");
							tmpSubjectScoreMap.put("grade_ranking", stuObj.getGradeRanking() + "");

						}
					}
					if (!tmpSubjectScoreMap.containsKey("score")) {
						//当前学生-当前科目下，无数据.
						tmpSubjectScoreMap.put("score", "0");
						tmpSubjectScoreMap.put("ranking", "0");
						tmpSubjectScoreMap.put("grade_ranking", "0");
					}
				} else {
					tmpSubjectScoreMap.put("score", "0");
					tmpSubjectScoreMap.put("ranking", "0");
					tmpSubjectScoreMap.put("grade_ranking", "0");
				}
				tmpSubjectScoreList.add(tmpSubjectScoreMap);
			}

			tmpDataMap.put("scoreList", tmpSubjectScoreList);

			dataList.add(tmpDataMap);
		}

		resultMap.put("headerCell", headerCell);
		resultMap.put("result", dataList);
		return resultMap;
	}

	/**
	 * @Description: 获取要显示的科目数据.
	 * @author YangShuan
	 * @date 2018/2/5 9:41
	 */
	@Override
	public List<RpcenterSubjectVo> getSubject(Integer rpcid, String subjectId, String classId) {
		List<RpcenterSubjectVo> subjectList = scoreRankingMapper.getSubject(rpcid, subjectId, classId);
		if (!subjectList.isEmpty()) {
			for (RpcenterSubjectVo item : subjectList) {
				if (item.getSubjectid().equals("all")) {
					item.setSubject("全科总分");
				}

				if (item.getSubjectid().equals("ysw")) {
					item.setSubject("总分-语数外");
				}
			}
		}
		return subjectList;
	}

	/**
	 * @Description: 获取标题.
	 * @author YangShuan
	 * @date 2018/2/5 9:58
	 */
	@Override
	public List<String> getTitle(List<RpcenterSubjectVo> subjectArr) {
		Map titleMap = new HashMap();
		List headerCell = new ArrayList();
		headerCell.add("学号");
		headerCell.add("性别");
		headerCell.add("姓名");
		headerCell.add("班级");

		for (RpcenterSubjectVo item : subjectArr) {
			headerCell.add(item.getSubject());
		}
		return headerCell;
	}

	/**
	 * TODO::排序还有问题.
	 *
	 * @Description: 获取学生信息
	 * @author YangShuan
	 * @date 2018/2/6
	 */
	@Override
	public LinkedHashMap<Integer, Object> getStu(Integer rpcid, String subjectId, String classId, String orderBy) {
		//大于0的数据.
		List<RpcenterScoreRanking> stuList = scoreRankingMapper.getStu(rpcid, subjectId, classId, orderBy);
		//等于0的数据.
		List<RpcenterScoreRanking> stuList2 = scoreRankingMapper.getStu2(rpcid, subjectId, classId, orderBy);

		LinkedHashMap<Integer, Object> stuMap = new LinkedHashMap<Integer, Object>(0);
		if (!stuList.isEmpty()) {
			for (RpcenterScoreRanking item : stuList) {
				//System.out.println("stuid=" + item.getStudentid());
				stuMap.put(item.getStudentid(), item);
			}
		}

		if (!stuList2.isEmpty()) {
			for (RpcenterScoreRanking item2 : stuList2) {
				stuMap.put(item2.getStudentid(), item2);
			}
		}
		return stuMap;
	}

	/**
	 * @Description: 获取学生-科目数据集合.
	 * @author YangShuan
	 * @date 2018/2/6
	 */
	Map<Integer, List<Map<String, Object>>> getStuSubjectRelation(Integer rpcid, String subjectId, String classId) {

		Map<Integer, List<Map<String, Object>>> resultMap = null;

		List<RpcenterScoreRanking> stuList = scoreRankingMapper.getStuSubjectRelation(rpcid, subjectId, classId);
		if (!stuList.isEmpty()) {
			resultMap = new HashMap<>();

			for (RpcenterScoreRanking item : stuList) {
				Map<String, Object> subjectMap = new HashMap<String, Object>();
				List<Map<String, Object>> stuSubList = new ArrayList<>();

				subjectMap.put(item.getSubjectid() + "", item);
				stuSubList.add(subjectMap);

				Integer key = item.getStudentid();
				if (resultMap.containsKey(key)) {
					resultMap.get(key).add(subjectMap);
				} else {
					resultMap.put(key, stuSubList);
				}
			}
		}
		return resultMap;
	}
}
