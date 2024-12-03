package com.telecom.gateway.billing.repository;

import com.telecom.gateway.common.model.SupportHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillingRepository extends MongoRepository<SupportHistory, String> {
}

