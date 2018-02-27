package com.education.service;

import com.education.domain.ExamClass;

import java.util.List;

/**
 * @author YangShuan
 * @Description: 考试班级相关-接口
 * @date 2018/2/2 14:08
 */
public interface IExamClassService {
	//获取考试班级集合.
	List<ExamClass> getExamClass(Integer id);
}