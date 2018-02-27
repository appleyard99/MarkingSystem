package com.education.domain;

import java.util.Date;

public class Exam {
    private Integer examid;

    private String examname;

    private Byte examtype;

    private String notes;

    private Integer schoolid;

    private Integer campusid;

    private Integer gradeid;

    private Integer subjectid;

    private Integer createby;

    private Date createdAt;

    private Integer updateby;

    private Date updatedAt;

    private Integer termid;

    private Byte mark;

    private Byte layout;

    private Byte bindingline;

    private Byte analysisviewtype;

    private Byte videoviewtype;

    private Float score;

    private Float avgscore;

    private Byte status;

    private Integer pagenum;

    private String answercardpath;

    private String paperpath;

    private String xpspath;

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname == null ? null : examname.trim();
    }

    public Byte getExamtype() {
        return examtype;
    }

    public void setExamtype(Byte examtype) {
        this.examtype = examtype;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
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

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
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

    public Integer getTermid() {
        return termid;
    }

    public void setTermid(Integer termid) {
        this.termid = termid;
    }

    public Byte getMark() {
        return mark;
    }

    public void setMark(Byte mark) {
        this.mark = mark;
    }

    public Byte getLayout() {
        return layout;
    }

    public void setLayout(Byte layout) {
        this.layout = layout;
    }

    public Byte getBindingline() {
        return bindingline;
    }

    public void setBindingline(Byte bindingline) {
        this.bindingline = bindingline;
    }

    public Byte getAnalysisviewtype() {
        return analysisviewtype;
    }

    public void setAnalysisviewtype(Byte analysisviewtype) {
        this.analysisviewtype = analysisviewtype;
    }

    public Byte getVideoviewtype() {
        return videoviewtype;
    }

    public void setVideoviewtype(Byte videoviewtype) {
        this.videoviewtype = videoviewtype;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(Float avgscore) {
        this.avgscore = avgscore;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public String getAnswercardpath() {
        return answercardpath;
    }

    public void setAnswercardpath(String answercardpath) {
        this.answercardpath = answercardpath == null ? null : answercardpath.trim();
    }

    public String getPaperpath() {
        return paperpath;
    }

    public void setPaperpath(String paperpath) {
        this.paperpath = paperpath == null ? null : paperpath.trim();
    }

    public String getXpspath() {
        return xpspath;
    }

    public void setXpspath(String xpspath) {
        this.xpspath = xpspath == null ? null : xpspath.trim();
    }
}