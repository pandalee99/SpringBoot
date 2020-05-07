package com.example.mybatiscodehelper.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * user_mybatishelper
 */
public class UserMybatishelper {
    /**
     * userid
     */
    private Integer userid;

    /**
     * username
     */
    private String username;

    /**
     * birth
     */
    private Date birth;

    /**
     * 工资明细
     */
    private BigDecimal salary;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}