package com.homeDeposit.homeDeposit.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@AllArgsConstructor
public class MoneyFlowDao {
    private double amount;

    @Size(max = 50, message = "Не больше 50 символов")
    private String description;

    private Date date;
    private String type;
}
