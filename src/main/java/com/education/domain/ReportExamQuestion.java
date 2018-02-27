package com.education.domain;

import java.util.Date;

public class ReportExamQuestion {
    private Integer requid;

    private Integer examid;

    private Integer questionid;

    private Integer seqno;

    private Integer classid;

    private String classname;

    private Float average;

    private String qstitle;

    private String qsgroup;

    private Date createdAt;

    public Integer getRequid() {
        return requid;
    }

    public void setRequid(Integer requid) {
        this.requid = requid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getSeqno() {
        return seqno;
    }

    public void setSeqno(Integer seqno) {
        this.seqno = seqno;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    public String getQstitle() {
        return qstitle;
    }

    public void setQstitle(String qstitle) {
        this.qstitle = qstitle == null ? null : qstitle.trim();
    }

    public String getQsgroup() {
        return qsgroup;
    }

    public void setQsgroup(String qsgroup) {
        this.qsgroup = qsgroup == null ? null : qsgroup.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}