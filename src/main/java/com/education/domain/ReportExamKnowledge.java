package com.education.domain;

import java.util.Date;

public class ReportExamKnowledge {
    private Integer reknid;

    private Integer examid;

    private Integer kiid;

    private Integer classid;

    private String classname;

    private Float average;

    private Date createdAt;

    public Integer getReknid() {
        return reknid;
    }

    public void setReknid(Integer reknid) {
        this.reknid = reknid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getKiid() {
        return kiid;
    }

    public void setKiid(Integer kiid) {
        this.kiid = kiid;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}