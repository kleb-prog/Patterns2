package com.homeDeposit.homeDeposit.Repository;

import com.homeDeposit.homeDeposit.Entity.MoneyFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoneyFlowRepository extends JpaRepository<MoneyFlow, UUID> {
}
