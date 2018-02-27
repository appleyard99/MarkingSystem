package com.education.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import com.education.domain.QbKnowledge;
import com.education.domain.vo.QbKnowledgeVo;

@Component
public interface QbKnowledgeMapper {
    @Delete({
        "delete from qb_knowledge",
        "where question_know_id = #{questionKnowId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer questionKnowId);

    @Insert({
        "insert into qb_knowledge (question_know_id, questionbankid, ",
        "knowid, kiid, status)",
        "values (#{questionKnowId,jdbcType=INTEGER}, #{questionbankid,jdbcType=INTEGER}, ",
        "#{knowid,jdbcType=INTEGER}, #{kiid,jdbcType=INTEGER}, #{status,jdbcType=TINYINT})"
    })
    int insert(QbKnowledge record);

    @Select({
        "select",
        "question_know_id, questionbankid, knowid, kiid, status",
        "from qb_knowledge",
        "where question_know_id = #{questionKnowId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="question_know_id", property="questionKnowId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="knowid", property="knowid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    QbKnowledge selectByPrimaryKey(Integer questionKnowId);

    @Select({
        "select",
        "question_know_id, questionbankid, knowid, kiid, status",
        "from qb_knowledge"
    })
    @Results({
        @Result(column="question_know_id", property="questionKnowId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="questionbankid", property="questionbankid", jdbcType=JdbcType.INTEGER),
        @Result(column="knowid", property="knowid", jdbcType=JdbcType.INTEGER),
        @Result(column="kiid", property="kiid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<QbKnowledge> selectAll();

    @Update({
        "update qb_knowledge",
        "set questionbankid = #{questionbankid,jdbcType=INTEGER},",
          "knowid = #{knowid,jdbcType=INTEGER},",
          "kiid = #{kiid,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT}",
        "where question_know_id = #{questionKnowId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QbKnowledge record);

    /**
     * @Description: 获取某些题目知识点信息;
     * @author mgg
     * @date 2018/2/27
     */
    @Select({
            "<script>",
            "select ",
            "q.`questionbankid`,k.`kiid`,k.`knowname` from qb_knowledge q",
            "join knowledge_item k ",
            " on  k.`kiid`=q.`kiid`",
            "where q.questionbankid in ",
            "<foreach collection=\"list1\" index=\"index\" item=\"item\" open=\"(\" separator=\",\" close=\")\">",
            "#{item,jdbcType=INTEGER}",
            "</foreach>",
            "and k.status=1",
            "</script>"

    })
    List<QbKnowledgeVo> selectSome(@Param("list1")  List<Integer> list1);


}
