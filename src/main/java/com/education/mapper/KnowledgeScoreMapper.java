package com.education.mapper;

import com.education.domain.KnowledgeScore;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface KnowledgeScoreMapper {
    @Delete({
        "delete from knowledge_score",
        "where ksid = #{ksid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ksid);

    @Insert({
        "insert into knowledge_score (ksid, schoolid, ",
        "campusid, gradeid, ",
        "classid, studentid, ",
        "subjectid, kiid, ",
        "termid, total, score, ",
        "rate, examid, created_at, ",
        "updated_at)",
        "values (#{ksid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{gradeid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{studentid,jdbcType=INTEGER}, ",
        "#{subjectid,jdbcType=INTEGER}, #{kiid,jdbcType=INTEGER}, ",
        "#{termid,jdbcType=INTEGER}, #{total,jdbcType=REAL}, #{score,jdbcType=REAL}, ",
        "#{rate,jdbcType=REAL}, #{examid,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(KnowledgeScore record);

    @Select({
        "select",
        "ksid, schoolid, campusid, gradeid, classid, studentid, subjectid, kiid, termid, ",
        "total, score, rate, examid, created_at, updated_at",
        "from knowledge_score",
        "where ksid = #{ksid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ksid", property="ksid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
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
    KnowledgeScore selectByPrimaryKey(Integer ksid);

    @Select({
        "select",
        "ksid, schoolid, campusid, gradeid, classid, studentid, subjectid, kiid, termid, ",
        "total, score, rate, examid, created_at, updated_at",
        "from knowledge_score"
    })
    @Results({
        @Result(column="ksid", property="ksid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
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
    List<KnowledgeScore> selectAll();

    @Update({
        "update knowledge_score",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "studentid = #{studentid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "kiid = #{kiid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "total = #{total,jdbcType=REAL},",
          "score = #{score,jdbcType=REAL},",
          "rate = #{rate,jdbcType=REAL},",
          "examid = #{examid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where ksid = #{ksid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(KnowledgeScore record);
}