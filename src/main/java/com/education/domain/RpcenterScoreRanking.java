package com.education.domain;

import java.util.Date;

public class RpcenterScoreRanking {
    private Integer rpsrid;

    private Integer rpcid;

    private Integer examid;

    private Integer studentid;

    private Integer classid;

    private String subjectid;

    private Float score;

    private Short ranking;

    private Short gradeRanking;

    private Date createAt;

    public Integer getRpsrid() {
        return rpsrid;
    }

    public void setRpsrid(Integer rpsrid) {
        this.rpsrid = rpsrid;
    }

    public Integer getRpcid() {
        return rpcid;
    }

    public void setRpcid(Integer rpcid) {
        this.rpcid = rpcid;
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

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid == null ? null : subjectid.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Short getRanking() {
        return ranking;
    }

    public void setRanking(Short ranking) {
        this.ranking = ranking;
    }

    public Short getGradeRanking() {
        return gradeRanking;
    }

    public void setGradeRanking(Short gradeRanking) {
        this.gradeRanking = gradeRanking;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}