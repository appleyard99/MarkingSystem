package com.education.mapper;

import com.education.domain.WqRedoTaskDetail;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WqRedoTaskDetailMapper {
    @Delete({
        "delete from wq_redo_task_detail",
        "where rtdetailid = #{rtdetailid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rtdetailid);

    @Insert({
        "insert into wq_redo_task_detail (rtdetailid, redotaskid, ",
        "subjectid, total, ",
        "donenum, correctnum, ",
        "status)",
        "values (#{rtdetailid,jdbcType=INTEGER}, #{redotaskid,jdbcType=INTEGER}, ",
        "#{subjectid,jdbcType=INTEGER}, #{total,jdbcType=INTEGER}, ",
        "#{donenum,jdbcType=INTEGER}, #{correctnum,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT})"
    })
    int insert(WqRedoTaskDetail record);

    @Select({
        "select",
        "rtdetailid, redotaskid, subjectid, total, donenum, correctnum, status",
        "from wq_redo_task_detail",
        "where rtdetailid = #{rtdetailid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="rtdetailid", property="rtdetailid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="redotaskid", property="redotaskid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.INTEGER),
        @Result(column="donenum", property="donenum", jdbcType=JdbcType.INTEGER),
        @Result(column="correctnum", property="correctnum", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    WqRedoTaskDetail selectByPrimaryKey(Integer rtdetailid);

    @Select({
        "select",
        "rtdetailid, redotaskid, subjectid, total, donenum, correctnum, status",
        "from wq_redo_task_detail"
    })
    @Results({
        @Result(column="rtdetailid", property="rtdetailid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="redotaskid", property="redotaskid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="total", property="total", jdbcType=JdbcType.INTEGER),
        @Result(column="donenum", property="donenum", jdbcType=JdbcType.INTEGER),
        @Result(column="correctnum", property="correctnum", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<WqRedoTaskDetail> selectAll();

    @Update({
        "update wq_redo_task_detail",
        "set redotaskid = #{redotaskid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "total = #{total,jdbcType=INTEGER},",
          "donenum = #{donenum,jdbcType=INTEGER},",
          "correctnum = #{correctnum,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where rtdetailid = #{rtdetailid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WqRedoTaskDetail record);
}