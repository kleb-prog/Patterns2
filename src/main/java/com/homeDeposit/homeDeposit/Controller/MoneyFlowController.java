package com.homeDeposit.homeDeposit.Controller;

import com.homeDeposit.homeDeposit.DAO.MoneyFlowDao;
import com.homeDeposit.homeDeposit.Entity.MoneyFlow;
import com.homeDeposit.homeDeposit.Entity.MoneyFlowType;
import com.homeDeposit.homeDeposit.Service.MoneyFlowService;
import com.homeDeposit.homeDeposit.utilites.CalculatorOfCurrentAmount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/money")
public class MoneyFlowController {

    private final MoneyFlowService moneyFlowService;

    @GetMapping("/{id}")
    public String getOneMoneyFlow(Model model, @PathVariable String id) {
        Optional<MoneyFlow> moneyFlow = moneyFlowService.findOneByID(UUID.fromString(id));
        List<MoneyFlow> moneyFlowList = new ArrayList<>();
        moneyFlowList.add(moneyFlow.orElse(null));
        model.addAttribute("moneyFlows", moneyFlowList);
        return "showMF";
    }

    @GetMapping("/showAll")
    public String getAllMoneyFlows(Model model) {
        List<MoneyFlow> moneyFlowList = moneyFlowService.findAll();
        double currentAmount = CalculatorOfCurrentAmount.calculate(moneyFlowList);
        model.addAttribute("moneyFlows", moneyFlowList);
        model.addAttribute("currentAmount", currentAmount);
        return "showMF";
    }

    @GetMapping("/addForm")
    public String showAddForm() {
        return "money";
    }

    @PostMapping
    public String addOne(MoneyFlowDao moneyFlowDao) {
        MoneyFlow moneyFlow = MoneyFlow.builder()
                .uuid(UUID.randomUUID())
                .amount(moneyFlowDao.getAmount())
                .date(moneyFlowDao.getDate())
                .description(moneyFlowDao.getDescription())
                .type(MoneyFlowType.valueOf(moneyFlowDao.getType())).build();

        moneyFlowService.saveMF(moneyFlow);

        return "redirect:/money/showAll";
    }
}
