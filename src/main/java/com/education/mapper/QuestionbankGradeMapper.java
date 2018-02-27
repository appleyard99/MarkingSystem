package com.education.mapper;

import com.education.domain.QuestionbankGrade;
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
public interface QuestionbankGradeMapper {
    @Delete({
        "delete from questionbank_grade",
        "where qgid = #{qgid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer qgid);

    @Insert({
        "insert into questionbank_grade (qgid, schoolid, ",
        "campusid, gradeid, ",
        "questionbankid, questionid, ",
        "termid, subjectid, ",
        "total, score, rate, ",
        "created_at, examid, ",
        "updated_at)",
        "values (#{qgid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{gradeid,jdbcType=INTEGER}, ",
        "#{questionbankid,jdbcType=INTEGER}, #{questionid,jdbcType=INTEGER}, ",
        "#{termid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER}, ",
        "#{total,jdbcType=REAL}, #{score,jdbcType=REAL}, #{rate,jdbcType=REAL}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{examid,jdbcType=INTEGER}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(QuestionbankGrade record);

    @Select({
        "select",
        "qgid, schoolid, campusid, gradeid, questionbankid, questionid, termid, subjectid, ",
        "total, score, rate, created_at, examid, updated_at",
        "from questionbank_grade",
        "where qgid = #{qgid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="qgid", property="qgid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    QuestionbankGrade selectByPrimaryKey(Integer qgid);

    @Select({
        "select",
        "qgid, schoolid, campusid, gradeid, questionbankid, questionid, termid, subjectid, ",
        "total, score, rate, created_at, examid, updated_at",
        "from questionbank_grade"
    })
    @Results({
        @Result(column="qgid", property="qgid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<QuestionbankGrade> selectAll();

    @Update({
        "update questionbank_grade",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "questionbankid = #{questionbankid,jdbcType=INTEGER},",
          "questionid = #{questionid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "total = #{total,jdbcType=REAL},",
          "score = #{score,jdbcType=REAL},",
          "rate = #{rate,jdbcType=REAL},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "examid = #{examid,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where qgid = #{qgid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionbankGrade record);

    /**
     *@Description: 获取试卷小题及其 `年级得分率` 对应关系
     *@author Lvxianya
     *@date 2018/2/8
     */
    @Select({
        "SELECT `questionid`,`rate`",
        "FROM questionbank_grade",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "GROUP BY `questionid`" 
    })
    List<QuestionbankGrade> getGradeRateRelation(Integer examid);
}