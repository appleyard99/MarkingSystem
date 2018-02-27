package com.education.mapper;

import com.education.domain.ExamResult;
import com.education.domain.ExamResultWithBLOBs;
import java.util.List;

import com.education.domain.vo.ExamResultVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface ExamResultMapper {
    @Delete({
        "delete from exam_result",
        "where exrid = #{exrid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer exrid);

    @Insert({
        "insert into exam_result (exrid, examid, ",
        "questionid, studentid, ",
        "classid, answertime, ",
        "answerstatus, score, ",
        "helpflag, helptime, ",
        "qsgroup, answer, ",
        "notes, remarks)",
        "values (#{exrid,jdbcType=INTEGER}, #{examid,jdbcType=INTEGER}, ",
        "#{questionid,jdbcType=INTEGER}, #{studentid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{answertime,jdbcType=TIMESTAMP}, ",
        "#{answerstatus,jdbcType=TINYINT}, #{score,jdbcType=REAL}, ",
        "#{helpflag,jdbcType=TINYINT}, #{helptime,jdbcType=TIMESTAMP}, ",
        "#{qsgroup,jdbcType=VARCHAR}, #{answer,jdbcType=LONGVARCHAR}, ",
        "#{notes,jdbcType=LONGVARCHAR}, #{remarks,jdbcType=LONGVARCHAR})"
    })
    int insert(ExamResult record);

    @Select({
        "select",
        "exrid, examid, questionid, studentid, classid, answertime, answerstatus, score, ",
        "helpflag, helptime, qsgroup, answer, notes, remarks",
        "from exam_result",
        "where exrid = #{exrid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="exrid", property="exrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="answertime", property="answertime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="answerstatus", property="answerstatus", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="helpflag", property="helpflag", jdbcType=JdbcType.TINYINT),
        @Result(column="helptime", property="helptime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="answer", property="answer", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="notes", property="notes", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.LONGVARCHAR)
    })
    ExamResultWithBLOBs selectByPrimaryKey(Integer exrid);

    @Select({
        "select",
        "exrid, examid, questionid, studentid, classid, answertime, answerstatus, score, ",
        "helpflag, helptime, qsgroup, answer, notes, remarks",
        "from exam_result"
    })
    @Results({
        @Result(column="exrid", property="exrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="answertime", property="answertime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="answerstatus", property="answerstatus", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="helpflag", property="helpflag", jdbcType=JdbcType.TINYINT),
        @Result(column="helptime", property="helptime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="qsgroup", property="qsgroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="answer", property="answer", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="notes", property="notes", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="remarks", property="remarks", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ExamResult> selectAll();

    @Update({
        "update exam_result",
        "set examid = #{examid,jdbcType=INTEGER},",
          "questionid = #{questionid,jdbcType=INTEGER},",
          "studentid = #{studentid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "answertime = #{answertime,jdbcType=TIMESTAMP},",
          "answerstatus = #{answerstatus,jdbcType=TINYINT},",
          "score = #{score,jdbcType=REAL},",
          "helpflag = #{helpflag,jdbcType=TINYINT},",
          "helptime = #{helptime,jdbcType=TIMESTAMP},",
          "qsgroup = #{qsgroup,jdbcType=VARCHAR},",
          "answer = #{answer,jdbcType=LONGVARCHAR},",
          "notes = #{notes,jdbcType=LONGVARCHAR},",
          "remarks = #{remarks,jdbcType=LONGVARCHAR}",
        "where exrid = #{exrid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExamResult record);

    /**
     *@Description: 获取xx考试xx班级,学生大题得分情况.
     *@author liuyizheng
     *@date 2018/2/7
     */
    @Select({
            "SELECT	`qsgroup`,SUM(score) AS zscore",
            "FROM	${tableName} ",
            "WHERE	`examid` = #{examid,jdbcType=INTEGER}	AND `classid` = #{classid,jdbcType=INTEGER}  AND `answerstatus`=1",
            "GROUP BY qsgroup"
    })
    List<ExamResultVo> getQsgroupScoreRelation(@Param("classid") Integer classid, @Param("examid") Integer examid, @Param("tableName") String tableName);

    /**
     *@Description: 获取xx考试所有学生-小题得分情况.
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT `questionid`,`studentid`,`score`",
        "FROM ${tableName}",
        "WHERE examid = #{examid, jdbcType=INTEGER} and classid = #{classid, jdbcType=INTEGER} and answerstatus = 1",
    })
    List<ExamResult> getStuQuesScore(@Param("tableName") String tableName, @Param("examid") Integer examid, @Param("classid") Integer classid);

    /**
     *@Description: 获取xx考试所有学生-小题对应关系
     *@author Lvxianya
     *@date 2018/2/7
     */
    @Select({
        "SELECT `questionid`,`studentid`,`qsgroup`,`score`",
        "FROM ${tableName}",
        "WHERE examid = #{examid, jdbcType=INTEGER} and answerstatus = 1",
        "<if test=\"classid != null\"> AND classid = #{classid, jdbcType=INTEGER}</if>",
        "GROUP BY studentid, questionid, qsgroup"
    })
    List<ExamResult> getStuScoreRelation(@Param("tableName") String tableName, @Param("examid") Integer examid, @Param("classid") Integer classid);
}