package com.goormtone.goormtoneServer.controller.detail.dto;

import com.goormtone.goormtoneServer.domain.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetailPageCommentDto {
  private String commentNickname;
  private String memberId;
  private LocalDateTime createdAt;
  private String content;
  private Long commentId;

  public static DetailPageCommentDto ofComment(Comment comment){
    return new DetailPageCommentDto(comment.getCommentNickname(),comment.getMember().getId(),comment.getCreateTime(),comment.getContent(),comment.getId());
  }
}
