package com.goormtone.goormtoneServer.controller.photo;

import com.goormtone.goormtoneServer.controller.photo.dto.MemberPointAccumulateDto;
import com.goormtone.goormtoneServer.controller.photo.dto.PhotoUploadDto;
import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.LoginRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PhotoUploadController {
  @PostMapping("/upload-image")
  public MemberPointAccumulateDto upload(@RequestBody PhotoUploadDto uploadDto, HttpServletRequest request);
}
