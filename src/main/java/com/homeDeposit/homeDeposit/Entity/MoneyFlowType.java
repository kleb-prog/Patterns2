package com.homeDeposit.homeDeposit.Entity;

import lombok.Getter;

public enum MoneyFlowType {
    IncomeType("Income"), SpendingType("Spending");

    @Getter
    private String name;

    MoneyFlowType(String name) {
        this.name = name;
    }
}
