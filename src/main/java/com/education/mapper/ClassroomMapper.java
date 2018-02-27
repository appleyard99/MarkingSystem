package com.education.mapper;

import com.education.domain.Classroom;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ClassroomMapper {
    @Delete({
        "delete from classroom",
        "where roomid = #{roomid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer roomid);

    @Insert({
        "insert into classroom (roomid, room, ",
        "capacity, metaid, ",
        "schoolid, campusid, ",
        "buildingid, status)",
        "values (#{roomid,jdbcType=INTEGER}, #{room,jdbcType=VARCHAR}, ",
        "#{capacity,jdbcType=INTEGER}, #{metaid,jdbcType=INTEGER}, ",
        "#{schoolid,jdbcType=INTEGER}, #{campusid,jdbcType=INTEGER}, ",
        "#{buildingid,jdbcType=INTEGER}, #{status,jdbcType=TINYINT})"
    })
    int insert(Classroom record);

    @Select({
        "select",
        "roomid, room, capacity, metaid, schoolid, campusid, buildingid, status",
        "from classroom",
        "where roomid = #{roomid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
        @Result(column="capacity", property="capacity", jdbcType=JdbcType.INTEGER),
        @Result(column="metaid", property="metaid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="buildingid", property="buildingid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Classroom selectByPrimaryKey(Integer roomid);

    @Select({
        "select",
        "roomid, room, capacity, metaid, schoolid, campusid, buildingid, status",
        "from classroom"
    })
    @Results({
        @Result(column="roomid", property="roomid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="room", property="room", jdbcType=JdbcType.VARCHAR),
        @Result(column="capacity", property="capacity", jdbcType=JdbcType.INTEGER),
        @Result(column="metaid", property="metaid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="buildingid", property="buildingid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Classroom> selectAll();

    @Update({
        "update classroom",
        "set room = #{room,jdbcType=VARCHAR},",
          "capacity = #{capacity,jdbcType=INTEGER},",
          "metaid = #{metaid,jdbcType=INTEGER},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "buildingid = #{buildingid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where roomid = #{roomid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Classroom record);
}