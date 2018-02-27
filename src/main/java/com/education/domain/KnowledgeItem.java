package com.education.domain;

import java.util.Date;

public class KnowledgeItem {
    private Integer kiid;

    private String knowname;

    private Integer knowid;

    private Byte level;

    private Integer parentid;

    private String knowcode;

    private Float showorder;

    private Byte status;

    private Integer createby;

    private Date createdAt;

    private Integer updateby;

    private Date updatedAt;

    public Integer getKiid() {
        return kiid;
    }

    public void setKiid(Integer kiid) {
        this.kiid = kiid;
    }

    public String getKnowname() {
        return knowname;
    }

    public void setKnowname(String knowname) {
        this.knowname = knowname == null ? null : knowname.trim();
    }

    public Integer getKnowid() {
        return knowid;
    }

    public void setKnowid(Integer knowid) {
        this.knowid = knowid;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getKnowcode() {
        return knowcode;
    }

    public void setKnowcode(String knowcode) {
        this.knowcode = knowcode == null ? null : knowcode.trim();
    }

    public Float getShoworder() {
        return showorder;
    }

    public void setShoworder(Float showorder) {
        this.showorder = showorder;
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