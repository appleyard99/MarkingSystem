package com.education.mapper;

import com.education.domain.Knowledge;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface KnowledgeMapper {
    @Delete({
        "delete from knowledge",
        "where knowid = #{knowid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer knowid);

    @Insert({
        "insert into knowledge (knowid, knowname, ",
        "stageid, subjectid, ",
        "schoolid, status, ",
        "createby, created_at, ",
        "updateby, updated_at)",
        "values (#{knowid,jdbcType=INTEGER}, #{knowname,jdbcType=VARCHAR}, ",
        "#{stageid,jdbcType=TINYINT}, #{subjectid,jdbcType=INTEGER}, ",
        "#{schoolid,jdbcType=INTEGER}, #{status,jdbcType=TINYINT}, ",
        "#{createby,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updateby,jdbcType=INTEGER}, #{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(Knowledge record);

    @Select({
        "select",
        "knowid, knowname, stageid, subjectid, schoolid, status, createby, created_at, ",
        "updateby, updated_at",
        "from knowledge",
        "where knowid = #{knowid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="knowid", property="knowid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="knowname", property="knowname", jdbcType=JdbcType.VARCHAR),
        @Result(column="stageid", property="stageid", jdbcType=JdbcType.TINYINT),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    Knowledge selectByPrimaryKey(Integer knowid);

    @Select({
        "select",
        "knowid, knowname, stageid, subjectid, schoolid, status, createby, created_at, ",
        "updateby, updated_at",
        "from knowledge"
    })
    @Results({
        @Result(column="knowid", property="knowid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="knowname", property="knowname", jdbcType=JdbcType.VARCHAR),
        @Result(column="stageid", property="stageid", jdbcType=JdbcType.TINYINT),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Knowledge> selectAll();

    @Update({
        "update knowledge",
        "set knowname = #{knowname,jdbcType=VARCHAR},",
          "stageid = #{stageid,jdbcType=TINYINT},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "createby = #{createby,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updateby = #{updateby,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where knowid = #{knowid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Knowledge record);
}