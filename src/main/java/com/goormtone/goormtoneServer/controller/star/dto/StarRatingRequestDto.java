package com.goormtone.goormtoneServer.controller.star.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StarRatingRequestDto {
  private Long cupStoreId;
  private Integer rating;
}
