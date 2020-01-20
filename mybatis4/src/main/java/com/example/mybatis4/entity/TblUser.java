package com.example.mybatis4.entity;

import java.io.Serializable;

public class TblUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.user_id
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.user_name
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.user_age
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    private Integer userAge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_user
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.user_id
     *
     * @return the value of tbl_user.user_id
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.user_id
     *
     * @param userId the value for tbl_user.user_id
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.user_name
     *
     * @return the value of tbl_user.user_name
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.user_name
     *
     * @param userName the value for tbl_user.user_name
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.user_age
     *
     * @return the value of tbl_user.user_age
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.user_age
     *
     * @param userAge the value for tbl_user.user_age
     *
     * @mbg.generated Wed Jan 15 19:25:59 CST 2020
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}