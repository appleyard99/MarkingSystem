package com.education.mapper;

import com.education.domain.Systemlog;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SystemlogMapper {
    @Delete({
        "delete from systemlog",
        "where logid = #{logid,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long logid);

    @Insert({
        "insert into systemlog (logid, userid, ",
        "schoolid, level, ",
        "source, module, ",
        "controller, action, ",
        "recordid, created_at, ",
        "ip, message, subjectid, ",
        "types, usercategory, ",
        "useragent, classid, ",
        "browser, remarks)",
        "values (#{logid,jdbcType=BIGINT}, #{userid,jdbcType=BIGINT}, ",
        "#{schoolid,jdbcType=INTEGER}, #{level,jdbcType=TINYINT}, ",
        "#{source,jdbcType=TINYINT}, #{module,jdbcType=VARCHAR}, ",
        "#{controller,jdbcType=VARCHAR}, #{action,jdbcType=VARCHAR}, ",
        "#{recordid,jdbcType=VARCHAR}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{ip,jdbcType=VARCHAR}, #{message,jdbcType=VARCHAR}, #{subjectid,jdbcType=INTEGER}, ",
        "#{types,jdbcType=TINYINT}, #{usercategory,jdbcType=VARCHAR}, ",
        "#{useragent,jdbcType=VARCHAR}, #{classid,jdbcType=INTEGER}, ",
        "#{browser,jdbcType=VARCHAR}, #{remarks,jdbcType=LONGVARCHAR})"
    })
    int insert(Systemlog record);

    @Select({
        "select",
        "logid, userid, schoolid, level, source, module, controller, action, recordid, ",
        "created_at, ip, message, subjectid, types, usercategory, useragent, classid, ",
        "browser, remarks",
        "from systemlog",
        "where logid = #{logid,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="logid", property="logid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.BIGINT),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="source", property="source", jdbcType=JdbcType.TINYINT),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="controller", property="controller", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="recordid", property="recordid", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="types", property="types", jdbcType=JdbcType.TINYINT),
        @Result(column="usercategory", property="usercategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="useragent", property="useragent", jdbcType=JdbcType.VARCHAR),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="browser", property="browser", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.LONGVARCHAR)
    })
    Systemlog selectByPrimaryKey(Long logid);

    @Select({
        "select",
        "logid, userid, schoolid, level, source, module, controller, action, recordid, ",
        "created_at, ip, message, subjectid, types, usercategory, useragent, classid, ",
        "browser, remarks",
        "from systemlog"
    })
    @Results({
        @Result(column="logid", property="logid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.BIGINT),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="source", property="source", jdbcType=JdbcType.TINYINT),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="controller", property="controller", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="recordid", property="recordid", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="types", property="types", jdbcType=JdbcType.TINYINT),
        @Result(column="usercategory", property="usercategory", jdbcType=JdbcType.VARCHAR),
        @Result(column="useragent", property="useragent", jdbcType=JdbcType.VARCHAR),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="browser", property="browser", jdbcType=JdbcType.VARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Systemlog> selectAll();

    @Update({
        "update systemlog",
        "set userid = #{userid,jdbcType=BIGINT},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "level = #{level,jdbcType=TINYINT},",
          "source = #{source,jdbcType=TINYINT},",
          "module = #{module,jdbcType=VARCHAR},",
          "controller = #{controller,jdbcType=VARCHAR},",
          "action = #{action,jdbcType=VARCHAR},",
          "recordid = #{recordid,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "message = #{message,jdbcType=VARCHAR},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "types = #{types,jdbcType=TINYINT},",
          "usercategory = #{usercategory,jdbcType=VARCHAR},",
          "useragent = #{useragent,jdbcType=VARCHAR},",
          "classid = #{classid,jdbcType=INTEGER},",
          "browser = #{browser,jdbcType=VARCHAR},",
          "remarks = #{remarks,jdbcType=LONGVARCHAR}",
        "where logid = #{logid,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Systemlog record);
}