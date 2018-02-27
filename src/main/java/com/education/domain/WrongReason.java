package com.education.domain;

public class WrongReason {
    private Integer wrid;

    private Integer subjectid;

    private String reason;

    private Byte isdefault;

    public Integer getWrid() {
        return wrid;
    }

    public void setWrid(Integer wrid) {
        this.wrid = wrid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Byte getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Byte isdefault) {
        this.isdefault = isdefault;
    }
}