package com.education.mapper;

import com.education.domain.SchoolSubject;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SchoolSubjectMapper {
    @Delete({
        "delete from school_subject",
        "where ssid = #{ssid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ssid);

    @Insert({
        "insert into school_subject (ssid, schoolid, ",
        "campusid, subjectid, ",
        "subject, createby, ",
        "createtime, updateby, ",
        "updatetime, status, ",
        "category)",
        "values (#{ssid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER}, ",
        "#{subject,jdbcType=VARCHAR}, #{createby,jdbcType=INTEGER}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{updateby,jdbcType=INTEGER}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT}, ",
        "#{category,jdbcType=TINYINT})"
    })
    int insert(SchoolSubject record);

    @Select({
        "select",
        "ssid, schoolid, campusid, subjectid, subject, createby, createtime, updateby, ",
        "updatetime, status, category",
        "from school_subject",
        "where ssid = #{ssid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ssid", property="ssid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="category", property="category", jdbcType=JdbcType.TINYINT)
    })
    SchoolSubject selectByPrimaryKey(Integer ssid);

    @Select({
        "select",
        "ssid, schoolid, campusid, subjectid, subject, createby, createtime, updateby, ",
        "updatetime, status, category",
        "from school_subject"
    })
    @Results({
        @Result(column="ssid", property="ssid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="category", property="category", jdbcType=JdbcType.TINYINT)
    })
    List<SchoolSubject> selectAll();

    @Update({
        "update school_subject",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "subject = #{subject,jdbcType=VARCHAR},",
          "createby = #{createby,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "updateby = #{updateby,jdbcType=INTEGER},",
          "updatetime = #{updatetime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "category = #{category,jdbcType=TINYINT}",
        "where ssid = #{ssid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SchoolSubject record);
}