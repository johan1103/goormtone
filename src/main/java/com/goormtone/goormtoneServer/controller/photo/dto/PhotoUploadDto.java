package com.goormtone.goormtoneServer.controller.photo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoUploadDto {
  private MultipartFile file;
  private Long cupStoreId;
}
