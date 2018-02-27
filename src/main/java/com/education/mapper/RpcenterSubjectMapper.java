package com.education.mapper;

import com.education.domain.RpcenterSubject;

import java.util.List;

import com.education.domain.vo.RpcenterSubjectVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface RpcenterSubjectMapper {
	@Delete({
			"delete from rpcenter_subject",
			"where rpsid = #{rpsid,jdbcType=INTEGER}"
	})
	int deleteByPrimaryKey(Integer rpsid);

	@Insert({
			"insert into rpcenter_subject (rpsid, rpcid, ",
			"type, subjectid, ",
			"examid, created_at, ",
			"status)",
			"values (#{rpsid,jdbcType=INTEGER}, #{rpcid,jdbcType=INTEGER}, ",
			"#{type,jdbcType=TINYINT}, #{subjectid,jdbcType=INTEGER}, ",
			"#{examid,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
			"#{status,jdbcType=TINYINT})"
	})
	int insert(RpcenterSubject record);

	@Select({
			"select",
			"rpsid, rpcid, type, subjectid, examid, created_at, status",
			"from rpcenter_subject",
			"where rpsid = #{rpsid,jdbcType=INTEGER}"
	})
	@Results({
			@Result(column = "rpsid", property = "rpsid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "rpcid", property = "rpcid", jdbcType = JdbcType.INTEGER),
			@Result(column = "type", property = "type", jdbcType = JdbcType.TINYINT),
			@Result(column = "subjectid", property = "subjectid", jdbcType = JdbcType.INTEGER),
			@Result(column = "examid", property = "examid", jdbcType = JdbcType.INTEGER),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT)
	})
	RpcenterSubject selectByPrimaryKey(Integer rpsid);

	@Select({
			"select",
			"rpsid, rpcid, type, subjectid, examid, created_at, status",
			"from rpcenter_subject"
	})
	@Results({
			@Result(column = "rpsid", property = "rpsid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "rpcid", property = "rpcid", jdbcType = JdbcType.INTEGER),
			@Result(column = "type", property = "type", jdbcType = JdbcType.TINYINT),
			@Result(column = "subjectid", property = "subjectid", jdbcType = JdbcType.INTEGER),
			@Result(column = "examid", property = "examid", jdbcType = JdbcType.INTEGER),
			@Result(column = "created_at", property = "createdAt", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT)
	})
	List<RpcenterSubject> selectAll();

	@Update({
			"update rpcenter_subject",
			"set rpcid = #{rpcid,jdbcType=INTEGER},",
			"type = #{type,jdbcType=TINYINT},",
			"subjectid = #{subjectid,jdbcType=INTEGER},",
			"examid = #{examid,jdbcType=INTEGER},",
			"created_at = #{createdAt,jdbcType=TIMESTAMP},",
			"status = #{status,jdbcType=TINYINT}",
			"where rpsid = #{rpsid,jdbcType=INTEGER}"
	})
	int updateByPrimaryKey(RpcenterSubject record);


	@Select({
			"select",
			" a.subjectid,a.examid,b.subject ",
			" from rpcenter_subject a LEFT JOIN school_subject b ON a.subjectid = b.subjectid ",
			" where a.rpcid =#{arg0,jdbcType=INTEGER} and a.status= 1 AND b.schoolid =#{arg1,jdbcType=INTEGER} GROUP BY subjectid "
	})
	List<RpcenterSubjectVo> getSubject(Integer rpcid, Integer schoolId);
}