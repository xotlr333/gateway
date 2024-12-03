package com.telecom.gateway.tech.controller;

import com.telecom.gateway.common.dto.SupportRequest;
import com.telecom.gateway.common.dto.SupportResponse;
import com.telecom.gateway.common.model.SupportHistory;
import com.telecom.gateway.tech.repository.TechRepository;
import com.telecom.gateway.tech.service.TechService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tech")
@RequiredArgsConstructor
@Tag(name = "기술문의 API", description = "기술문의 접수 및 처리")
public class TechController {
    private final TechService techService;
    private final TechRepository techRepository;

    @Operation(summary = "기술문의 접수", description = "고객의 기술문의를 접수합니다.")
    @PostMapping
    public ResponseEntity<SupportResponse> createTechSupport(@RequestBody SupportRequest request) {
        return ResponseEntity.ok(techService.processTechSupport(request));
    }

    @Operation(summary = "문의 조회", description = "문의 내역을 조회합니다.")
    @GetMapping("/{inquiryId}")
    public ResponseEntity<SupportHistory> getTechSupport(@PathVariable String inquiryId) {
        return ResponseEntity.ok(techService.getTechSupport(inquiryId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SupportHistory>> getAll() {
        return ResponseEntity.ok(techRepository.findAll());
    }
}


