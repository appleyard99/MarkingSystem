package com.education.mapper;

import com.education.domain.QuestionbankClass;
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
public interface QuestionbankClassMapper {
    @Delete({
        "delete from questionbank_class",
        "where qcid = #{qcid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer qcid);

    @Insert({
        "insert into questionbank_class (qcid, classid, ",
        "subjectid, questionbankid, ",
        "questionid, termid, ",
        "total, score, rate, ",
        "created_at, examid, ",
        "updated_at)",
        "values (#{qcid,jdbcType=INTEGER}, #{classid,jdbcType=INTEGER}, ",
        "#{subjectid,jdbcType=INTEGER}, #{questionbankid,jdbcType=INTEGER}, ",
        "#{questionid,jdbcType=INTEGER}, #{termid,jdbcType=INTEGER}, ",
        "#{total,jdbcType=REAL}, #{score,jdbcType=REAL}, #{rate,jdbcType=REAL}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{examid,jdbcType=INTEGER}, ",
        "#{updatedAt,jdbcType=TIMESTAMP})"
    })
    int insert(QuestionbankClass record);

    @Select({
        "select",
        "qcid, classid, subjectid, questionbankid, questionid, termid, total, score, ",
        "rate, created_at, examid, updated_at",
        "from questionbank_class",
        "where qcid = #{qcid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="qcid", property="qcid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    QuestionbankClass selectByPrimaryKey(Integer qcid);

    @Select({
        "select",
        "qcid, classid, subjectid, questionbankid, questionid, termid, total, score, ",
        "rate, created_at, examid, updated_at",
        "from questionbank_class"
    })
    @Results({
        @Result(column="qcid", property="qcid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.REAL),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<QuestionbankClass> selectAll();

    @Update({
        "update questionbank_class",
        "set classid = #{classid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "questionbankid = #{questionbankid,jdbcType=INTEGER},",
          "questionid = #{questionid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "total = #{total,jdbcType=REAL},",
          "score = #{score,jdbcType=REAL},",
          "rate = #{rate,jdbcType=REAL},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "examid = #{examid,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP}",
        "where qcid = #{qcid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionbankClass record);

    /**
     *@Description: 获取班级（各个题目）得分率信息
     *@author Lvxianya
     *@date 2018/2/8
     */
    @Select({
        "SELECT `questionid`,`classid`,`rate`",
        "FROM questionbank_class",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "GROUP BY `questionid`, `classid`"
    })
    List<QuestionbankClass> getClassRateRelation(Integer examid);
}