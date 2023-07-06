package com.goormtone.goormtoneServer.controller.map;

import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreListDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreRequestDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MapControllerImpl implements MapController{
  @Override
  public SearchCupStoreListDto searchCupStore(SearchCupStoreRequestDto requestDto) {
    String imageUrl = "https://d12zq4w4guyljn.cloudfront.net/300_300_20221114025716561_photo_79460f6e0b30.jpg";
    SearchCupStore searchCupStore = new SearchCupStore("구름 컵 수거함기기1",3.1D, imageUrl
            ,1L,126.913409,33.4471298);
    return new SearchCupStoreListDto(List.of(searchCupStore),1);
  }
}
