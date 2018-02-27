package com.education.mapper;

import com.education.domain.AclPermission;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface AclPermissionMapper {
    @Delete({
        "delete from acl_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into acl_permission (id, identification, ",
        "id_name, type, description, ",
        "created_at, updated_at, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{identification,jdbcType=VARCHAR}, ",
        "#{idName,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{updatedAt,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=BIT})"
    })
    int insert(AclPermission record);

    @Select({
        "select",
        "id, identification, id_name, type, description, created_at, updated_at, status",
        "from acl_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="identification", property="identification", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_name", property="idName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    AclPermission selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, identification, id_name, type, description, created_at, updated_at, status",
        "from acl_permission"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="identification", property="identification", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_name", property="idName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<AclPermission> selectAll();

    @Update({
        "update acl_permission",
        "set identification = #{identification,jdbcType=VARCHAR},",
          "id_name = #{idName,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "updated_at = #{updatedAt,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AclPermission record);
}