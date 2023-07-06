package com.goormtone.goormtoneServer.controller.donation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DonationDto {
  private String memberId;
  private Long nonprofitOrganizationId;
  private Integer donationPoint;

  public static DonationDto ofDonationRequestDtoAndMemberId(DonationRequestDto donationRequestDto, String memberId){
    return new DonationDto(memberId, donationRequestDto.getOrganizationId(), donationRequestDto.getDonationPoint());
  }
}
