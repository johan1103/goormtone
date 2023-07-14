package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.controller.organization.dto.OrganizationDto;
import com.goormtone.goormtoneServer.controller.organization.dto.OrganizationListResponseDto;
import com.goormtone.goormtoneServer.domain.nonProfit.NonProfitOrganization;
import com.goormtone.goormtoneServer.repository.NonProfitOrganizationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrganizationService {
    private final NonProfitOrganizationRepository organizationRepository;
    public OrganizationListResponseDto findAll(){
        //stream으로 바꿔보기
        List<OrganizationDto> organizationDtos = new ArrayList<>();
        List<NonProfitOrganization> organizations = organizationRepository.findAll();
        for (NonProfitOrganization organization : organizations){
            organizationDtos.add(OrganizationDto.ofOrganization(organization));
        }
        return OrganizationListResponseDto.ofOrganizationDto(organizationDtos);
    }
}
