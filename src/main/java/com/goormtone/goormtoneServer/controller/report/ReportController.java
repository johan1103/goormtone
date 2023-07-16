package com.goormtone.goormtoneServer.controller.report;

import com.goormtone.goormtoneServer.controller.report.dto.ReportDto;
import com.goormtone.goormtoneServer.controller.report.dto.ReportListResponseDto;
import com.goormtone.goormtoneServer.controller.report.dto.ReportRequestDto;
import com.goormtone.goormtoneServer.controller.report.dto.ReportResponseDto;
import com.goormtone.goormtoneServer.resolver.TokenResolver;
import com.goormtone.goormtoneServer.service.ReportService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;
    @PostMapping
    public ReportResponseDto report(@RequestBody ReportRequestDto requestDto, HttpServletRequest request){
        return reportService.report(ReportDto
                .of(requestDto,TokenResolver.resolveMemberIdFromToken(request.getHeader("authorization"))));
    }
    @GetMapping("/list")
    public ReportListResponseDto getList(){
        return reportService.getList();
    }
}
