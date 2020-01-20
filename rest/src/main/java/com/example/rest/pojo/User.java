package com.example.rest.pojo;


import com.example.rest.enumeration.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
public class User {
    private Long id;
    private String userName;
    private SexEnum sex = null;
    private String note;
    
}