package com.education.domain;

import java.util.Date;

public class Rpcenter {
    private Integer rpcid;

    private String examname;

    private Integer schoolid;

    private Integer yearid;

    private Integer gradeid;

    private Integer createby;

    private Byte examtype;

    private String subject;

    private Byte customScore;

    private Date examTime;

    private Date updatedAt;

    private Date createdAt;

    private Byte status;

    public Integer getRpcid() {
        return rpcid;
    }

    public void setRpcid(Integer rpcid) {
        this.rpcid = rpcid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname == null ? null : examname.trim();
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public Integer getYearid() {
        return yearid;
    }

    public void setYearid(Integer yearid) {
        this.yearid = yearid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Byte getExamtype() {
        return examtype;
    }

    public void setExamtype(Byte examtype) {
        this.examtype = examtype;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Byte getCustomScore() {
        return customScore;
    }

    public void setCustomScore(Byte customScore) {
        this.customScore = customScore;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}