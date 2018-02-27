package com.education.mapper;

import com.education.domain.AclResource;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AclResourceMapper {
    @Delete({
        "delete from acl_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into acl_resource (id, controller, ",
        "ctl_title, action, ",
        "act_title, element, ",
        "type, created_at, ",
        "updated_at, status)",
        "values (#{id,jdbcType=INTEGER}, #{controller,jdbcType=VARCHAR}, ",
        "#{ctlTitle,jdbcType=VARCHAR}, #{action,jdbcType=VARCHAR}, ",
        "#{actTitle,jdbcType=VARCHAR}, #{element,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=TINYINT}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{updatedAt,jdbcType=TIMESTAMP}, #{status,jdbcType=BIT})"
    })
    int insert(AclResource record);

    @Select({
        "select",
        "id, controller, ctl_title, action, act_title, element, type, created_at, updated_at, ",
        "status",
        "from acl_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="controller", property="controller", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctl_title", property="ctlTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_title", property="actTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="element", property="element", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    AclResource selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, controller, ctl_title, action, act_title, element, type, created_at, updated_at, ",
        "status",
        "from acl_resource"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="controller", property="controller", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctl_title", property="ctlTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="act_title", property="actTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="element", property="element", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<AclResource> selectAll();

    @Update({
        "update acl_resource",
        "set controller = #{controller,jdbcType=VARCHAR},",
          "ctl_title = #{ctlTitle,jdbcType=VARCHAR},",
          "action = #{action,jdbcType=VARCHAR},",
          "act_title = #{actTitle,jdbcType=VARCHAR},",
          "element = #{element,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=TINYINT},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AclResource record);
}