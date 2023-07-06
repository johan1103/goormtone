package com.goormtone.goormtoneServer.controller.map;

import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreListDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreRequestDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/map")
public interface MapController {
  @GetMapping("/search")
  public SearchCupStoreListDto searchCupStore(@RequestBody SearchCupStoreRequestDto requestDto);
}
