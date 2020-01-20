package com.example.designshop.pojo;

import java.io.Serializable;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("product")
public class ProductPo implements Serializable {
    private static final long serialVersionUID = 3288311147760635602L;
    private Long id;
    private String productName;
    private int stock;
    private double price;
    private int version;
    private String note;
    
    
}