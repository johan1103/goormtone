package com.goormtone.goormtoneServer.controller.organization.dto;

import com.goormtone.goormtoneServer.domain.nonProfit.NonProfitOrganization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationResponse {
  private String name;
  private String description;
  private LocalDate start;
  private LocalDate end;
  private Integer point;
  private Integer maxPoint;
  public static OrganizationResponse ofOrganization(NonProfitOrganization organization){
    return new OrganizationResponseBuilder()
            .name(organization.getName())
            .description(organization.getDescription())
            .start(organization.getStartDate())
            .end(organization.getEndDate())
            .point(organization.getPoint())
            .maxPoint(organization.getMaxPoint())
            .build();
  }
}
