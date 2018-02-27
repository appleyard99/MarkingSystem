package com.education.mapper;

import com.education.domain.Terminfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TerminfoMapper {
    @Delete({
        "delete from terminfo",
        "where termid = #{termid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer termid);

    @Insert({
        "insert into terminfo (termid, yearid, ",
        "termname, startdate, ",
        "enddate, status)",
        "values (#{termid,jdbcType=INTEGER}, #{yearid,jdbcType=INTEGER}, ",
        "#{termname,jdbcType=VARCHAR}, #{startdate,jdbcType=DATE}, ",
        "#{enddate,jdbcType=DATE}, #{status,jdbcType=TINYINT})"
    })
    int insert(Terminfo record);

    @Select({
        "select",
        "termid, yearid, termname, startdate, enddate, status",
        "from terminfo",
        "where termid = #{termid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="yearid", property="yearid", jdbcType=JdbcType.INTEGER),
        @Result(column="termname", property="termname", jdbcType=JdbcType.VARCHAR),
        @Result(column="startdate", property="startdate", jdbcType=JdbcType.DATE),
        @Result(column="enddate", property="enddate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Terminfo selectByPrimaryKey(Integer termid);

    @Select({
        "select",
        "termid, yearid, termname, startdate, enddate, status",
        "from terminfo"
    })
    @Results({
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="yearid", property="yearid", jdbcType=JdbcType.INTEGER),
        @Result(column="termname", property="termname", jdbcType=JdbcType.VARCHAR),
        @Result(column="startdate", property="startdate", jdbcType=JdbcType.DATE),
        @Result(column="enddate", property="enddate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Terminfo> selectAll();

    @Update({
        "update terminfo",
        "set yearid = #{yearid,jdbcType=INTEGER},",
          "termname = #{termname,jdbcType=VARCHAR},",
          "startdate = #{startdate,jdbcType=DATE},",
          "enddate = #{enddate,jdbcType=DATE},",
          "status = #{status,jdbcType=TINYINT}",
        "where termid = #{termid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Terminfo record);
}