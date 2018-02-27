package com.education.domain;

import java.util.Date;

public class ReportExamSegment {
    private Integer reseid;

    private Integer examid;

    private Integer classid;

    private Short segment;

    private Short num;

    private Date createdAt;

    public Integer getReseid() {
        return reseid;
    }

    public void setReseid(Integer reseid) {
        this.reseid = reseid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Short getSegment() {
        return segment;
    }

    public void setSegment(Short segment) {
        this.segment = segment;
    }

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}