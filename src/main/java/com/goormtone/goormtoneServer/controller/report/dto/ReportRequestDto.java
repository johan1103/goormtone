package com.goormtone.goormtoneServer.controller.report.dto;

import com.goormtone.goormtoneServer.domain.report.ReportType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequestDto {
    private Long cupStoreId;
    private ReportType reportType;
    private String content;
}
