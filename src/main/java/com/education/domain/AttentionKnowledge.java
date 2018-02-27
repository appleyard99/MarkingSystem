package com.education.domain;

import java.util.Date;

public class AttentionKnowledge {
    private Integer akid;

    private Integer teacherid;

    private Integer classid;

    private Integer termid;

    private Integer kiid;

    private Date createdAt;

    private String reason;

    private Byte status;

    private Date updatedAt;

    private Integer subjectid;

    public Integer getAkid() {
        return akid;
    }

    public void setAkid(Integer akid) {
        this.akid = akid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getTermid() {
        return termid;
    }

    public void setTermid(Integer termid) {
        this.termid = termid;
    }

    public Integer getKiid() {
        return kiid;
    }

    public void setKiid(Integer kiid) {
        this.kiid = kiid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }
}