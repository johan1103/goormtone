package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.controller.report.dto.ReportDto;
import com.goormtone.goormtoneServer.controller.report.dto.ReportListResponseDto;
import com.goormtone.goormtoneServer.controller.report.dto.ReportResponseDto;
import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.domain.report.Report;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import com.goormtone.goormtoneServer.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportService {
    private final ReportRepository reportRepository;
    private final MemberRepository memberRepository;
    private final CupStoreRepository cupStoreRepository;
    public ReportResponseDto report(ReportDto reportDto){
        Optional<Member> findMember = memberRepository.findById(reportDto.getMemberId());
        Optional<CupStore> findCupStore = cupStoreRepository.findById(reportDto.getCupStoreId());
        Report newReport = reportRepository.save(new Report(null,findMember.get(),findCupStore.get()
                ,reportDto.getReportType(),reportDto.getReportDateTime(),reportDto.getContent()));
        return ReportResponseDto.ofReport(newReport);
    }
    public ReportListResponseDto getList(){
        List<ReportDto> reportDtos = reportRepository.findAll()
                .stream().map(ReportDto::of).collect(Collectors.toList());
        return ReportListResponseDto.ofReportDto(reportDtos);
    }
}
