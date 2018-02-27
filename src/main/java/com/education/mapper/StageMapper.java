package com.education.mapper;

import com.education.domain.Stage;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface StageMapper {
    @Delete({
        "delete from stage",
        "where stageid = #{stageid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer stageid);

    @Insert({
        "insert into stage (stageid, stage, ",
        "status)",
        "values (#{stageid,jdbcType=INTEGER}, #{stage,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT})"
    })
    int insert(Stage record);

    @Select({
        "select",
        "stageid, stage, status",
        "from stage",
        "where stageid = #{stageid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="stageid", property="stageid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="stage", property="stage", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Stage selectByPrimaryKey(Integer stageid);

    @Select({
        "select",
        "stageid, stage, status",
        "from stage"
    })
    @Results({
        @Result(column="stageid", property="stageid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="stage", property="stage", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Stage> selectAll();

    @Update({
        "update stage",
        "set stage = #{stage,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT}",
        "where stageid = #{stageid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Stage record);
}