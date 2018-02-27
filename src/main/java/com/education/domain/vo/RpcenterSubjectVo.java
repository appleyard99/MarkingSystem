package com.education.domain.vo;

/**
 * 报表中心-班级-科目
 *
 * @author YangShuan
 * @create 2018/2/1
 */
public class RpcenterSubjectVo {
	private String subjectid;
	private Integer examid;
	private String subject;

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public Integer getExamid() {
		return examid;
	}

	public void setExamid(Integer examid) {
		this.examid = examid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
