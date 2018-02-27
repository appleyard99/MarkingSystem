package com.education.mapper;

import com.education.domain.AttentionStudent;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AttentionStudentMapper {
    @Delete({
        "delete from attention_student",
        "where asid = #{asid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer asid);

    @Insert({
        "insert into attention_student (asid, teacherid, ",
        "classid, termid, ",
        "studentid, created_at, ",
        "reason, status, ",
        "updated_at)",
        "values (#{asid,jdbcType=INTEGER}, #{teacherid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{termid,jdbcType=INTEGER}, ",
        "#{studentid,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{reason,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(AttentionStudent record);

    @Select({
        "select",
        "asid, teacherid, classid, termid, studentid, created_at, reason, status, updated_at",
        "from attention_student",
        "where asid = #{asid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="asid", property="asid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    AttentionStudent selectByPrimaryKey(Integer asid);

    @Select({
        "select",
        "asid, teacherid, classid, termid, studentid, created_at, reason, status, updated_at",
        "from attention_student"
    })
    @Results({
        @Result(column="asid", property="asid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AttentionStudent> selectAll();

    @Update({
        "update attention_student",
        "set teacherid = #{teacherid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "studentid = #{studentid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where asid = #{asid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AttentionStudent record);
}