package com.education.domain;

import java.util.Date;

public class WrongQuestionReason {
    private Integer wqrid;

    private Integer wqid;

    private Integer wrid;

    private Date createdAt;

    private Date updatedAt;

    private Byte status;

    private Integer userid;

    private Integer subjectid;

    public Integer getWqrid() {
        return wqrid;
    }

    public void setWqrid(Integer wqrid) {
        this.wqrid = wqrid;
    }

    public Integer getWqid() {
        return wqid;
    }

    public void setWqid(Integer wqid) {
        this.wqid = wqid;
    }

    public Integer getWrid() {
        return wrid;
    }

    public void setWrid(Integer wrid) {
        this.wrid = wrid;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }
}