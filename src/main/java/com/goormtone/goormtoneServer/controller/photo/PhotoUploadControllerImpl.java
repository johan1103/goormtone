package com.goormtone.goormtoneServer.controller.photo;

import com.goormtone.goormtoneServer.controller.photo.dto.MemberPointAccumulateDto;
import com.goormtone.goormtoneServer.controller.photo.dto.PhotoDto;
import com.goormtone.goormtoneServer.controller.photo.dto.PhotoUploadDto;
import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.LoginRequestDto;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import com.goormtone.goormtoneServer.resolver.TokenResolver;
import com.goormtone.goormtoneServer.service.PhotoUploadService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PhotoUploadControllerImpl implements PhotoUploadController{
  private final PhotoUploadService photoUploadService;
  private final TokenResolver resolver;
  @Override
  public MemberPointAccumulateDto upload(PhotoUploadDto uploadDto, HttpServletRequest request) {
    PhotoDto photoDto = PhotoDto.ofPhotoUploadDto(uploadDto,
            resolver.resolveMemberIdFromToken(request.getHeader("authorization")));
    return photoUploadService.upload(photoDto);
  }
}
