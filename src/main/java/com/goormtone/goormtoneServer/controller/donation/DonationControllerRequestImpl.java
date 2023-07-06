package com.goormtone.goormtoneServer.controller.donation;

import com.goormtone.goormtoneServer.controller.donation.dto.DonationDto;
import com.goormtone.goormtoneServer.controller.donation.dto.DonationRequestDto;
import com.goormtone.goormtoneServer.controller.donation.dto.DonationResponseDto;
import com.goormtone.goormtoneServer.resolver.TokenResolver;
import com.goormtone.goormtoneServer.service.DonationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DonationControllerRequestImpl implements DonationController{
  private final TokenResolver resolver;
  private final DonationService donationService;
  @Override
  public DonationResponseDto donate(DonationRequestDto requestDto, HttpServletRequest request) {
    String memberId = resolver.resolveMemberIdFromToken(request.getHeader("authorization"));
    return donationService.donate(DonationDto.ofDonationRequestDtoAndMemberId(requestDto, memberId));
  }
}
