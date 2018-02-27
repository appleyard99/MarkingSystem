package com.education.mapper;

import com.education.domain.ReportExamSummary;
import java.util.List;

import com.education.domain.vo.ExamQuestionVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface ReportExamSummaryMapper {
    @Delete({
        "delete from report_exam_summary",
        "where resuid = #{resuid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer resuid);

    @Insert({
        "insert into report_exam_summary (resuid, examid, ",
        "studentid, classid, ",
        "qstitle, qsgroup, ",
        "score, created_at)",
        "values (#{resuid,jdbcType=INTEGER}, #{examid,jdbcType=INTEGER}, ",
        "#{studentid,jdbcType=INTEGER}, #{classid,jdbcType=INTEGER}, ",
        "#{qstitle,jdbcType=VARCHAR}, #{qsgroup,jdbcType=VARCHAR}, ",
        "#{score,jdbcType=REAL}, #{createdAt,jdbcType=TIMESTAMP})"
    })
    int insert(ReportExamSummary record);

    @Select({
        "select",
        "resuid, examid, studentid, classid, qstitle, qsgroup, score, created_at",
        "from report_exam_summary",
        "where resuid = #{resuid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="resuid", property="resuid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="qstitle", property="qstitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    ReportExamSummary selectByPrimaryKey(Integer resuid);

    @Select({
        "select",
        "resuid, examid, studentid, classid, qstitle, qsgroup, score, created_at",
        "from report_exam_summary"
    })
    @Results({
        @Result(column="resuid", property="resuid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="qstitle", property="qstitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ReportExamSummary> selectAll();

    @Update({
        "update report_exam_summary",
        "set examid = #{examid,jdbcType=INTEGER},",
          "studentid = #{studentid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "qstitle = #{qstitle,jdbcType=VARCHAR},",
          "qsgroup = #{qsgroup,jdbcType=VARCHAR},",
          "score = #{score,jdbcType=REAL},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP}",
        "where resuid = #{resuid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReportExamSummary record);

    /**
     *@Description: 获取学生大题作答信息
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "<script> ",
        "SELECT `studentid`,`qstitle`,`qsgroup`,`score`",
        "FROM report_exam_summary",
        "WHERE examid = #{examid, jdbcType=INTEGER} ",
        "<if test=\"classid != null\"> AND classid=#{classid, jdbcType=INTEGER}</if>",
        "GROUP BY studentid, qsgroup",
        "</script> "
    })
    List<ExamQuestionVo> getStuQsgroupRelation(@Param("examid") Integer examid, @Param("classid") Integer classid);
}