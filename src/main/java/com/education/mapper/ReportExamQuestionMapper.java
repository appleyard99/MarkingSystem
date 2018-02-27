package com.education.mapper;

import com.education.domain.ReportExamQuestion;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface ReportExamQuestionMapper {
    @Delete({
        "delete from report_exam_question",
        "where requid = #{requid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer requid);

    @Insert({
        "insert into report_exam_question (requid, examid, ",
        "questionid, seqno, ",
        "classid, classname, ",
        "average, qstitle, qsgroup, ",
        "created_at)",
        "values (#{requid,jdbcType=INTEGER}, #{examid,jdbcType=INTEGER}, ",
        "#{questionid,jdbcType=INTEGER}, #{seqno,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{classname,jdbcType=VARCHAR}, ",
        "#{average,jdbcType=REAL}, #{qstitle,jdbcType=VARCHAR}, #{qsgroup,jdbcType=VARCHAR}, ",
        "#{createdAt,jdbcType=TIMESTAMP})"
    })
    int insert(ReportExamQuestion record);

    @Select({
        "select",
        "requid, examid, questionid, seqno, classid, classname, average, qstitle, qsgroup, ",
        "created_at",
        "from report_exam_question",
        "where requid = #{requid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="requid", property="requid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="seqno", property="seqno", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="classname", property="classname", jdbcType=JdbcType.VARCHAR),
        @Result(column="average", property="average", jdbcType=JdbcType.REAL),
        @Result(column="qstitle", property="qstitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    ReportExamQuestion selectByPrimaryKey(Integer requid);

    @Select({
        "select",
        "requid, examid, questionid, seqno, classid, classname, average, qstitle, qsgroup, ",
        "created_at",
        "from report_exam_question"
    })
    @Results({
        @Result(column="requid", property="requid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="seqno", property="seqno", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="classname", property="classname", jdbcType=JdbcType.VARCHAR),
        @Result(column="average", property="average", jdbcType=JdbcType.REAL),
        @Result(column="qstitle", property="qstitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ReportExamQuestion> selectAll();

    @Update({
        "update report_exam_question",
        "set examid = #{examid,jdbcType=INTEGER},",
          "questionid = #{questionid,jdbcType=INTEGER},",
          "seqno = #{seqno,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "classname = #{classname,jdbcType=VARCHAR},",
          "average = #{average,jdbcType=REAL},",
          "qstitle = #{qstitle,jdbcType=VARCHAR},",
          "qsgroup = #{qsgroup,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP}",
        "where requid = #{requid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReportExamQuestion record);

    @Select({
            "SELECT classid,average,qsgroup FROM report_exam_question",
            "WHERE examid = #{examid, jdbcType=INTEGER} ",
            "AND classid=#{classid, jdbcType=INTEGER}",
            "AND qsgroup IS NOT NULL" ,
            "GROUP BY qsgroup ,classid"
    })
    List<ReportExamQuestion> getQsgroupScoreRelation(@Param("classid") Integer classid, @Param("examid") Integer examid);

    /**
     *@Description: 获取xx考试xx班级,学生小题平均分
     *@author liuyizheng
     *@date 2018/2/7
     */
    @Select({
            "SELECT `classid`,`average`,`seqno` FROM report_exam_question",
            "WHERE examid=#{examid, jdbcType=INTEGER}" ,
            "AND classid =#{classid, jdbcType=INTEGER} ",
            "AND seqno != 0 ",
            "GROUP BY  `seqno`,`classid`"
    })
    List<ReportExamQuestion> getSmaQueAvg(@Param("examid") Integer examid, @Param("classid") Integer classid);

    /**
     *@Description: 根据"考试编号"，"班级编号"，"题目编号"和"qstitle"条件来查询小题班级平均分
     *@author Lvxianya
     *@date 2018/2/6
     */
    @Select({
        "SELECT average",
        "FROM report_exam_question",
        "WHERE examid = #{examid, jdbcType=INTEGER} AND classid = #{classid, jdbcType=INTEGER} AND",
            "questionid = #{questionid, jdbcType=INTEGER} AND",
            "(qstitle = \"\" OR qstitle IS NULL)",
        "LIMIT 1"
    })
    Float getClassAverage(@Param("examid") Integer examid, @Param("classid") Integer classid, @Param("questionid") Integer questionid);
}