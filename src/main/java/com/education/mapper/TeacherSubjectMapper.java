package com.education.mapper;

import com.education.domain.TeacherSubject;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TeacherSubjectMapper {
    @Delete({
        "delete from teacher_subject",
        "where tsid = #{tsid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tsid);

    @Insert({
        "insert into teacher_subject (tsid, schoolid, ",
        "campusid, termid, ",
        "gradeid, subjectid, ",
        "teacherid, status)",
        "values (#{tsid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{termid,jdbcType=INTEGER}, ",
        "#{gradeid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER}, ",
        "#{teacherid,jdbcType=INTEGER}, #{status,jdbcType=TINYINT})"
    })
    int insert(TeacherSubject record);

    @Select({
        "select",
        "tsid, schoolid, campusid, termid, gradeid, subjectid, teacherid, status",
        "from teacher_subject",
        "where tsid = #{tsid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tsid", property="tsid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    TeacherSubject selectByPrimaryKey(Integer tsid);

    @Select({
        "select",
        "tsid, schoolid, campusid, termid, gradeid, subjectid, teacherid, status",
        "from teacher_subject"
    })
    @Results({
        @Result(column="tsid", property="tsid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<TeacherSubject> selectAll();

    @Update({
        "update teacher_subject",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "teacherid = #{teacherid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where tsid = #{tsid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TeacherSubject record);
}