package com.goormtone.goormtoneServer.controller.comment;

import com.goormtone.goormtoneServer.controller.comment.dto.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public interface CommentController {
  @PostMapping
  public CommentResponseDto comment(@RequestBody CommentRequestDto requestDto, HttpServletRequest request);

  @DeleteMapping
  public CommentDeleteResponseDto deleteComment(@RequestParam(value = "commentId") Long commentId, HttpServletRequest request);

  @PatchMapping
  public CommentPatchResponseDto updateComment(@RequestBody CommentPatchRequestDto requestDto, HttpServletRequest request);
}
