package com.education.domain;

import java.util.TreeMap;

/**
 * 超级实体类对象，可以装载任意实体类之任意属性，可以用于装载多表连接查询返回的复合数据
 *
 * @author liuyizheng
 * @create 2018/2/2
 */
public class SuperDomain extends TreeMap<String,Object>{
    
    public SuperDomain setProperty(String name, Object value) {
        this.put(name, value);
        return this;
    }

}
