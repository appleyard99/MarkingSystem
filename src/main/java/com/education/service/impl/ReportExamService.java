package com.education.service.impl;

import com.education.config.ExamResultConfigs;
import com.education.domain.*;
import com.education.domain.vo.ExamQuestionVo;
import com.education.domain.vo.ExamResultVo;
import com.education.domain.vo.ReportExamVo;
import com.education.domain.vo.RpcenterClassVo;
import com.education.mapper.*;
import com.education.service.IReportExamService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 成绩报表仓库相关
 *
 * @author Lvxianya
 * @create 2018/2/2
 */
@Service
@Transactional
public class ReportExamService implements IReportExamService {

    @Autowired
    private StudentClassMapper studentClassMapper;

    @Autowired
    private ExamStudentMapper examStudentMapper;

    @Autowired
    private ExamQuestionMapper examQuestionMapper;

    @Autowired
    private ReportExamSummaryMapper reportExamSummaryMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReportExamBigquesMapper reportExamBigquesMapper;

    @Autowired
    private ExamMapper examMapper;

    //数据表配置信息
    @Autowired
    private ExamResultConfigs examResultConfigs;

    @Autowired
    private ExamResultMapper examResultMapper;

    @Autowired
    private ReportExamSegmentMapper reportExamSegmentMapper;

    @Autowired
    private WrongQuestionMapper wrongQuestionMapper;

    @Autowired
    private ReportExamQuestionMapper reportExamQuestionMapper;

    @Autowired
    private ExamClassMapper examClassMapper;

    @Autowired
    private ReportExamKnowledgeMapper reportExamKnowledgeMapper;

    @Autowired
    private KnowledgeClassMapper knowledgeClassMapper;

    @Autowired
    private KnowledgeGradeMapper knowledgeGradeMapper;

    @Autowired
    private KnowledgeItemMapper knowledgeItemMapper;

    @Autowired
    private QuestionbankGradeMapper questionbankGradeMapper;

    @Autowired
    private QuestionbankClassMapper questionbankClassMapper;
    
    /**
     *@Description: 获取"学情表格"数据.
     *@author Lvxianya
     *@date 2018/2/2 
     */
    @Override
    public Map<String, Object> getSummaryList(Integer classid, Integer examid, Integer termid) {
        Map<String, Object> dataMap = null;
        //获取班级人数
        Integer stuNum = studentClassMapper.getStuNum(classid, termid);
        if(stuNum <= 0) {
            return dataMap;
        }

        dataMap = new HashMap<String, Object>();
        dataMap.put("stuNum", stuNum);

        //获取学生得分，名次信息
        List<ReportExamVo> stuInfoList = examStudentMapper.getStuExamInfo(classid, examid);

        //获取 "学情表格"数据 标题部分.
        List<ExamQuestionVo> titleList = examQuestionMapper.getQuesTitleRelation(examid);
        List<String> titleStrList = new ArrayList<String>();

        titleStrList.add("姓名");
        titleStrList.add("学号");
        titleStrList.add("成绩");
        titleStrList.add("名次");
        if(titleList != null) {
            for (ExamQuestionVo examQuestion : titleList) {
                titleStrList.add(examQuestion.getQstitle() + "(总分:" + examQuestion.getScore() + ")");
            }
        }

        dataMap.put("headerCell", titleStrList);

        if(stuInfoList != null) {
            //获取学生大题作答信息
            List<ExamQuestionVo> stuQuesDetailList = reportExamSummaryMapper.getStuQsgroupRelation(examid, classid);
            //封装学生大题答题分数信息{"studentid":"分数1，分数2"...}
            Map<Integer, List<Float>> stuQuesDetailMap = new HashMap<Integer, List<Float>>(0);
            if(stuQuesDetailList != null) {
                for (ExamQuestionVo examQuestion : stuQuesDetailList) {
                    Integer key = examQuestion.getStudentid();

                    if(!stuQuesDetailMap.containsKey(key)) {
                        List<Float> scoreList = new ArrayList<Float>();
                        scoreList.add(examQuestion.getScore());
                        stuQuesDetailMap.put(key, scoreList);
                    }else {
                        List<Float> scoreList = stuQuesDetailMap.get(key);
                        scoreList.add(examQuestion.getScore());
                        stuQuesDetailMap.put(key, scoreList);
                    }
                }
            }

            //封装完整result数据
            for (ReportExamVo reportExam : stuInfoList) {
                /*获取学生姓名学号*/
                User user = userMapper.selectByPKAndStatus(reportExam.getStudentid());
                if(user != null) {
                    reportExam.setUsername(user.getUsername());
                    reportExam.setUsercode(user.getUsercode());
                }

                //判断试卷状态
                if(reportExam.getStatus() <= 1) {
                    reportExam.setScore(-1f);
                    reportExam.setScoreList(null);
                }else {
                    reportExam.setScoreList(stuQuesDetailMap.get(reportExam.getStudentid()));
                }
            }
        }

        dataMap.put("result", stuInfoList);
        return dataMap;
    }

