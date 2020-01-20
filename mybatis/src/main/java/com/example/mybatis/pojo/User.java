package com.example.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_user")
public class User {
    @TableId(value = "user_id")
    private Long userId;
    private String userName;
    private Integer userAge;

}