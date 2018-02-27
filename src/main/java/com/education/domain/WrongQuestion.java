package com.education.domain;

import java.util.Date;

public class WrongQuestion {
    private Integer wqid;

    private Integer userid;

    private Integer questionid;

    private Integer questionbankid;

    private String smallqsno;

    private Integer examid;

    private Date createdAt;

    private Date updatedAt;

    private Integer schoolid;

    private Integer gradeid;

    private Integer classid;

    private Integer subjectid;

    private String remark;

    private Byte status;

    private Byte iscorrect;

    private Float scorerate;

    public Integer getWqid() {
        return wqid;
    }

    public void setWqid(Integer wqid) {
        this.wqid = wqid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getQuestionbankid() {
        return questionbankid;
    }

    public void setQuestionbankid(Integer questionbankid) {
        this.questionbankid = questionbankid;
    }

    public String getSmallqsno() {
        return smallqsno;
    }

    public void setSmallqsno(String smallqsno) {
        this.smallqsno = smallqsno == null ? null : smallqsno.trim();
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIscorrect() {
        return iscorrect;
    }

    public void setIscorrect(Byte iscorrect) {
        this.iscorrect = iscorrect;
    }

    public Float getScorerate() {
        return scorerate;
    }

    public void setScorerate(Float scorerate) {
        this.scorerate = scorerate;
    }
}