package com.example.security.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
public class User {
    private Long id;

    private String username;

    private String password;

    private String roles;

}
