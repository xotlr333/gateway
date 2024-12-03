package com.telecom.gateway.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "고객 문의 응답")
public class SupportResponse {
    @Schema(description = "문의 ID", example = "inq_123")
    private String inquiryId;
    
    @Schema(description = "처리 상태", example = "COMPLETED")
    private String status;
    
    @Schema(description = "처리 결과", example = "문의하신 내용이 접수되었습니다.")
    private String result;
    
    @Schema(description = "처리 시간")
    private LocalDateTime processedAt;
}


