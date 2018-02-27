package com.education.domain;

public class WqArrangeTaskDetail {
    private Integer atdetailid;

    private Integer arrangetaskid;

    private Integer subjectid;

    private Integer total;

    private Integer donenum;

    private Byte status;

    public Integer getAtdetailid() {
        return atdetailid;
    }

    public void setAtdetailid(Integer atdetailid) {
        this.atdetailid = atdetailid;
    }

    public Integer getArrangetaskid() {
        return arrangetaskid;
    }

    public void setArrangetaskid(Integer arrangetaskid) {
        this.arrangetaskid = arrangetaskid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDonenum() {
        return donenum;
    }

    public void setDonenum(Integer donenum) {
        this.donenum = donenum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}