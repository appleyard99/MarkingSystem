package com.education.domain;

public class WqRedoTaskDetail {
    private Integer rtdetailid;

    private Integer redotaskid;

    private Integer subjectid;

    private Integer total;

    private Integer donenum;

    private Integer correctnum;

    private Byte status;

    public Integer getRtdetailid() {
        return rtdetailid;
    }

    public void setRtdetailid(Integer rtdetailid) {
        this.rtdetailid = rtdetailid;
    }

    public Integer getRedotaskid() {
        return redotaskid;
    }

    public void setRedotaskid(Integer redotaskid) {
        this.redotaskid = redotaskid;
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

    public Integer getCorrectnum() {
        return correctnum;
    }

    public void setCorrectnum(Integer correctnum) {
        this.correctnum = correctnum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}