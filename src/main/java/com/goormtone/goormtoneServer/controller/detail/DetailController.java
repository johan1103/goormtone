package com.goormtone.goormtoneServer.controller.detail;

import com.goormtone.goormtoneServer.controller.detail.dto.CupStoreDetailResponseDto;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detail")
public interface DetailController {

  @GetMapping
  public CupStoreDetailResponseDto getDetail(@RequestParam(value = "cupStoreId") Long cupStoreId);
}
