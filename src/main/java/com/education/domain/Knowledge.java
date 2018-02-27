package com.education.domain;

import java.util.Date;

public class Knowledge {
    private Integer knowid;

    private String knowname;

    private Byte stageid;

    private Integer subjectid;

    private Integer schoolid;

    private Byte status;

    private Integer createby;

    private Date createdAt;

    private Integer updateby;

    private Date updatedAt;

    public Integer getKnowid() {
        return knowid;
    }

    public void setKnowid(Integer knowid) {
        this.knowid = knowid;
    }

    public String getKnowname() {
        return knowname;
    }

    public void setKnowname(String knowname) {
        this.knowname = knowname == null ? null : knowname.trim();
    }

    public Byte getStageid() {
        return stageid;
    }

    public void setStageid(Byte stageid) {
        this.stageid = stageid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}