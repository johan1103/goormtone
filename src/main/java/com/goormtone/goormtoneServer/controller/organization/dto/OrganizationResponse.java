package com.goormtone.goormtoneServer.controller.organization.dto;

import com.goormtone.goormtoneServer.domain.nonProfit.NonProfitOrganization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationResponse {
  private String name;
  private Integer accumulatePoint;
  public static OrganizationResponse ofOrganization(NonProfitOrganization organization){
    return new OrganizationResponse(organization.getName(),organization.getPoint());
  }
}
