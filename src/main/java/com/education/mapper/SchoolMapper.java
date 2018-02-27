package com.education.mapper;

import com.education.domain.School;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SchoolMapper {
    @Delete({
        "delete from school",
        "where schoolid = #{schoolid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer schoolid);

    @Insert({
        "insert into school (schoolid, schoolcode, ",
        "name, postcode, ",
        "telephone, contact, ",
        "fax, email, address, ",
        "createby, createtime, ",
        "updateby, updatetime, ",
        "remark, status, ",
        "areaid, logo, site)",
        "values (#{schoolid,jdbcType=INTEGER}, #{schoolcode,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{postcode,jdbcType=VARCHAR}, ",
        "#{telephone,jdbcType=VARCHAR}, #{contact,jdbcType=VARCHAR}, ",
        "#{fax,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{createby,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updateby,jdbcType=INTEGER}, #{updatetime,jdbcType=TIMESTAMP}, ",
        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{areaid,jdbcType=INTEGER}, #{logo,jdbcType=VARCHAR}, #{site,jdbcType=VARCHAR})"
    })
    int insert(School record);

    @Select({
        "select",
        "schoolid, schoolcode, name, postcode, telephone, contact, fax, email, address, ",
        "createby, createtime, updateby, updatetime, remark, status, areaid, logo, site",
        "from school",
        "where schoolid = #{schoolid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolcode", property="schoolcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="postcode", property="postcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="fax", property="fax", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="areaid", property="areaid", jdbcType=JdbcType.INTEGER),
        @Result(column="logo", property="logo", jdbcType=JdbcType.VARCHAR),
        @Result(column="site", property="site", jdbcType=JdbcType.VARCHAR)
    })
    School selectByPrimaryKey(Integer schoolid);

    @Select({
        "select",
        "schoolid, schoolcode, name, postcode, telephone, contact, fax, email, address, ",
        "createby, createtime, updateby, updatetime, remark, status, areaid, logo, site",
        "from school"
    })
    @Results({
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolcode", property="schoolcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="postcode", property="postcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact", property="contact", jdbcType=JdbcType.VARCHAR),
        @Result(column="fax", property="fax", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="areaid", property="areaid", jdbcType=JdbcType.INTEGER),
        @Result(column="logo", property="logo", jdbcType=JdbcType.VARCHAR),
        @Result(column="site", property="site", jdbcType=JdbcType.VARCHAR)
    })
    List<School> selectAll();

    @Update({
        "update school",
        "set schoolcode = #{schoolcode,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "postcode = #{postcode,jdbcType=VARCHAR},",
          "telephone = #{telephone,jdbcType=VARCHAR},",
          "contact = #{contact,jdbcType=VARCHAR},",
          "fax = #{fax,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "createby = #{createby,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "updateby = #{updateby,jdbcType=INTEGER},",
          "updatetime = #{updatetime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "areaid = #{areaid,jdbcType=INTEGER},",
          "logo = #{logo,jdbcType=VARCHAR},",
          "site = #{site,jdbcType=VARCHAR}",
        "where schoolid = #{schoolid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(School record);
}