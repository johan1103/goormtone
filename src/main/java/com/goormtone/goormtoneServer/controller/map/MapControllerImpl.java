package com.goormtone.goormtoneServer.controller.map;

import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreListDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreRequestDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStore;
import com.goormtone.goormtoneServer.service.CupStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MapControllerImpl implements MapController{
  private final CupStoreService cupStoreService;
  @Override
  public SearchCupStoreListDto searchCupStore(SearchCupStoreRequestDto requestDto) {
    return cupStoreService.search(requestDto);
  }
}
