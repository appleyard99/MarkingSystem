package com.education.mapper;

import com.education.domain.WqArrangeTaskDetail;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WqArrangeTaskDetailMapper {
    @Delete({
        "delete from wq_arrange_task_detail",
        "where atdetailid = #{atdetailid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer atdetailid);

    @Insert({
        "insert into wq_arrange_task_detail (atdetailid, arrangetaskid, ",
        "subjectid, total, ",
        "donenum, status)",
        "values (#{atdetailid,jdbcType=INTEGER}, #{arrangetaskid,jdbcType=INTEGER}, ",
        "#{subjectid,jdbcType=INTEGER}, #{total,jdbcType=INTEGER}, ",
        "#{donenum,jdbcType=INTEGER}, #{status,jdbcType=TINYINT})"
    })
    int insert(WqArrangeTaskDetail record);

    @Select({
        "select",
        "atdetailid, arrangetaskid, subjectid, total, donenum, status",
        "from wq_arrange_task_detail",
        "where atdetailid = #{atdetailid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="atdetailid", property="atdetailid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="arrangetaskid", property="arrangetaskid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.INTEGER),
        @Result(column="donenum", property="donenum", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    WqArrangeTaskDetail selectByPrimaryKey(Integer atdetailid);

    @Select({
        "select",
        "atdetailid, arrangetaskid, subjectid, total, donenum, status",
        "from wq_arrange_task_detail"
    })
    @Results({
        @Result(column="atdetailid", property="atdetailid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="arrangetaskid", property="arrangetaskid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.INTEGER),
        @Result(column="donenum", property="donenum", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<WqArrangeTaskDetail> selectAll();

    @Update({
        "update wq_arrange_task_detail",
        "set arrangetaskid = #{arrangetaskid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "total = #{total,jdbcType=INTEGER},",
          "donenum = #{donenum,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where atdetailid = #{atdetailid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WqArrangeTaskDetail record);
}