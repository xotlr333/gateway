package com.telecom.gateway.tech.repository;

import com.telecom.gateway.common.model.SupportHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TechRepository extends MongoRepository<SupportHistory, String> {
}


