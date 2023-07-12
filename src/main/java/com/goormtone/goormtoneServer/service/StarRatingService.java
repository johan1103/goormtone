package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.controller.detail.dto.CupStoreDetailResponseDto;
import com.goormtone.goormtoneServer.controller.star.dto.RatingInfoDto;
import com.goormtone.goormtoneServer.controller.star.dto.StarRatingDto;
import com.goormtone.goormtoneServer.controller.star.dto.StarRatingResponseDto;
import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.domain.starRating.StarRating;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import com.goormtone.goormtoneServer.repository.StarRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StarRatingService {
  private final StarRatingRepository starRatingRepository;
  private final MemberRepository memberRepository;
  private final CupStoreRepository cupStoreRepository;

  public StarRatingResponseDto rating(StarRatingDto starRatingDto){
    Optional<CupStore> cupStore = cupStoreRepository.findById(starRatingDto.getCupStoreId());
    Optional<Member> member = memberRepository.findById(starRatingDto.getMemberId());
    Optional<StarRating> findStarRating = starRatingRepository.findStarRatingByMemberIdAndCupStoreId(
            starRatingDto.getMemberId(),starRatingDto.getCupStoreId());
    StarRating starRating = findStarRating.orElseGet(()
            -> starRatingRepository.save(new StarRating(null, null, cupStore.get(), member.get())));
    starRating.setRating(starRatingDto.getRating());

    RatingInfoDto ratingInfoDto = new RatingInfoDto();
    setRatingInfoToDto(ratingInfoDto,starRatingDto.getCupStoreId());

    return StarRatingResponseDto.ofStarRatingDtoAndMember(starRatingDto,ratingInfoDto,member.get());
  }

  private void setRatingInfoToDto(RatingInfoDto ratingInfoDto,Long cupStoreId){
    List<StarRating> starRatings = getStarRating(cupStoreId);
    ratingInfoDto.setAverageRating(getRatingAverage(starRatings));
    ratingInfoDto.setTotalRatingPeople(starRatings.size());
  }

  public void setRatingInfoToDto(CupStoreDetailResponseDto responseDto,Long cupStoreId){
    List<StarRating> starRatings = getStarRating(cupStoreId);
    responseDto.setAverageRating(getRatingAverage(starRatings));
    responseDto.setTotalRatingPeople(starRatings.size());
  }
  private Double getRatingAverage(List<StarRating> starRatings){
    Double averageRating = 0D;
    for(StarRating starRating : starRatings){
      averageRating+=starRating.getRating();
    }
    averageRating/=(starRatings.size()==0?1:starRatings.size());
    return averageRating;
  }
  private List<StarRating> getStarRating(Long cupStoreId){
    return starRatingRepository.findStarRatingsByCupStoreId(cupStoreId);
  }

  private RatingInfoDto
}
