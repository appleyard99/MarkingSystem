package com.education.mapper;

import com.education.domain.Campus;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface CampusMapper {
    @Delete({
        "delete from campus",
        "where campusid = #{campusid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer campusid);

    @Insert({
        "insert into campus (campusid, campusname, ",
        "schoolid, status)",
        "values (#{campusid,jdbcType=INTEGER}, #{campusname,jdbcType=VARCHAR}, ",
        "#{schoolid,jdbcType=INTEGER}, #{status,jdbcType=TINYINT})"
    })
    int insert(Campus record);

    @Select({
        "select",
        "campusid, campusname, schoolid, status",
        "from campus",
        "where campusid = #{campusid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="campusname", property="campusname", jdbcType=JdbcType.VARCHAR),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Campus selectByPrimaryKey(Integer campusid);

    @Select({
        "select",
        "campusid, campusname, schoolid, status",
        "from campus"
    })
    @Results({
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="campusname", property="campusname", jdbcType=JdbcType.VARCHAR),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Campus> selectAll();

    @Update({
        "update campus",
        "set campusname = #{campusname,jdbcType=VARCHAR},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where campusid = #{campusid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Campus record);
}