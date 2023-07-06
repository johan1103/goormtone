package com.goormtone.goormtoneServer.controller.photo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {
  private String memberId;
  private MultipartFile file;
  private Long cupStoreId;

  public static PhotoDto ofPhotoUploadDto(PhotoUploadDto photoUploadDto,String memberId){
    return new PhotoDto(memberId,photoUploadDto.getFile(),photoUploadDto.getCupStoreId());
  }
}
