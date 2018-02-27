package com.education.domain.vo;

import java.util.List;

/**
 * @program: markingsystem
 * @description:
 * @author: Lvxianya
 * @create: 2018-01-31
 **/
public class ReportExamVo {

    private Integer studentid;
    private Float score;
    private Integer ranking;
    private Byte status;
    private String username;
    private String usercode;
    private List<Float> scoreList;

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public List<Float> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Float> scoreList) {
        this.scoreList = scoreList;
    }
}
