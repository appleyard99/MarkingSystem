package com.education.service.impl;

import com.education.domain.ExamClass;
import com.education.mapper.ExamClassMapper;
import com.education.service.IExamClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 考试班级相关
 *
 * @author YangShuan
 * @create 2018/2/2
 */
@Service
public class ExamClassService implements IExamClassService {

	@Autowired
	ExamClassMapper classMapper;

	@Override
	public List<ExamClass> getExamClass(Integer id) {
		return classMapper.getExamClass(id);
	}
}
