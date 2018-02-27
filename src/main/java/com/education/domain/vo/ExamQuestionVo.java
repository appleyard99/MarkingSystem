package com.education.domain.vo;

/**
 * @program: markingsystem
 * @description: 试卷大题名称和总分
 * @author: Lvxianya
 * @create: 2018-01-31
 **/
public class ExamQuestionVo {
    /*学生id,用于获取学生各大题答题情况*/
    private Integer studentid;

    private String qstitle;
    private String qsgroup;
    private Float score;

    private Byte type;
    private Integer num;

    public String getQstitle() {
        return qstitle;
    }

    public void setQstitle(String qstitle) {
        this.qstitle = qstitle;
    }

    public String getQsgroup() {
        return qsgroup;
    }

    public void setQsgroup(String qsgroup) {
        this.qsgroup = qsgroup;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
