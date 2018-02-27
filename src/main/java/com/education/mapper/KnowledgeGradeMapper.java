package com.education.mapper;

import com.education.domain.KnowledgeGrade;
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
public interface KnowledgeGradeMapper {
    @Delete({
        "delete from knowledge_grade",
        "where kgid = #{kgid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer kgid);

    @Insert({
        "insert into knowledge_grade (kgid, schoolid, ",
        "campusid, gradeid, ",
        "kiid, termid, subjectid, ",
        "total, score, rate, ",
        "examid, created_at, ",
        "updated_at)",
        "values (#{kgid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{gradeid,jdbcType=INTEGER}, ",
        "#{kiid,jdbcType=INTEGER}, #{termid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER}, ",
        "#{total,jdbcType=REAL}, #{score,jdbcType=REAL}, #{rate,jdbcType=REAL}, ",
        "#{examid,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(KnowledgeGrade record);

    @Select({
        "select",
        "kgid, schoolid, campusid, gradeid, kiid, termid, subjectid, total, score, rate, ",
        "examid, created_at, updated_at",
        "from knowledge_grade",
        "where kgid = #{kgid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="kgid", property="kgid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    KnowledgeGrade selectByPrimaryKey(Integer kgid);

    @Select({
        "select",
        "kgid, schoolid, campusid, gradeid, kiid, termid, subjectid, total, score, rate, ",
        "examid, created_at, updated_at",
        "from knowledge_grade"
    })
    @Results({
        @Result(column="kgid", property="kgid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KnowledgeGrade> selectAll();

    @Update({
        "update knowledge_grade",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "kiid = #{kiid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "total = #{total,jdbcType=REAL},",
          "score = #{score,jdbcType=REAL},",
          "rate = #{rate,jdbcType=REAL},",
          "examid = #{examid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where kgid = #{kgid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(KnowledgeGrade record);

    /**
     *@Description: 获取年级--知识点对应关系（班级）
     *@author Lvxianya
     *@date 2018/2/6
     */
    @Select({
        "SELECT `kiid`, `rate`",
        "FROM `knowledge_grade`",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "GROUP BY kiid"
    })
    List<KnowledgeGrade> getKnowGradeRelation(Integer examid);
}