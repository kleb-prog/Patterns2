package com.homeDeposit.homeDeposit.Service;

import com.homeDeposit.homeDeposit.Entity.MoneyFlow;
import com.homeDeposit.homeDeposit.Repository.MoneyFlowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MoneyFlowService {

    private final MoneyFlowRepository moneyFlowRepository;

    public Optional<MoneyFlow> findOneByID(UUID uuid) {
        return moneyFlowRepository.findById(uuid);
    }

    public List<MoneyFlow> findAll() {
        return moneyFlowRepository.findAll();
    }

    public void saveMF(MoneyFlow moneyFlow) {
        moneyFlowRepository.save(moneyFlow);
    }
}
