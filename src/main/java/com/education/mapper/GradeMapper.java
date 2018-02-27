package com.education.mapper;

import com.education.domain.Grade;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface GradeMapper {
    @Delete({
        "delete from grade",
        "where gradeid = #{gradeid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer gradeid);

    @Insert({
        "insert into grade (gradeid, gradename, ",
        "stageid, period, ",
        "status)",
        "values (#{gradeid,jdbcType=INTEGER}, #{gradename,jdbcType=VARCHAR}, ",
        "#{stageid,jdbcType=INTEGER}, #{period,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT})"
    })
    int insert(Grade record);

    @Select({
        "select",
        "gradeid, gradename, stageid, period, status",
        "from grade",
        "where gradeid = #{gradeid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gradename", property="gradename", jdbcType=JdbcType.VARCHAR),
        @Result(column="stageid", property="stageid", jdbcType=JdbcType.INTEGER),
        @Result(column="period", property="period", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Grade selectByPrimaryKey(Integer gradeid);

    @Select({
        "select",
        "gradeid, gradename, stageid, period, status",
        "from grade"
    })
    @Results({
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="gradename", property="gradename", jdbcType=JdbcType.VARCHAR),
        @Result(column="stageid", property="stageid", jdbcType=JdbcType.INTEGER),
        @Result(column="period", property="period", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Grade> selectAll();

    @Update({
        "update grade",
        "set gradename = #{gradename,jdbcType=VARCHAR},",
          "stageid = #{stageid,jdbcType=INTEGER},",
          "period = #{period,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT}",
        "where gradeid = #{gradeid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Grade record);
}