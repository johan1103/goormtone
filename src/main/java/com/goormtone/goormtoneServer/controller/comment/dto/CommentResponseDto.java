package com.goormtone.goormtoneServer.controller.comment.dto;

import com.goormtone.goormtoneServer.domain.comment.Comment;
import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
  public String cupStoreName;
  public String content;
  public LocalDate createTime;
  public String commentNickname;
  public static CommentResponseDto ofComment(Comment comment){
    return new CommentResponseDto(comment.getCupStore().getName(),comment.getContent(),
            comment.getCreateTime(),comment.getCommentNickname());
  }
}
