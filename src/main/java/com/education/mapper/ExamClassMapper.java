package com.education.mapper;

import com.education.domain.ExamClass;
import com.education.domain.vo.RpcenterClassVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExamClassMapper {
	@Delete({
			"delete from exam_class",
			"where excid = #{excid,jdbcType=INTEGER}"
	})
	int deleteByPrimaryKey(Integer excid);

	@Insert({
			"insert into exam_class (excid, examid, ",
			"subjectid, classid, ",
			"classname, gradeid, ",
			"gradename, teacherid, ",
			"created_at, classcount, ",
			"submitcount, markcount, ",
			"starttime, endtime, ",
			"showtimedatetime, checkstatus, ",
			"avgscore, ranking)",
			"values (#{excid,jdbcType=INTEGER}, #{examid,jdbcType=INTEGER}, ",
			"#{subjectid,jdbcType=INTEGER}, #{classid,jdbcType=INTEGER}, ",
			"#{classname,jdbcType=VARCHAR}, #{gradeid,jdbcType=INTEGER}, ",
			"#{gradename,jdbcType=VARCHAR}, #{teacherid,jdbcType=INTEGER}, ",
			"#{createdAt,jdbcType=TIMESTAMP}, #{classcount,jdbcType=INTEGER}, ",
			"#{submitcount,jdbcType=INTEGER}, #{markcount,jdbcType=INTEGER}, ",
			"#{starttime,jdbcType=TIMESTAMP}, #{endtime,jdbcType=TIMESTAMP}, ",
			"#{showtimedatetime,jdbcType=TIMESTAMP}, #{checkstatus,jdbcType=TINYINT}, ",
			"#{avgscore,jdbcType=REAL}, #{ranking,jdbcType=INTEGER})"
	})
	int insert(ExamClass record);

	@Select({
			"select",
			"excid, examid, subjectid, classid, classname, gradeid, gradename, teacherid, ",
			"created_at, classcount, submitcount, markcount, starttime, endtime, showtimedatetime, ",
			"checkstatus, avgscore, ranking",
			"from exam_class",
			"where excid = #{excid,jdbcType=INTEGER}"
	})
	@Results({
			@Result(column = "excid", property = "excid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "examid", property = "examid", jdbcType = JdbcType.INTEGER),
			@Result(column = "subjectid", property = "subjectid", jdbcType = JdbcType.INTEGER),
			@Result(column = "classid", property = "classid", jdbcType = JdbcType.INTEGER),
			@Result(column = "classname", property = "classname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "gradeid", property = "gradeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "gradename", property = "gradename", jdbcType = JdbcType.VARCHAR),
			@Result(column = "teacherid", property = "teacherid", jdbcType = JdbcType.INTEGER),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "classcount", property = "classcount", jdbcType = JdbcType.INTEGER),
			@Result(column = "submitcount", property = "submitcount", jdbcType = JdbcType.INTEGER),
			@Result(column = "markcount", property = "markcount", jdbcType = JdbcType.INTEGER),
			@Result(column = "starttime", property = "starttime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "endtime", property = "endtime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "showtimedatetime", property = "showtimedatetime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "checkstatus", property = "checkstatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "avgscore", property = "avgscore", jdbcType = JdbcType.REAL),
			@Result(column = "ranking", property = "ranking", jdbcType = JdbcType.INTEGER)
	})
	ExamClass selectByPrimaryKey(Integer excid);

	@Select({
			"select",
			"excid, examid, subjectid, classid, classname, gradeid, gradename, teacherid, ",
			"created_at, classcount, submitcount, markcount, starttime, endtime, showtimedatetime, ",
			"checkstatus, avgscore, ranking",
			"from exam_class"
	})
	@Results({
			@Result(column = "excid", property = "excid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "examid", property = "examid", jdbcType = JdbcType.INTEGER),
			@Result(column = "subjectid", property = "subjectid", jdbcType = JdbcType.INTEGER),
			@Result(column = "classid", property = "classid", jdbcType = JdbcType.INTEGER),
			@Result(column = "classname", property = "classname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "gradeid", property = "gradeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "gradename", property = "gradename", jdbcType = JdbcType.VARCHAR),
			@Result(column = "teacherid", property = "teacherid", jdbcType = JdbcType.INTEGER),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "classcount", property = "classcount", jdbcType = JdbcType.INTEGER),
			@Result(column = "submitcount", property = "submitcount", jdbcType = JdbcType.INTEGER),
			@Result(column = "markcount", property = "markcount", jdbcType = JdbcType.INTEGER),
			@Result(column = "starttime", property = "starttime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "endtime", property = "endtime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "showtimedatetime", property = "showtimedatetime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "checkstatus", property = "checkstatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "avgscore", property = "avgscore", jdbcType = JdbcType.REAL),
			@Result(column = "ranking", property = "ranking", jdbcType = JdbcType.INTEGER)
	})
	List<ExamClass> selectAll();

	@Update({
			"update exam_class",
			"set examid = #{examid,jdbcType=INTEGER},",
			"subjectid = #{subjectid,jdbcType=INTEGER},",
			"classid = #{classid,jdbcType=INTEGER},",
			"classname = #{classname,jdbcType=VARCHAR},",
			"gradeid = #{gradeid,jdbcType=INTEGER},",
			"gradename = #{gradename,jdbcType=VARCHAR},",
			"teacherid = #{teacherid,jdbcType=INTEGER},",
			"created_at = #{createdAt,jdbcType=TIMESTAMP},",
			"classcount = #{classcount,jdbcType=INTEGER},",
			"submitcount = #{submitcount,jdbcType=INTEGER},",
			"markcount = #{markcount,jdbcType=INTEGER},",
			"starttime = #{starttime,jdbcType=TIMESTAMP},",
			"endtime = #{endtime,jdbcType=TIMESTAMP},",
			"showtimedatetime = #{showtimedatetime,jdbcType=TIMESTAMP},",
			"checkstatus = #{checkstatus,jdbcType=TINYINT},",
			"avgscore = #{avgscore,jdbcType=REAL},",
			"ranking = #{ranking,jdbcType=INTEGER}",
			"where excid = #{excid,jdbcType=INTEGER}"
	})
	int updateByPrimaryKey(ExamClass record);

	@Select({
			"select",
			" classid, classname ",
			" from exam_class ",
			" where examid = #{id,jdbcType=INTEGER}"
	})
	List<ExamClass> getExamClass(Integer id);

	/**
	 *@Description: 获取某次考试发布的班级信息
	 *@author Lvxianya
	 *@date 2018/2/6
	 */
	@Select({
		"<script> ",
		"SELECT `classid`,`classname`",
		"FROM exam_class",
		"<where>",
		"<if test=\"examid != null\">examid=#{examid, jdbcType=INTEGER}</if>",
		"<if test=\"classid != null\"> AND classid=#{classid, jdbcType=INTEGER}</if>",
		"</where>",
		"</script> "
	})
    List<RpcenterClassVo> getExamClasses(@Param("examid") Integer examid, @Param("classid") Integer classid);
}