    /**
     *@Description: 获取年级大题、小题均分对比数据;年级平均分由计算得出
     *@author liuyizheng
     *@date 2018/2/5 10:42
     */
    @Override
    public Map<String, Object> getQuestion(Integer examid, Integer classid,Integer tp) {

        HashMap<String, Object> datamap = new HashMap<>();
        ArrayList<Object> resultList = new ArrayList<>();
        Float qsgroupAverageSum = 0.00f;    //每道题年级平均分的总和

        Float gradeScore = examStudentMapper.getZScore(examid);  //获取年级大题总分
        Integer gradeNum = examStudentMapper.getZNum(examid);    //获取年级作答人数

        //试卷班级情况
        List<ExamClass> classList = examClassMapper.getExamClass(examid);
        List<String> titleStrList = new ArrayList<String>();
        titleStrList.add("题号");
        titleStrList.add("年级平均分");
        //获取表格标题部分
        if (classList != null){
            for (ExamClass examClass: classList) {
                titleStrList.add(examClass.getClassname());
            }
        }

        if (tp == 1) {
            // 获取试卷大题及其名称.
            List<ExamQuestionVo> quesTitleList = examQuestionMapper.getQuesTitleRelation(examid);

            if(quesTitleList != null){
                for (int j=0; j<=quesTitleList.size(); j++) {   //  9
                    HashMap<String, Object> resultMap = new HashMap<>();
                    ArrayList<Object> scoreList = new ArrayList<>();

                    if(j == quesTitleList.size()){  //获取总平均分集合

                        //---计算每班大题平均分---
                        Float classScoreSum = 0.00f;   //班级总分
                        Exam exam = examMapper.selectByPrimaryKey(examid);
                        String tableName = getSource(exam);
                        Float bigQuestionAvg = 0.00f;    //班级大题平均分
                        //获取（班级）大题--分数对应关系
                        for(int i=0; i<classList.size(); i++){
                            List<ExamResultVo> examResultVOList = examResultMapper.getQsgroupScoreRelation(classList.get(i).getClassid(), examid, tableName);
                            //获取班级作答人数
                            int classStuNum = examStudentMapper.getclassStuNum(examid, classList.get(i).getClassid());

                            if (examResultVOList != null){
                                for (ExamResultVo examResultVO:examResultVOList ) {
                                    //班级总分
                                    float classZscore = examResultVO.getZscore();
                                    classScoreSum += classZscore;

                                }
                                //班级平均分
                                float big = classScoreSum / classStuNum;
                                BigDecimal b   =   new   BigDecimal(big);
                                bigQuestionAvg   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).floatValue();
                                scoreList.add(bigQuestionAvg);
                                classScoreSum = 0.00f;
                            }
                        }

                        //年级总平均分
                        float gradeAverage = gradeScore / gradeNum;
//                    float gradeAverage=(float)(Math.round(g*100)/100);   //年级总平均分。保留两位小数

                        resultMap.put("qstitle","总平均");
                        resultMap.put("scoreList",scoreList);
                        resultMap.put("gradeAverage",gradeAverage);

                        resultList.add(resultMap);

                    }else{
                        for (int i=0; i<classList.size(); i++){    //  6
                            //获取题目组、班级-及平均分(大题)
                            List<ReportExamQuestion> reportExamQuestionList = reportExamQuestionMapper.getQsgroupScoreRelation(classList.get(i).getClassid(),examid);
                            if(reportExamQuestionList != null){
                                scoreList.add(reportExamQuestionList.get(j).getAverage());  //从数据库取出每班平均分
                                float value = reportExamQuestionList.get(j).getAverage();
//                                float value = (float)(Math.round(v*100)/100);   //保留小数点后两位
                                qsgroupAverageSum += value;
//                            System.out.println(value);
                            }

                        }
                        //年级大题平均分
                        int classNum = classList.size();
                        float q = qsgroupAverageSum /classNum;
//                        float qsgroupAverage = (float)(Math.round(q*100)/100);
                        BigDecimal b   =   new   BigDecimal(q);
                        float   qsgroupAverage   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).floatValue();

                        resultMap.put("qstitle",j+1);
                        resultMap.put("scoreList",scoreList);
                        resultMap.put("gradeAverage",qsgroupAverage);

                        resultList.add(resultMap);

                        qsgroupAverageSum = 0.00f;

                    }
                }
            }
        }

        if (tp == 2){
            List<ExamQuestion> examQuestionList = examQuestionMapper.getQsgroupSeqnoRelation(examid);
            if(examQuestionList != null){
                for (int j=0; j<=examQuestionList.size(); j++) {   //  35
                    HashMap<String, Object> resultMap = new HashMap<>();
                    ArrayList<Object> scoreList = new ArrayList<>();

                    if(j == examQuestionList.size()){  //循环最后一次

                        //---计算每班平均分---
                        Float classScoreSum = 0.00f;   //班级总分
                        Exam exam = examMapper.selectByPrimaryKey(examid);
                        String tableName = getSource(exam);
                        Float questionAvg = 0.00f;    //班级平均分
                        //获取（班级）大题--分数对应关系
                        for(int i=0; i<classList.size(); i++){
                            List<ExamResultVo> examResultVOList = examResultMapper.getQsgroupScoreRelation(classList.get(i).getClassid(), examid, tableName);
                            //获取班级作答人数
                            int classStuNum = examStudentMapper.getclassStuNum(examid, classList.get(i).getClassid());

                            if (examResultVOList != null){
                                for (ExamResultVo examResultVo:examResultVOList ) {
                                    //班级总分
                                    float classZscore = examResultVo.getZscore();
                                    classScoreSum += classZscore;
                                }
                                //班级平均分
                                float big = classScoreSum / classStuNum;
                                BigDecimal b   =   new   BigDecimal(big);
                                questionAvg   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).floatValue();
                                scoreList.add(questionAvg);
                                classScoreSum = 0.00f;
                            }
                        }

                        //年级总平均分
                        float gradeAverage = gradeScore / gradeNum;

                        resultMap.put("qstitle","总平均");
                        resultMap.put("scoreList",scoreList);
                        resultMap.put("gradeAverage",gradeAverage);

                        resultList.add(resultMap);

                    }else{
                        for (int i=0; i<classList.size(); i++){    //  6
                            //获取小题题号、班级、及平均分.
                            List<ReportExamQuestion> reportExamQuestionList = reportExamQuestionMapper.getSmaQueAvg(examid,classList.get(i).getClassid());
                            scoreList.add(reportExamQuestionList.get(j).getAverage());  //从数据库取出每班平均分
                            float value = reportExamQuestionList.get(j).getAverage();
//                                float value = (float)(Math.round(v*100)/100);   //保留小数点后两位
                            qsgroupAverageSum += value;
//                            System.out.println(value);

                        }
                        //年级大题平均分
                        int classNum = classList.size();
                        float q = qsgroupAverageSum /classNum;
//                        float qsgroupAverage = (float)(Math.round(q*100)/100);
                        BigDecimal b   =   new   BigDecimal(q);
                        float   qsgroupAverage   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).floatValue();

                        resultMap.put("qstitle",j+1);
                        resultMap.put("scoreList",scoreList);
                        resultMap.put("gradeAverage",qsgroupAverage);

                        resultList.add(resultMap);

                        qsgroupAverageSum = 0.00f;

                    }
                }
            }

        }

        datamap.put("headerCell",titleStrList);
        datamap.put("result",resultList);

        return datamap;
    }

    /**
     *@Description: "学情表格==>大题作答详情"---展示数据的时候使用.简答题：才有“得分率”概念;
     *@author Lvxianya
     *@date 2018/2/2
     */
    @Override
    public Map<String, Object> getBigQues(Integer examid, Integer classid) {
        Map<String, Object> dataMap = null;

        //获取表格标题部分
        Map<String, Object> summaryTitleMap = getSummaryTitle(examid);
        if(summaryTitleMap == null) {
            return dataMap;
        }
        Integer quesNum = (Integer) summaryTitleMap.get("quesNum");

        //题目组和题型的关系
        Map<String, Object> qtRelationMap = getQsgroupTypeRelation(examid);

        //答案信息
        Map<String, List<Map<String, Object>>> detailsMap = getDetailsByQsgroup(examid, classid);
        if(detailsMap == null) {
            return dataMap;
        }

        List<List<String>> resultLists = new ArrayList<>();
        //封装result数据
        for (int i = 0; i < quesNum; i++) {
            List<String> mergeStrList = new ArrayList<>();
            Iterator<String> it = qtRelationMap.keySet().iterator();
            while(it.hasNext()) {
                String qsgroup = it.next();
                List<String> resultList = dealAnswer(detailsMap, i, qsgroup, (Byte) qtRelationMap.get(qsgroup));
                mergeStrList.addAll(resultList);
            }
            resultLists.add(mergeStrList);
        }

        dataMap = new HashMap<>();
        dataMap.put("maintitle", summaryTitleMap.get("maintitle"));
        dataMap.put("lgqnum", summaryTitleMap.get("lgqnum"));
        dataMap.put("subtitle", summaryTitleMap.get("subtitle"));
        dataMap.put("result", resultLists);
        return dataMap;
    }

    /**
     *@Description: 获取小题作答详情数据.
     *@author Lvxianya
     *@date 2018/2/3
     */
    @Override
    public Map<String, Object> getReplyDetails(Integer examid, Integer classid) {
        Map<String, Object> dataMap = new HashMap<>();

        //获取表格标题部分
        List<String> headerCell = getReplyHeadCell(examid);

        //获取学生id信息
        List<ExamStudent> examStudentList = examStudentMapper.selByExamidAndClassId(examid, classid);

        //获取xx考试所有学生-小题得分情况
        Map<Integer, Map<Integer, Float>> stuQuesScoreMap = getStuQuesScore(examid, classid);

        //获取题目和题号的对应关系
        Map<Integer, Integer> quesSeqnoRelaMap = getQuesSeqnoRelation(examid);

        Map<Integer, Object> stuIdAndUserNameAndCodeMap = new TreeMap<>();
        for (ExamStudent examStudent : examStudentList) {
            Integer studentid = examStudent.getStudentid();
            //根据学生id返回学生的基础信息（学号\性别\姓名\班级）
            Map<String, Object> stuInfoMap = getUserInfo(studentid);

            Map<String, Object> userNameAndCodeMap = new HashMap<>();
            //获取学生姓名学号
            if(!stuIdAndUserNameAndCodeMap.containsKey(studentid)) {
                User student = (User) stuInfoMap.get("student");

                if(student != null) {
                    String username = StringUtils.isNotBlank(student.getUsername()) ? student.getUsername() : "";
                    String usercode = StringUtils.isNotBlank(student.getUsercode()) ? student.getUsercode() : "";
                    userNameAndCodeMap.put("username", username);
                    userNameAndCodeMap.put("usercode", usercode);
                }
            }

            if(examStudent.getStatus() > 1) {
                List<Float> scoreList = null;
                Integer index = 0;
                Float totalScore = 0f;
                if(quesSeqnoRelaMap != null) {
                    scoreList = new ArrayList<>();
                    Iterator<Integer> quesidIt = quesSeqnoRelaMap.keySet().iterator();
                    while(quesidIt.hasNext()) {
                        Integer quesid = quesidIt.next();
                        Integer seqno = quesSeqnoRelaMap.get(quesid);
                        Float score = stuQuesScoreMap.get(studentid).get(seqno);
                        if(score >= 0) {
                            scoreList.add(score);
                            totalScore += score;
                        }else {
                            scoreList.add(0f);
                        }
                    }
                }

                userNameAndCodeMap.put("totalScore", totalScore);
                userNameAndCodeMap.put("scoreList", scoreList);
            }else {
                userNameAndCodeMap.put("totalScore", -1);
                userNameAndCodeMap.put("scoreList", new ArrayList<Float>());
            }
            stuIdAndUserNameAndCodeMap.put(studentid, userNameAndCodeMap);
        }

        dataMap.put("headerCell", headerCell);
        dataMap.put("result", stuIdAndUserNameAndCodeMap.values());
        return dataMap;
    }

    /**
     *@Description: 获取"分数段分布图"数据
     *@author Lvxianya
     *@date 2018/2/5
     */
    @Override
    public Map<String, Object> getSegment(Integer examid, Integer classid) {
        Map<String, Object> dataMap = new HashMap<>();
        //获取试卷信息
        Exam exam = examMapper.selectByPrimaryKey(examid);

        //根据"试卷"和"班级"编号获取各分数段人数
        List<Integer> numList = reportExamSegmentMapper.getSegment(examid, classid);

        if(numList != null && numList.size() > 0) {
            dataMap.put("score", exam.getScore());
            dataMap.put("number", numList.size());
            dataMap.put("result", numList);
        }
        return dataMap;
    }

    /**
     *@Description: 获取班级小题答错名单数据.
     *@author Lvxianya
     *@date 2018/2/6
     */
    @Override
    public List<Map<String, Object>> getErrList(Integer examid, Integer classid) {
        List<Map<String, Object>> dataList = null;

        //根据"试卷编号"，"班级编号"，状态status获取当前"题目编号"
        List<Integer> questionidList = wrongQuestionMapper.getQuesByExamidAndClsid(examid, classid);

        if(questionidList != null && questionidList.size() > 0) {
            dataList = new ArrayList<>();
            for (Integer questionid : questionidList) {
                Map<String, Object> dataMap = new HashMap<>();

                //获取题目信息（题号）
                ExamQuestion examQuestion = examQuestionMapper.selectByPrimaryKey(questionid);

                //班级平均分
                Float average = reportExamQuestionMapper.getClassAverage(examid, classid, questionid);

                //据题目获取答错学生名单
                List<String> usernameList = wrongQuestionMapper.getUserByQid(examid, classid, questionid);
                if(examQuestion != null) {
                    dataMap.put("seqno", examQuestion.getSeqno());
                }
                dataMap.put("average", average);
                dataMap.put("userlist", usernameList);
                dataList.add(dataMap);
            }
        }

        return dataList;
    }

    /**
     *@Description: 获取知识点均分对比表数据
     *@author Lvxianya
     *@date 2018/2/6
     */
    @Override
    public Map<String, Object> getKnowledge(Integer examid, Integer classid) {
        Map<String, Object> dataMap = new HashMap<>();

        //试卷班级情况
        List<RpcenterClassVo> clsInfoList = examClassMapper.getExamClasses(examid, null);

        //知识点均分对比表格-标题头信息
        List<String> headerCell = getKnowHeadCell(clsInfoList);

        //班级知识点得分情况 <kiid, <classid, average>>
        Map<Integer, Map<Integer, Float>> kiidScoreMap = getKiidScore(examid);

        //班级知识点得分率情况 <kiid, rate>
        List<KnowledgeClass> classRateList = knowledgeClassMapper.getKnowClassRelation(examid, classid);
        Map<Integer, Float> classRateMap = null;
        if(classRateList != null && classRateList.size() > 0) {
            classRateMap = new HashMap<>();
            for (KnowledgeClass knowledgeClass : classRateList) {
                classRateMap.put(knowledgeClass.getKiid(), knowledgeClass.getRate());
            }
        }

        //年级知识点得分率情况 <kiid, rate>
        List<KnowledgeGrade> gradeRateList = knowledgeGradeMapper.getKnowGradeRelation(examid);
        Map<Integer, Float> gradeRateMap = null;
        if(gradeRateList != null && gradeRateList.size() > 0) {
            gradeRateMap = new HashMap<>();
            for (KnowledgeGrade knowledgeGrade : gradeRateList) {
                gradeRateMap.put(knowledgeGrade.getKiid(), knowledgeGrade.getRate());
            }
        }

        //获取知识点信息<"kiid", "knowname">
        Map<Integer, String> kiidInfoMap = getKiidInfo(examid);

        //用于封装result数据
        List<Map<String, Object>> result = null;
        //班级知识点得分率信息
        List<Float> classKnowList = new ArrayList<>();
        //年级知识点得分率信息
        List<Float> gradeKnowList = new ArrayList<>();

        if(kiidInfoMap != null ) {
            result = new ArrayList<>();
            Iterator<Integer> kiidIt = kiidInfoMap.keySet().iterator();
            //遍历知识点名称
            while (kiidIt.hasNext()) {
                //获取"知识点编号"
                Integer kiid = kiidIt.next();
                Float totalScore = 0f;
                Map<String, Object> resultMap = new HashMap<>();

                resultMap.put("knowname", kiidInfoMap.get(kiid));

                //每个知识点下所有班级的均分情况
                List<Float> scoreList = new ArrayList<>();

                if(clsInfoList != null && clsInfoList.size() > 0) {
                    //遍历班级信息
                    for (RpcenterClassVo clsInfo : clsInfoList) {
                        Integer clsid = clsInfo.getClassid();
                        Float score = kiidScoreMap.get(kiid).get(clsid);
                        if(score == null) {
                            score = 0f;
                        }
                        totalScore += score;
                        scoreList.add(score);
                    }
                }
                resultMap.put("scoreList", scoreList);
                resultMap.put("gradeAverage", (Math.floor((totalScore / clsInfoList.size())*100)/100));

                //班级知识点得分率情况
                if(classRateMap != null) {
                    addRateToList(classRateMap, classKnowList, kiid);
                }

                //年级知识点得分率情况
                if(gradeRateMap != null) {
                    addRateToList(gradeRateMap, gradeKnowList, kiid);
                }

                result.add(resultMap);
            }
        }

        dataMap.put("headerCell", headerCell);
        dataMap.put("result", result);
        if(kiidInfoMap == null) {
            kiidInfoMap = new HashMap<>();
        }
        dataMap.put("knowledge", kiidInfoMap.values());
        dataMap.put("classKnowledge", classKnowList);
        dataMap.put("gradeKnowledge", gradeKnowList);
        return dataMap;
    }

    /**
     *@Description: 获取年级考情报表"作答详情表格"数据
     *@author Lvxianya
     *@date 2018/2/7
     */
    @Override
    public List<Map<String, Object>> getGradeSituation(Integer examid) {
        List<Map<String, Object>> dataList = new ArrayList<>();

        //试卷班级情况
        List<RpcenterClassVo> classList = examClassMapper.getExamClasses(examid, null);

        //"年级每题详细得分"信息
        Map<String, Object> graSituMap = getGradeSituationNew(examid, null);
        List<String> headerCell = getHeadTitle(examid, null);

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("tabname", "年级每题详细得分");
        dataMap.put("title", headerCell);
        //TODO
        //graSituMap.get("data") 数据结构有问题
        dataMap.put("data", graSituMap.get("data"));

        //获取"班级平均分、班级得分率、年级平均分、年级得分率"相关数据
        //TODO
        getOtherData(examid, classList);

        return dataList;
    }

    /**
     *@Description: 获取'班级平均分、班级得分率、年级平均分、年级得分率'相关数据
     *@author Lvxianya
     *@date 2018/2/8
     */
    private void getOtherData(Integer examid, List<RpcenterClassVo> classList) {
        Map<Integer, String> classMap = new TreeMap<>();
        //获取班级id集合
        List<Integer> classIdList = new ArrayList<>(0);
        //classList转成Map结构
        if(classList != null && classList.size() > 0) {
            for (RpcenterClassVo rpcenterClassVo : classList) {
                classIdList.add(rpcenterClassVo.getClassid());
                classMap.put(rpcenterClassVo.getClassid(), rpcenterClassVo.getClassname());
            }
        }

        //获取大题和小题关联信息 <qsgroup, [questionid...]>
        List<ExamQuestion> bsList = examQuestionMapper.getQsgroupQuidRelation(examid);

        //（各个题目）年级得分率 <questionid, rate>
        List<QuestionbankGrade> gradeRateList = questionbankGradeMapper.getGradeRateRelation(examid);

        //（各个题目）班级得分率
        //TODO
        getClassRateRelation(examid, classIdList);

        //（各个题目）班级大题平均分

        //（各个题目）班级小题平均分

        //（各个题目）年级大题平均分

        //（各个题目）年级小题平均分

        //班级平均分-班级得分率-年级均分-年级得分率

    }

    /**
     *@Description: 获取班级得分率关联信息
     *@author Lvxianya
     *@date 2018/2/8
     */
    //判断第一个班级id不需要
    //TODO
    private void getClassRateRelation(Integer examid, List<Integer> classIdList) {
        Map<Integer, Map<Integer, Float>> classRateMap = null;
        List<QuestionbankClass> classRateList = questionbankClassMapper.getClassRateRelation(examid);

        if(classRateList != null && classRateList.size() > 0) {
            classRateMap = new HashMap<>();

            Integer firstClassId = null;
            if(classIdList != null && classIdList.size() > 0) {
                //获取第一个班级ID
                firstClassId = classRateList.get(0).getClassid();
            }

            for (QuestionbankClass questionbankClass : classRateList) {
                Map<Integer, Float> clsMap = null;

                Integer rateClassid = questionbankClass.getClassid();
                if(classIdList != null && classIdList.size() > 0) {
                    if(rateClassid == firstClassId) {
                        for (Integer classId : classIdList) {
                            if(!classRateMap.containsKey(classId)) {
                                clsMap = new TreeMap<>();
                            }else {
                                clsMap = classRateMap.get(classId);
                            }

                            clsMap.put(questionbankClass.getQuestionid(), 0f);
                            classRateMap.put(classId, clsMap);
                        }
                    }
                }

                if(!classRateMap.containsKey(rateClassid)) {
                    clsMap = new TreeMap<>();
                }else {
                    clsMap = classRateMap.get(rateClassid);
                }

                clsMap.put(questionbankClass.getQuestionid(), questionbankClass.getRate());
                classRateMap.put(rateClassid, clsMap);
            }
        }
    }

    /**
     *@Description: 获取报表-头部标题.
     *@author Lvxianya
     *@date 2018/2/8
     */
    private List<String> getHeadTitle(Integer examid, Integer classid) {
        List<String> headerCell = new ArrayList<>();

        if(classid == null) {
            headerCell.add("学号");
            headerCell.add("姓名");
            headerCell.add("班级");
            headerCell.add("总分");
            headerCell.add("年级名次");
        }else {
            headerCell.add("学号");
            headerCell.add("姓名");
            headerCell.add("总分");
            headerCell.add("班级名次");
        }

        Map<String, List<Integer>> qsgroupSeqnoMap = getQsgroupSeqnoRelation(examid);
        List<ExamQuestionVo> quesTitleList = examQuestionMapper.getQuesTitleRelation(examid);

        if(quesTitleList != null && quesTitleList.size() > 0) {
            for (ExamQuestionVo examQuestionVo : quesTitleList) {
                List<String> temp = new ArrayList<String>();
                temp.add(examQuestionVo.getQstitle() + "(总分:" + examQuestionVo.getScore() + ")");

                String qsgroup = examQuestionVo.getQsgroup();
                List<Integer> seqnoList = qsgroupSeqnoMap.get(qsgroup);
                if(seqnoList != null && seqnoList.size() > 0) {
                    for (Integer seqno : seqnoList) {
                        temp.add(seqno.toString());
                    }
                }

                headerCell.addAll(temp);
            }
        }

        return headerCell;
    }

    /**
     *@Description: 获取题目组和题号的对应关系
     *@author Lvxianya
     *@date 2018/2/8
     */
    private Map<String, List<Integer>> getQsgroupSeqnoRelation(Integer examid) {
        Map<String, List<Integer>> examQuesMap = null;
        List<ExamQuestion> examQuestionList = examQuestionMapper.getQsgroupSeqnoRelation(examid);

        if(examQuestionList != null && examQuestionList.size() > 0) {
            examQuesMap = new HashMap<>();
            for (ExamQuestion examQuestion : examQuestionList) {
                String qsgroup = examQuestion.getQsgroup();
                List<Integer> seqnoList = null;
                if(!examQuesMap.containsKey(qsgroup)) {
                    seqnoList = new ArrayList<>();
                }else {
                    seqnoList = examQuesMap.get(qsgroup);
                }

                seqnoList.add(examQuestion.getSeqno());
            }
        }

        return examQuesMap;
    }

    /**
     *@Description: 获取xx考试，学生大题作答信息（获取年级考情报表数据-使用）
     *@author Lvxianya
     *@date 2018/2/7
     */
    private Map<String, Object> getGradeSituationNew(Integer examid, Integer classid) {
        /*returnMap : <"data", examStudentMap>
        *                   examStudentMap : <studentid, dataMap>
        *                        dataMap : <"examstudent", ExamStudent>
        *                                       ExamStudent : studentid, classid, score, ranking, grade_ranking, status
        *                                  <"usercode", usercode>
        *                                  <"username", username>...
        *
        *             <"classData", classDataMap>
        *                   classDataMap : <classid, [dataMap...]>
        *                        dataMap : 同上
        * */
        Map<String, Object> returnMap = new HashMap<>();

        List<ExamStudent> examStudentList = examStudentMapper.getstuInfoByexamidAndclassid(examid, classid);

        Map<Integer, List<Map<String, Object>>> classDataMap = null;

        Map<Integer, Map<String, Object>> examStudentMap = null;
        if(examStudentList != null && examStudentList.size() > 0) {
            classDataMap = new HashMap<>();

            examStudentMap = new TreeMap<>();
            //转Map结构
            for(ExamStudent examStudent : examStudentList) {
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("examstudent", examStudent);

                examStudentMap.put(examStudent.getStudentid(), dataMap);
            }

            //获取 `学生大题、小题得分详情数据`
            Map<Integer, List<Float>> bQuesMap = getBQuestionNew(examid, classid);

            Iterator<Integer> examStudentIt = examStudentMap.keySet().iterator();
            while(examStudentIt.hasNext()) {
                Integer studentid = examStudentIt.next();
                Map<String, Object> dataMap = examStudentMap.get(studentid);

                if(dataMap == null) {
                    dataMap = new HashMap<>();
                }

                //获取学生基础信息
                Map<String, Object> userInfoMap = getUserInfo(studentid);
                User studentInfo = (User) userInfoMap.get("student");
                String classname = (String) userInfoMap.get("classname");

                if(studentInfo != null) {
                    String usercode = studentInfo.getUsercode();
                    String username = studentInfo.getUsername();
                    dataMap.put("usercode", StringUtils.isNotBlank(usercode)? usercode : ""); //学号
                    dataMap.put("username", StringUtils.isNotBlank(username)? username : ""); //姓名
                }

                dataMap.put("classname", StringUtils.isNotBlank(classname)? classname : ""); //班级

                ExamStudent examStudent = (ExamStudent) dataMap.get("examstudent");
                if(examStudent != null) {
                    Byte status = examStudent.getStatus();
                    if(status == -1) {
                        dataMap.put("score", "作废");
                        dataMap.put("ranking", "作废");
                        dataMap.put("grade_ranking", "作废");
                    }else if(status == 1) {
                        dataMap.put("score", "缺考");
                        dataMap.put("ranking", "缺考");
                        dataMap.put("grade_ranking", "缺考");
                    }
                }

                //题目作答信息
                List<Float> resultList = bQuesMap.get(studentid);
                if(resultList != null && resultList.size() > 0) {
                    dataMap.put("scorelist", resultList);
                }else {
                    dataMap.put("scorelist", new ArrayList<>(0));
                }

                //拆分出各个班级的题目作答情况
                if(examStudent != null) {
                    Integer clsid = examStudent.getClassid();
                    List<Map<String, Object>> dataList = null;
                    if(!classDataMap.containsKey(clsid)) {
                        dataList = new ArrayList<>();
                    }else {
                        dataList = classDataMap.get(clsid);
                    }

                    dataList.add(dataMap);
                    classDataMap.put(clsid, dataList);
                }

                examStudentMap.put(studentid, dataMap);
            }
        }

        returnMap.put("data", examStudentMap);
        returnMap.put("classData", classDataMap);

        return returnMap;
    }

    /**
     *@Description: 获取xx考试，学生作答信息集合（获取年级考情报表数据-使用）key : studentid, value :
     *@author Lvxianya
     *@date 2018/2/7
     */
    private Map<Integer, List<Float>> getBQuestionNew(Integer examid, Integer classid) {
        Map<Integer, List<Float>> resultMap = null;

        //返回学生大题作答信息 [studentid, score]
        List<ExamQuestionVo> examQuestionVoList = reportExamSummaryMapper.getStuQsgroupRelation(examid, classid);

        //转成Map结构 <studentid, [score...]>
        Map<Integer, List<Float>> examQuestionVoMap = null;
        if(examQuestionVoList != null && examQuestionVoList.size() > 0) {
            examQuestionVoMap = new HashMap<>();
            for(ExamQuestionVo questionVo : examQuestionVoList) {
                Integer studentid = questionVo.getStudentid();

                List scoreList = null;
                if(!examQuestionVoMap.containsKey(studentid)) {
                    scoreList = new ArrayList<>();
                }else {
                    scoreList = examQuestionVoMap.get(studentid);
                }
                scoreList.add(questionVo.getScore());
                examQuestionVoMap.put(studentid, scoreList);
            }
        }

        //获取xx考试所有学生-小题对应关系     examResultList  :   [`questionid`,`studentid`,`qsgroup`,`score`]
        Exam exam = examMapper.selectByPrimaryKey(examid);
        String tableName = getSource(exam);
        List<ExamResult> examResultList = examResultMapper.getStuScoreRelation(tableName, examid, classid);

        //转成Map结构 <studentid, <qsgroup, [score...]>>
        Map<Integer, Map<String, List<Float>>> examResultMap = null;
        if(examResultList != null && examResultList.size() > 0) {
            examResultMap = new TreeMap<>();
            for(ExamResult examResult : examResultList) {
                Integer studentid = examResult.getStudentid();

                Map<String, List<Float>> qsMap = null;
                if(!examResultMap.containsKey(studentid)) {
                    qsMap = new TreeMap<>();
                }else {
                    qsMap = examResultMap.get(studentid);
                }

                String qsgroup = examResult.getQsgroup();

                List<Float> scoreList = null;
                if(!qsMap.containsKey(qsgroup)) {
                    scoreList = new ArrayList<>();
                }else {
                    scoreList = qsMap.get(qsgroup);
                }
                scoreList.add(examResult.getScore());
                qsMap.put(qsgroup, scoreList);

                examResultMap.put(studentid, qsMap);
            }
        }

        //封装最终数据格式
        if(examResultMap != null) {
            resultMap = new TreeMap<>();

            Iterator<Integer> examResultIt = examResultMap.keySet().iterator();
            while(examResultIt.hasNext()) {
                Integer studentid = examResultIt.next();

                List<Float> resultList = new ArrayList<>();
                Map<String, List<Float>> qsMap = examResultMap.get(studentid);
                if(qsMap != null) {
                    Iterator<String> qsIt = qsMap.keySet().iterator();
                    while(qsIt.hasNext()) {
                        String qsgroup = qsIt.next();

                        List<Float> resultScoreList = qsMap.get(qsgroup);

                        List<Float> quesScoreList = null;
                        if(examQuestionVoMap != null) {
                            quesScoreList = examQuestionVoMap.get(studentid);
                        }

                        if(resultScoreList != null && quesScoreList != null) {
                            quesScoreList.addAll(resultScoreList);
                            resultList.addAll(quesScoreList);
                        }
                    }
                }

                resultMap.put(studentid, resultList);
            }
        }

        return resultMap;
    }

    /**
     *@Description: 根据"知识点id",从Map中获取"得分率"存放到List集合中
     *@author Lvxianya
     *@date 2018/2/7
     */
    private void addRateToList(Map<Integer, Float> map, List<Float> list, Integer kiid) {
        Float rate = map.get(kiid);
        if(rate == null) {
            rate = 0f;
        }
        list.add(rate);
    }

    /**
     *@Description: 班级知识点得分情况 <kiid, <classid, average>>
     *@author Lvxianya
     *@date 2018/2/7
     */
    private Map<Integer, Map<Integer, Float>> getKiidScore(Integer examid) {
        Map<Integer, Map<Integer, Float>> kiidScoreMap = null;
        List<ReportExamKnowledge> kiidScoreList = reportExamKnowledgeMapper.getKiidScore(examid);

        if(kiidScoreList != null && kiidScoreList.size() > 0) {
            kiidScoreMap = new HashMap<>();
            for (ReportExamKnowledge rpExamKnowledge : kiidScoreList) {
                Integer kiid = rpExamKnowledge.getKiid();

                //判断kiidScoreMap是否存在kiid键
                if(!kiidScoreMap.containsKey(kiid)) {
                    Map<Integer, Float> clsScoreMap = new HashMap<>();
                    clsScoreMap.put(rpExamKnowledge.getClassid(), rpExamKnowledge.getAverage());

                    kiidScoreMap.put(kiid, clsScoreMap);
                }else {
                    Map<Integer, Float> clsScoreMap = kiidScoreMap.get(kiid);
                    clsScoreMap.put(rpExamKnowledge.getClassid(), rpExamKnowledge.getAverage());

                    kiidScoreMap.put(kiid, clsScoreMap);
                }
            }
        }

        return kiidScoreMap;
    }

    /**
     *@Description: 获取知识点信息
     *@author Lvxianya
     *@date 2018/2/6
     */
    private Map<Integer, String> getKiidInfo(Integer examid) {
        Map<Integer, String> kiidInfoMap = null;
        List<Integer> kiidList = reportExamKnowledgeMapper.getKiidInfo(examid);

        if(kiidList != null && kiidList.size() > 0) {
            kiidInfoMap = new TreeMap<>();
            for (Integer kiid : kiidList) {
                //获取知识点名称
                KnowledgeItem item = knowledgeItemMapper.selectByPrimaryKey(kiid);
                if(item != null) {
                    kiidInfoMap.put(kiid, item.getKnowname());
                }
            }
        }

        return kiidInfoMap;
    }

    /**
     *@Description: 知识点均分对比表格-标题头信息
     *@author Lvxianya
     *@date 2018/2/6
     */
    private List<String> getKnowHeadCell(List<RpcenterClassVo> clsInfoList) {
        List<String> headerCell = new ArrayList<>();

        headerCell.add("知识点名称");
        headerCell.add("年级均分");

        if(clsInfoList != null && clsInfoList.size() > 0) {
            for (RpcenterClassVo clsInfo : clsInfoList) {
                headerCell.add(clsInfo.getClassname());
            }
        }

        return headerCell;
    }

    /**
     *@Description: 根据学生id返回学生的基础信息（学号\性别\姓名\班级）
     *@author Lvxianya
     *@date 2018/2/5
     */
    private Map<String, Object> getUserInfo(Integer studentid) {
        Map<String, Object> stuInfoMap = null;
        User student = userMapper.selectByPrimaryKey(studentid);
        if(student != null) {
            stuInfoMap = new HashMap<>();
            stuInfoMap.put("student", student);

            if(student.getCategory() == 3) {
                //获取学生班级名称
                List<Classinfo> classinfoList = studentClassMapper.getStuClassInfo(studentid);
                if(classinfoList != null && classinfoList.size() > 0) {
                    stuInfoMap.put("classname", classinfoList.get(0).getClassname());
                }
            }
        }

        return stuInfoMap;
    }

    /**
     *@Description: 获取xx考试所有学生-小题得分情况
     *@author Lvxianya
     *@date 2018/2/3
     */
    private Map<Integer, Map<Integer, Float>> getStuQuesScore(Integer examid, Integer classid) {
        Map<Integer, Map<Integer, Float>> stuQuesScoreMap = null;
        //获取当前试卷答案所在的表
        Exam exam = examMapper.selectByPrimaryKey(examid);
        String tableName = getSource(exam);

        //获取xx考试所有学生-小题得分情况.
        List<ExamResult> examResultList = examResultMapper.getStuQuesScore(tableName, examid, classid);

        if(examResultList != null && examResultList.size() > 0) {
            stuQuesScoreMap = new TreeMap<>();

            //小题和题号对应关系
            Map<Integer, Integer> quesSeqnoRelaMap = getQuesSeqnoRelation(examid);
            for (ExamResult examResult : examResultList) {
                Integer seqno = quesSeqnoRelaMap.get(examResult.getQuestionid());
                Integer studentid = examResult.getStudentid();
                if(!stuQuesScoreMap.containsKey(studentid)) {
                    Map<Integer, Float> scoreMap = new TreeMap<>();
                    scoreMap.put(seqno, examResult.getScore());
                    stuQuesScoreMap.put(studentid, scoreMap);
                }else {
                    Map<Integer, Float> scoreMap = stuQuesScoreMap.get(studentid);
                    scoreMap.put(seqno, examResult.getScore());
                    stuQuesScoreMap.put(studentid, scoreMap);
                }
            }
        }

        return stuQuesScoreMap;
    }

    /**
     *@Description: 获取题目和题号的对应关系
     *@author Lvxianya
     *@date 2018/2/5
     */
    private Map<Integer,Integer> getQuesSeqnoRelation(Integer examid) {
        Map<Integer, Integer> quesSeqnoRelaMap = null;
        List<ExamQuestion> examQuestionList = examQuestionMapper.getQuesSeqnoRelation(examid);
        if(examQuestionList != null && examQuestionList.size() > 0) {
            quesSeqnoRelaMap = new TreeMap<>();
            for (ExamQuestion examQuestion : examQuestionList) {
                quesSeqnoRelaMap.put(examQuestion.getQuestionid(), examQuestion.getSeqno());
            }
        }

        return quesSeqnoRelaMap;
    }

    /**
     *@Description: 根据试卷ID确定ExamResult模型对应的数据表
     *@author Lvxianya
     *@date 2018/2/5
     */
    private String getSource(Exam exam) {
        List<ExamResultConfigs.ExamResultConfig> examResultConfigList = examResultConfigs.getExamresult();
        Integer num = 0;
        if(examResultConfigList.size() == 1) {
            num = examResultConfigList.get(0).getNum();
        }else {
            for (ExamResultConfigs.ExamResultConfig resultConfig : examResultConfigList) {
                if(resultConfig.getEndtime() == null) {
                    if(exam.getCreatedAt() == resultConfig.getStarttime()) {
                        num = resultConfig.getNum();
                        break;
                    }
                }else {
                    if(exam.getCreatedAt() == resultConfig.getEndtime() && exam.getCreatedAt() == resultConfig.getStarttime()) {
                        num = resultConfig.getNum();
                        break;
                    }
                }
            }
        }

        String tableName = "exam_result_";
        Integer tableIndex = num > 0 ? (((exam.getExamid() / 10) % 64 + 1) - 1) % num + 1 : 1;

        if(tableIndex > 0 && tableIndex < 10) {
            tableName = tableName + "00" + tableIndex;
        }else if(tableIndex >= 10 && tableIndex < 100) {
            tableName = tableName + "0" + tableIndex;
        }else {
            tableName = tableName + tableIndex;
        }
        return tableName;
    }

    /**
     *@Description: 小题作答详情-表格头部标题
     *@author Lvxianya
     *@date 2018/2/3
     */
    private List<String> getReplyHeadCell(Integer examid) {
        List<String> headCellList = new ArrayList<>();
        headCellList.add("姓名");
        headCellList.add("学号");
        headCellList.add("成绩");

        //获取题号和分值信息
        List<ExamQuestion> seqnoScoreRelaList = examQuestionMapper.getSeqnoScoreRelation(examid);
        if(seqnoScoreRelaList != null && seqnoScoreRelaList.size() > 0) {
            for(ExamQuestion examQuestion : seqnoScoreRelaList) {
                headCellList.add(examQuestion.getSeqno() + "(" + examQuestion.getScore() + ")");
            }
        }

        return headCellList;
    }

    /**
     *@Description: （"学情表格==>大题作答详情"）
     * 配合getBigQues函数使用.
     *@author Lvxianya
     *@date 2018/2/2
     */
    private List<String> dealAnswer(Map<String, List<Map<String, Object>>> detailsMap, int index, String qsgroup, Byte type) {
        List<String> result = new ArrayList<>();
        List<Map<String, Object>> detailsMapList = detailsMap.get(qsgroup);
        if(detailsMapList.size() <= index) {
            for (int i = detailsMapList.size(); i <= index; i++) {
                Map<String, Object> answerMap = new HashMap<>();
                answerMap.put("reportExamBigques", null);
                answerMap.put("result", "");
                detailsMapList.add(answerMap);
            }
        }

        ReportExamBigques reportExamBigques = (ReportExamBigques) detailsMapList.get(index).get("reportExamBigques");
        String resultStr = (String) detailsMapList.get(index).get("result");
        if(reportExamBigques == null) {
            //题号
            result.add("");
            if(type == 0) {
                //单选题   答案
                result.add("");
                //错误人数
                result.add("");
                //高频选项
                result.add("");
            }else if(type == 5) {
                //简答题   得分率
                result.add("");
            }else {
                //其他题型  错误人数
                result.add("");
            }
        }else {
            //题号
            if(!result.contains(reportExamBigques.getSeqno())) {
                result.add(reportExamBigques.getSeqno().toString());
            }

            if(type == 0) {
                //单选题   答案
                if(!result.contains(resultStr)) {
                    result.add(resultStr);
                }
                //错误人数
                if(!result.contains(reportExamBigques.getErrorNum())) {
                    result.add(reportExamBigques.getErrorNum().toString());
                }
                //高频选项
                if(!result.contains(reportExamBigques.getErrorAnswer())) {
                    result.add(reportExamBigques.getErrorAnswer());
                }
            }else if(type == 5) {
                //简答题   得分率
                if(!result.contains(reportExamBigques.getRate())) {
                    result.add(reportExamBigques.getRate().toString());
                }
            }else {
                //其他题型  错误人数
                if(!result.contains(reportExamBigques.getErrorNum())) {
                    result.add(reportExamBigques.getErrorNum().toString());
                }
            }
        }
        return result;
    }

    /**
     *@Description: 根据大题题号返回数据信息.
     *@author Lvxianya
     *@date 2018/2/2
     */
    private Map<String, List<Map<String, Object>>> getDetailsByQsgroup(Integer examid, Integer classid) {
        Map<String, List<Map<String, Object>>> detailsMap = null;
        List<ReportExamBigques> rpExamBigQuesList = reportExamBigquesMapper.getDetailsByQsgroup(examid, classid);
        if(rpExamBigQuesList != null && rpExamBigQuesList.size() > 0) {
            detailsMap = new HashMap<>();
            //获取“单选题”的正确答案.
            Map<Integer, String> seqnoResultRelationMap = getSeqnoResultRelation(examid, 0);
            if(seqnoResultRelationMap != null) {
                for (ReportExamBigques reportExamBigques : rpExamBigQuesList) {
                    //获取指定题型的答案
                    Map<String, Object> answerMap = getAnswer(reportExamBigques, seqnoResultRelationMap);
                    String key = reportExamBigques.getQsgroup();
                    if(detailsMap.containsKey(key)) {
                        List<Map<String, Object>> detailsList = detailsMap.get(key);
                        detailsList.add(answerMap);
                        detailsMap.put(key, detailsList);
                    }else {
                        List<Map<String, Object>> detailsList = new ArrayList<>();
                        detailsList.add(answerMap);
                        detailsMap.put(key, detailsList);
                    }
                }
            }
        }

        return detailsMap;
    }

    /**
     *@Description: 获取指定题型的答案.
     *@author Lvxianya
     *@date 2018/2/2
     */
    private Map<String, Object> getAnswer(ReportExamBigques reportExamBigques, Map<Integer, String> seqnoResultRelationMap) {
        Map<String, Object> answerMap = new HashMap<String, Object>();
        answerMap.put("reportExamBigques", reportExamBigques);
        if(reportExamBigques.getType() == 0) {
            answerMap.put("result", seqnoResultRelationMap.get(reportExamBigques.getSeqno()));
        }
        return answerMap;
    }

    /**
     *@Description: 获取题号和答案对应关系.
     *@author Lvxianya
     *@date 2018/2/2
     */
    private Map<Integer, String> getSeqnoResultRelation(Integer examid, Integer type) {
        Map<Integer, String> seqnoResultRelationMap = null;
        List<ExamQuestionWithBLOBs> seqnoResultRelationList = examQuestionMapper.getSeqnoResultRelation(examid, type);
        if(seqnoResultRelationList != null && seqnoResultRelationList.size() > 1) {
            seqnoResultRelationMap = new TreeMap<Integer, String>();
            for (ExamQuestionWithBLOBs questionWithBLOBs : seqnoResultRelationList) {
                seqnoResultRelationMap.put(questionWithBLOBs.getSeqno(), questionWithBLOBs.getResult());
            }
        }

        return seqnoResultRelationMap;
    }

    /**
     *@Description: 题目组和题型的关系
     *@author Lvxianya
     *@date 2018/2/2
     */
    private Map<String, Object> getQsgroupTypeRelation(Integer examid) {
        Map<String, Object> qtRelationMap = null;
        List<ExamQuestionVo> qtRelationList  = examQuestionMapper.getQsgroupTypeRelation(examid);
        if(qtRelationList != null) {
            qtRelationMap = new TreeMap<String, Object >();
            for (ExamQuestionVo examQuestion : qtRelationList) {
                qtRelationMap.put(examQuestion.getQsgroup(),examQuestion.getType());
            }
        }

        return qtRelationMap;
    }

    /**
     *@Description: 获取表格标题部分
     *@author Lvxianya
     *@date 2018/2/2
     */
    private Map<String, Object> getSummaryTitle(Integer examid) {
        Map<String, Object> summaryTitleMap = null;
        List<ExamQuestionVo> examQuestionList = examQuestionMapper.getSummaryTitle(examid);
        //主标题
        List<String> mainTitle = null;
        //在表格里所占列数
        List<Integer> lgqnum = null;
        //副标题
        List<String[]> subtitle = null;
        //大题下面最大小题数量
        Integer quesNum = 0;

        if(examQuestionList != null && examQuestionList.size() > 0) {
            summaryTitleMap = new HashMap<>();

            mainTitle = new ArrayList<String>();
            lgqnum = new ArrayList<Integer>();
            subtitle = new ArrayList<String[]>();

            for (ExamQuestionVo examQuestion : examQuestionList) {
                //主标题
                mainTitle.add(examQuestion.getQstitle());
                //在表格里所占列数
                Map<String, Object> numTitleMap = getNumTitle(examQuestion.getType());
                lgqnum.add((Integer) numTitleMap.get("num"));
                //副标题
                subtitle.add((String[]) numTitleMap.get("stitle"));
                //大题下面最大小题数量
                if(examQuestion.getNum() > quesNum) {
                    quesNum = examQuestion.getNum();
                }
            }

            summaryTitleMap.put("maintitle", mainTitle);
            summaryTitleMap.put("lgqnum", lgqnum);
            summaryTitleMap.put("subtitle", subtitle);
            summaryTitleMap.put("quesNum", quesNum);
        }
        return summaryTitleMap;
    }

    /**
     *@Description: （成绩报表--学情表格--大题作答详情使用）.根据题目类型返回对应的列数和副标题名称.
     * type 题型,0:单选题 1:多选题 2:判断题 3:填空题 4:计算题 5:简答题
     *@author Lvxianya
     *@date 2018/2/2
     */
    private Map<String, Object> getNumTitle(Byte type) {
        Map<String, Object> numTitleMap = new HashMap<String, Object>();
        if(type == 0) {
            numTitleMap.put("num", 4);
            numTitleMap.put("stitle", new String[]{"题号", "答案", "错误人数", "高频错误选项"});
        }else {
            numTitleMap.put("num", 2);
            numTitleMap.put("stitle", new String[]{"题号", "错误人数"});
        }
        return numTitleMap;
    }
}
