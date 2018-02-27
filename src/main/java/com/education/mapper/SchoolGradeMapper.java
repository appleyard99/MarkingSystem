package com.education.mapper;

import com.education.domain.SchoolGrade;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SchoolGradeMapper {
    @Delete({
        "delete from school_grade",
        "where sgid = #{sgid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer sgid);

    @Insert({
        "insert into school_grade (sgid, schoolid, ",
        "campusid, gradeid, ",
        "gradename, stageid, ",
        "status)",
        "values (#{sgid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{gradeid,jdbcType=INTEGER}, ",
        "#{gradename,jdbcType=VARCHAR}, #{stageid,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT})"
    })
    int insert(SchoolGrade record);

    @Select({
        "select",
        "sgid, schoolid, campusid, gradeid, gradename, stageid, status",
        "from school_grade",
        "where sgid = #{sgid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="sgid", property="sgid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradename", property="gradename", jdbcType=JdbcType.VARCHAR),
        @Result(column="stageid", property="stageid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    SchoolGrade selectByPrimaryKey(Integer sgid);

    @Select({
        "select",
        "sgid, schoolid, campusid, gradeid, gradename, stageid, status",
        "from school_grade"
    })
    @Results({
        @Result(column="sgid", property="sgid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradename", property="gradename", jdbcType=JdbcType.VARCHAR),
        @Result(column="stageid", property="stageid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<SchoolGrade> selectAll();

    @Update({
        "update school_grade",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "gradename = #{gradename,jdbcType=VARCHAR},",
          "stageid = #{stageid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where sgid = #{sgid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SchoolGrade record);
}