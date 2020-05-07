package com.example.mybatiscodehelper.pojo;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class User {

    Integer userid;

    String username;

    Date birth;

    /**
     * 工资明细
     *
     */
    BigDecimal salary;


}
