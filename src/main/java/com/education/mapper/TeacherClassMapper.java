package com.education.mapper;

import com.education.domain.TeacherClass;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TeacherClassMapper {
    @Delete({
        "delete from teacher_class",
        "where tcid = #{tcid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tcid);

    @Insert({
        "insert into teacher_class (tcid, teacherid, ",
        "classid, termid, ",
        "gradeid, subjectid, ",
        "schoolid, campusid, ",
        "status, type)",
        "values (#{tcid,jdbcType=INTEGER}, #{teacherid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{termid,jdbcType=INTEGER}, ",
        "#{gradeid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER}, ",
        "#{schoolid,jdbcType=INTEGER}, #{campusid,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT}, #{type,jdbcType=BIT})"
    })
    int insert(TeacherClass record);

    @Select({
        "select",
        "tcid, teacherid, classid, termid, gradeid, subjectid, schoolid, campusid, status, ",
        "type",
        "from teacher_class",
        "where tcid = #{tcid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tcid", property="tcid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT)
    })
    TeacherClass selectByPrimaryKey(Integer tcid);

    @Select({
        "select",
        "tcid, teacherid, classid, termid, gradeid, subjectid, schoolid, campusid, status, ",
        "type",
        "from teacher_class"
    })
    @Results({
        @Result(column="tcid", property="tcid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT)
    })
    List<TeacherClass> selectAll();

    @Update({
        "update teacher_class",
        "set teacherid = #{teacherid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "type = #{type,jdbcType=BIT}",
        "where tcid = #{tcid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TeacherClass record);
}