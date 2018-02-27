package com.education.mapper;

import com.education.domain.ExamStudent;
import java.util.List;

import com.education.domain.vo.ReportExamVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface ExamStudentMapper {
    @Delete({
        "delete from exam_student",
        "where exsid = #{exsid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer exsid);

    @Insert({
        "insert into exam_student (exsid, examid, ",
        "studentid, teacherid, ",
        "created_at, submittime, ",
        "classid, status, ",
        "score, scorerate, ranking, ",
        "grade_ranking, exceed, ",
        "exceed_rate, grade_exceed, ",
        "grade_exceed_rate)",
        "values (#{exsid,jdbcType=INTEGER}, #{examid,jdbcType=INTEGER}, ",
        "#{studentid,jdbcType=INTEGER}, #{teacherid,jdbcType=INTEGER}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{submittime,jdbcType=TIMESTAMP}, ",
        "#{classid,jdbcType=INTEGER}, #{status,jdbcType=TINYINT}, ",
        "#{score,jdbcType=REAL}, #{scorerate,jdbcType=REAL}, #{ranking,jdbcType=INTEGER}, ",
        "#{gradeRanking,jdbcType=INTEGER}, #{exceed,jdbcType=INTEGER}, ",
        "#{exceedRate,jdbcType=REAL}, #{gradeExceed,jdbcType=INTEGER}, ",
        "#{gradeExceedRate,jdbcType=REAL})"
    })
    int insert(ExamStudent record);

    @Select({
        "select",
        "exsid, examid, studentid, teacherid, created_at, submittime, classid, status, ",
        "score, scorerate, ranking, grade_ranking, exceed, exceed_rate, grade_exceed, ",
        "grade_exceed_rate",
        "from exam_student",
        "where exsid = #{exsid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="exsid", property="exsid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="submittime", property="submittime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="scorerate", property="scorerate", jdbcType=JdbcType.REAL),
        @Result(column="ranking", property="ranking", jdbcType=JdbcType.INTEGER),
        @Result(column="grade_ranking", property="gradeRanking", jdbcType=JdbcType.INTEGER),
        @Result(column="exceed", property="exceed", jdbcType=JdbcType.INTEGER),
        @Result(column="exceed_rate", property="exceedRate", jdbcType=JdbcType.REAL),
        @Result(column="grade_exceed", property="gradeExceed", jdbcType=JdbcType.INTEGER),
        @Result(column="grade_exceed_rate", property="gradeExceedRate", jdbcType=JdbcType.REAL)
    })
    ExamStudent selectByPrimaryKey(Integer exsid);

    @Select({
        "select",
        "exsid, examid, studentid, teacherid, created_at, submittime, classid, status, ",
        "score, scorerate, ranking, grade_ranking, exceed, exceed_rate, grade_exceed, ",
        "grade_exceed_rate",
        "from exam_student"
    })
    @Results({
        @Result(column="exsid", property="exsid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="submittime", property="submittime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="scorerate", property="scorerate", jdbcType=JdbcType.REAL),
        @Result(column="ranking", property="ranking", jdbcType=JdbcType.INTEGER),
        @Result(column="grade_ranking", property="gradeRanking", jdbcType=JdbcType.INTEGER),
        @Result(column="exceed", property="exceed", jdbcType=JdbcType.INTEGER),
        @Result(column="exceed_rate", property="exceedRate", jdbcType=JdbcType.REAL),
        @Result(column="grade_exceed", property="gradeExceed", jdbcType=JdbcType.INTEGER),
        @Result(column="grade_exceed_rate", property="gradeExceedRate", jdbcType=JdbcType.REAL)
    })
    List<ExamStudent> selectAll();

    @Update({
        "update exam_student",
        "set examid = #{examid,jdbcType=INTEGER},",
          "studentid = #{studentid,jdbcType=INTEGER},",
          "teacherid = #{teacherid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "submittime = #{submittime,jdbcType=TIMESTAMP},",
          "classid = #{classid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "score = #{score,jdbcType=REAL},",
          "scorerate = #{scorerate,jdbcType=REAL},",
          "ranking = #{ranking,jdbcType=INTEGER},",
          "grade_ranking = #{gradeRanking,jdbcType=INTEGER},",
          "exceed = #{exceed,jdbcType=INTEGER},",
          "exceed_rate = #{exceedRate,jdbcType=REAL},",
          "grade_exceed = #{gradeExceed,jdbcType=INTEGER},",
          "grade_exceed_rate = #{gradeExceedRate,jdbcType=REAL}",
        "where exsid = #{exsid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ExamStudent record);

    /**
     *@Description: 获取学生得分，名次信息
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT studentid, score, ranking, status",
        "FROM `exam_student`",
        "WHERE examid = #{examid, jdbcType=INTEGER} and classid = #{classid, jdbcType=INTEGER} and status = 3",
        "ORDER BY studentid"
    })
    List<ReportExamVo> getStuExamInfo(@Param("classid") Integer classid, @Param("examid") Integer examid);

    @Select({
            "SELECT sum(score) as num" ,
            "from  exam_student WHERE examid=#{examid,jdbcType=INTEGER} and `status`=3;"
    })
    Float getZScore(Integer examid);

    @Select({
            "SELECT count(*) as num" ,
            "from  exam_student WHERE examid=#{examid,jdbcType=INTEGER} and `status`=3;"
    })
    Integer getZNum(Integer examid);

    /**
     *@Description: 根据"试卷标号"和"班级编号"获取学生id信息
     *@author Lvxianya
     *@date 2018/2/3
     */
    @Select({
        "SELECT studentid, status",
        "FROM exam_student",
        "WHERE examid = #{examid, jdbcType=INTEGER} and classid = #{classid, jdbcType=INTEGER} and status = 3",
        "ORDER BY studentid"
    })
    List<ExamStudent> selByExamidAndClassId(@Param("examid") Integer examid, @Param("classid") Integer classid);

    /** 
     *@Description: 获取班级作答人数
     *@author liuyizheng
     *@date 2018/2/7
     */
    @Select({
            "SELECT COUNT(*) AS num",
            "FROM  exam_student WHERE examid=#{examid, jdbcType=INTEGER}",
            "AND classid=#{classid, jdbcType=INTEGER}",
            "AND `status`=3;"
    })
    int getclassStuNum(@Param("examid") Integer examid, @Param("classid") Integer classid);

    /**
     *@Description: 获取学生得分、名次信息
     *@author Lvxianya
     *@date 2018/2/7
     */
    @Select({
        "<script> ",
        "SELECT studentid, classid, score, ranking, grade_ranking, status",
        "FROM exam_student ",
        " <where> ",
        " <if test=\"examid != null\">examid = #{examid, jdbcType=INTEGER}</if> ",
        " <if test=\"classid != null\"> AND classid = #{classid, jdbcType=INTEGER}</if> ",
        " </where> ",
        "ORDER BY classid, studentid",
        " </script> "
    })
    @Results({
        @Result(column="grade_ranking", property="gradeRanking", jdbcType=JdbcType.INTEGER),
    })
    List<ExamStudent> getstuInfoByexamidAndclassid(@Param("examid") Integer examid, @Param("classid") Integer classid);
}