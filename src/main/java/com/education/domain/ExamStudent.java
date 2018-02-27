package com.education.domain;

import java.util.Date;

public class ExamStudent {
    private Integer exsid;

    private Integer examid;

    private Integer studentid;

    private Integer teacherid;

    private Date createdAt;

    private Date submittime;

    private Integer classid;

    private Byte status;

    private Float score;

    private Float scorerate;

    private Integer ranking;

    private Integer gradeRanking;

    private Integer exceed;

    private Float exceedRate;

    private Integer gradeExceed;

    private Float gradeExceedRate;

    public Integer getExsid() {
        return exsid;
    }

    public void setExsid(Integer exsid) {
        this.exsid = exsid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
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

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getScorerate() {
        return scorerate;
    }

    public void setScorerate(Float scorerate) {
        this.scorerate = scorerate;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getGradeRanking() {
        return gradeRanking;
    }

    public void setGradeRanking(Integer gradeRanking) {
        this.gradeRanking = gradeRanking;
    }

    public Integer getExceed() {
        return exceed;
    }

    public void setExceed(Integer exceed) {
        this.exceed = exceed;
    }

    public Float getExceedRate() {
        return exceedRate;
    }

    public void setExceedRate(Float exceedRate) {
        this.exceedRate = exceedRate;
    }

    public Integer getGradeExceed() {
        return gradeExceed;
    }

    public void setGradeExceed(Integer gradeExceed) {
        this.gradeExceed = gradeExceed;
    }

    public Float getGradeExceedRate() {
        return gradeExceedRate;
    }

    public void setGradeExceedRate(Float gradeExceedRate) {
        this.gradeExceedRate = gradeExceedRate;
    }
}