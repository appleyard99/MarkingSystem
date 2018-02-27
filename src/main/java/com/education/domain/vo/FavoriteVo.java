package com.education.domain.vo;

import java.util.Date;

/**
 * @description 用户收藏
 * @author mgg;
 * @date 2018-02-07
 */
public class FavoriteVo {

    private Integer questionbankid;
    private Integer schoolid;
    private Byte type;
    private String body;
    private String analysis;
    private Integer usecount;

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
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Integer getUsecount() {
        return usecount;
    }

    public void setUsecount(Integer usecount) {
        this.usecount = usecount;
    }





}
