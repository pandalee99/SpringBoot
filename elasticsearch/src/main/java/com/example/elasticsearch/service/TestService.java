package com.example.elasticsearch.service;

import com.example.elasticsearch.pojo.Entity;

import java.util.List;

public interface TestService {

    void saveEntity(Entity entity);

    void saveEntity(List<Entity> entityList);

    List<Entity> searchEntity(String searchContent);
}