package com.goormtone.goormtoneServer.controller.comment;

import com.goormtone.goormtoneServer.controller.comment.dto.*;
import com.goormtone.goormtoneServer.resolver.TokenResolver;
import com.goormtone.goormtoneServer.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController{
  private final CommentService commentService;
  @Override
  public CommentResponseDto comment(CommentRequestDto requestDto, HttpServletRequest request) {
    CommentDto commentDto = CommentDto.ofCommentRequestAndMemberId(requestDto,
            TokenResolver.resolveMemberIdFromToken(request.getHeader("authorization")));
    return commentService.comment(commentDto);
  }

  @Override
  public CommentDeleteResponseDto deleteComment(Long commentId, HttpServletRequest request) {
    return commentService.delete(CommentDeleteDto.ofCommentIdAndMemberId(commentId,
            TokenResolver.resolveMemberIdFromToken(request.getHeader("authorization"))));
  }

  @Override
  public CommentPatchResponseDto updateComment(CommentPatchRequestDto requestDto, HttpServletRequest request) {
    return commentService.update(CommentPatchDto.ofCommentPatchRequestDto(requestDto,
            TokenResolver.resolveMemberIdFromToken(request.getHeader("authorization"))));
  }
}
