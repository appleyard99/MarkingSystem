package com.education.mapper;

import com.education.domain.Building;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BuildingMapper {
    @Delete({
        "delete from building",
        "where buildingid = #{buildingid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer buildingid);

    @Insert({
        "insert into building (buildingid, buildingname, ",
        "campusid, status)",
        "values (#{buildingid,jdbcType=INTEGER}, #{buildingname,jdbcType=VARCHAR}, ",
        "#{campusid,jdbcType=INTEGER}, #{status,jdbcType=TINYINT})"
    })
    int insert(Building record);

    @Select({
        "select",
        "buildingid, buildingname, campusid, status",
        "from building",
        "where buildingid = #{buildingid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="buildingid", property="buildingid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="buildingname", property="buildingname", jdbcType=JdbcType.VARCHAR),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    Building selectByPrimaryKey(Integer buildingid);

    @Select({
        "select",
        "buildingid, buildingname, campusid, status",
        "from building"
    })
    @Results({
        @Result(column="buildingid", property="buildingid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="buildingname", property="buildingname", jdbcType=JdbcType.VARCHAR),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<Building> selectAll();

    @Update({
        "update building",
        "set buildingname = #{buildingname,jdbcType=VARCHAR},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where buildingid = #{buildingid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Building record);
}