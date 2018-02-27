package com.education.mapper;

import com.education.domain.KnowledgeClass;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface KnowledgeClassMapper {
    @Delete({
        "delete from knowledge_class",
        "where kcid = #{kcid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer kcid);

    @Insert({
        "insert into knowledge_class (kcid, classid, ",
        "subjectid, kiid, ",
        "termid, total, score, ",
        "rate, examid, created_at, ",
        "updated_at)",
        "values (#{kcid,jdbcType=INTEGER}, #{classid,jdbcType=INTEGER}, ",
        "#{subjectid,jdbcType=INTEGER}, #{kiid,jdbcType=INTEGER}, ",
        "#{termid,jdbcType=INTEGER}, #{total,jdbcType=REAL}, #{score,jdbcType=REAL}, ",
        "#{rate,jdbcType=REAL}, #{examid,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(KnowledgeClass record);

    @Select({
        "select",
        "kcid, classid, subjectid, kiid, termid, total, score, rate, examid, created_at, ",
        "updated_at",
        "from knowledge_class",
        "where kcid = #{kcid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="kcid", property="kcid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    KnowledgeClass selectByPrimaryKey(Integer kcid);

    @Select({
        "select",
        "kcid, classid, subjectid, kiid, termid, total, score, rate, examid, created_at, ",
        "updated_at",
        "from knowledge_class"
    })
    @Results({
        @Result(column="kcid", property="kcid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KnowledgeClass> selectAll();

    @Update({
        "update knowledge_class",
        "set classid = #{classid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "kiid = #{kiid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "total = #{total,jdbcType=REAL},",
          "score = #{score,jdbcType=REAL},",
          "rate = #{rate,jdbcType=REAL},",
          "examid = #{examid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where kcid = #{kcid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(KnowledgeClass record);

    /**
     *@Description: 获取班级--知识点对应关系（班级）
     *@author Lvxianya
     *@date 2018/2/6
     */
    @Select({
        "SELECT `kiid`, `rate`",
        "FROM `knowledge_class`",
        "WHERE examid = #{examid, jdbcType=INTEGER} AND classid = #{classid, jdbcType=INTEGER}",
        "GROUP BY kiid"
    })
    List<KnowledgeClass> getKnowClassRelation(@Param("examid") Integer examid, @Param("classid") Integer classid);
}