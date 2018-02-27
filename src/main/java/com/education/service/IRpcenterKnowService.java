package com.education.service;

import java.util.Map;

/**
 * @author YangShuan
 * @Description: 报表中心-知识点相关
 * @date 2018/2/8 11:21
 */
public interface IRpcenterKnowService {
	/**
	 * 获取知识点相关报表数据
	 *
	 * @param classId 班级ID
	 * @param examid  试卷ID
	 * @param rpcid   报表主键ID
	 * @return
	 */
	Map<String, Object> getKnowList(String classId, Integer examid, Integer rpcid);
}
