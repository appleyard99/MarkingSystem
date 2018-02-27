package com.education.mapper;

import com.education.domain.ReportExamAvgrate;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ReportExamAvgrateMapper {
    @Delete({
        "delete from report_exam_avgrate",
        "where reavrid = #{reavrid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer reavrid);

    @Insert({
        "insert into report_exam_avgrate (reavrid, examid, ",
        "classid, class_average, ",
        "class_rate, grade_average, ",
        "grade_rate, created_at)",
        "values (#{reavrid,jdbcType=INTEGER}, #{examid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{classAverage,jdbcType=REAL}, ",
        "#{classRate,jdbcType=REAL}, #{gradeAverage,jdbcType=REAL}, ",
        "#{gradeRate,jdbcType=REAL}, #{createdAt,jdbcType=TIMESTAMP})"
    })
    int insert(ReportExamAvgrate record);

    @Select({
        "select",
        "reavrid, examid, classid, class_average, class_rate, grade_average, grade_rate, ",
        "created_at",
        "from report_exam_avgrate",
        "where reavrid = #{reavrid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="reavrid", property="reavrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="class_average", property="classAverage", jdbcType=JdbcType.REAL),
        @Result(column="class_rate", property="classRate", jdbcType=JdbcType.REAL),
        @Result(column="grade_average", property="gradeAverage", jdbcType=JdbcType.REAL),
        @Result(column="grade_rate", property="gradeRate", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    ReportExamAvgrate selectByPrimaryKey(Integer reavrid);

    @Select({
        "select",
        "reavrid, examid, classid, class_average, class_rate, grade_average, grade_rate, ",
        "created_at",
        "from report_exam_avgrate"
    })
    @Results({
        @Result(column="reavrid", property="reavrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="class_average", property="classAverage", jdbcType=JdbcType.REAL),
        @Result(column="class_rate", property="classRate", jdbcType=JdbcType.REAL),
        @Result(column="grade_average", property="gradeAverage", jdbcType=JdbcType.REAL),
        @Result(column="grade_rate", property="gradeRate", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ReportExamAvgrate> selectAll();

    @Update({
        "update report_exam_avgrate",
        "set examid = #{examid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "class_average = #{classAverage,jdbcType=REAL},",
          "class_rate = #{classRate,jdbcType=REAL},",
          "grade_average = #{gradeAverage,jdbcType=REAL},",
          "grade_rate = #{gradeRate,jdbcType=REAL},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP}",
        "where reavrid = #{reavrid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReportExamAvgrate record);
}