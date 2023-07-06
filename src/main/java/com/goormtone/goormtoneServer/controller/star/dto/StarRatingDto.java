package com.goormtone.goormtoneServer.controller.star.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StarRatingDto {
  private Long cupStoreId;
  private Integer rating;
  private String memberId;

  public static StarRatingDto ofStarRatingRequestAndMemberId(StarRatingRequestDto requestDto,String memberId){
    return new StarRatingDto(requestDto.getCupStoreId(), requestDto.getRating(), memberId);
  }
}
