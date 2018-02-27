package com.education.service;


import com.education.domain.vo.RpcenterSubjectVo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 成绩报表--学生成绩排名汇总
 *
 * @author YangShuan
 * @Description:
 * @date 2018/2/5 9:15
 */
public interface IRpcenterScoreRankingService {

	/**
	 * 获取成绩排名汇总 数据
	 *
	 * @param rpcid     报表主键ID
	 * @param subjectId 科目 ID（all全科总分;ysw总分语数外）
	 * @param classId   班级ID（all所有班级;）
	 * @return
	 * @author YangShuan
	 */
	Map<String, Object> getScoreList(Integer rpcid, String subjectId, String classId);

	/**
	 * 获取满足条件的科目数据
	 *
	 * @param rpcid     报表主键ID
	 * @param subjectId 科目 ID（all全科总分;ysw总分语数外）
	 * @param classId   班级ID（all所有班级;）
	 * @return
	 * @author YangShuan
	 */
	List<RpcenterSubjectVo> getSubject(Integer rpcid, String subjectId, String classId);

	/**
	 * 报表-标题部分数据处理.
	 *
	 * @param subjectArr
	 * @return
	 * @author YangShuan
	 */
	List<String> getTitle(List<RpcenterSubjectVo> subjectArr);


	/**
	 * 获取满足条件的学生数据.
	 *
	 * @param rpcid     报表主键ID
	 * @param subjectId 科目ID（all全科总分;ysw总分语数外）
	 * @param classId   班级ID（all所有班级;）
	 * @param orderBy   排序方式
	 * @return
	 * @author YangShuan
	 */
	LinkedHashMap<Integer, Object> getStu(Integer rpcid, String subjectId, String classId, String orderBy);

}