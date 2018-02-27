package com.education.mapper;

import com.education.domain.FavoriteTag;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface FavoriteTagMapper {
    @Delete({
        "delete from favorite_tag",
        "where tagid = #{tagid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tagid);

    @Insert({
        "insert into favorite_tag (tagid, tagname, ",
        "subjectid, createby, ",
        "created_at, updatedby, ",
        "updated_at, status)",
        "values (#{tagid,jdbcType=INTEGER}, #{tagname,jdbcType=VARCHAR}, ",
        "#{subjectid,jdbcType=INTEGER}, #{createby,jdbcType=INTEGER}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{updatedby,jdbcType=INTEGER}, ",
        "#{updatedAt,jdbcType=TIMESTAMP}, #{status,jdbcType=BIT})"
    })
    int insert(FavoriteTag record);

    @Select({
        "select",
        "tagid, tagname, subjectid, createby, created_at, updatedby, updated_at, status",
        "from favorite_tag",
        "where tagid = #{tagid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tagid", property="tagid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tagname", property="tagname", jdbcType=JdbcType.VARCHAR),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updatedby", property="updatedby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    FavoriteTag selectByPrimaryKey(Integer tagid);

    @Select({
        "select",
        "tagid, tagname, subjectid, createby, created_at, updatedby, updated_at, status",
        "from favorite_tag"
    })
    @Results({
        @Result(column="tagid", property="tagid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tagname", property="tagname", jdbcType=JdbcType.VARCHAR),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updatedby", property="updatedby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<FavoriteTag> selectAll();

    @Update({
        "update favorite_tag",
        "set tagname = #{tagname,jdbcType=VARCHAR},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "createby = #{createby,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updatedby = #{updatedby,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIT}",
        "where tagid = #{tagid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FavoriteTag record);
}