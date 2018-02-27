package com.education.domain;

public class ClassroomMeta {
    private Integer metaid;

    private Integer schoolid;

    private String feature;

    private Byte status;

    public Integer getMetaid() {
        return metaid;
    }

    public void setMetaid(Integer metaid) {
        this.metaid = metaid;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature == null ? null : feature.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}