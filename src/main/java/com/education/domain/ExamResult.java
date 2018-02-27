package com.education.domain;

import java.util.Date;

public class ExamResult {
    private Integer exrid;

    private Integer examid;

    private Integer questionid;

    private Integer studentid;

    private Integer classid;

    private Date answertime;

    private Byte answerstatus;

    private Float score;

    private Byte helpflag;

    private Date helptime;

    private String qsgroup;

    public Integer getExrid() {
        return exrid;
    }

    public void setExrid(Integer exrid) {
        this.exrid = exrid;
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

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Date getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Date answertime) {
        this.answertime = answertime;
    }

    public Byte getAnswerstatus() {
        return answerstatus;
    }

    public void setAnswerstatus(Byte answerstatus) {
        this.answerstatus = answerstatus;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Byte getHelpflag() {
        return helpflag;
    }

    public void setHelpflag(Byte helpflag) {
        this.helpflag = helpflag;
    }

    public Date getHelptime() {
        return helptime;
    }

    public void setHelptime(Date helptime) {
        this.helptime = helptime;
    }

    public String getQsgroup() {
        return qsgroup;
    }

    public void setQsgroup(String qsgroup) {
        this.qsgroup = qsgroup == null ? null : qsgroup.trim();
    }
}