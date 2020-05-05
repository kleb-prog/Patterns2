package com.homeDeposit.homeDeposit.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoneyFlow {
    @Id
    private UUID uuid;

    private double amount;

    private String description;

    private Date date;

    private MoneyFlowType type;
}
