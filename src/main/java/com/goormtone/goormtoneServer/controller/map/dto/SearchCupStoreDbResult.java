package com.goormtone.goormtoneServer.controller.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCupStoreDbResult {
  private String name;
  private Double starRating;
  private String imageUrl;
  private Long cupStoreId;
  private Double lat;
  private Double lng;
  private String hours;
  private String groupName;
  private Long groupId;
}
