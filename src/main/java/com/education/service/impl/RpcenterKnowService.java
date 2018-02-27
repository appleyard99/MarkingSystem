package com.education.service.impl;

import com.education.domain.ExamClass;
import com.education.mapper.ExamClassMapper;
import com.education.mapper.KnowledgeClassMapper;
import com.education.mapper.ReportExamKnowledgeMapper;
import com.education.service.IRpcenterKnowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报表中心--知识点相关
 *
 * @author YangShuan
 * @create 2018/2/8
 */
@Service
public class RpcenterKnowService implements IRpcenterKnowService {

	@Autowired
	KnowledgeClassMapper knowClassMapper;
	@Autowired
	ReportExamKnowledgeMapper rpKnowMapper;
	@Autowired
	ExamClassMapper examClassMapper;

	/**
	 * @Description: 获取知识点相关报表数据
	 * @author YangShuan
	 * @date 2018/2/8 11:32
	 */
	@Override
	public Map<String, Object> getKnowList(String classId, Integer examid, Integer rpcid) {
		Map<String, Object> errorMap = new HashMap<String, Object>(0);
		Map<String, Object> resultMap = new HashMap<String, Object>(0);

		//step1:获取试卷班级情况.
		List<ExamClass> examClassList = examClassMapper.getExamClass(examid);


		resultMap.put("data", examClassList);
		return resultMap;
	}
}
