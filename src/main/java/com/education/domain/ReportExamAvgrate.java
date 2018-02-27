package com.education.domain;

import java.util.Date;

public class ReportExamAvgrate {
    private Integer reavrid;

    private Integer examid;

    private Integer classid;

    private Float classAverage;

    private Float classRate;

    private Float gradeAverage;

    private Float gradeRate;

    private Date createdAt;

    public Integer getReavrid() {
        return reavrid;
    }

    public void setReavrid(Integer reavrid) {
        this.reavrid = reavrid;
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

    public Float getClassAverage() {
        return classAverage;
    }

    public void setClassAverage(Float classAverage) {
        this.classAverage = classAverage;
    }

    public Float getClassRate() {
        return classRate;
    }

    public void setClassRate(Float classRate) {
        this.classRate = classRate;
    }

    public Float getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(Float gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    public Float getGradeRate() {
        return gradeRate;
    }

    public void setGradeRate(Float gradeRate) {
        this.gradeRate = gradeRate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}