package com.mps.finances.data.repository.jpa;

import com.mps.finances.data.repository.FinanceDataRepository;
import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ConditionalOnProperty(value = "com.mps.finance.jpa.repo.enabled", havingValue = "true")
public interface FinanceDataJpaRepository extends JpaRepository<FinancialAccount, Long>, FinanceDataRepository {

    List<FinancialAccount> findByPersonPersonId(Long personId);

    List<FinancialAccount> findByPersonFirstName(String firstName);
}