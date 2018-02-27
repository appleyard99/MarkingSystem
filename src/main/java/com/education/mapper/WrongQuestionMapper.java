package com.education.mapper;

import com.education.domain.WrongQuestion;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface WrongQuestionMapper {
    @Delete({
        "delete from wrong_question",
        "where wqid = #{wqid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer wqid);

    @Insert({
        "insert into wrong_question (wqid, userid, ",
        "questionid, questionbankid, ",
        "smallqsno, examid, ",
        "created_at, updated_at, ",
        "schoolid, gradeid, ",
        "classid, subjectid, ",
        "remark, status, ",
        "iscorrect, scorerate)",
        "values (#{wqid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{questionid,jdbcType=INTEGER}, #{questionbankid,jdbcType=INTEGER}, ",
        "#{smallqsno,jdbcType=VARCHAR}, #{examid,jdbcType=INTEGER}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{updatedAt,jdbcType=TIMESTAMP}, ",
        "#{schoolid,jdbcType=INTEGER}, #{gradeid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{iscorrect,jdbcType=TINYINT}, #{scorerate,jdbcType=REAL})"
    })
    int insert(WrongQuestion record);

    @Select({
        "select",
        "wqid, userid, questionid, questionbankid, smallqsno, examid, created_at, updated_at, ",
        "schoolid, gradeid, classid, subjectid, remark, status, iscorrect, scorerate",
        "from wrong_question",
        "where wqid = #{wqid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="wqid", property="wqid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="smallqsno", property="smallqsno", jdbcType=JdbcType.VARCHAR),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="iscorrect", property="iscorrect", jdbcType=JdbcType.TINYINT),
        @Result(column="scorerate", property="scorerate", jdbcType=JdbcType.REAL)
    })
    WrongQuestion selectByPrimaryKey(Integer wqid);

    @Select({
        "select",
        "wqid, userid, questionid, questionbankid, smallqsno, examid, created_at, updated_at, ",
        "schoolid, gradeid, classid, subjectid, remark, status, iscorrect, scorerate",
        "from wrong_question"
    })
    @Results({
        @Result(column="wqid", property="wqid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="smallqsno", property="smallqsno", jdbcType=JdbcType.VARCHAR),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="iscorrect", property="iscorrect", jdbcType=JdbcType.TINYINT),
        @Result(column="scorerate", property="scorerate", jdbcType=JdbcType.REAL)
    })
    List<WrongQuestion> selectAll();

    @Update({
        "update wrong_question",
        "set userid = #{userid,jdbcType=INTEGER},",
          "questionid = #{questionid,jdbcType=INTEGER},",
          "questionbankid = #{questionbankid,jdbcType=INTEGER},",
          "smallqsno = #{smallqsno,jdbcType=VARCHAR},",
          "examid = #{examid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "iscorrect = #{iscorrect,jdbcType=TINYINT},",
          "scorerate = #{scorerate,jdbcType=REAL}",
        "where wqid = #{wqid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WrongQuestion record);

    /**
     *@Description: 根据"试卷编号"，"班级编号"，状态status获取当前"题目编号"
     *@author Lvxianya
     *@date 2018/2/6
     */
    @Select({
        "SELECT `questionid`",
        "FROM wrong_question",
        "WHERE examid = #{examid, jdbcType=INTEGER} AND classid = #{classid, jdbcType=INTEGER} AND status = 1",
        "GROUP BY questionid",
        "ORDER BY questionid"
    })
    List<Integer> getQuesByExamidAndClsid(@Param("examid") Integer examid, @Param("classid") Integer classid);

    /**
     *@Description: 根据题目编号获取答错学生名单
     *@author Lvxianya
     *@date 2018/2/6
     */
    @Select({
        "SELECT u.username",
        "FROM wrong_question wq inner join `user` u on u.userid = wq.userid",
        "WHERE wq.examid = #{examid, jdbcType=INTEGER} AND wq.classid = #{classid, jdbcType=INTEGER} AND wq.questionid = #{questionid, jdbcType=INTEGER} AND wq.status = 1"
    })
    List<String> getUserByQid(@Param("examid") Integer examid, @Param("classid") Integer classid, @Param("questionid") Integer questionid);
}