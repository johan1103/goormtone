package com.goormtone.goormtoneServer.controller.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCupStoreRequestDto {
  private Double lat;
  private Double lng;
  private Double searchBoundary;
}
