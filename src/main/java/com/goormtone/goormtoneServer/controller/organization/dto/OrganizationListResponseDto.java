package com.goormtone.goormtoneServer.controller.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationListResponseDto {
    private List<OrganizationDto> organizations;
    private Integer size;

    public static OrganizationListResponseDto ofOrganizationDto(List<OrganizationDto> organizationDtos){
        return new OrganizationListResponseDto(organizationDtos,organizationDtos.size());
    }
}
