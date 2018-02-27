package com.education.mapper;

import com.education.domain.WrongReason;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface WrongReasonMapper {
    @Delete({
        "delete from wrong_reason",
        "where wrid = #{wrid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer wrid);

    @Insert({
        "insert into wrong_reason (wrid, subjectid, ",
        "reason, isdefault)",
        "values (#{wrid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER}, ",
        "#{reason,jdbcType=VARCHAR}, #{isdefault,jdbcType=TINYINT})"
    })
    int insert(WrongReason record);

    @Select({
        "select",
        "wrid, subjectid, reason, isdefault",
        "from wrong_reason",
        "where wrid = #{wrid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="wrid", property="wrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="isdefault", property="isdefault", jdbcType=JdbcType.TINYINT)
    })
    WrongReason selectByPrimaryKey(Integer wrid);

    @Select({
        "select",
        "wrid, subjectid, reason, isdefault",
        "from wrong_reason"
    })
    @Results({
        @Result(column="wrid", property="wrid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="reason", property="reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="isdefault", property="isdefault", jdbcType=JdbcType.TINYINT)
    })
    List<WrongReason> selectAll();

    @Update({
        "update wrong_reason",
        "set subjectid = #{subjectid,jdbcType=INTEGER},",
          "reason = #{reason,jdbcType=VARCHAR},",
          "isdefault = #{isdefault,jdbcType=TINYINT}",
        "where wrid = #{wrid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WrongReason record);
}