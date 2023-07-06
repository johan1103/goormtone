package com.goormtone.goormtoneServer.controller.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
  private String memberId;
  private Long cupStoreId;
  private String content;

  public static CommentDto ofCommentRequestAndMemberId(CommentRequestDto requestDto,String memberId){
    return new CommentDto(memberId,requestDto.getCupStoreId(),requestDto.getContent());
  }
}
