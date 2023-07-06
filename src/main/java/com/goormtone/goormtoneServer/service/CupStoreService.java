package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStore;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreListDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreRequestDto;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CupStoreService {
  private final CupStoreRepository cupStoreRepository;
  public SearchCupStoreListDto search(SearchCupStoreRequestDto requestDto){
    Slice<Object[]> storeObjectList = cupStoreRepository.searchCupStoresInMap(requestDto.getLng(),
            requestDto.getLat(),requestDto.getSearchBoundary()
    , PageRequest.of(0,20));
    List<SearchCupStore> cupStores = storeObjectList.map(
            objects -> new SearchCupStore(
                    objects[0]==null ? null : ((String) objects[0]),
                    null,
                    objects[1]==null ? null : ((String) objects[1]),
                    objects[2]==null ? null : ((Long) objects[2]),
                    objects[3]==null ? null : ((Double) objects[3]),
                    objects[4]==null ? null : ((Double) objects[4])
            )
    ).stream().toList();
    return SearchCupStoreListDto.ofSearchCupStore(cupStores);
  }

}
