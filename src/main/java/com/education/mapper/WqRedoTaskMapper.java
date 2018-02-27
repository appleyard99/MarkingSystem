package com.education.mapper;

import com.education.domain.WqRedoTask;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WqRedoTaskMapper {
    @Delete({
        "delete from wq_redo_task",
        "where redotaskid = #{redotaskid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer redotaskid);

    @Insert({
        "insert into wq_redo_task (redotaskid, startday, ",
        "endday, studentid, ",
        "status, schoolid, ",
        "campusid, classid, ",
        "gradeid, termid, ",
        "created_at, updated_at)",
        "values (#{redotaskid,jdbcType=INTEGER}, #{startday,jdbcType=DATE}, ",
        "#{endday,jdbcType=DATE}, #{studentid,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{classid,jdbcType=INTEGER}, ",
        "#{gradeid,jdbcType=INTEGER}, #{termid,jdbcType=INTEGER}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(WqRedoTask record);

    @Select({
        "select",
        "redotaskid, startday, endday, studentid, status, schoolid, campusid, classid, ",
        "gradeid, termid, created_at, updated_at",
        "from wq_redo_task",
        "where redotaskid = #{redotaskid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="redotaskid", property="redotaskid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="startday", property="startday", jdbcType=JdbcType.DATE),
        @Result(column="endday", property="endday", jdbcType=JdbcType.DATE),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    WqRedoTask selectByPrimaryKey(Integer redotaskid);

    @Select({
        "select",
        "redotaskid, startday, endday, studentid, status, schoolid, campusid, classid, ",
        "gradeid, termid, created_at, updated_at",
        "from wq_redo_task"
    })
    @Results({
        @Result(column="redotaskid", property="redotaskid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="startday", property="startday", jdbcType=JdbcType.DATE),
        @Result(column="endday", property="endday", jdbcType=JdbcType.DATE),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WqRedoTask> selectAll();

    @Update({
        "update wq_redo_task",
        "set startday = #{startday,jdbcType=DATE},",
          "endday = #{endday,jdbcType=DATE},",
          "studentid = #{studentid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where redotaskid = #{redotaskid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WqRedoTask record);
}