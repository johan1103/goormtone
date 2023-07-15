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
public class ReportResponseDto {
    private Long id;
    private String memberId;
    private Long cupStoreId;
    private ReportType reportType;
    private LocalDateTime reportDateTime;

    public static ReportResponseDto ofReport(Report report){
        return new ReportResponseDtoBuilder()
                .id(report.getId())
                .memberId(report.getMember().getId())
                .cupStoreId(report.getCupStore().getId())
                .reportType(report.getReportType())
                .reportDateTime(report.getReportDateTime())
                .build();
    }
}
