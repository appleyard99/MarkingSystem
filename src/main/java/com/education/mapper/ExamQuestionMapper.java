package com.education.mapper;

import com.education.domain.ExamQuestion;
import com.education.domain.ExamQuestionWithBLOBs;
import java.util.List;

import com.education.domain.vo.ExamQuestionVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface ExamQuestionMapper {
    @Delete({
        "delete from exam_question",
        "where questionid = #{questionid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer questionid);

    @Insert({
        "insert into exam_question (questionid, examid, ",
        "questionbankid, seqno, ",
        "type, score, mcqscore, ",
        "answernum, difficulty, ",
        "remark, correcttype, ",
        "qstitle, qsgroup, ",
        "maxitemnum, scoreline, ",
        "rowindex, cellindex, ",
        "ismerge, mergeidstr, ",
        "seqname, body, ",
        "analysis, result, ",
        "otherresult)",
        "values (#{questionid,jdbcType=INTEGER}, #{examid,jdbcType=INTEGER}, ",
        "#{questionbankid,jdbcType=INTEGER}, #{seqno,jdbcType=INTEGER}, ",
        "#{type,jdbcType=TINYINT}, #{score,jdbcType=REAL}, #{mcqscore,jdbcType=REAL}, ",
        "#{answernum,jdbcType=TINYINT}, #{difficulty,jdbcType=TINYINT}, ",
        "#{remark,jdbcType=VARCHAR}, #{correcttype,jdbcType=TINYINT}, ",
        "#{qstitle,jdbcType=VARCHAR}, #{qsgroup,jdbcType=VARCHAR}, ",
        "#{maxitemnum,jdbcType=TINYINT}, #{scoreline,jdbcType=REAL}, ",
        "#{rowindex,jdbcType=INTEGER}, #{cellindex,jdbcType=INTEGER}, ",
        "#{ismerge,jdbcType=TINYINT}, #{mergeidstr,jdbcType=VARCHAR}, ",
        "#{seqname,jdbcType=VARCHAR}, #{body,jdbcType=LONGVARCHAR}, ",
        "#{analysis,jdbcType=LONGVARCHAR}, #{result,jdbcType=LONGVARCHAR}, ",
        "#{otherresult,jdbcType=LONGVARCHAR})"
    })
    int insert(ExamQuestion record);

    @Select({
        "select",
        "questionid, examid, questionbankid, seqno, type, score, mcqscore, answernum, ",
        "difficulty, remark, correcttype, qstitle, qsgroup, maxitemnum, scoreline, rowindex, ",
        "cellindex, ismerge, mergeidstr, seqname, body, analysis, result, otherresult",
        "from exam_question",
        "where questionid = #{questionid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="seqno", property="seqno", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="mcqscore", property="mcqscore", jdbcType=JdbcType.REAL),
        @Result(column="answernum", property="answernum", jdbcType=JdbcType.TINYINT),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="correcttype", property="correcttype", jdbcType=JdbcType.TINYINT),
        @Result(column="qstitle", property="qstitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="maxitemnum", property="maxitemnum", jdbcType=JdbcType.TINYINT),
        @Result(column="scoreline", property="scoreline", jdbcType=JdbcType.REAL),
        @Result(column="rowindex", property="rowindex", jdbcType=JdbcType.INTEGER),
        @Result(column="cellindex", property="cellindex", jdbcType=JdbcType.INTEGER),
        @Result(column="ismerge", property="ismerge", jdbcType=JdbcType.TINYINT),
        @Result(column="mergeidstr", property="mergeidstr", jdbcType=JdbcType.VARCHAR),
        @Result(column="seqname", property="seqname", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="analysis", property="analysis", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="result", property="result", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="otherresult", property="otherresult", jdbcType=JdbcType.LONGVARCHAR)
    })
    ExamQuestionWithBLOBs selectByPrimaryKey(Integer questionid);

    @Select({
        "select",
        "questionid, examid, questionbankid, seqno, type, score, mcqscore, answernum, ",
        "difficulty, remark, correcttype, qstitle, qsgroup, maxitemnum, scoreline, rowindex, ",
        "cellindex, ismerge, mergeidstr, seqname, body, analysis, result, otherresult",
        "from exam_question"
    })
    @Results({
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="seqno", property="seqno", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="mcqscore", property="mcqscore", jdbcType=JdbcType.REAL),
        @Result(column="answernum", property="answernum", jdbcType=JdbcType.TINYINT),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.TINYINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="correcttype", property="correcttype", jdbcType=JdbcType.TINYINT),
        @Result(column="qstitle", property="qstitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="maxitemnum", property="maxitemnum", jdbcType=JdbcType.TINYINT),
        @Result(column="scoreline", property="scoreline", jdbcType=JdbcType.REAL),
        @Result(column="rowindex", property="rowindex", jdbcType=JdbcType.INTEGER),
        @Result(column="cellindex", property="cellindex", jdbcType=JdbcType.INTEGER),
        @Result(column="ismerge", property="ismerge", jdbcType=JdbcType.TINYINT),
        @Result(column="mergeidstr", property="mergeidstr", jdbcType=JdbcType.VARCHAR),
        @Result(column="seqname", property="seqname", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="analysis", property="analysis", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="result", property="result", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="otherresult", property="otherresult", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ExamQuestion> selectAll();

    @Update({
        "update exam_question",
        "set examid = #{examid,jdbcType=INTEGER},",
          "questionbankid = #{questionbankid,jdbcType=INTEGER},",
          "seqno = #{seqno,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "score = #{score,jdbcType=REAL},",
          "mcqscore = #{mcqscore,jdbcType=REAL},",
          "answernum = #{answernum,jdbcType=TINYINT},",
          "difficulty = #{difficulty,jdbcType=TINYINT},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "correcttype = #{correcttype,jdbcType=TINYINT},",
          "qstitle = #{qstitle,jdbcType=VARCHAR},",
          "qsgroup = #{qsgroup,jdbcType=VARCHAR},",
          "maxitemnum = #{maxitemnum,jdbcType=TINYINT},",
          "scoreline = #{scoreline,jdbcType=REAL},",
          "rowindex = #{rowindex,jdbcType=INTEGER},",
          "cellindex = #{cellindex,jdbcType=INTEGER},",
          "ismerge = #{ismerge,jdbcType=TINYINT},",
          "mergeidstr = #{mergeidstr,jdbcType=VARCHAR},",
          "seqname = #{seqname,jdbcType=VARCHAR},",
          "body = #{body,jdbcType=LONGVARCHAR},",
          "analysis = #{analysis,jdbcType=LONGVARCHAR},",
          "result = #{result,jdbcType=LONGVARCHAR},",
          "otherresult = #{otherresult,jdbcType=LONGVARCHAR}",
        "where questionid = #{questionid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExamQuestion record);

    /**
     *@Description: 获取 "学情表格"数据 标题部分
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT qstitle, qsgroup, SUM( score ) AS score",
        "FROM exam_question",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "GROUP BY qsgroup",
        "ORDER BY qsgroup"
    })
    List<ExamQuestionVo> getQuesTitleRelation(Integer examid);

    /**
     *@Description: 获取表格标题部分
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT `qsgroup`,`type`,`qstitle`, count( * ) AS num",
        "FROM exam_question",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "GROUP BY qsgroup",
        "ORDER BY qsgroup"
    })
    List<ExamQuestionVo> getSummaryTitle(Integer examid);

    /**
     *@Description: 题目组和题型的关系
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
       " SELECT `qsgroup`,`type` ",
       "FROM exam_question ",
       "WHERE  examid = #{examid, jdbcType=INTEGER} ",
       "GROUP BY  qsgroup ",
       "ORDER BY qsgroup"
    })
    List<ExamQuestionVo> getQsgroupTypeRelation(Integer examid);

    /**
     *@Description: 获取题号和答案对应关系.
     *@author Lvxianya
     *@date 2018/2/2
     */
    @Select({
        "SELECT `seqno`,`result`",
        "FROM exam_question",
        "WHERE  examid = #{examid, jdbcType=INTEGER} and `type`= #{type, jdbcType=TINYINT}",
        "GROUP BY  `seqno`",
        "ORDER BY  `seqno` ASC"
    })
    List<ExamQuestionWithBLOBs> getSeqnoResultRelation(@Param("examid") Integer examid, @Param("type") Integer type);

    /**
     *@Description: 小题作答详情-表格头部标题
     *@author Lvxianya
     *@date 2018/2/3
     */
    @Select({
        "SELECT seqno, score",
        "FROM exam_question",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "ORDER BY seqno"
    })
    List<ExamQuestion> getSeqnoScoreRelation(Integer examid);

    /**
     *@Description: 获取题目和题号的对应关系
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT questionid,seqno",
        "FROM exam_question",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "ORDER BY seqno"
    })
    List<ExamQuestion> getQuesSeqnoRelation(Integer examid);

    /**
     *@Description: 获取题目组和题号的对应关系
     *@author Lvxianya
     *@date 2018/2/8
     */
    @Select({
        "SELECT `qsgroup`,`seqno`",
        "FROM exam_question",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "GROUP BY `qsgroup`,`seqno`",
        "ORDER BY `seqno` ASC"   
    })
    List<ExamQuestion> getQsgroupSeqnoRelation(Integer examid);

    /**
     *@Description: 返回试卷大题和小题ID关联信息
     *@author Lvxianya
     *@date 2018/2/8
     */
    @Select({
        "SELECT `qsgroup`,`questionid`",
        "FROM exam_question",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "GROUP BY `qsgroup`,`questionid`",
        "ORDER BY `seqno` ASC"
    })
    List<ExamQuestion> getQsgroupQuidRelation(Integer examid);
}