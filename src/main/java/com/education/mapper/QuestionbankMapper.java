package com.education.mapper;

import com.education.domain.Questionbank;
import com.education.domain.QuestionbankWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface QuestionbankMapper {
    @Delete({
        "delete from questionbank",
        "where questionbankid = #{questionbankid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer questionbankid);

    @Insert({
        "insert into questionbank (questionbankid, schoolid, ",
        "subjectid, type, ",
        "score, difficulty, ",
        "correcttype, answernum, ",
        "status, share, mcqscore, ",
        "createby, created_at, ",
        "usecount, updatedby, ",
        "updated_at, pdfpath, ",
        "wordpath, imgpath, ",
        "htmlpath, body, ",
        "result, analysis)",
        "values (#{questionbankid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{subjectid,jdbcType=INTEGER}, #{type,jdbcType=TINYINT}, ",
        "#{score,jdbcType=REAL}, #{difficulty,jdbcType=TINYINT}, ",
        "#{correcttype,jdbcType=TINYINT}, #{answernum,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT}, #{share,jdbcType=TINYINT}, #{mcqscore,jdbcType=CHAR}, ",
        "#{createby,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{usecount,jdbcType=INTEGER}, #{updatedby,jdbcType=INTEGER}, ",
        "#{updatedAt,jdbcType=TIMESTAMP}, #{pdfpath,jdbcType=VARCHAR}, ",
        "#{wordpath,jdbcType=VARCHAR}, #{imgpath,jdbcType=VARCHAR}, ",
        "#{htmlpath,jdbcType=VARCHAR}, #{body,jdbcType=LONGVARCHAR}, ",
        "#{result,jdbcType=LONGVARCHAR}, #{analysis,jdbcType=LONGVARCHAR})"
    })
    int insert(Questionbank record);

    @Select({
        "select",
        "questionbankid, schoolid, subjectid, type, score, difficulty, correcttype, answernum, ",
        "status, share, mcqscore, createby, created_at, usecount, updatedby, updated_at, ",
        "pdfpath, wordpath, imgpath, htmlpath, body, result, analysis",
        "from questionbank",
        "where questionbankid = #{questionbankid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.TINYINT),
        @Result(column="correcttype", property="correcttype", jdbcType=JdbcType.TINYINT),
        @Result(column="answernum", property="answernum", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="share", property="share", jdbcType=JdbcType.TINYINT),
        @Result(column="mcqscore", property="mcqscore", jdbcType=JdbcType.CHAR),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="usecount", property="usecount", jdbcType=JdbcType.INTEGER),
        @Result(column="updatedby", property="updatedby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pdfpath", property="pdfpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="wordpath", property="wordpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgpath", property="imgpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="htmlpath", property="htmlpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="result", property="result", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="analysis", property="analysis", jdbcType=JdbcType.LONGVARCHAR)
    })
    QuestionbankWithBLOBs selectByPrimaryKey(Integer questionbankid);

    @Select({
        "select",
        "questionbankid, schoolid, subjectid, type, score, difficulty, correcttype, answernum, ",
        "status, share, mcqscore, createby, created_at, usecount, updatedby, updated_at, ",
        "pdfpath, wordpath, imgpath, htmlpath, body, result, analysis",
        "from questionbank"
    })
    @Results({
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.TINYINT),
        @Result(column="correcttype", property="correcttype", jdbcType=JdbcType.TINYINT),
        @Result(column="answernum", property="answernum", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="share", property="share", jdbcType=JdbcType.TINYINT),
        @Result(column="mcqscore", property="mcqscore", jdbcType=JdbcType.CHAR),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="usecount", property="usecount", jdbcType=JdbcType.INTEGER),
        @Result(column="updatedby", property="updatedby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pdfpath", property="pdfpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="wordpath", property="wordpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgpath", property="imgpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="htmlpath", property="htmlpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="result", property="result", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="analysis", property="analysis", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Questionbank> selectAll();

    @Update({
        "update questionbank",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "score = #{score,jdbcType=REAL},",
          "difficulty = #{difficulty,jdbcType=TINYINT},",
          "correcttype = #{correcttype,jdbcType=TINYINT},",
          "answernum = #{answernum,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "share = #{share,jdbcType=TINYINT},",
          "mcqscore = #{mcqscore,jdbcType=CHAR},",
          "createby = #{createby,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "usecount = #{usecount,jdbcType=INTEGER},",
          "updatedby = #{updatedby,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "pdfpath = #{pdfpath,jdbcType=VARCHAR},",
          "wordpath = #{wordpath,jdbcType=VARCHAR},",
          "imgpath = #{imgpath,jdbcType=VARCHAR},",
          "htmlpath = #{htmlpath,jdbcType=VARCHAR},",
          "body = #{body,jdbcType=LONGVARCHAR},",
          "result = #{result,jdbcType=LONGVARCHAR},",
          "analysis = #{analysis,jdbcType=LONGVARCHAR}",
        "where questionbankid = #{questionbankid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Questionbank record);
}