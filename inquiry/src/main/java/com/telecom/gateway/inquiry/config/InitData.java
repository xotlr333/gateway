// inquiry/src/main/java/com/telecom/gateway/inquiry/config/InitData.java
package com.telecom.gateway.inquiry.config;

import com.telecom.gateway.common.model.SupportHistory;
import com.telecom.gateway.inquiry.repository.InquiryRepository;
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
    public CommandLineRunner initInquiryData(InquiryRepository repository) {
        return args -> {
            // 기존 데이터 삭제
            repository.deleteAll();

            // 샘플 데이터 생성
            SupportHistory[] histories = {
                    SupportHistory.builder()
                            .id(UUID.randomUUID().toString())
                            .customerId("user1")
                            .content("5G 요금제 문의")
                            .type("INQUIRY")
                            .status("COMPLETED")
                            .result("5G 요금제에 대한 상세 설명 제공 완료")
                            .createdAt(LocalDateTime.now().minusDays(1))
                            .processedAt(LocalDateTime.now().minusDays(1).plusHours(1))
                            .build(),
                    SupportHistory.builder()
                            .id(UUID.randomUUID().toString())
                            .customerId("user2")
                            .content("부가서비스 신청 방법")
                            .type("INQUIRY")
                            .status("COMPLETED")
                            .result("부가서비스 신청 절차 안내 완료")
                            .createdAt(LocalDateTime.now().minusHours(5))
                            .processedAt(LocalDateTime.now().minusHours(4))
                            .build()
            };

            repository.saveAll(Arrays.asList(histories));
        };
    }
}