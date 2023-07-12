package com.goormtone.goormtoneServer.controller.star.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatingInfoDto {
    private Double averageRating;
    private Integer totalRatingPeople;
}
