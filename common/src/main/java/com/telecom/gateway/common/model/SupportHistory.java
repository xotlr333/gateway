package com.telecom.gateway.common.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "support_history")
public class SupportHistory {
    @Id
    private String id;
    private String customerId;
    private String content;
    private String type;
    private String status;
    private String result;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;
}


