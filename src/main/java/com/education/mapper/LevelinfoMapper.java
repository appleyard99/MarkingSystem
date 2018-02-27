package com.education.mapper;

import com.education.domain.Levelinfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface LevelinfoMapper {
    @Delete({
        "delete from levelinfo",
        "where levelid = #{levelid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer levelid);

    @Insert({
        "insert into levelinfo (levelid, level, ",
        "rate, schoolid, campusid, ",
        "levelname)",
        "values (#{levelid,jdbcType=INTEGER}, #{level,jdbcType=TINYINT}, ",
        "#{rate,jdbcType=REAL}, #{schoolid,jdbcType=INTEGER}, #{campusid,jdbcType=INTEGER}, ",
        "#{levelname,jdbcType=VARCHAR})"
    })
    int insert(Levelinfo record);

    @Select({
        "select",
        "levelid, level, rate, schoolid, campusid, levelname",
        "from levelinfo",
        "where levelid = #{levelid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="levelid", property="levelid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="levelname", property="levelname", jdbcType=JdbcType.VARCHAR)
    })
    Levelinfo selectByPrimaryKey(Integer levelid);

    @Select({
        "select",
        "levelid, level, rate, schoolid, campusid, levelname",
        "from levelinfo"
    })
    @Results({
        @Result(column="levelid", property="levelid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="levelname", property="levelname", jdbcType=JdbcType.VARCHAR)
    })
    List<Levelinfo> selectAll();

    @Update({
        "update levelinfo",
        "set level = #{level,jdbcType=TINYINT},",
          "rate = #{rate,jdbcType=REAL},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "levelname = #{levelname,jdbcType=VARCHAR}",
        "where levelid = #{levelid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Levelinfo record);
}