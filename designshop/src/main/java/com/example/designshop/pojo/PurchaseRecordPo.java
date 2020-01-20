package com.example.designshop.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("purchaseRecord")
public class PurchaseRecordPo implements Serializable {
	private static final long serialVersionUID = -360816189433370174L;
	private Long id;
	private Long userId;
	private Long productId;
	private double price;
	private int quantity;
	private double sum;
	private Timestamp purchaseTime;
	private String note;

}