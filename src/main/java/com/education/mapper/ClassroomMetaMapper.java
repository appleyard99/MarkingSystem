package com.education.mapper;

import com.education.domain.ClassroomMeta;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ClassroomMetaMapper {
    @Delete({
        "delete from classroom_meta",
        "where metaid = #{metaid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer metaid);

    @Insert({
        "insert into classroom_meta (metaid, schoolid, ",
        "feature, status)",
        "values (#{metaid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{feature,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT})"
    })
    int insert(ClassroomMeta record);

    @Select({
        "select",
        "metaid, schoolid, feature, status",
        "from classroom_meta",
        "where metaid = #{metaid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="metaid", property="metaid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="feature", property="feature", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    ClassroomMeta selectByPrimaryKey(Integer metaid);

    @Select({
        "select",
        "metaid, schoolid, feature, status",
        "from classroom_meta"
    })
    @Results({
        @Result(column="metaid", property="metaid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="feature", property="feature", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<ClassroomMeta> selectAll();

    @Update({
        "update classroom_meta",
        "set schoolid = #{schoolid,jdbcType=INTEGER},",
          "feature = #{feature,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT}",
        "where metaid = #{metaid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ClassroomMeta record);
}