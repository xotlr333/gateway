package com.telecom.gateway.inquiry.controller;

import com.telecom.gateway.common.dto.SupportRequest;
import com.telecom.gateway.common.dto.SupportResponse;
import com.telecom.gateway.common.model.SupportHistory;
import com.telecom.gateway.inquiry.repository.InquiryRepository;
import com.telecom.gateway.inquiry.service.InquiryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
@Tag(name = "일반문의 API", description = "일반문의 접수 및 처리")
public class InquiryController {
    private final InquiryService inquiryService;
    private final InquiryRepository inquiryRepository;

    @Operation(summary = "일반문의 접수", description = "고객의 일반문의를 접수합니다.")
    @PostMapping
    public ResponseEntity<SupportResponse> createInquiry(@RequestBody SupportRequest request) {
        return ResponseEntity.ok(inquiryService.processInquiry(request));
    }

    @Operation(summary = "문의 조회", description = "문의 내역을 조회합니다.")
    @GetMapping("/{inquiryId}")
    public ResponseEntity<SupportHistory> getInquiry(@PathVariable String inquiryId) {
        return ResponseEntity.ok(inquiryService.getInquiry(inquiryId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SupportHistory>> getAll() {
        return ResponseEntity.ok(inquiryRepository.findAll());
    }
}


