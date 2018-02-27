package com.education.domain.vo;

/**
 * @author mgg
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: 题目知识点
 * @date 2018/2/27
 */
public class QbKnowledgeVo {

    private Integer questionbankid;
    private Integer kiid;
    private String knowname;


    public Integer getQuestionbankid() {
        return questionbankid;
    }

    public void setQuestionbankid(Integer questionbankid) {
        this.questionbankid = questionbankid;
    }

    public String getKnowname() {
        return knowname;
    }

    public void setKnowname(String knowname) {
        this.knowname = knowname == null ? null : knowname.trim();
    }

    public Integer getKiid() {
        return kiid;
    }

    public void setKiid(Integer kiid) {
        this.kiid = kiid;
    }


}
