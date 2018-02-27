package com.education.mapper;

import com.education.domain.AclRolePermission;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AclRolePermissionMapper {
    @Delete({
        "delete from acl_role_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into acl_role_permission (id, role_id, ",
        "group_id, permission_id, ",
        "priority, rule)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{groupId,jdbcType=INTEGER}, #{permissionId,jdbcType=INTEGER}, ",
        "#{priority,jdbcType=TINYINT}, #{rule,jdbcType=LONGVARCHAR})"
    })
    int insert(AclRolePermission record);

    @Select({
        "select",
        "id, role_id, group_id, permission_id, priority, rule",
        "from acl_role_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER),
        @Result(column="priority", property="priority", jdbcType=JdbcType.TINYINT),
        @Result(column="rule", property="rule", jdbcType=JdbcType.LONGVARCHAR)
    })
    AclRolePermission selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, role_id, group_id, permission_id, priority, rule",
        "from acl_role_permission"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.INTEGER),
        @Result(column="priority", property="priority", jdbcType=JdbcType.TINYINT),
        @Result(column="rule", property="rule", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<AclRolePermission> selectAll();

    @Update({
        "update acl_role_permission",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "group_id = #{groupId,jdbcType=INTEGER},",
          "permission_id = #{permissionId,jdbcType=INTEGER},",
          "priority = #{priority,jdbcType=TINYINT},",
          "rule = #{rule,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AclRolePermission record);
}