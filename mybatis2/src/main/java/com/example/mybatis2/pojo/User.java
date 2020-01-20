package com.example.mybatis2.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
public class User {
    int id;
    String user_name;
    int sex;
    String note;
}
