package com.goormtone.goormtoneServer.controller.donation;

import com.goormtone.goormtoneServer.controller.donation.dto.DonationRequestDto;
import com.goormtone.goormtoneServer.controller.donation.dto.DonationResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donation")
public interface DonationController {
  @PostMapping
  public DonationResponseDto donate(@RequestBody DonationRequestDto requestDto, HttpServletRequest request);
}
