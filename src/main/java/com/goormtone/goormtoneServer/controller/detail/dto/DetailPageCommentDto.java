package com.goormtone.goormtoneServer.controller.detail.dto;

import com.goormtone.goormtoneServer.domain.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetailPageCommentDto {
  String commentNickname;
  LocalDate createdAt;
  String content;

  public static DetailPageCommentDto ofComment(Comment comment){
    return new DetailPageCommentDto(comment.getCommentNickname(),comment.getCreateTime(),comment.getContent());
  }
}
