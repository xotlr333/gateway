// billing/src/main/java/com/telecom/gateway/billing/config/InitData.java
package com.telecom.gateway.billing.config;

import com.telecom.gateway.common.model.SupportHistory;
import com.telecom.gateway.billing.repository.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class InitData {

    @Bean
    public CommandLineRunner initBillingData(BillingRepository repository) {
        return args -> {
            // 기존 데이터 삭제
            repository.deleteAll();

            // 샘플 데이터 생성
            SupportHistory[] histories = {
                    SupportHistory.builder()
                            .id(UUID.randomUUID().toString())
                            .customerId("user5")
                            .content("청구서 문의")
                            .type("BILLING")
                            .status("COMPLETED")
                            .result("청구 내역 상세 설명 완료")
                            .createdAt(LocalDateTime.now().minusDays(3))
                            .processedAt(LocalDateTime.now().minusDays(3).plusHours(1))
                            .build(),
                    SupportHistory.builder()
                            .id(UUID.randomUUID().toString())
                            .customerId("user6")
                            .content("자동이체 신청 방법")
                            .type("BILLING")
                            .status("COMPLETED")
                            .result("자동이체 신청 절차 안내 완료")
                            .createdAt(LocalDateTime.now().minusHours(12))
                            .processedAt(LocalDateTime.now().minusHours(11))
                            .build()
            };

            repository.saveAll(Arrays.asList(histories));
        };
    }
}