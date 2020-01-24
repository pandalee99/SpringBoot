package com.example.thymeleaf.service;


import com.example.thymeleaf.pojo.Product;

import java.util.List;

public interface ProductService {
    //展示全部

    List<Product> ShowAll();

    //删除产品

    int delete(Long id);

    //增加产品

     int add(Product product);

     Product get(String name);

}
