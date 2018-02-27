package com.education.mapper;

import com.education.domain.ReportExamBigques;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface ReportExamBigquesMapper {
    @Delete({
        "delete from report_exam_bigques",
        "where rebqid = #{rebqid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rebqid);

    @Insert({
        "insert into report_exam_bigques (rebqid, questionid, ",
        "qsgroup, examid, ",
        "type, seqno, classid, ",
        "error_num, error_answer, ",
        "rate, created_at)",
        "values (#{rebqid,jdbcType=INTEGER}, #{questionid,jdbcType=INTEGER}, ",
        "#{qsgroup,jdbcType=VARCHAR}, #{examid,jdbcType=INTEGER}, ",
        "#{type,jdbcType=TINYINT}, #{seqno,jdbcType=INTEGER}, #{classid,jdbcType=INTEGER}, ",
        "#{errorNum,jdbcType=SMALLINT}, #{errorAnswer,jdbcType=VARCHAR}, ",
        "#{rate,jdbcType=REAL}, #{createdAt,jdbcType=TIMESTAMP})"
    })
    int insert(ReportExamBigques record);

    @Select({
        "select",
        "rebqid, questionid, qsgroup, examid, type, seqno, classid, error_num, error_answer, ",
        "rate, created_at",
        "from report_exam_bigques",
        "where rebqid = #{rebqid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="rebqid", property="rebqid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="seqno", property="seqno", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="error_num", property="errorNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="error_answer", property="errorAnswer", jdbcType=JdbcType.VARCHAR),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    ReportExamBigques selectByPrimaryKey(Integer rebqid);

    @Select({
        "select",
        "rebqid, questionid, qsgroup, examid, type, seqno, classid, error_num, error_answer, ",
        "rate, created_at",
        "from report_exam_bigques"
    })
    @Results({
        @Result(column="rebqid", property="rebqid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="seqno", property="seqno", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="error_num", property="errorNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="error_answer", property="errorAnswer", jdbcType=JdbcType.VARCHAR),
        @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ReportExamBigques> selectAll();

    @Update({
        "update report_exam_bigques",
        "set questionid = #{questionid,jdbcType=INTEGER},",
          "qsgroup = #{qsgroup,jdbcType=VARCHAR},",
          "examid = #{examid,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "seqno = #{seqno,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "error_num = #{errorNum,jdbcType=SMALLINT},",
          "error_answer = #{errorAnswer,jdbcType=VARCHAR},",
          "rate = #{rate,jdbcType=REAL},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP}",
        "where rebqid = #{rebqid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReportExamBigques record);

    /**
     *@Description: 根据大题题号返回答案数据信息
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT rebqid, questionid, qsgroup, examid, type, seqno, classid, error_num, error_answer, rate, created_at",
        "FROM report_exam_bigques",
        "WHERE  examid = #{examid, jdbcType=INTEGER} and `classid`=#{classid, jdbcType=INTEGER}",
        "GROUP BY  qsgroup,seqno",
        "ORDER BY seqno"
    })
    @Results({
            @Result(column="rebqid", property="rebqid", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
            @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
            @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
            @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
            @Result(column="seqno", property="seqno", jdbcType=JdbcType.INTEGER),
            @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
            @Result(column="error_num", property="errorNum", jdbcType=JdbcType.SMALLINT),
            @Result(column="error_answer", property="errorAnswer", jdbcType=JdbcType.VARCHAR),
            @Result(column="rate", property="rate", jdbcType=JdbcType.REAL),
            @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ReportExamBigques> getDetailsByQsgroup(@Param("examid") Integer examid, @Param("classid") Integer classid);
}