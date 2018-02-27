package com.education.mapper;

import com.education.domain.LevelResult;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface LevelResultMapper {
    @Delete({
        "delete from level_result",
        "where lrid = #{lrid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer lrid);

    @Insert({
        "insert into level_result (lrid, classid, ",
        "subjectid, studentid, ",
        "levelid, termid, ",
        "updated_at)",
        "values (#{lrid,jdbcType=INTEGER}, #{classid,jdbcType=INTEGER}, ",
        "#{subjectid,jdbcType=INTEGER}, #{studentid,jdbcType=INTEGER}, ",
        "#{levelid,jdbcType=INTEGER}, #{termid,jdbcType=INTEGER}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(LevelResult record);

    @Select({
        "select",
        "lrid, classid, subjectid, studentid, levelid, termid, updated_at",
        "from level_result",
        "where lrid = #{lrid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="lrid", property="lrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="levelid", property="levelid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    LevelResult selectByPrimaryKey(Integer lrid);

    @Select({
        "select",
        "lrid, classid, subjectid, studentid, levelid, termid, updated_at",
        "from level_result"
    })
    @Results({
        @Result(column="lrid", property="lrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="levelid", property="levelid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<LevelResult> selectAll();

    @Update({
        "update level_result",
        "set classid = #{classid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "studentid = #{studentid,jdbcType=INTEGER},",
          "levelid = #{levelid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where lrid = #{lrid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(LevelResult record);
}