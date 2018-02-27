package com.education.mapper;

import com.education.domain.ExamCorrect;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ExamCorrectMapper {
    @Delete({
        "delete from exam_correct",
        "where correctid = #{correctid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer correctid);

    @Insert({
        "insert into exam_correct (correctid, wqid, ",
        "examid, questionid, ",
        "studentid, correcttime, ",
        "answer, status)",
        "values (#{correctid,jdbcType=INTEGER}, #{wqid,jdbcType=INTEGER}, ",
        "#{examid,jdbcType=INTEGER}, #{questionid,jdbcType=INTEGER}, ",
        "#{studentid,jdbcType=INTEGER}, #{correcttime,jdbcType=TIMESTAMP}, ",
        "#{answer,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT})"
    })
    int insert(ExamCorrect record);

    @Select({
        "select",
        "correctid, wqid, examid, questionid, studentid, correcttime, answer, status",
        "from exam_correct",
        "where correctid = #{correctid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="correctid", property="correctid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="wqid", property="wqid", jdbcType=JdbcType.INTEGER),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="correcttime", property="correcttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    ExamCorrect selectByPrimaryKey(Integer correctid);

    @Select({
        "select",
        "correctid, wqid, examid, questionid, studentid, correcttime, answer, status",
        "from exam_correct"
    })
    @Results({
        @Result(column="correctid", property="correctid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="wqid", property="wqid", jdbcType=JdbcType.INTEGER),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="correcttime", property="correcttime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<ExamCorrect> selectAll();

    @Update({
        "update exam_correct",
        "set wqid = #{wqid,jdbcType=INTEGER},",
          "examid = #{examid,jdbcType=INTEGER},",
          "questionid = #{questionid,jdbcType=INTEGER},",
          "studentid = #{studentid,jdbcType=INTEGER},",
          "correcttime = #{correcttime,jdbcType=TIMESTAMP},",
          "answer = #{answer,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT}",
        "where correctid = #{correctid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExamCorrect record);
}