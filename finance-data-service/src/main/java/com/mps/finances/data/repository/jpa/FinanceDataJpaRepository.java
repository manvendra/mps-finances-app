package com.mps.finances.data.repository.jpa;

import com.mps.finances.data.repository.FinanceDataRepository;
import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@ConditionalOnProperty(value = "com.mps.finance.jpa.repo.enabled", havingValue = "true")
public interface FinanceDataJpaRepository extends JpaRepository<FinancialAccount, Long>, FinanceDataRepository {

    List<FinancialAccount> findByPersonId(Long personId);

    List<FinancialAccount> findByPersonFirstName(String firstName);
}
