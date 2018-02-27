package com.education.domain;

import java.util.Date;

public class UserIdentity {
    private Integer uiid;

    private Integer userid;

    private Integer schoolid;

    private Integer campusid;

    private Byte usertype;

    private Integer bindUserid;

    private Byte usestatus;

    private Date createdAt;

    private Integer createby;

    private Date updatedAt;

    private Integer updateby;

    public Integer getUiid() {
        return uiid;
    }

    public void setUiid(Integer uiid) {
        this.uiid = uiid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public Integer getCampusid() {
        return campusid;
    }

    public void setCampusid(Integer campusid) {
        this.campusid = campusid;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Integer getBindUserid() {
        return bindUserid;
    }

    public void setBindUserid(Integer bindUserid) {
        this.bindUserid = bindUserid;
    }

    public Byte getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(Byte usestatus) {
        this.usestatus = usestatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }
}