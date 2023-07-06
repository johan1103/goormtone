package com.goormtone.goormtoneServer.controller.donation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonationRequestDto {
  private Integer donationPoint;
  private Long organizationId;
}
