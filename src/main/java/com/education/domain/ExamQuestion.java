package com.education.domain;

public class ExamQuestion {
    private Integer questionid;

    private Integer examid;

    private Integer questionbankid;

    private Integer seqno;

    private Byte type;

    private Float score;

    private Float mcqscore;

    private Byte answernum;

    private Byte difficulty;

    private String remark;

    private Byte correcttype;

    private String qstitle;

    private String qsgroup;

    private Byte maxitemnum;

    private Float scoreline;

    private Integer rowindex;

    private Integer cellindex;

    private Byte ismerge;

    private String mergeidstr;

    private String seqname;

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getQuestionbankid() {
        return questionbankid;
    }

    public void setQuestionbankid(Integer questionbankid) {
        this.questionbankid = questionbankid;
    }

    public Integer getSeqno() {
        return seqno;
    }

    public void setSeqno(Integer seqno) {
        this.seqno = seqno;
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

    public Float getMcqscore() {
        return mcqscore;
    }

    public void setMcqscore(Float mcqscore) {
        this.mcqscore = mcqscore;
    }

    public Byte getAnswernum() {
        return answernum;
    }

    public void setAnswernum(Byte answernum) {
        this.answernum = answernum;
    }

    public Byte getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Byte difficulty) {
        this.difficulty = difficulty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getCorrecttype() {
        return correcttype;
    }

    public void setCorrecttype(Byte correcttype) {
        this.correcttype = correcttype;
    }

    public String getQstitle() {
        return qstitle;
    }

    public void setQstitle(String qstitle) {
        this.qstitle = qstitle == null ? null : qstitle.trim();
    }

    public String getQsgroup() {
        return qsgroup;
    }

    public void setQsgroup(String qsgroup) {
        this.qsgroup = qsgroup == null ? null : qsgroup.trim();
    }

    public Byte getMaxitemnum() {
        return maxitemnum;
    }

    public void setMaxitemnum(Byte maxitemnum) {
        this.maxitemnum = maxitemnum;
    }

    public Float getScoreline() {
        return scoreline;
    }

    public void setScoreline(Float scoreline) {
        this.scoreline = scoreline;
    }

    public Integer getRowindex() {
        return rowindex;
    }

    public void setRowindex(Integer rowindex) {
        this.rowindex = rowindex;
    }

    public Integer getCellindex() {
        return cellindex;
    }

    public void setCellindex(Integer cellindex) {
        this.cellindex = cellindex;
    }

    public Byte getIsmerge() {
        return ismerge;
    }

    public void setIsmerge(Byte ismerge) {
        this.ismerge = ismerge;
    }

    public String getMergeidstr() {
        return mergeidstr;
    }

    public void setMergeidstr(String mergeidstr) {
        this.mergeidstr = mergeidstr == null ? null : mergeidstr.trim();
    }

    public String getSeqname() {
        return seqname;
    }

    public void setSeqname(String seqname) {
        this.seqname = seqname == null ? null : seqname.trim();
    }
}