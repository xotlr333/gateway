// tech/src/main/java/com/telecom/gateway/tech/config/InitData.java
package com.telecom.gateway.tech.config;

import com.telecom.gateway.common.model.SupportHistory;
import com.telecom.gateway.tech.repository.TechRepository;
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
    public CommandLineRunner initTechData(TechRepository repository) {
        return args -> {
            // 기존 데이터 삭제
            repository.deleteAll();

            // 샘플 데이터 생성
            SupportHistory[] histories = {
                    SupportHistory.builder()
                            .id(UUID.randomUUID().toString())
                            .customerId("user3")
                            .content("통화 품질 저하 현상")
                            .type("TECH")
                            .status("COMPLETED")
                            .result("네트워크 점검 및 조치 완료")
                            .createdAt(LocalDateTime.now().minusDays(2))
                            .processedAt(LocalDateTime.now().minusDays(2).plusHours(2))
                            .build(),
                    SupportHistory.builder()
                            .id(UUID.randomUUID().toString())
                            .customerId("user4")
                            .content("데이터 속도 개선 요청")
                            .type("TECH")
                            .status("COMPLETED")
                            .result("기지국 최적화 작업 완료")
                            .createdAt(LocalDateTime.now().minusHours(8))
                            .processedAt(LocalDateTime.now().minusHours(6))
                            .build()
            };

            repository.saveAll(Arrays.asList(histories));
        };
    }
}