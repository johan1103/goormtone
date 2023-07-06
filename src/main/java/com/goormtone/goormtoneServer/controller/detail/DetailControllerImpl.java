package com.goormtone.goormtoneServer.controller.detail;

import com.goormtone.goormtoneServer.controller.detail.dto.CupStoreDetailResponseDto;
import com.goormtone.goormtoneServer.service.CupStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DetailControllerImpl implements DetailController{
  private final CupStoreService cupStoreService;
  @Override
  public CupStoreDetailResponseDto getDetail(Long cupStoreId) {
    return cupStoreService.getDetail(cupStoreId);
  }
}
