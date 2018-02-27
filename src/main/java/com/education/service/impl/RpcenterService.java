package com.education.service.impl;

import com.education.domain.ExamClass;
import com.education.domain.vo.RpcenterClassVo;
import com.education.domain.vo.RpcenterSubjectVo;
import com.education.mapper.ExamClassMapper;
import com.education.mapper.RpcenterMapper;
import com.education.mapper.RpcenterSubjectMapper;
import com.education.service.IRpcenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 报表中心
 *
 * @author YangShuan
 * @create 2018/2/1
 */
@Service
public class RpcenterService implements IRpcenterService {

	@Autowired
	RpcenterMapper rpMapper;
	@Autowired
	RpcenterSubjectMapper subjectMapper;
	@Autowired
	ExamClassMapper examClassMapper;

	/**
	 * 获取科目班级-Map写法.
	 *
	 * @param id
	 * @param schoolId
	 * @return
	 */
	@Override
	public Map<String, Object> getSubjectClass(Integer id, Integer schoolId) {
		//获取科目.
		List<RpcenterSubjectVo> subjectList = subjectMapper.getSubject(id, schoolId);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List sbList = new ArrayList();

		Boolean isYSWScore = this.isYSWScore(id);

		Map<String, String> subjectMap = new HashMap<String, String>(0);

		subjectMap.put("subjectid", "all");
		subjectMap.put("examid", "0");
		subjectMap.put("subject", "全科总分");
		sbList.add(subjectMap);

		if (isYSWScore) {
			subjectMap.put("subjectid", "ysw");
			subjectMap.put("examid", "0");
			subjectMap.put("subject", "总分-语数外");
			sbList.add(subjectMap);
		}


		//班级集合.
		Map classMap = new HashMap<String, Object>();
		List classList = new ArrayList();

		Map<String, String> classMap2 = new HashMap<String, String>(0);
		classMap2.put("classid", "all");
		classMap2.put("className", "所有班级");
		classList.add(classMap2);

		for (RpcenterSubjectVo item : subjectList) {

			subjectMap = new HashMap<String, String>(0);
			subjectMap.put("subjectid", item.getSubjectid() + "");
			subjectMap.put("examid", item.getExamid() + "");
			subjectMap.put("subject", item.getSubject());
			sbList.add(subjectMap);

			//获取 科目试卷 对应的班级
			List<ExamClass> examClassList = examClassMapper.getExamClass(item.getExamid());

			for (ExamClass item2 : examClassList) {
				Integer key = item2.getClassid();

				if (!classMap.containsKey(key)) {
					classMap.put(key, item2.getClassname());

					classMap2 = new HashMap<String, String>();
					classMap2.put("classid", item2.getClassid().toString());
					classMap2.put("className", item2.getClassname());
					classList.add(classMap2);
				}
			}
		}

		resultMap.put("subArr", sbList);
		resultMap.put("classArr", classList);
		return resultMap;
	}

	/**
	 * 获取科目班级--对象写法
	 *
	 * @param id
	 * @param schoolId
	 * @return
	 */
	@Override
	public Map<String, Object> getSubjectClass2(Integer id, Integer schoolId) {

		//获取科目.
		List<RpcenterSubjectVo> subjectList = subjectMapper.getSubject(id, schoolId);
		Map<String, Object> resultMap = new HashMap<String, Object>();

		RpcenterSubjectVo subjectObj = new RpcenterSubjectVo();
		subjectObj.setExamid(0);
		subjectObj.setSubjectid("all");
		subjectObj.setSubject("全科总分");
		subjectList.add(0, subjectObj);

		Boolean isYSWScore = this.isYSWScore(id);
		if (isYSWScore != null) {
			System.out.println("isYSWScore=true");
			RpcenterSubjectVo subjectObj2 = new RpcenterSubjectVo();
			subjectObj2.setExamid(0);
			subjectObj2.setSubjectid("ysw");
			subjectObj2.setSubject("总分-语数外");
			subjectList.add(1, subjectObj2);
		}
		resultMap.put("subArr", subjectList);

		//班级集合.
		Map classMap = new HashMap<String, Object>();
		Map<Integer, Object> classMap2 = new HashMap<Integer, Object>();

		for (RpcenterSubjectVo item : subjectList) {
			//获取 科目试卷 对应的班级
			List<ExamClass> examClassList = examClassMapper.getExamClass(item.getExamid());

			for (ExamClass item2 : examClassList) {
				Integer key = item2.getClassid();

				if (!classMap.containsKey(key)) {
					classMap.put(key, item2.getClassname());

					RpcenterClassVo obj = new RpcenterClassVo();
					obj.setClassid(item2.getClassid());
					obj.setClassname(item2.getClassname());
					classMap2.put(key, obj);

				}
			}
		}
		resultMap.put("classArr", classMap2.values());

		return resultMap;
	}


	//是否包含语数外.
	@Override
	public Boolean isYSWScore(Integer id) {
		Integer rst;
		rst = rpMapper.isYSWScore(id);
		if (rst != null) {
			if (rst == 2) {
				return true;
			}
		}
		return false;
	}
}
