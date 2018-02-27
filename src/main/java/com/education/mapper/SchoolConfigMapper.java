package com.education.mapper;

import com.education.domain.SchoolConfig;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SchoolConfigMapper {
    @Delete({
        "delete from school_config",
        "where recordid = #{recordid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer recordid);

    @Insert({
        "insert into school_config (recordid, schoolid, ",
        "cfgname, cfgvalue, ",
        "createtime, memo, ",
        "updatetime)",
        "values (#{recordid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{cfgname,jdbcType=VARCHAR}, #{cfgvalue,jdbcType=VARCHAR}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{memo,jdbcType=VARCHAR}, ",
        "#{updatetime,jdbcType=TIMESTAMP})"
    })
    int insert(SchoolConfig record);

    @Select({
        "select",
        "recordid, schoolid, cfgname, cfgvalue, createtime, memo, updatetime",
        "from school_config",
        "where recordid = #{recordid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="recordid", property="recordid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="cfgname", property="cfgname", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfgvalue", property="cfgvalue", jdbcType=JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    SchoolConfig selectByPrimaryKey(Integer recordid);

    @Select({
        "select",
        "recordid, schoolid, cfgname, cfgvalue, createtime, memo, updatetime",
        "from school_config"
    })
    @Results({
        @Result(column="recordid", property="recordid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="cfgname", property="cfgname", jdbcType=JdbcType.VARCHAR),
        @Result(column="cfgvalue", property="cfgvalue", jdbcType=JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SchoolConfig> selectAll();

    @Update({
        "update school_config",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "cfgname = #{cfgname,jdbcType=VARCHAR},",
          "cfgvalue = #{cfgvalue,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "memo = #{memo,jdbcType=VARCHAR},",
          "updatetime = #{updatetime,jdbcType=TIMESTAMP}",
        "where recordid = #{recordid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SchoolConfig record);
}