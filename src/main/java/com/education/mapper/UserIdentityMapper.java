package com.education.mapper;

import com.education.domain.UserIdentity;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface UserIdentityMapper {
    @Delete({
        "delete from user_identity",
        "where uiid = #{uiid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer uiid);

    @Insert({
        "insert into user_identity (uiid, userid, ",
        "schoolid, campusid, ",
        "usertype, bind_userid, ",
        "usestatus, created_at, ",
        "createby, updated_at, ",
        "updateby)",
        "values (#{uiid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{schoolid,jdbcType=INTEGER}, #{campusid,jdbcType=INTEGER}, ",
        "#{usertype,jdbcType=TINYINT}, #{bindUserid,jdbcType=INTEGER}, ",
        "#{usestatus,jdbcType=TINYINT}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{createby,jdbcType=INTEGER}, #{updatedAt,jdbcType=TIMESTAMP}, ",
        "#{updateby,jdbcType=INTEGER})"
    })
    int insert(UserIdentity record);

    @Select({
        "select",
        "uiid, userid, schoolid, campusid, usertype, bind_userid, usestatus, created_at, ",
        "createby, updated_at, updateby",
        "from user_identity",
        "where uiid = #{uiid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="uiid", property="uiid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="usertype", property="usertype", jdbcType=JdbcType.TINYINT),
        @Result(column="bind_userid", property="bindUserid", jdbcType=JdbcType.INTEGER),
        @Result(column="usestatus", property="usestatus", jdbcType=JdbcType.TINYINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER)
    })
    UserIdentity selectByPrimaryKey(Integer uiid);

    @Select({
        "select",
        "uiid, userid, schoolid, campusid, usertype, bind_userid, usestatus, created_at, ",
        "createby, updated_at, updateby",
        "from user_identity"
    })
    @Results({
        @Result(column="uiid", property="uiid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="usertype", property="usertype", jdbcType=JdbcType.TINYINT),
        @Result(column="bind_userid", property="bindUserid", jdbcType=JdbcType.INTEGER),
        @Result(column="usestatus", property="usestatus", jdbcType=JdbcType.TINYINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER)
    })
    List<UserIdentity> selectAll();

    @Update({
        "update user_identity",
        "set userid = #{userid,jdbcType=INTEGER},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "usertype = #{usertype,jdbcType=TINYINT},",
          "bind_userid = #{bindUserid,jdbcType=INTEGER},",
          "usestatus = #{usestatus,jdbcType=TINYINT},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "createby = #{createby,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "updateby = #{updateby,jdbcType=INTEGER}",
        "where uiid = #{uiid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserIdentity record);
}