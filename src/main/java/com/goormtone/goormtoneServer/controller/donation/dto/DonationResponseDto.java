package com.goormtone.goormtoneServer.controller.donation.dto;

import com.goormtone.goormtoneServer.domain.nonProfit.NonProfitOrganization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonationResponseDto {
  private String name;
  private Integer accumulatePoints;

  public static DonationResponseDto ofOrganization(NonProfitOrganization organization){
    return new DonationResponseDto(organization.getName(),organization.getPoint());
  }
}
