package com.telecom.gateway.billing.controller;

import com.telecom.gateway.billing.repository.BillingRepository;
import com.telecom.gateway.common.dto.SupportRequest;
import com.telecom.gateway.common.dto.SupportResponse;
import com.telecom.gateway.common.model.SupportHistory;
import com.telecom.gateway.billing.service.BillingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
@RequiredArgsConstructor
@Tag(name = "요금문의 API", description = "요금문의 접수 및 처리")
public class BillingController {
    private final BillingService billingService;
    private final BillingRepository billingRepository;

    @Operation(summary = "요금문의 접수", description = "고객의 요금문의를 접수합니다.")
    @PostMapping
    public ResponseEntity<SupportResponse> createBillingSupport(@RequestBody SupportRequest request) {
        return ResponseEntity.ok(billingService.processBillingSupport(request));
    }

    @Operation(summary = "문의 조회", description = "문의 내역을 조회합니다.")
    @GetMapping("/{inquiryId}")
    public ResponseEntity<SupportHistory> getBillingSupport(@PathVariable String inquiryId) {
        return ResponseEntity.ok(billingService.getBillingSupport(inquiryId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SupportHistory>> getAll() {
        return ResponseEntity.ok(billingRepository.findAll());
    }
}

