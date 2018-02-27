package com.education.mapper;

import com.education.domain.Classinfo;
import com.education.domain.StudentClass;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
public interface StudentClassMapper {
    @Delete({
        "delete from student_class",
        "where scid = #{scid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer scid);

    @Insert({
        "insert into student_class (scid, studentid, ",
        "classid, termid, ",
        "gradeid, schoolid, ",
        "campusid, status)",
        "values (#{scid,jdbcType=INTEGER}, #{studentid,jdbcType=INTEGER}, ",
        "#{classid,jdbcType=INTEGER}, #{termid,jdbcType=INTEGER}, ",
        "#{gradeid,jdbcType=INTEGER}, #{schoolid,jdbcType=INTEGER}, ",
        "#{campusid,jdbcType=INTEGER}, #{status,jdbcType=BIT})"
    })
    int insert(StudentClass record);

    @Select({
        "select",
        "scid, studentid, classid, termid, gradeid, schoolid, campusid, status",
        "from student_class",
        "where scid = #{scid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="scid", property="scid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    StudentClass selectByPrimaryKey(Integer scid);

    @Select({
        "select",
        "scid, studentid, classid, termid, gradeid, schoolid, campusid, status",
        "from student_class"
    })
    @Results({
        @Result(column="scid", property="scid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="studentid", property="studentid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="termid", property="termid", jdbcType=JdbcType.INTEGER),
        @Result(column="gradeid", property="gradeid", jdbcType=JdbcType.INTEGER),
        @Result(column="schoolid", property="schoolid", jdbcType=JdbcType.INTEGER),
        @Result(column="campusid", property="campusid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<StudentClass> selectAll();

    @Update({
        "update student_class",
        "set studentid = #{studentid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "termid = #{termid,jdbcType=INTEGER},",
          "gradeid = #{gradeid,jdbcType=INTEGER},",
          "schoolid = #{schoolid,jdbcType=INTEGER},",
          "campusid = #{campusid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=BIT}",
        "where scid = #{scid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentClass record);

    /**
     *@Description: 获取班级人数
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT count(1)",
        "FROM student_class",
        "WHERE classid = #{classid, jdbcType=INTEGER}",
        "AND termid = #{termid, jdbcType=INTEGER} and status = 1"
    })
    Integer getStuNum(@Param("classid") Integer classid, @Param("termid") Integer termid);

    /**
     *@Description: 根据学生id,获取学生班级信息
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Select({
        "SELECT	a.classid,	b.classname",
        "FROM	student_class a",
        "LEFT JOIN classinfo b ON a.classid = b.classid",
        "WHERE	a.studentid = #{studentid, jdbcType=INTEGER}"
    })
    List<Classinfo> getStuClassInfo(Integer studentid);
}