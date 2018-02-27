package com.education.mapper;

import com.education.domain.AclObjResource;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AclObjResourceMapper {
    @Delete({
        "delete from acl_obj_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into acl_obj_resource (id, role_id, ",
        "group_id, resource_id)",
        "values (#{id,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
        "#{groupId,jdbcType=INTEGER}, #{resourceId,jdbcType=INTEGER})"
    })
    int insert(AclObjResource record);

    @Select({
        "select",
        "id, role_id, group_id, resource_id",
        "from acl_obj_resource",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.INTEGER)
    })
    AclObjResource selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, role_id, group_id, resource_id",
        "from acl_obj_resource"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.INTEGER)
    })
    List<AclObjResource> selectAll();

    @Update({
        "update acl_obj_resource",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "group_id = #{groupId,jdbcType=INTEGER},",
          "resource_id = #{resourceId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AclObjResource record);
}