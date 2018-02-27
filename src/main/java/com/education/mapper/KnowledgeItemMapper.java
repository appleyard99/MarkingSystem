package com.education.mapper;

import com.education.domain.KnowledgeItem;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface KnowledgeItemMapper {
    @Delete({
        "delete from knowledge_item",
        "where kiid = #{kiid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer kiid);

    @Insert({
        "insert into knowledge_item (kiid, knowname, ",
        "knowid, level, parentid, ",
        "knowcode, showorder, ",
        "status, createby, ",
        "created_at, updateby, ",
        "updated_at)",
        "values (#{kiid,jdbcType=INTEGER}, #{knowname,jdbcType=VARCHAR}, ",
        "#{knowid,jdbcType=INTEGER}, #{level,jdbcType=TINYINT}, #{parentid,jdbcType=INTEGER}, ",
        "#{knowcode,jdbcType=VARCHAR}, #{showorder,jdbcType=REAL}, ",
        "#{status,jdbcType=TINYINT}, #{createby,jdbcType=INTEGER}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{updateby,jdbcType=INTEGER}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(KnowledgeItem record);

    @Select({
        "select",
        "kiid, knowname, knowid, level, parentid, knowcode, showorder, status, createby, ",
        "created_at, updateby, updated_at",
        "from knowledge_item",
        "where kiid = #{kiid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="knowname", property="knowname", jdbcType=JdbcType.VARCHAR),
        @Result(column="knowid", property="knowid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="parentid", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="knowcode", property="knowcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="showorder", property="showorder", jdbcType=JdbcType.REAL),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    KnowledgeItem selectByPrimaryKey(Integer kiid);

    @Select({
        "select",
        "kiid, knowname, knowid, level, parentid, knowcode, showorder, status, createby, ",
        "created_at, updateby, updated_at",
        "from knowledge_item"
    })
    @Results({
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="knowname", property="knowname", jdbcType=JdbcType.VARCHAR),
        @Result(column="knowid", property="knowid", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="parentid", property="parentid", jdbcType=JdbcType.INTEGER),
        @Result(column="knowcode", property="knowcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="showorder", property="showorder", jdbcType=JdbcType.REAL),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KnowledgeItem> selectAll();

    @Update({
        "update knowledge_item",
        "set knowname = #{knowname,jdbcType=VARCHAR},",
          "knowid = #{knowid,jdbcType=INTEGER},",
          "level = #{level,jdbcType=TINYINT},",
          "parentid = #{parentid,jdbcType=INTEGER},",
          "knowcode = #{knowcode,jdbcType=VARCHAR},",
          "showorder = #{showorder,jdbcType=REAL},",
          "status = #{status,jdbcType=TINYINT},",
          "createby = #{createby,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updateby = #{updateby,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where kiid = #{kiid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(KnowledgeItem record);
}