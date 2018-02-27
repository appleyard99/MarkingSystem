package com.education.domain;

import java.util.Date;

public class RpcenterCompositeAnalysis {
    private Integer rpcaid;

    private Integer rpcid;

    private Integer headteacher;

    private Integer teacherid;

    private Integer classid;

    private String subjectid;

    private Short stuNum;

    private Short absentNum;

    private Float averageScore;

    private Short excellentNum;

    private String excellentRate;

    private Short gooldNum;

    private String gooldRate;

    private Short passNum;

    private String passRate;

    private Short failNum;

    private String failRate;

    private Float highestScore;

    private Float minimumScore;

    private String standardDeviation;

    private Short ranking;

    private Date createAt;

    public Integer getRpcaid() {
        return rpcaid;
    }

    public void setRpcaid(Integer rpcaid) {
        this.rpcaid = rpcaid;
    }

    public Integer getRpcid() {
        return rpcid;
    }

    public void setRpcid(Integer rpcid) {
        this.rpcid = rpcid;
    }

    public Integer getHeadteacher() {
        return headteacher;
    }

    public void setHeadteacher(Integer headteacher) {
        this.headteacher = headteacher;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
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

    public Short getStuNum() {
        return stuNum;
    }

    public void setStuNum(Short stuNum) {
        this.stuNum = stuNum;
    }

    public Short getAbsentNum() {
        return absentNum;
    }

    public void setAbsentNum(Short absentNum) {
        this.absentNum = absentNum;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    public Short getExcellentNum() {
        return excellentNum;
    }

    public void setExcellentNum(Short excellentNum) {
        this.excellentNum = excellentNum;
    }

    public String getExcellentRate() {
        return excellentRate;
    }

    public void setExcellentRate(String excellentRate) {
        this.excellentRate = excellentRate == null ? null : excellentRate.trim();
    }

    public Short getGooldNum() {
        return gooldNum;
    }

    public void setGooldNum(Short gooldNum) {
        this.gooldNum = gooldNum;
    }

    public String getGooldRate() {
        return gooldRate;
    }

    public void setGooldRate(String gooldRate) {
        this.gooldRate = gooldRate == null ? null : gooldRate.trim();
    }

    public Short getPassNum() {
        return passNum;
    }

    public void setPassNum(Short passNum) {
        this.passNum = passNum;
    }

    public String getPassRate() {
        return passRate;
    }

    public void setPassRate(String passRate) {
        this.passRate = passRate == null ? null : passRate.trim();
    }

    public Short getFailNum() {
        return failNum;
    }

    public void setFailNum(Short failNum) {
        this.failNum = failNum;
    }

    public String getFailRate() {
        return failRate;
    }

    public void setFailRate(String failRate) {
        this.failRate = failRate == null ? null : failRate.trim();
    }

    public Float getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(Float highestScore) {
        this.highestScore = highestScore;
    }

    public Float getMinimumScore() {
        return minimumScore;
    }

    public void setMinimumScore(Float minimumScore) {
        this.minimumScore = minimumScore;
    }

    public String getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(String standardDeviation) {
        this.standardDeviation = standardDeviation == null ? null : standardDeviation.trim();
    }

    public Short getRanking() {
        return ranking;
    }

    public void setRanking(Short ranking) {
        this.ranking = ranking;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}