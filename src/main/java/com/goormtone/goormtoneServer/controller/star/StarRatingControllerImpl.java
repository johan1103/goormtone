package com.goormtone.goormtoneServer.controller.star;

import com.goormtone.goormtoneServer.controller.star.dto.StarRatingDto;
import com.goormtone.goormtoneServer.controller.star.dto.StarRatingRequestDto;
import com.goormtone.goormtoneServer.controller.star.dto.StarRatingResponseDto;
import com.goormtone.goormtoneServer.resolver.TokenResolver;
import com.goormtone.goormtoneServer.service.StarRatingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StarRatingControllerImpl implements StarRatingController{
  private final StarRatingService starRatingService;
  @Override
  public StarRatingResponseDto rating(StarRatingRequestDto requestDto, HttpServletRequest request) {
    StarRatingDto ratingDto = StarRatingDto.ofStarRatingRequestAndMemberId(requestDto
            , TokenResolver.resolveMemberIdFromToken(request.getHeader("authorization")));
    return starRatingService.rating(ratingDto);
  }
}
