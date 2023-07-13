package com.goormtone.goormtoneServer.controller.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDeleteResponseDto {
    private Long deletedCommentId;
}
