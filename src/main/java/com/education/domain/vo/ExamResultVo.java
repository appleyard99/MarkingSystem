package com.education.domain.vo;

/**
 * 获取（班级）大题--分数对应关系
 *
 * @author liuyizheng
 * @create 2018/2/5
 */
public class ExamResultVo {
    private String qsgroup;
    private Float zscore;

    public String getQsgroup() {
        return qsgroup;
    }

    public void setQsgroup(String qsgroup) {
        this.qsgroup = qsgroup;
    }

    public Float getZscore() {
        return zscore;
    }

    public void setZscore(Float zscore) {
        this.zscore = zscore;
    }
}
