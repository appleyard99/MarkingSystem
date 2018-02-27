package com.education.mapper;

import com.education.domain.ReportExamKnowledge;
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
public interface ReportExamKnowledgeMapper {
    @Delete({
        "delete from report_exam_knowledge",
        "where reknid = #{reknid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer reknid);

    @Insert({
        "insert into report_exam_knowledge (reknid, examid, ",
        "kiid, classid, classname, ",
        "average, created_at)",
        "values (#{reknid,jdbcType=INTEGER}, #{examid,jdbcType=INTEGER}, ",
        "#{kiid,jdbcType=INTEGER}, #{classid,jdbcType=INTEGER}, #{classname,jdbcType=VARCHAR}, ",
        "#{average,jdbcType=REAL}, #{createdAt,jdbcType=TIMESTAMP})"
    })
    int insert(ReportExamKnowledge record);

    @Select({
        "select",
        "reknid, examid, kiid, classid, classname, average, created_at",
        "from report_exam_knowledge",
        "where reknid = #{reknid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="reknid", property="reknid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="classname", property="classname", jdbcType=JdbcType.VARCHAR),
        @Result(column="average", property="average", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    ReportExamKnowledge selectByPrimaryKey(Integer reknid);

    @Select({
        "select",
        "reknid, examid, kiid, classid, classname, average, created_at",
        "from report_exam_knowledge"
    })
    @Results({
        @Result(column="reknid", property="reknid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="examid", property="examid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="classid", property="classid", jdbcType=JdbcType.INTEGER),
        @Result(column="classname", property="classname", jdbcType=JdbcType.VARCHAR),
        @Result(column="average", property="average", jdbcType=JdbcType.REAL),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ReportExamKnowledge> selectAll();

    @Update({
        "update report_exam_knowledge",
        "set examid = #{examid,jdbcType=INTEGER},",
          "kiid = #{kiid,jdbcType=INTEGER},",
          "classid = #{classid,jdbcType=INTEGER},",
          "classname = #{classname,jdbcType=VARCHAR},",
          "average = #{average,jdbcType=REAL},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP}",
        "where reknid = #{reknid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReportExamKnowledge record);

    /**
     *@Description: 根据"试卷编号"获取知识点-班级-平均分信息
     *@author Lvxianya
     *@date 2018/2/6
     */
    @Select({
        "SELECT `kiid`, `classid`, `average`",
        "FROM `report_exam_knowledge`",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "GROUP BY kiid, classid"
    })
    List<ReportExamKnowledge> getKiidScore(Integer examid);

    /**
     *@Description: 根据"试卷编号"获取"知识点编号"集合
     *@author Lvxianya
     *@date 2018/2/6
     */
    @Select({
        "SELECT `kiid`",
        "FROM `report_exam_knowledge`",
        "WHERE examid = #{examid, jdbcType=INTEGER}",
        "GROUP BY kiid"
    })
    List<Integer> getKiidInfo(Integer examid);
}