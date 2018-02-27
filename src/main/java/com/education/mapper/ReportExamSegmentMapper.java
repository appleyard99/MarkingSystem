package com.education.mapper;

import com.education.domain.ReportExamSegment;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface ReportExamSegmentMapper {
    @Delete({
        "delete from report_exam_segment",
        "where reseid = #{reseid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer reseid);

    @Insert({
        "insert into report_exam_segment (reseid, examid, ",
        "classid, segment, ",
        "num, created_at)",
        "values (#{reseid,jdbcType=INTEGER}, #{examid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{segment,jdbcType=SMALLINT}, ",
        "#{num,jdbcType=SMALLINT}, #{createdAt,jdbcType=TIMESTAMP})"
    })
    int insert(ReportExamSegment record);

    @Select({
        "select",
        "reseid, examid, classid, segment, num, created_at",
        "from report_exam_segment",
        "where reseid = #{reseid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="reseid", property="reseid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="segment", property="segment", jdbcType=JdbcType.SMALLINT),
        @Result(column="num", property="num", jdbcType=JdbcType.SMALLINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    ReportExamSegment selectByPrimaryKey(Integer reseid);

    @Select({
        "select",
        "reseid, examid, classid, segment, num, created_at",
        "from report_exam_segment"
    })
    @Results({
        @Result(column="reseid", property="reseid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="segment", property="segment", jdbcType=JdbcType.SMALLINT),
        @Result(column="num", property="num", jdbcType=JdbcType.SMALLINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ReportExamSegment> selectAll();

    @Update({
        "update report_exam_segment",
        "set examid = #{examid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "segment = #{segment,jdbcType=SMALLINT},",
          "num = #{num,jdbcType=SMALLINT},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP}",
        "where reseid = #{reseid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReportExamSegment record);

    /**
     *@Description: 根据"试卷"和"班级"编号获取各分数段人数
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT num",
        "FROM report_exam_segment",
        "WHERE examid = #{examid, jdbcType=INTEGER} and classid = #{classid, jdbcType=INTEGER}",
        "ORDER BY segment"
    })
    List<Integer> getSegment(@Param("examid") Integer examid, @Param("classid") Integer classid);
}