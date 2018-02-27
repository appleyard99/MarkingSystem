package com.education.service;

import java.util.Map;

public interface IExamService {
    //检查操作的合法性:只可以访问自己学校的数据.
    Map<String,Object> checkExam(Integer examid, Integer schoolid);
}
