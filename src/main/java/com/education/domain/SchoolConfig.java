package com.education.domain;

import java.util.Date;

public class SchoolConfig {
    private Integer recordid;

    private Integer schoolid;

    private String cfgname;

    private String cfgvalue;

    private Date createtime;

    private String memo;

    private Date updatetime;

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getCfgname() {
        return cfgname;
    }

    public void setCfgname(String cfgname) {
        this.cfgname = cfgname == null ? null : cfgname.trim();
    }

    public String getCfgvalue() {
        return cfgvalue;
    }

    public void setCfgvalue(String cfgvalue) {
        this.cfgvalue = cfgvalue == null ? null : cfgvalue.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}