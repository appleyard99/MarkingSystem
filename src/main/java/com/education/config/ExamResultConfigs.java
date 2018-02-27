package com.education.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ExamResult数据在数据库中进行了分表操作，需要通过读取配置文件的方式来动态获取相应的数据表名，like: exam_result_001
 *
 * @author Lvxianya
 * @create 2018/2/5
 */
@Configuration
@ConfigurationProperties(prefix = "tblsplit")
public class ExamResultConfigs {
    private List<ExamResultConfig> examresult = new ArrayList<>();

    public List<ExamResultConfig> getExamresult() {
        return examresult;
    }

    public void setExamresult(List<ExamResultConfig> examresult) {
        this.examresult = examresult;
    }

    public static class ExamResultConfig {
        private Date starttime;
        private Date endtime;
        private Integer num;

        public Date getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            if(StringUtils.isNotBlank(starttime)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    this.starttime = simpleDateFormat.parse(starttime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else {
                this.starttime = null;
            }
        }

        public Date getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            if(StringUtils.isNotBlank(endtime)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    this.endtime = simpleDateFormat.parse(endtime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else {
                this.endtime = null;
            }
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "ConfigsProp{" +
                    "starttime=" + starttime +
                    ", endtime='" + endtime + '\'' +
                    ", num='" + num + '\'' +
                    '}';
        }
    }
}
