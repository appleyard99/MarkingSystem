package com.education.mapper;

import com.education.domain.AttentionKnowledge;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AttentionKnowledgeMapper {
    @Delete({
        "delete from attention_knowledge",
        "where akid = #{akid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer akid);

    @Insert({
        "insert into attention_knowledge (akid, teacherid, ",
        "classid, termid, ",
        "kiid, created_at, ",
        "reason, status, ",
        "updated_at, subjectid)",
        "values (#{akid,jdbcType=INTEGER}, #{teacherid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{termid,jdbcType=INTEGER}, ",
        "#{kiid,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{reason,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{updatedAt,jdbcType=TIMESTAMP}, #{subjectid,jdbcType=INTEGER})"
    })
    int insert(AttentionKnowledge record);

    @Select({
        "select",
        "akid, teacherid, classid, termid, kiid, created_at, reason, status, updated_at, ",
        "subjectid",
        "from attention_knowledge",
        "where akid = #{akid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="akid", property="akid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER)
    })
    AttentionKnowledge selectByPrimaryKey(Integer akid);

    @Select({
        "select",
        "akid, teacherid, classid, termid, kiid, created_at, reason, status, updated_at, ",
        "subjectid",
        "from attention_knowledge"
    })
    @Results({
        @Result(column="akid", property="akid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER)
    })
    List<AttentionKnowledge> selectAll();

    @Update({
        "update attention_knowledge",
        "set teacherid = #{teacherid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "kiid = #{kiid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "subjectid = #{subjectid,jdbcType=INTEGER}",
        "where akid = #{akid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AttentionKnowledge record);
}