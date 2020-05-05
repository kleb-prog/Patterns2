package com.homeDeposit.homeDeposit.DAO;

import com.homeDeposit.homeDeposit.Entity.MoneyFlowType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class MoneyFlowDao {
    private double amount;
    private String description;
    private Date date;
    private String type;
}
