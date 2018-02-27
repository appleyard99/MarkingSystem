package com.education.domain;

import java.util.Date;

public class ExamCorrect {
    private Integer correctid;

    private Integer wqid;

    private Integer examid;

    private Integer questionid;

    private Integer studentid;

    private Date correcttime;

    private String answer;

    private Byte status;

    public Integer getCorrectid() {
        return correctid;
    }

    public void setCorrectid(Integer correctid) {
        this.correctid = correctid;
    }

    public Integer getWqid() {
        return wqid;
    }

    public void setWqid(Integer wqid) {
        this.wqid = wqid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Date getCorrecttime() {
        return correcttime;
    }

    public void setCorrecttime(Date correcttime) {
        this.correcttime = correcttime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}