package com.goormtone.goormtoneServer.controller.star;

import com.goormtone.goormtoneServer.controller.star.dto.StarRatingRequestDto;
import com.goormtone.goormtoneServer.controller.star.dto.StarRatingResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public interface StarRatingController {
  @PostMapping
  public StarRatingResponseDto rating(@RequestBody StarRatingRequestDto requestDto, HttpServletRequest request);
}
