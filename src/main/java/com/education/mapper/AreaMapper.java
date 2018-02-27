package com.education.mapper;

import com.education.domain.Area;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AreaMapper {
    @Delete({
        "delete from area",
        "where areaid = #{areaid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer areaid);

    @Insert({
        "insert into area (areaid, areaname, ",
        "parentid)",
        "values (#{areaid,jdbcType=INTEGER}, #{areaname,jdbcType=VARCHAR}, ",
        "#{parentid,jdbcType=INTEGER})"
    })
    int insert(Area record);

    @Select({
        "select",
        "areaid, areaname, parentid",
        "from area",
        "where areaid = #{areaid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="areaid", property="areaid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="areaname", property="areaname", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentid", property="parentid", jdbcType=JdbcType.INTEGER)
    })
    Area selectByPrimaryKey(Integer areaid);

    @Select({
        "select",
        "areaid, areaname, parentid",
        "from area"
    })
    @Results({
        @Result(column="areaid", property="areaid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="areaname", property="areaname", jdbcType=JdbcType.VARCHAR),
        @Result(column="parentid", property="parentid", jdbcType=JdbcType.INTEGER)
    })
    List<Area> selectAll();

    @Update({
        "update area",
        "set areaname = #{areaname,jdbcType=VARCHAR},",
          "parentid = #{parentid,jdbcType=INTEGER}",
        "where areaid = #{areaid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Area record);
}