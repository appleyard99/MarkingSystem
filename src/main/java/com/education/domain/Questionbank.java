package com.education.domain;

import java.util.Date;

public class Questionbank {
    private Integer questionbankid;

    private Integer schoolid;

    private Integer subjectid;

    private Byte type;

    private Float score;

    private Byte difficulty;

    private Byte correcttype;

    private Byte answernum;

    private Byte status;

    private Byte share;

    private String mcqscore;

    private Integer createby;

    private Date createdAt;

    private Integer usecount;

    private Integer updatedby;

    private Date updatedAt;

    private String pdfpath;

    private String wordpath;

    private String imgpath;

    private String htmlpath;

    public Integer getQuestionbankid() {
        return questionbankid;
    }

    public void setQuestionbankid(Integer questionbankid) {
        this.questionbankid = questionbankid;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Byte getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Byte difficulty) {
        this.difficulty = difficulty;
    }

    public Byte getCorrecttype() {
        return correcttype;
    }

    public void setCorrecttype(Byte correcttype) {
        this.correcttype = correcttype;
    }

    public Byte getAnswernum() {
        return answernum;
    }

    public void setAnswernum(Byte answernum) {
        this.answernum = answernum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getShare() {
        return share;
    }

    public void setShare(Byte share) {
        this.share = share;
    }

    public String getMcqscore() {
        return mcqscore;
    }

    public void setMcqscore(String mcqscore) {
        this.mcqscore = mcqscore == null ? null : mcqscore.trim();
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

    public Integer getUsecount() {
        return usecount;
    }

    public void setUsecount(Integer usecount) {
        this.usecount = usecount;
    }

    public Integer getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(Integer updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPdfpath() {
        return pdfpath;
    }

    public void setPdfpath(String pdfpath) {
        this.pdfpath = pdfpath == null ? null : pdfpath.trim();
    }

    public String getWordpath() {
        return wordpath;
    }

    public void setWordpath(String wordpath) {
        this.wordpath = wordpath == null ? null : wordpath.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public String getHtmlpath() {
        return htmlpath;
    }

    public void setHtmlpath(String htmlpath) {
        this.htmlpath = htmlpath == null ? null : htmlpath.trim();
    }
}