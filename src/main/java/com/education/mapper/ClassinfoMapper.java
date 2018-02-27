package com.education.mapper;

import com.education.domain.Classinfo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ClassinfoMapper {
    @Delete({
        "delete from classinfo",
        "where classid = #{classid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer classid);

    @Insert({
        "insert into classinfo (classid, classname, ",
        "classtype, termid, ",
        "gradeid, schoolid, ",
        "campusid, personnum, ",
        "roomid, status)",
        "values (#{classid,jdbcType=INTEGER}, #{classname,jdbcType=VARCHAR}, ",
        "#{classtype,jdbcType=TINYINT}, #{termid,jdbcType=INTEGER}, ",
        "#{gradeid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{personnum,jdbcType=INTEGER}, ",
        "#{roomid,jdbcType=INTEGER}, #{status,jdbcType=TINYINT})"
    })
    int insert(Classinfo record);

    @Select({
        "select",
        "classid, classname, classtype, termid, gradeid, schoolid, campusid, personnum, ",
        "roomid, status",
        "from classinfo",
        "where classid = #{classid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classname", property="classname", jdbcType=JdbcType.VARCHAR),
        @Result(column="classtype", property="classtype", jdbcType=JdbcType.TINYINT),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="personnum", property="personnum", jdbcType=JdbcType.INTEGER),
        @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Classinfo selectByPrimaryKey(Integer classid);

    @Select({
        "select",
        "classid, classname, classtype, termid, gradeid, schoolid, campusid, personnum, ",
        "roomid, status",
        "from classinfo"
    })
    @Results({
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="classname", property="classname", jdbcType=JdbcType.VARCHAR),
        @Result(column="classtype", property="classtype", jdbcType=JdbcType.TINYINT),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="personnum", property="personnum", jdbcType=JdbcType.INTEGER),
        @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Classinfo> selectAll();

    @Update({
        "update classinfo",
        "set classname = #{classname,jdbcType=VARCHAR},",
          "classtype = #{classtype,jdbcType=TINYINT},",
          "termid = #{termid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "personnum = #{personnum,jdbcType=INTEGER},",
          "roomid = #{roomid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where classid = #{classid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Classinfo record);
}