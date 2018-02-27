package com.education.mapper;

import com.education.domain.Exam;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface ExamMapper {
    @Delete({
        "delete from exam",
        "where examid = #{examid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer examid);

    @Insert({
        "insert into exam (examid, examname, ",
        "examtype, notes, ",
        "schoolid, campusid, ",
        "gradeid, subjectid, ",
        "createby, created_at, ",
        "updateby, updated_at, ",
        "termid, mark, layout, ",
        "bindingline, analysisviewtype, ",
        "videoviewtype, score, ",
        "avgscore, status, pagenum, ",
        "answercardpath, paperpath, ",
        "xpspath)",
        "values (#{examid,jdbcType=INTEGER}, #{examname,jdbcType=VARCHAR}, ",
        "#{examtype,jdbcType=TINYINT}, #{notes,jdbcType=VARCHAR}, ",
        "#{schoolid,jdbcType=INTEGER}, #{campusid,jdbcType=INTEGER}, ",
        "#{gradeid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER}, ",
        "#{createby,jdbcType=INTEGER}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updateby,jdbcType=INTEGER}, #{updatedAt,jdbcType=TIMESTAMP}, ",
        "#{termid,jdbcType=INTEGER}, #{mark,jdbcType=TINYINT}, #{layout,jdbcType=TINYINT}, ",
        "#{bindingline,jdbcType=TINYINT}, #{analysisviewtype,jdbcType=TINYINT}, ",
        "#{videoviewtype,jdbcType=TINYINT}, #{score,jdbcType=REAL}, ",
        "#{avgscore,jdbcType=REAL}, #{status,jdbcType=TINYINT}, #{pagenum,jdbcType=INTEGER}, ",
        "#{answercardpath,jdbcType=VARCHAR}, #{paperpath,jdbcType=VARCHAR}, ",
        "#{xpspath,jdbcType=VARCHAR})"
    })
    int insert(Exam record);

    @Select({
        "select",
        "examid, examname, examtype, notes, schoolid, campusid, gradeid, subjectid, createby, ",
        "created_at, updateby, updated_at, termid, mark, layout, bindingline, analysisviewtype, ",
        "videoviewtype, score, avgscore, status, pagenum, answercardpath, paperpath, ",
        "xpspath",
        "from exam",
        "where examid = #{examid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examname", property="examname", jdbcType=JdbcType.VARCHAR),
        @Result(column="examtype", property="examtype", jdbcType=JdbcType.TINYINT),
        @Result(column="notes", property="notes", jdbcType=JdbcType.VARCHAR),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="mark", property="mark", jdbcType=JdbcType.TINYINT),
        @Result(column="layout", property="layout", jdbcType=JdbcType.TINYINT),
        @Result(column="bindingline", property="bindingline", jdbcType=JdbcType.TINYINT),
        @Result(column="analysisviewtype", property="analysisviewtype", jdbcType=JdbcType.TINYINT),
        @Result(column="videoviewtype", property="videoviewtype", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="avgscore", property="avgscore", jdbcType=JdbcType.REAL),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="pagenum", property="pagenum", jdbcType=JdbcType.INTEGER),
        @Result(column="answercardpath", property="answercardpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="paperpath", property="paperpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="xpspath", property="xpspath", jdbcType=JdbcType.VARCHAR)
    })
    Exam selectByPrimaryKey(Integer examid);

    @Select({
        "select",
        "examid, examname, examtype, notes, schoolid, campusid, gradeid, subjectid, createby, ",
        "created_at, updateby, updated_at, termid, mark, layout, bindingline, analysisviewtype, ",
        "videoviewtype, score, avgscore, status, pagenum, answercardpath, paperpath, ",
        "xpspath",
        "from exam"
    })
    @Results({
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examname", property="examname", jdbcType=JdbcType.VARCHAR),
        @Result(column="examtype", property="examtype", jdbcType=JdbcType.TINYINT),
        @Result(column="notes", property="notes", jdbcType=JdbcType.VARCHAR),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="mark", property="mark", jdbcType=JdbcType.TINYINT),
        @Result(column="layout", property="layout", jdbcType=JdbcType.TINYINT),
        @Result(column="bindingline", property="bindingline", jdbcType=JdbcType.TINYINT),
        @Result(column="analysisviewtype", property="analysisviewtype", jdbcType=JdbcType.TINYINT),
        @Result(column="videoviewtype", property="videoviewtype", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.REAL),
        @Result(column="avgscore", property="avgscore", jdbcType=JdbcType.REAL),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="pagenum", property="pagenum", jdbcType=JdbcType.INTEGER),
        @Result(column="answercardpath", property="answercardpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="paperpath", property="paperpath", jdbcType=JdbcType.VARCHAR),
        @Result(column="xpspath", property="xpspath", jdbcType=JdbcType.VARCHAR)
    })
    List<Exam> selectAll();

    @Update({
        "update exam",
        "set examname = #{examname,jdbcType=VARCHAR},",
          "examtype = #{examtype,jdbcType=TINYINT},",
          "notes = #{notes,jdbcType=VARCHAR},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "createby = #{createby,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updateby = #{updateby,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "termid = #{termid,jdbcType=INTEGER},",
          "mark = #{mark,jdbcType=TINYINT},",
          "layout = #{layout,jdbcType=TINYINT},",
          "bindingline = #{bindingline,jdbcType=TINYINT},",
          "analysisviewtype = #{analysisviewtype,jdbcType=TINYINT},",
          "videoviewtype = #{videoviewtype,jdbcType=TINYINT},",
          "score = #{score,jdbcType=REAL},",
          "avgscore = #{avgscore,jdbcType=REAL},",
          "status = #{status,jdbcType=TINYINT},",
          "pagenum = #{pagenum,jdbcType=INTEGER},",
          "answercardpath = #{answercardpath,jdbcType=VARCHAR},",
          "paperpath = #{paperpath,jdbcType=VARCHAR},",
          "xpspath = #{xpspath,jdbcType=VARCHAR}",
        "where examid = #{examid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Exam record);

    /**
     *@Description: 检查操作的合法性:只可以访问自己学校的数据
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT schoolid, termid, examname, score",
        "FROM `exam`",
        "WHERE examid = #{examid, jdbcType=INTEGER} and schoolid = #{schoolid, jdbcType=INTEGER}",
        "LIMIT 1"
    })
    Exam getExam(@Param("examid") Integer examid, @Param("schoolid") Integer schoolid);
}