package com.education.domain;

import java.util.Date;

public class ExamClass {
    private Integer excid;

    private Integer examid;

    private Integer subjectid;

    private Integer classid;

    private String classname;

    private Integer gradeid;

    private String gradename;

    private Integer teacherid;

    private Date createdAt;

    private Integer classcount;

    private Integer submitcount;

    private Integer markcount;

    private Date starttime;

    private Date endtime;

    private Date showtimedatetime;

    private Byte checkstatus;

    private Float avgscore;

    private Integer ranking;

    public Integer getExcid() {
        return excid;
    }

    public void setExcid(Integer excid) {
        this.excid = excid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename == null ? null : gradename.trim();
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getClasscount() {
        return classcount;
    }

    public void setClasscount(Integer classcount) {
        this.classcount = classcount;
    }

    public Integer getSubmitcount() {
        return submitcount;
    }

    public void setSubmitcount(Integer submitcount) {
        this.submitcount = submitcount;
    }

    public Integer getMarkcount() {
        return markcount;
    }

    public void setMarkcount(Integer markcount) {
        this.markcount = markcount;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getShowtimedatetime() {
        return showtimedatetime;
    }

    public void setShowtimedatetime(Date showtimedatetime) {
        this.showtimedatetime = showtimedatetime;
    }

    public Byte getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(Byte checkstatus) {
        this.checkstatus = checkstatus;
    }

    public Float getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(Float avgscore) {
        this.avgscore = avgscore;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}