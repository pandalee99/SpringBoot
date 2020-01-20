package com.example.designshop.dao;


import com.example.designshop.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseRecordDao {
    public int insertPurchaseRecord(PurchaseRecordPo pr);
}