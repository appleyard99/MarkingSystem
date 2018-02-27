package com.education.mapper;

import com.education.domain.Favorite;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import com.education.domain.vo.FavoriteVo;

@Component
public interface FavoriteMapper {
    @Delete({
        "delete from favorite",
        "where favoriteid = #{favoriteid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer favoriteid);

    @Insert({
        "insert into favorite (favoriteid, userid, ",
        "favtype, tagid, ",
        "itemid, subjectid, ",
        "created_at, status)",
        "values (#{favoriteid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{favtype,jdbcType=TINYINT}, #{tagid,jdbcType=INTEGER}, ",
        "#{itemid,jdbcType=INTEGER}, #{subjectid,jdbcType=INTEGER}, ",
        "#{createdAt,jdbcType=TIMESTAMP}, #{status,jdbcType=BIT})"
    })
    int insert(Favorite record);

    @Select({
        "select",
        "favoriteid, userid, favtype, tagid, itemid, subjectid, created_at, status",
        "from favorite",
        "where favoriteid = #{favoriteid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="favoriteid", property="favoriteid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="favtype", property="favtype", jdbcType=JdbcType.TINYINT),
        @Result(column="tagid", property="tagid", jdbcType=JdbcType.INTEGER),
        @Result(column="itemid", property="itemid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    Favorite selectByPrimaryKey(Integer favoriteid);

    @Select({
        "select",
        "favoriteid, userid, favtype, tagid, itemid, subjectid, created_at, status",
        "from favorite"
    })
    @Results({
        @Result(column="favoriteid", property="favoriteid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="favtype", property="favtype", jdbcType=JdbcType.TINYINT),
        @Result(column="tagid", property="tagid", jdbcType=JdbcType.INTEGER),
        @Result(column="itemid", property="itemid", jdbcType=JdbcType.INTEGER),
        @Result(column="subjectid", property="subjectid", jdbcType=JdbcType.INTEGER),
        @Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Favorite> selectAll();

    @Update({
        "update favorite",
        "set userid = #{userid,jdbcType=INTEGER},",
          "favtype = #{favtype,jdbcType=TINYINT},",
          "tagid = #{tagid,jdbcType=INTEGER},",
          "itemid = #{itemid,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "created_at = #{createdAt,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIT}",
        "where favoriteid = #{favoriteid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Favorite record);

    /**
     * @Description: 获取教师对应科目收藏的题目
     * @author mgg
     * @date 2018/2/6
     */
    @Select({
            "<script>",
            "SELECT ",
            "f.`itemid`,f.`tagid`,q.`questionbankid`,q.`schoolid`,q.`body`,q.`type`,q.`analysis`,q.`usecount`,q.`subjectid`",
            "FROM favorite f",
            "JOIN questionbank q",
            "ON q.questionbankid=f.itemid",
            "WHERE f.`userid`=#{userId,jdbcType=INTEGER}",
            "AND f.`subjectid`=#{subjectId,jdbcType=INTEGER}",
            "AND f.`favtype`=1",
            "AND f.`status`=1",
            "<if test=\"tagId!=0\">f.`tagid`=#{tagId, jdbcType=INTEGER}</if>",
            "ORDER BY f.created_at desc",
            "LIMIT #{page, jdbcType=INTEGER},#{pageLine, jdbcType=INTEGER}",
            "</script>"
    })
    List<FavoriteVo> findAllFavorites(@Param("userId") Integer userId, @Param("subjectId") Integer subjectId, @Param("page") Integer page, @Param("pageLine") Integer pageLine, @Param("tagId") Integer tagId);


}