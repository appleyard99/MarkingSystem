package com.education.domain;

import java.util.Date;

public class ReportExamSummary {
    private Integer resuid;

    private Integer examid;

    private Integer studentid;

    private Integer classid;

    private String qstitle;

    private String qsgroup;

    private Float score;

    private Date createdAt;

    public Integer getResuid() {
        return resuid;
    }

    public void setResuid(Integer resuid) {
        this.resuid = resuid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}