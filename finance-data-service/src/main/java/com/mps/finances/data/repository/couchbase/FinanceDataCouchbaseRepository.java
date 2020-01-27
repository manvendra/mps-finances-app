package com.mps.finances.data.repository.couchbase;

import com.mps.finances.data.repository.jpa.entities.account.FinancialAccount;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

@ConditionalOnProperty(value = "com.mps.finance.couchbase.repo.enabled", havingValue = "true")
public interface FinanceDataCouchbaseRepository extends CouchbaseRepository<FinancialAccount, Long> {

}
