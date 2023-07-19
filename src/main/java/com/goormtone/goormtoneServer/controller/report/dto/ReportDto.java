package com.goormtone.goormtoneServer.controller.report.dto;

import com.goormtone.goormtoneServer.domain.report.Report;
import com.goormtone.goormtoneServer.domain.report.ReportType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private Long cupStoreId;
    private ReportType reportType;
    private String memberId;
    private LocalDateTime reportDateTime;
    private String content;
    public static ReportDto of(ReportRequestDto reportRequestDto,String memberId){
        return new ReportDtoBuilder()
                .cupStoreId(reportRequestDto.getCupStoreId())
                .reportType(reportRequestDto.getReportType())
                .memberId(memberId)
                .reportDateTime(LocalDateTime.now())
                .content(reportRequestDto.getContent())
                .build();
    }
    public static ReportDto of(Report report){
        return new ReportDtoBuilder()
                .cupStoreId(report.getCupStore().getId())
                .reportType(report.getReportType())
                .memberId(report.getMember().getId())
                .reportDateTime(report.getReportDateTime())
                .content(report.getContent())
                .build();
    }
}
