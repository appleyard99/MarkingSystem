package com.education.mapper;

import com.education.domain.RpcenterScoreRanking;
import com.education.domain.vo.RpcenterSubjectVo;
import com.education.domain.vo.RpcenterSubjectVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RpcenterScoreRankingMapper {
	@Delete({
			"delete from rpcenter_score_ranking",
			"where rpsrid = #{rpsrid,jdbcType=INTEGER}"
	})
	int deleteByPrimaryKey(Integer rpsrid);

	@Insert({
			"insert into rpcenter_score_ranking (rpsrid, rpcid, ",
			"examid, studentid, ",
			"classid, subjectid, ",
			"score, ranking, grade_ranking, ",
			"create_at)",
			"values (#{rpsrid,jdbcType=INTEGER}, #{rpcid,jdbcType=INTEGER}, ",
			"#{examid,jdbcType=INTEGER}, #{studentid,jdbcType=INTEGER}, ",
			"#{classid,jdbcType=INTEGER}, #{subjectid,jdbcType=VARCHAR}, ",
			"#{score,jdbcType=REAL}, #{ranking,jdbcType=SMALLINT}, #{gradeRanking,jdbcType=SMALLINT}, ",
			"#{createAt,jdbcType=TIMESTAMP})"
	})
	int insert(RpcenterScoreRanking record);

	@Select({
			"select",
			"rpsrid, rpcid, examid, studentid, classid, subjectid, score, ranking, grade_ranking, ",
			"create_at",
			"from rpcenter_score_ranking",
			"where rpsrid = #{rpsrid,jdbcType=INTEGER}"
	})
	@Results({
			@Result(column = "rpsrid", property = "rpsrid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "rpcid", property = "rpcid", jdbcType = JdbcType.INTEGER),
			@Result(column = "examid", property = "examid", jdbcType = JdbcType.INTEGER),
			@Result(column = "studentid", property = "studentid", jdbcType = JdbcType.INTEGER),
			@Result(column = "classid", property = "classid", jdbcType = JdbcType.INTEGER),
			@Result(column = "subjectid", property = "subjectid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "score", property = "score", jdbcType = JdbcType.REAL),
			@Result(column = "ranking", property = "ranking", jdbcType = JdbcType.SMALLINT),
			@Result(column = "grade_ranking", property = "gradeRanking", jdbcType = JdbcType.SMALLINT),
			@Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP)
	})
	RpcenterScoreRanking selectByPrimaryKey(Integer rpsrid);

	@Select({
			"select",
			"rpsrid, rpcid, examid, studentid, classid, subjectid, score, ranking, grade_ranking, ",
			"create_at",
			"from rpcenter_score_ranking"
	})
	@Results({
			@Result(column = "rpsrid", property = "rpsrid", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "rpcid", property = "rpcid", jdbcType = JdbcType.INTEGER),
			@Result(column = "examid", property = "examid", jdbcType = JdbcType.INTEGER),
			@Result(column = "studentid", property = "studentid", jdbcType = JdbcType.INTEGER),
			@Result(column = "classid", property = "classid", jdbcType = JdbcType.INTEGER),
			@Result(column = "subjectid", property = "subjectid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "score", property = "score", jdbcType = JdbcType.REAL),
			@Result(column = "ranking", property = "ranking", jdbcType = JdbcType.SMALLINT),
			@Result(column = "grade_ranking", property = "gradeRanking", jdbcType = JdbcType.SMALLINT),
			@Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP)
	})
	List<RpcenterScoreRanking> selectAll();

	@Update({
			"update rpcenter_score_ranking",
			"set rpcid = #{rpcid,jdbcType=INTEGER},",
			"examid = #{examid,jdbcType=INTEGER},",
			"studentid = #{studentid,jdbcType=INTEGER},",
			"classid = #{classid,jdbcType=INTEGER},",
			"subjectid = #{subjectid,jdbcType=VARCHAR},",
			"score = #{score,jdbcType=REAL},",
			"ranking = #{ranking,jdbcType=SMALLINT},",
			"grade_ranking = #{gradeRanking,jdbcType=SMALLINT},",
			"create_at = #{createAt,jdbcType=TIMESTAMP}",
			"where rpsrid = #{rpsrid,jdbcType=INTEGER}"
	})
	int updateByPrimaryKey(RpcenterScoreRanking record);

	/**
	 * @Description: 获取满足条件的科目数据集合
	 * @author YangShuan
	 * @date 2018/2/5 9:52
	 */
	@Select({
			"<script> ",
			"select",
			"  a.subjectid,a.examid,classid, b.`subject` ",
			" from rpcenter_score_ranking a LEFT JOIN school_subject b ON a.subjectid = b.subjectid ",
			" where  ",
			" rpcid=#{arg0,jdbcType=INTEGER} ",

			"<choose>",
			"<when test=\" arg1=='all' \">",
			"and a.subjectid!=\"ysw\"",
			"</when>",
			"<when test=\" arg1=='ysw' \">",
			"and a.subjectid!=\"all\"",
			"</when>",
			"<otherwise>",
			"and a.subjectid=#{arg1,jdbcType=VARCHAR}",
			"</otherwise>",
			"</choose>",

			"<if test=\" arg2!='all' \">",
			"and classid=#{arg2, jdbcType=INTEGER}",
			"</if>",

			" GROUP BY a.subjectid ",
			"</script> "
	})
	List<RpcenterSubjectVo> getSubject(Integer rpcid, String subjectId, String classid);

	/**
	 * @Description: 获取满足条件的学生数据集合 score >0
	 * @author YangShuan
	 * @date 2018/2/6
	 */
	@Select({
			"<script> ",
			"select",
			"  studentid,score,grade_ranking as gradeRanking",
			" from rpcenter_score_ranking   ",
			" where  ",
			" rpcid=#{arg0,jdbcType=INTEGER} ",
			" and subjectid=#{arg1,jdbcType=VARCHAR} ",
			" and  score >0 ",
			"<if test=\" arg2!='all' \">",
			" and classid=#{arg2, jdbcType=INTEGER}",
			"</if>",
			" GROUP BY studentid ",
			//" ORDER BY #{arg3,jdbcType=INTEGER} ",
			" ORDER BY score DESC ",
			"</script> "
	})
	List<RpcenterScoreRanking> getStu(Integer rpcid, String subjectId, String classid, String orderBy);

	/**
	 * @Description: 获取满足条件的学生数据集合 score =0
	 * @author YangShuan
	 * @date 2018/2/6
	 */
	@Select({
			"<script> ",
			"select",
			"  studentid,score,grade_ranking as gradeRanking ",
			" from rpcenter_score_ranking   ",
			" where  ",
			" rpcid=#{arg0,jdbcType=INTEGER} ",
			" and subjectid=#{arg1,jdbcType=VARCHAR} ",
			" and  score =0 ",
			"<if test=\" arg2!='all' \">",
			" and classid=#{arg2, jdbcType=INTEGER}",
			"</if>",
			" GROUP BY studentid ",
			//" ORDER BY #{arg3,jdbcType=INTEGER} ",
			" ORDER BY score DESC ",
			"</script> "
	})
	List<RpcenterScoreRanking> getStu2(Integer rpcid, String subjectId, String classid, String orderBy);


	/**
	 * @Description: 返回 学生-科目-的维度集合数据.（分数、班级名次、年级名次）
	 * @author YangShuan
	 * @date 2018/2/6
	 */
	@Select({
			"<script> ",
			"select",
			" studentid,classid,subjectid,score,ranking,grade_ranking as gradeRanking ",
			" from rpcenter_score_ranking   ",
			" where  ",
			" rpcid=#{arg0,jdbcType=INTEGER} ",

			"<choose>",
			"<when test=\" arg1=='all' \">",
			"and subjectid!=\"ysw\"",
			"</when>",
			"<when test=\" arg1=='ysw' \">",
			"and subjectid!=\"all\"",
			"</when>",
			"<otherwise>",
			"and subjectid=#{arg1,jdbcType=VARCHAR}",
			"</otherwise>",
			"</choose>",

			"<if test=\" arg2!='all' \">",
			"and classid=#{arg2, jdbcType=INTEGER}",
			"</if>",
			" GROUP BY studentid,subjectid ",
			"</script> "
	})
	List<RpcenterScoreRanking> getStuSubjectRelation(Integer rpcid, String subjectId, String classid);

}