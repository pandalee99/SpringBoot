package com.example.mybatis3.pojo;

import com.example.mybatis3.enumeration.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias(value = "user")// MyBatis指定别名
public class User {

	private Long id = null;

	private String userName = null;

	private String note = null;

	private SexEnum sex = null;

}