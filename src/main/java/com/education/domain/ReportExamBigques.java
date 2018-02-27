package com.education.domain;

import java.util.Date;

public class ReportExamBigques {
    private Integer rebqid;

    private Integer questionid;

    private String qsgroup;

    private Integer examid;

    private Byte type;

    private Integer seqno;

    private Integer classid;

    private Short errorNum;

    private String errorAnswer;

    private Float rate;

    private Date createdAt;

    public Integer getRebqid() {
        return rebqid;
    }

    public void setRebqid(Integer rebqid) {
        this.rebqid = rebqid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQsgroup() {
        return qsgroup;
    }

    public void setQsgroup(String qsgroup) {
        this.qsgroup = qsgroup == null ? null : qsgroup.trim();
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public Short getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Short errorNum) {
        this.errorNum = errorNum;
    }

    public String getErrorAnswer() {
        return errorAnswer;
    }

    public void setErrorAnswer(String errorAnswer) {
        this.errorAnswer = errorAnswer == null ? null : errorAnswer.trim();
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}