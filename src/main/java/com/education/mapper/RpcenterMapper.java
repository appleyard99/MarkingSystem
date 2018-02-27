package com.education.mapper;

import com.education.domain.Rpcenter;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface RpcenterMapper {
	@Delete({
			"delete from rpcenter",
			"where rpcid = #{rpcid,jdbcType=INTEGER}"
	})
	int deleteByPrimaryKey(Integer rpcid);

	@Insert({
			"insert into rpcenter (rpcid, examname, ",
			"schoolid, yearid, ",
			"gradeid, createby, ",
			"examtype, subject, ",
			"custom_score, exam_time, ",
			"updated_at, created_at, ",
			"status)",
			"values (#{rpcid,jdbcType=INTEGER}, #{examname,jdbcType=VARCHAR}, ",
			"#{schoolid,jdbcType=INTEGER}, #{yearid,jdbcType=INTEGER}, ",
			"#{gradeid,jdbcType=INTEGER}, #{createby,jdbcType=INTEGER}, ",
			"#{examtype,jdbcType=TINYINT}, #{subject,jdbcType=VARCHAR}, ",
			"#{customScore,jdbcType=TINYINT}, #{examTime,jdbcType=TIMESTAMP}, ",
			"#{updatedAt,jdbcType=TIMESTAMP}, #{createdAt,jdbcType=TIMESTAMP}, ",
			"#{status,jdbcType=TINYINT})"
	})
	int insert(Rpcenter record);

	@Select({
			"select",
			"rpcid, examname, schoolid, yearid, gradeid, createby, examtype, subject, custom_score, ",
			"exam_time, updated_at, created_at, status",
			"from rpcenter",
			"where rpcid = #{rpcid,jdbcType=INTEGER}"
	})
	@Results({
			@Result(column = "rpcid", property = "rpcid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "examname", property = "examname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "schoolid", property = "schoolid", jdbcType = JdbcType.INTEGER),
			@Result(column = "yearid", property = "yearid", jdbcType = JdbcType.INTEGER),
			@Result(column = "gradeid", property = "gradeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "createby", property = "createby", jdbcType = JdbcType.INTEGER),
			@Result(column = "examtype", property = "examtype", jdbcType = JdbcType.TINYINT),
			@Result(column = "subject", property = "subject", jdbcType = JdbcType.VARCHAR),
			@Result(column = "custom_score", property = "customScore", jdbcType = JdbcType.TINYINT),
			@Result(column = "exam_time", property = "examTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT)
	})
	Rpcenter selectByPrimaryKey(Integer rpcid);

	@Select({
			"select",
			"rpcid, examname, schoolid, yearid, gradeid, createby, examtype, subject, custom_score, ",
			"exam_time, updated_at, created_at, status",
			"from rpcenter"
	})
	@Results({
			@Result(column = "rpcid", property = "rpcid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "examname", property = "examname", jdbcType = JdbcType.VARCHAR),
			@Result(column = "schoolid", property = "schoolid", jdbcType = JdbcType.INTEGER),
			@Result(column = "yearid", property = "yearid", jdbcType = JdbcType.INTEGER),
			@Result(column = "gradeid", property = "gradeid", jdbcType = JdbcType.INTEGER),
			@Result(column = "createby", property = "createby", jdbcType = JdbcType.INTEGER),
			@Result(column = "examtype", property = "examtype", jdbcType = JdbcType.TINYINT),
			@Result(column = "subject", property = "subject", jdbcType = JdbcType.VARCHAR),
			@Result(column = "custom_score", property = "customScore", jdbcType = JdbcType.TINYINT),
			@Result(column = "exam_time", property = "examTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT)
	})
	List<Rpcenter> selectAll();

	@Update({
			"update rpcenter",
			"set examname = #{examname,jdbcType=VARCHAR},",
			"schoolid = #{schoolid,jdbcType=INTEGER},",
			"yearid = #{yearid,jdbcType=INTEGER},",
			"gradeid = #{gradeid,jdbcType=INTEGER},",
			"createby = #{createby,jdbcType=INTEGER},",
			"examtype = #{examtype,jdbcType=TINYINT},",
			"subject = #{subject,jdbcType=VARCHAR},",
			"custom_score = #{customScore,jdbcType=TINYINT},",
			"exam_time = #{examTime,jdbcType=TIMESTAMP},",
			"updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
			"created_at = #{createdAt,jdbcType=TIMESTAMP},",
			"status = #{status,jdbcType=TINYINT}",
			"where rpcid = #{rpcid,jdbcType=INTEGER}"
	})
	int updateByPrimaryKey(Rpcenter record);


	/**
	 * @Description: 判断报表是否包含`语数外总分`
	 * @author YangShuan
	 * @date 2018/2/6
	 */
	@Select({
			"select",
			"custom_score",
			"from rpcenter",
			"where rpcid = #{rpcid,jdbcType=INTEGER} and status>0"
	})
	Integer isYSWScore(Integer rpcid);
}