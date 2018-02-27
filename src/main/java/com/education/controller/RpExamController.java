package com.education.controller;

import com.education.domain.Exam;
import com.education.service.IExamService;
import com.education.service.IReportExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 成绩报表模块相关
 *
 * @author Lvxianya
 * @create 2018/2/2
 */
@RestController
@RequestMapping(value = "/api/report-exam", produces = "application/json")
public class RpExamController {
    @Autowired
    private IReportExamService iReportExamService;

    @Autowired
    private IExamService iExamService;

    /**
     *@Description: 成绩报表--"学情表格"--“班级成绩单”相关数据
     *@author Lvxianya
     *@date 2018/2/2
     */
    @GetMapping(value="/summary/{classid}/{examid}/{schoolid}")
    public Map<String, Object> summaryAction(@PathVariable("classid") Integer classid,
                                             @PathVariable("examid") Integer examid,
                                             @PathVariable("schoolid") Integer schoolid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("code", 200);
            map.put("msg", "");

            //检查操作的合法性:只可以访问自己学校的数据.
            Map<String, Object> checkMap = iExamService.checkExam(examid, schoolid);

            if("false".equals(checkMap.get("status"))) {
                map.put("code", 501);
                map.put("msg", checkMap.get("msg"));
                return map;
            }

            Exam exam = (Exam) checkMap.get("data");
            //获取相关数据（【学情表格】数据）
            Map<String, Object> dataMap = iReportExamService.getSummaryList(classid, examid, exam.getTermid());

            if(dataMap == null) {
                map.put("code", 501);
                map.put("msg", "数据不存在");
            }

            //TODO
            //是否需要进行导出操作

            map.put("data", dataMap);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 501);
            map.put("msg", "网络波动异常");
            return map;
        }
    }

    /**
     *@Description: 获取年级大题、小题均分对比数据.
     *@author liuyizheng
     *@date 2018/2/2
     */
    @GetMapping(value = "/question/{classid}/{examid}/{tp}")
    public Map<String,Object> questionAction(@PathVariable("classid") Integer classid,
                                             @PathVariable("examid") Integer examid,
                                             @PathVariable("tp") Integer tp){
        Map<String, Object> map = new HashMap<String, Object>();

        try{
            //判断参数是否为大小题
            if (tp == 1 || tp == 2) {
                //获取大小题平均分
                Map<String, Object> datamap = iReportExamService.getQuestion( examid, classid,tp);
                map.put("msg","");
                map.put("code",200);
                map.put("data",datamap);
            }else{
                map.put("code",501);
                map.put("msg","参数不合法");
            }
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", 501);
            map.put("msg", "网络波动异常");
            return map;
        }

    }


    /**
     *@Description: 成绩报表--"学情表格"--“大题作答详情”数据
     *@author Lvxianya
     *@date 2018/2/2
     */
    @GetMapping(value="/bques/{classid}/{examid}")
    public Map<String, Object> bquesAction(@PathVariable("classid") Integer classid,
                                           @PathVariable("examid") Integer examid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("code", 200);
            map.put("msg", "");
            //获取相关数据
            Map<String, Object> dataMap = iReportExamService.getBigQues(examid, classid);
            if(dataMap == null) {
                map.put("code", 501);
                map.put("msg", "数据不存在");
                return map;
            }
            map.put("data", dataMap);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 501);
            map.put("msg", "网络波动异常");
            return map;
        }
    }

    /**
     *@Description: 成绩报表--"学情表格"--“小题作答详情”数据
     *@author Lvxianya
     *@date 2018/2/3
     */
    @GetMapping(value="/replydetails/{classid}/{examid}")
    public Map<String, Object> replydetailsAction(@PathVariable("classid") Integer classid,
                                                  @PathVariable("examid") Integer examid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("code", 200);
            map.put("msg", "");

            //获取小题作答相关数据
            Map<String, Object> dataMap = iReportExamService.getReplyDetails(examid, classid);
            map.put("data", dataMap);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 501);
            map.put("msg", "网络波动异常");
            return map;
        }
    }

    /**
     *@Description: 分数段分布图
     *@author Lvxianya
     *@date 2018/2/5
     */
    @GetMapping(value="/segment/{classid}/{examid}")
    public Map<String, Object> segmentAction(@PathVariable("classid") Integer classid,
                                             @PathVariable("examid") Integer examid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("code", 200);
            map.put("msg", "");

            Map<String, Object> dataMap = iReportExamService.getSegment(examid, classid);
            map.put("data", dataMap);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 501);
            map.put("msg", "网络波动异常");
            return map;
        }
    }

    /**
     *@Description: 班级小题答错名单数据
     *@author Lvxianya
     *@date 2018/2/6
     */
    @GetMapping(value="/errlist/{classid}/{examid}")
    public Map<String, Object> errlistAction(@PathVariable("classid") Integer classid,
                                             @PathVariable("examid") Integer examid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("code", 200);
            map.put("msg", "");

            List<Map<String, Object>> dataList = iReportExamService.getErrList(examid, classid);
            map.put("data", dataList);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 501);
            map.put("msg", "网络波动异常");
            return map;
        }
    }

    /**
     *@Description: 知识点均分对比数据
     *@author Lvxianya
     *@date 2018/2/6
     */
    @GetMapping(value="/knowledge/{classid}/{examid}")
    public Map<String, Object> knowledgeAction(@PathVariable("classid") Integer classid,
                                               @PathVariable("examid") Integer examid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("code", 200);
            map.put("msg", "");

            Map<String, Object> dataMap = iReportExamService.getKnowledge(examid, classid);
            map.put("data", dataMap);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 501);
            map.put("msg", "网络波动异常");
            return map;
        }
    }

    /**
     *@Description: 年级考情报表"作答详情表格"数据
     *@author Lvxianya
     *@date 2018/2/7
     */
    @GetMapping(value="/grade-situation/{classid}/{examid}")
    public Map<String, Object> gradeSituationAction(@PathVariable("classid") Integer classid,
                                                    @PathVariable("examid") Integer examid) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("code", 200);
            map.put("msg", "");

            List<Map<String, Object>> dataMap = iReportExamService.getGradeSituation(examid);
            map.put("data", dataMap);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 501);
            map.put("msg", "网络波动异常");
            return map;
        }
    }
}
