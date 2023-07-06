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
  private String file;
  private Long cupStoreId;
}
