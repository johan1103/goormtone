package com.goormtone.goormtoneServer.controller.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCupStore {
  private String name;
  private Double starRating;
  private String imageUrl;
  private Long cupStoreId;
  private Double lng;
  private Double lat;

}
