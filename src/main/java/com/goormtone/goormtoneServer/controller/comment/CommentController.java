package com.goormtone.goormtoneServer.controller.comment;

import com.goormtone.goormtoneServer.controller.comment.dto.CommentRequestDto;
import com.goormtone.goormtoneServer.controller.comment.dto.CommentResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public interface CommentController {
  @PostMapping
  public CommentResponseDto comment(@RequestBody CommentRequestDto requestDto, HttpServletRequest request);
}
