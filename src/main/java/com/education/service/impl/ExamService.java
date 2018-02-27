package com.education.service.impl;

import com.education.domain.Exam;
import com.education.mapper.ExamMapper;
import com.education.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 考试仓库.
 *
 * @author Lvxianya
 * @create 2018/2/2
 */
@Service
@Transactional
public class ExamService implements IExamService {

    @Autowired
    private ExamMapper examMapper;

    /**
     *@Description: 检查操作的合法性:只可以访问自己学校的数据
     *@author Lvxianya
     *@date 2018/2/2
     */
    @Override
    public Map<String, Object> checkExam(Integer examid, Integer schoolid) {
        Map<String, Object> checkMap = new HashMap<String, Object>();
        Exam exam = examMapper.getExam(examid, schoolid);
        if(exam == null) {
            checkMap.put("status", "false");
            checkMap.put("msg", "所访问数据不存在");
            return checkMap;
        }

        if(schoolid != exam.getSchoolid()) {
            checkMap.put("status", "false");
            checkMap.put("msg", "权限不够");
            return checkMap;
        }

        checkMap.put("status", "true");
        checkMap.put("msg", "");
        checkMap.put("data", exam);
        return checkMap;
    }
}
