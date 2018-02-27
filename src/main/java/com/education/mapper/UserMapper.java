package com.education.mapper;

import com.education.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    @Delete({
        "delete from user",
        "where userid = #{userid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userid);

    @Insert({
        "insert into user (userid, usercode, ",
        "password, username, ",
        "category, status, ",
        "gender, birthday, tel, ",
        "cardno, loginname, ",
        "email, photo, remark, ",
        "created_at, createby, ",
        "updated_at, updateby)",
        "values (#{userid,jdbcType=INTEGER}, #{usercode,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, ",
        "#{gender,jdbcType=TINYINT}, #{birthday,jdbcType=DATE}, #{tel,jdbcType=VARCHAR}, ",
        "#{cardno,jdbcType=VARCHAR}, #{loginname,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{photo,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{createby,jdbcType=INTEGER}, ",
        "#{updatedAt,jdbcType=TIMESTAMP}, #{updateby,jdbcType=INTEGER})"
    })
    int insert(User record);

    @Select({
        "select",
        "userid, usercode, password, username, category, status, gender, birthday, tel, ",
        "cardno, loginname, email, photo, remark, created_at, createby, updated_at, updateby",
        "from user",
        "where userid = #{userid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="usercode", property="usercode", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="gender", property="gender", jdbcType=JdbcType.TINYINT),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="cardno", property="cardno", jdbcType=JdbcType.VARCHAR),
        @Result(column="loginname", property="loginname", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER)
    })
    User selectByPrimaryKey(Integer userid);

    @Select({
        "select",
        "userid, usercode, password, username, category, status, gender, birthday, tel, ",
        "cardno, loginname, email, photo, remark, created_at, createby, updated_at, updateby",
        "from user"
    })
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="usercode", property="usercode", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="gender", property="gender", jdbcType=JdbcType.TINYINT),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="cardno", property="cardno", jdbcType=JdbcType.VARCHAR),
        @Result(column="loginname", property="loginname", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo", property="photo", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createby", property="createby", jdbcType=JdbcType.INTEGER),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateby", property="updateby", jdbcType=JdbcType.INTEGER)
    })
    List<User> selectAll();

    @Update({
        "update user",
        "set usercode = #{usercode,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "category = #{category,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "gender = #{gender,jdbcType=TINYINT},",
          "birthday = #{birthday,jdbcType=DATE},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "cardno = #{cardno,jdbcType=VARCHAR},",
          "loginname = #{loginname,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "photo = #{photo,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "createby = #{createby,jdbcType=INTEGER},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "updateby = #{updateby,jdbcType=INTEGER}",
        "where userid = #{userid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    /**
     *@Description: 获取学生姓名学号
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT `username`,`usercode`",
        "FROM `user`",
        "WHERE userid = #{studentid, jdbcType=INTEGER} and `status` = 1 limit 1"
    })
    User selectByPKAndStatus(Integer studentid);
}