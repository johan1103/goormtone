package com.goormtone.goormtoneServer.controller.organization;

import com.goormtone.goormtoneServer.controller.organization.dto.OrganizationDto;
import com.goormtone.goormtoneServer.controller.organization.dto.OrganizationListResponseDto;
import com.goormtone.goormtoneServer.controller.organization.dto.OrganizationResponse;
import com.goormtone.goormtoneServer.domain.nonProfit.NonProfitOrganization;
import com.goormtone.goormtoneServer.repository.NonProfitOrganizationRepository;
import com.goormtone.goormtoneServer.service.OrganizationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationControllerImpl {
  private final NonProfitOrganizationRepository organizationRepository;
  private final OrganizationService organizationService;
  @GetMapping
  public OrganizationResponse getOrganization(@RequestParam(value = "organizationId")Long organizationId){
    return OrganizationResponse.ofOrganization(organizationRepository.findById(organizationId).get());
  }
  @GetMapping("/list")
  public OrganizationListResponseDto getOrganizationList(){
    return organizationService.findAll();
  }
}
