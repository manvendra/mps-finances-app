package com.mps.finances.trackerservice;

import com.mps.finances.account.FinancialAccount;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface FinancialAccountRepository extends CouchbaseRepository<FinancialAccount, Long> {

}
