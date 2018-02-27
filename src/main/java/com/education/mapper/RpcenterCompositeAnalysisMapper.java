package com.education.mapper;

import com.education.domain.RpcenterCompositeAnalysis;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface RpcenterCompositeAnalysisMapper {
    @Delete({
        "delete from rpcenter_composite_analysis",
        "where rpcaid = #{rpcaid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rpcaid);

    @Insert({
        "insert into rpcenter_composite_analysis (rpcaid, rpcid, ",
        "headteacher, teacherid, ",
        "classid, subjectid, ",
        "stu_num, absent_num, ",
        "average_score, excellent_num, ",
        "excellent_rate, goold_num, ",
        "goold_rate, pass_num, ",
        "pass_rate, fail_num, ",
        "fail_rate, highest_score, ",
        "minimum_score, standard_deviation, ",
        "ranking, create_at)",
        "values (#{rpcaid,jdbcType=INTEGER}, #{rpcid,jdbcType=INTEGER}, ",
        "#{headteacher,jdbcType=INTEGER}, #{teacherid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{subjectid,jdbcType=VARCHAR}, ",
        "#{stuNum,jdbcType=SMALLINT}, #{absentNum,jdbcType=SMALLINT}, ",
        "#{averageScore,jdbcType=REAL}, #{excellentNum,jdbcType=SMALLINT}, ",
        "#{excellentRate,jdbcType=VARCHAR}, #{gooldNum,jdbcType=SMALLINT}, ",
        "#{gooldRate,jdbcType=VARCHAR}, #{passNum,jdbcType=SMALLINT}, ",
        "#{passRate,jdbcType=VARCHAR}, #{failNum,jdbcType=SMALLINT}, ",
        "#{failRate,jdbcType=VARCHAR}, #{highestScore,jdbcType=REAL}, ",
        "#{minimumScore,jdbcType=REAL}, #{standardDeviation,jdbcType=VARCHAR}, ",
        "#{ranking,jdbcType=SMALLINT}, #{createAt,jdbcType=TIMESTAMP})"
    })
    int insert(RpcenterCompositeAnalysis record);

    @Select({
        "select",
        "rpcaid, rpcid, headteacher, teacherid, classid, subjectid, stu_num, absent_num, ",
        "average_score, excellent_num, excellent_rate, goold_num, goold_rate, pass_num, ",
        "pass_rate, fail_num, fail_rate, highest_score, minimum_score, standard_deviation, ",
        "ranking, create_at",
        "from rpcenter_composite_analysis",
        "where rpcaid = #{rpcaid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="rpcaid", property="rpcaid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rpcid", property="rpcid", jdbcType=JdbcType.INTEGER),
        @Result(column="headteacher", property="headteacher", jdbcType=JdbcType.INTEGER),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.VARCHAR),
        @Result(column="stu_num", property="stuNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="absent_num", property="absentNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="average_score", property="averageScore", jdbcType=JdbcType.REAL),
        @Result(column="excellent_num", property="excellentNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="excellent_rate", property="excellentRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="goold_num", property="gooldNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="goold_rate", property="gooldRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass_num", property="passNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="pass_rate", property="passRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="fail_num", property="failNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="fail_rate", property="failRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="highest_score", property="highestScore", jdbcType=JdbcType.REAL),
        @Result(column="minimum_score", property="minimumScore", jdbcType=JdbcType.REAL),
        @Result(column="standard_deviation", property="standardDeviation", jdbcType=JdbcType.VARCHAR),
        @Result(column="ranking", property="ranking", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP)
    })
    RpcenterCompositeAnalysis selectByPrimaryKey(Integer rpcaid);

    @Select({
        "select",
        "rpcaid, rpcid, headteacher, teacherid, classid, subjectid, stu_num, absent_num, ",
        "average_score, excellent_num, excellent_rate, goold_num, goold_rate, pass_num, ",
        "pass_rate, fail_num, fail_rate, highest_score, minimum_score, standard_deviation, ",
        "ranking, create_at",
        "from rpcenter_composite_analysis"
    })
    @Results({
        @Result(column="rpcaid", property="rpcaid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rpcid", property="rpcid", jdbcType=JdbcType.INTEGER),
        @Result(column="headteacher", property="headteacher", jdbcType=JdbcType.INTEGER),
        @Result(column="teacherid", property="teacherid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.VARCHAR),
        @Result(column="stu_num", property="stuNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="absent_num", property="absentNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="average_score", property="averageScore", jdbcType=JdbcType.REAL),
        @Result(column="excellent_num", property="excellentNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="excellent_rate", property="excellentRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="goold_num", property="gooldNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="goold_rate", property="gooldRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="pass_num", property="passNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="pass_rate", property="passRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="fail_num", property="failNum", jdbcType=JdbcType.SMALLINT),
        @Result(column="fail_rate", property="failRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="highest_score", property="highestScore", jdbcType=JdbcType.REAL),
        @Result(column="minimum_score", property="minimumScore", jdbcType=JdbcType.REAL),
        @Result(column="standard_deviation", property="standardDeviation", jdbcType=JdbcType.VARCHAR),
        @Result(column="ranking", property="ranking", jdbcType=JdbcType.SMALLINT),
        @Result(column="create_at", property="createAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RpcenterCompositeAnalysis> selectAll();

    @Update({
        "update rpcenter_composite_analysis",
        "set rpcid = #{rpcid,jdbcType=INTEGER},",
          "headteacher = #{headteacher,jdbcType=INTEGER},",
          "teacherid = #{teacherid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=VARCHAR},",
          "stu_num = #{stuNum,jdbcType=SMALLINT},",
          "absent_num = #{absentNum,jdbcType=SMALLINT},",
          "average_score = #{averageScore,jdbcType=REAL},",
          "excellent_num = #{excellentNum,jdbcType=SMALLINT},",
          "excellent_rate = #{excellentRate,jdbcType=VARCHAR},",
          "goold_num = #{gooldNum,jdbcType=SMALLINT},",
          "goold_rate = #{gooldRate,jdbcType=VARCHAR},",
          "pass_num = #{passNum,jdbcType=SMALLINT},",
          "pass_rate = #{passRate,jdbcType=VARCHAR},",
          "fail_num = #{failNum,jdbcType=SMALLINT},",
          "fail_rate = #{failRate,jdbcType=VARCHAR},",
          "highest_score = #{highestScore,jdbcType=REAL},",
          "minimum_score = #{minimumScore,jdbcType=REAL},",
          "standard_deviation = #{standardDeviation,jdbcType=VARCHAR},",
          "ranking = #{ranking,jdbcType=SMALLINT},",
          "create_at = #{createAt,jdbcType=TIMESTAMP}",
        "where rpcaid = #{rpcaid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RpcenterCompositeAnalysis record);
}