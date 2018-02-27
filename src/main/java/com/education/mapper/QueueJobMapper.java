package com.education.mapper;

import com.education.domain.QueueJob;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface QueueJobMapper {
    @Delete({
        "delete from queue_job",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into queue_job (id, jobid, ",
        "tupe, status, created_at, ",
        "started_at, ended_at, ",
        "resource_id, data)",
        "values (#{id,jdbcType=INTEGER}, #{jobid,jdbcType=VARCHAR}, ",
        "#{tupe,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, #{createdAt,jdbcType=TIMESTAMP}, ",
        "#{startedAt,jdbcType=TIMESTAMP}, #{endedAt,jdbcType=TIMESTAMP}, ",
        "#{resourceId,jdbcType=INTEGER}, #{data,jdbcType=LONGVARCHAR})"
    })
    int insert(QueueJob record);

    @Select({
        "select",
        "id, jobid, tupe, status, created_at, started_at, ended_at, resource_id, data",
        "from queue_job",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="jobid", property="jobid", jdbcType=JdbcType.VARCHAR),
        @Result(column="tupe", property="tupe", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="started_at", property="startedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ended_at", property="endedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.INTEGER),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARCHAR)
    })
    QueueJob selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, jobid, tupe, status, created_at, started_at, ended_at, resource_id, data",
        "from queue_job"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="jobid", property="jobid", jdbcType=JdbcType.VARCHAR),
        @Result(column="tupe", property="tupe", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="started_at", property="startedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ended_at", property="endedAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.INTEGER),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<QueueJob> selectAll();

    @Update({
        "update queue_job",
        "set jobid = #{jobid,jdbcType=VARCHAR},",
          "tupe = #{tupe,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "started_at = #{startedAt,jdbcType=TIMESTAMP},",
          "ended_at = #{endedAt,jdbcType=TIMESTAMP},",
          "resource_id = #{resourceId,jdbcType=INTEGER},",
          "data = #{data,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QueueJob record);
}