package com.example.redis.pojo;

import java.io.Serializable;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")
public class User implements Serializable {
	private static final long serialVersionUID = 7760614561073458247L;
	private Long id;
	private String userName;
	private String note;
}