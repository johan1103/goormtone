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
  private Double averageRating;
  private Integer totalRatingPeople;

  public static StarRatingResponseDto ofStarRatingDtoAndMember(StarRatingDto starRatingDto, RatingInfoDto ratingInfoDto ,Member member){
    return new StarRatingResponseDto(member.getNickname(),
            starRatingDto.getRating(),
            ratingInfoDto.getAverageRating(),
            ratingInfoDto.getTotalRatingPeople()
            );
  }
}
