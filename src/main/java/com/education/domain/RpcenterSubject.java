package com.education.domain;

import java.util.Date;

public class RpcenterSubject {
    private Integer rpsid;

    private Integer rpcid;

    private Byte type;

    private Integer subjectid;

    private Integer examid;

    private Date createdAt;

    private Byte status;

    public Integer getRpsid() {
        return rpsid;
    }

    public void setRpsid(Integer rpsid) {
        this.rpsid = rpsid;
    }

    public Integer getRpcid() {
        return rpcid;
    }

    public void setRpcid(Integer rpcid) {
        this.rpcid = rpcid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
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