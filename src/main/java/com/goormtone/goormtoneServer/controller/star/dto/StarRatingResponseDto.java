package com.goormtone.goormtoneServer.controller.star.dto;

import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.domain.starRating.StarRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StarRatingResponseDto {
  private String memberName;
  private int rating;

  public static StarRatingResponseDto ofStarRatingDtoAndMember(StarRatingDto starRatingDto, Member member){
    return new StarRatingResponseDto(member.getNickname(),starRatingDto.getRating());
  }
}
