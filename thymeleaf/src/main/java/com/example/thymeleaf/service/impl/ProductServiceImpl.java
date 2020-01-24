package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.dao.ProductDao;
import com.example.thymeleaf.pojo.Product;
import com.example.thymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> ShowAll() {
        return productDao.showProduct();
    }

    @Override
    public int delete(Long id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public int add(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product get(String name) {
        return productDao.getProduct(name);
    }
}
