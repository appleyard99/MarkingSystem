package com.education.service;

import java.util.List;
import java.util.Map;

public interface IReportExamService {
    //获取相关数据（【学情表格】数据）
    Map<String,Object> getSummaryList(Integer classid, Integer examid, Integer termid);

    //"学情表格==>大题作答详情"---展示数据的时候使用.简答题：才有“得分率”概念;
    Map<String,Object> getBigQues(Integer examid, Integer classid);

    //获取平均分数据
    Map<String, Object> getQuestion(Integer examid, Integer classid,Integer tp);

    //获取小题作答详情数据.
    Map<String,Object> getReplyDetails(Integer examid, Integer classid);

    //获取"分数段分布图"数据
    Map<String,Object> getSegment(Integer examid, Integer classid);

    //获取班级小题答错名单数据
    List<Map<String, Object>> getErrList(Integer examid, Integer classid);

    //获取知识点均分对比表数据
    Map<String,Object> getKnowledge(Integer examid, Integer classid);

    //获取年级考情报表"作答详情表格"数据
    List<Map<String, Object>> getGradeSituation(Integer examid);
}
