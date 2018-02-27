package com.education.mapper;

import com.education.domain.Yearinfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface YearinfoMapper {
    @Delete({
        "delete from yearinfo",
        "where yearid = #{yearid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer yearid);

    @Insert({
        "insert into yearinfo (yearid, yearname, ",
        "startdate, enddate, status)",
        "values (#{yearid,jdbcType=INTEGER}, #{yearname,jdbcType=VARCHAR}, ",
        "#{startdate,jdbcType=DATE}, #{enddate,jdbcType=DATE}, #{status,jdbcType=TINYINT})"
    })
    int insert(Yearinfo record);

    @Select({
        "select",
        "yearid, yearname, startdate, enddate, status",
        "from yearinfo",
        "where yearid = #{yearid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="yearid", property="yearid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="yearname", property="yearname", jdbcType=JdbcType.VARCHAR),
        @Result(column="startdate", property="startdate", jdbcType=JdbcType.DATE),
        @Result(column="enddate", property="enddate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Yearinfo selectByPrimaryKey(Integer yearid);

    @Select({
        "select",
        "yearid, yearname, startdate, enddate, status",
        "from yearinfo"
    })
    @Results({
        @Result(column="yearid", property="yearid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="yearname", property="yearname", jdbcType=JdbcType.VARCHAR),
        @Result(column="startdate", property="startdate", jdbcType=JdbcType.DATE),
        @Result(column="enddate", property="enddate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Yearinfo> selectAll();

    @Update({
        "update yearinfo",
        "set yearname = #{yearname,jdbcType=VARCHAR},",
          "startdate = #{startdate,jdbcType=DATE},",
          "enddate = #{enddate,jdbcType=DATE},",
          "status = #{status,jdbcType=TINYINT}",
        "where yearid = #{yearid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Yearinfo record);
}