package com.example.thymeleaf.dao;

import com.example.thymeleaf.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    // 展示产品

     List<Product> showProduct();
    //删除产品
     int deleteProduct(Long id);

    //增加产品
     int addProduct(Product product);

     //获取单个产品
    Product getProduct(String name);
}
