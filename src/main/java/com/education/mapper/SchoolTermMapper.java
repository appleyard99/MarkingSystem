package com.education.mapper;

import com.education.domain.SchoolTerm;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SchoolTermMapper {
    @Delete({
        "delete from school_term",
        "where stid = #{stid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer stid);

    @Insert({
        "insert into school_term (stid, schoolid, ",
        "campusid, yearid, ",
        "termid, termname, ",
        "iscurrent)",
        "values (#{stid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{yearid,jdbcType=INTEGER}, ",
        "#{termid,jdbcType=INTEGER}, #{termname,jdbcType=VARCHAR}, ",
        "#{iscurrent,jdbcType=BIT})"
    })
    int insert(SchoolTerm record);

    @Select({
        "select",
        "stid, schoolid, campusid, yearid, termid, termname, iscurrent",
        "from school_term",
        "where stid = #{stid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="stid", property="stid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="yearid", property="yearid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="termname", property="termname", jdbcType=JdbcType.VARCHAR),
        @Result(column="iscurrent", property="iscurrent", jdbcType=JdbcType.BIT)
    })
    SchoolTerm selectByPrimaryKey(Integer stid);

    @Select({
        "select",
        "stid, schoolid, campusid, yearid, termid, termname, iscurrent",
        "from school_term"
    })
    @Results({
        @Result(column="stid", property="stid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="yearid", property="yearid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="termname", property="termname", jdbcType=JdbcType.VARCHAR),
        @Result(column="iscurrent", property="iscurrent", jdbcType=JdbcType.BIT)
    })
    List<SchoolTerm> selectAll();

    @Update({
        "update school_term",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "yearid = #{yearid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "termname = #{termname,jdbcType=VARCHAR},",
          "iscurrent = #{iscurrent,jdbcType=BIT}",
        "where stid = #{stid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SchoolTerm record);
}