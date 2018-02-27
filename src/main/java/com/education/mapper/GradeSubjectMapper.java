package com.education.mapper;

import com.education.domain.GradeSubject;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface GradeSubjectMapper {
    @Delete({
        "delete from grade_subject",
        "where gsid = #{gsid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer gsid);

    @Insert({
        "insert into grade_subject (gsid, gradeid, ",
        "subjectid, schoolid, ",
        "campusid, status)",
        "values (#{gsid,jdbcType=INTEGER}, #{gradeid,jdbcType=INTEGER}, ",
        "#{subjectid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{status,jdbcType=TINYINT})"
    })
    int insert(GradeSubject record);

    @Select({
        "select",
        "gsid, gradeid, subjectid, schoolid, campusid, status",
        "from grade_subject",
        "where gsid = #{gsid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="gsid", property="gsid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    GradeSubject selectByPrimaryKey(Integer gsid);

    @Select({
        "select",
        "gsid, gradeid, subjectid, schoolid, campusid, status",
        "from grade_subject"
    })
    @Results({
        @Result(column="gsid", property="gsid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<GradeSubject> selectAll();

    @Update({
        "update grade_subject",
        "set gradeid = #{gradeid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where gsid = #{gsid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GradeSubject record);
}