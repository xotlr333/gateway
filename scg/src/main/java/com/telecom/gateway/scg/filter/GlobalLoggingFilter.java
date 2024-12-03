// File: gateway/scg/src/main/java/com/telecom/gateway/scg/filter/GlobalLoggingFilter.java
package com.telecom.gateway.scg.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class GlobalLoggingFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        // 요청 로깅
        log.info("====== Request Logging ======");
        log.info("Request ID: {}", request.getId());
        log.info("Method: {}", request.getMethod());
        log.info("Path: {}", request.getPath());
        log.info("Headers: {}", request.getHeaders());

        // response-time 측정을 위한 시작 시간
        long startTime = System.currentTimeMillis();

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    ServerHttpResponse response = exchange.getResponse();

                    // 응답 로깅
                    log.info("====== Response Logging ======");
                    log.info("Request ID: {}", request.getId());
                    log.info("Status Code: {}", response.getStatusCode());
                    log.info("Headers: {}", response.getHeaders());
                    log.info("Response Time: {}ms", System.currentTimeMillis() - startTime);
                }));
    }

    @Override
    public int getOrder() {
        // 필터 체인에서 가장 먼저 실행되도록 높은 우선순위 부여
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
