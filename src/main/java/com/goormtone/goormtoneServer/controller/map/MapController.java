package com.goormtone.goormtoneServer.controller.map;

import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreListDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStoreRequestDto;
import com.goormtone.goormtoneServer.controller.map.dto.SearchCupStore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
public interface MapController {
  @GetMapping("/search")
  public SearchCupStoreListDto searchCupStore(@RequestParam("lat")Double latitude,
                                              @RequestParam("lng")Double longitude,
                                              @RequestParam("searchBoundary")Double boundary);
}
