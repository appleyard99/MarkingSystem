package com.education.service;

import java.util.Map;

/**
 * @author YangShuan
 * @Description: 报表中心
 * @date 2018/2/1 14:00
 */
public interface IRpcenterService {
	// 获取科目和班级列表集合.
	Map<String, Object> getSubjectClass(Integer id, Integer schoolId);

	Map<String, Object> getSubjectClass2(Integer id, Integer schoolId);

	//是否包含语数外.
	Boolean isYSWScore(Integer id);
}
