package com.education.mapper;

import com.education.domain.WrongQuestionReason;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WrongQuestionReasonMapper {
    @Delete({
        "delete from wrong_question_reason",
        "where wqrid = #{wqrid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer wqrid);

    @Insert({
        "insert into wrong_question_reason (wqrid, wqid, ",
        "wrid, created_at, ",
        "updated_at, status, ",
        "userid, subjectid)",
        "values (#{wqrid,jdbcType=INTEGER}, #{wqid,jdbcType=INTEGER}, ",
        "#{wrid,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updatedAt,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT}, ",
        "#{userid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER})"
    })
    int insert(WrongQuestionReason record);

    @Select({
        "select",
        "wqrid, wqid, wrid, created_at, updated_at, status, userid, subjectid",
        "from wrong_question_reason",
        "where wqrid = #{wqrid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="wqrid", property="wqrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="wqid", property="wqid", jdbcType=JdbcType.INTEGER),
        @Result(column="wrid", property="wrid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER)
    })
    WrongQuestionReason selectByPrimaryKey(Integer wqrid);

    @Select({
        "select",
        "wqrid, wqid, wrid, created_at, updated_at, status, userid, subjectid",
        "from wrong_question_reason"
    })
    @Results({
        @Result(column="wqrid", property="wqrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="wqid", property="wqid", jdbcType=JdbcType.INTEGER),
        @Result(column="wrid", property="wrid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER)
    })
    List<WrongQuestionReason> selectAll();

    @Update({
        "update wrong_question_reason",
        "set wqid = #{wqid,jdbcType=INTEGER},",
          "wrid = #{wrid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "userid = #{userid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER}",
        "where wqrid = #{wqrid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WrongQuestionReason record);
}