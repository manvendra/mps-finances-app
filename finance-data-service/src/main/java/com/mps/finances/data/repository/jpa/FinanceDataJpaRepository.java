package com.mps.finances.data.repository.jpa;

import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

@ConditionalOnProperty(value = "com.mps.finance.jpa.repo.enabled", havingValue = "true")
public interface FinanceDataJpaRepository extends JpaRepository<FinancialAccount, Long>,
                                                  JpaSpecificationExecutor<FinancialAccount> {

    List<FinancialAccount> findByOwnerId(Long personId);

    List<FinancialAccount> findByOwnerFirstName(String firstName);
}
