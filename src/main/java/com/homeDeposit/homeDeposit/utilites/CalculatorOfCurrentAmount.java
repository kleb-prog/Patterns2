package com.homeDeposit.homeDeposit.utilites;

import com.homeDeposit.homeDeposit.Entity.MoneyFlow;
import com.homeDeposit.homeDeposit.Entity.MoneyFlowType;

import java.util.List;

import static com.homeDeposit.homeDeposit.Entity.MoneyFlowType.IncomeType;
import static com.homeDeposit.homeDeposit.Entity.MoneyFlowType.SpendingType;

public class CalculatorOfCurrentAmount {
    public static double calculate(List<MoneyFlow> moneyFlowList) {
        double result = 0;
        for (MoneyFlow moneyFlow : moneyFlowList) {
            if (IncomeType.equals(moneyFlow.getType())) {
                result += moneyFlow.getAmount();
            } else if (SpendingType.equals(moneyFlow.getType())) {
                result -= moneyFlow.getAmount();
            }
        }

        return result;
    }
}
