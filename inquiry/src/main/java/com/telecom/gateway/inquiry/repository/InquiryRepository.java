package com.telecom.gateway.inquiry.repository;

import com.telecom.gateway.common.model.SupportHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InquiryRepository extends MongoRepository<SupportHistory, String> {
}


