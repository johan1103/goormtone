package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.controller.detail.dto.CupStoreDetailResponseDto;
import com.goormtone.goormtoneServer.controller.detail.dto.DetailPageCommentDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreDbResult;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreListDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreRequestDto;
import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CupStoreService {
  private final CupStoreRepository cupStoreRepository;
  private final StarRatingService starRatingService;
  private final CommentService commentService;

  public CupStoreDetailResponseDto getDetail(Long cupStoreId){
    CupStore cupStore = cupStoreRepository.findById(cupStoreId).get();
    CupStoreDetailResponseDto cupStoreDetailResponseDto = buildWithoutCommentsAndRating(cupStore);

    starRatingService.setRatingInfoToDto(cupStoreDetailResponseDto,cupStoreId);
    commentService.setCommentsInfoToDto(cupStoreDetailResponseDto,cupStoreId);
    return cupStoreDetailResponseDto;
  }
  private CupStoreDetailResponseDto buildWithoutCommentsAndRating(CupStore cupStore){
    return CupStoreDetailResponseDto.builder().
            imageUrl(cupStore.getImageUrl()).
            name(cupStore.getName()).
            roadAddress(cupStore.getRoadAddressName()).
            hours(cupStore.getHours()).build();
  }
  public SearchCupStoreListDto search(SearchCupStoreRequestDto requestDto){
    Slice<Object[]> storeObjectList = cupStoreRepository.searchCupStoresInMap(requestDto.getLng(),
            requestDto.getLat(),requestDto.getSearchBoundary()
    , PageRequest.of(0,20));
    List<SearchCupStoreDbResult> cupStores = storeObjectList.map(
            objects -> new SearchCupStoreDbResult(
                    objects[0]==null ? null : ((String) objects[0]),
                    null,
                    objects[1]==null ? null : ((String) objects[1]),
                    objects[2]==null ? null : ((Long) objects[2]),
                    objects[3]==null ? null : ((Double) objects[3]),
                    objects[4]==null ? null : ((Double) objects[4]),
                    objects[5]==null ? null : ((String) objects[5]),
                    objects[6]==null ? null : ((String) objects[6]),
                    objects[7]==null ? null : ((Long) objects[7])
            )
    ).stream().toList();
    return SearchCupStoreListDto.ofSearchCupStore(cupStores);
  }

}
