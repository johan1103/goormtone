package com.goormtone.goormtoneServer.controller.organization;

import com.goormtone.goormtoneServer.controller.organization.dto.OrganizationResponse;
import com.goormtone.goormtoneServer.repository.NonProfitOrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationControllerImpl {
  private final NonProfitOrganizationRepository organizationRepository;
  @GetMapping
  public OrganizationResponse getOrganization(@RequestParam(value = "organizationId")Long organizationId){
    return OrganizationResponse.ofOrganization(organizationRepository.findById(organizationId).get());
  }
}
