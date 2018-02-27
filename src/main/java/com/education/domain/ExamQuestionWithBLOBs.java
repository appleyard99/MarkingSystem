package com.education.domain;

public class ExamQuestionWithBLOBs extends ExamQuestion {
    private String body;

    private String analysis;

    private String result;

    private String otherresult;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getOtherresult() {
        return otherresult;
    }

    public void setOtherresult(String otherresult) {
        this.otherresult = otherresult == null ? null : otherresult.trim();
    }
}