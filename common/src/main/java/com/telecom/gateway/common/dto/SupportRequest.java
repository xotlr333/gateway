package com.telecom.gateway.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "고객 문의 요청")
public class SupportRequest {
    @Schema(description = "고객 ID", example = "user123")
    private String customerId;
    
    @Schema(description = "문의 내용", example = "5G 요금제 관련 문의드립니다.")
    private String content;
    
    @Schema(description = "문의 유형", example = "GENERAL")
    private String type;
}


