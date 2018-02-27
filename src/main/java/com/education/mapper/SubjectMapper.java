package com.education.mapper;

import com.education.domain.Subject;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SubjectMapper {
    @Delete({
        "delete from subject",
        "where subjectid = #{subjectid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer subjectid);

    @Insert({
        "insert into subject (subjectid, subject, ",
        "createby, createtime, ",
        "updateby, updatetime, ",
        "status)",
        "values (#{subjectid,jdbcType=INTEGER}, #{subject,jdbcType=VARCHAR}, ",
        "#{createby,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updateby,jdbcType=INTEGER}, #{updatetime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT})"
    })
    int insert(Subject record);

    @Select({
        "select",
        "subjectid, subject, createby, createtime, updateby, updatetime, status",
        "from subject",
        "where subjectid = #{subjectid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Subject selectByPrimaryKey(Integer subjectid);

    @Select({
        "select",
        "subjectid, subject, createby, createtime, updateby, updatetime, status",
        "from subject"
    })
    @Results({
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Subject> selectAll();

    @Update({
        "update subject",
        "set subject = #{subject,jdbcType=VARCHAR},",
          "createby = #{createby,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "updateby = #{updateby,jdbcType=INTEGER},",
          "updatetime = #{updatetime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT}",
        "where subjectid = #{subjectid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Subject record);
}