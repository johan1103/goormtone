package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.controller.donation.dto.DonationDto;
import com.goormtone.goormtoneServer.controller.donation.dto.DonationRequestDto;
import com.goormtone.goormtoneServer.controller.donation.dto.DonationResponseDto;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.domain.nonProfit.NonProfitOrganization;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import com.goormtone.goormtoneServer.repository.NonProfitOrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DonationService {
  private final NonProfitOrganizationRepository nonProfitOrganizationRepository;
  private final MemberRepository memberRepository;

  public DonationResponseDto donate(DonationDto donationDto){
    Member member = memberRepository.findById(donationDto.getMemberId()).get();
    NonProfitOrganization organization = nonProfitOrganizationRepository
            .findById(donationDto.getNonprofitOrganizationId()).get();
    member.donation(donationDto.getDonationPoint());
    organization.gainPoint(donationDto.getDonationPoint());
    return DonationResponseDto.ofOrganization(organization);
  }
}
