package com.goormtone.goormtoneServer.controller.report.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportListResponseDto {
    private List<ReportDto> reports;
    private Integer size;

    public static ReportListResponseDto ofReportDto(List<ReportDto> reports){
        return new ReportListResponseDto(reports,reports.size());
    }
}
