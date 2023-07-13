package com.goormtone.goormtoneServer.controller.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDeleteDto {
    private Long commentId;
    private String memberId;
    public static CommentDeleteDto ofCommentIdAndMemberId(Long commentId,String memberId){
        return CommentDeleteDto.builder()
                .commentId(commentId)
                .memberId(memberId)
                .build();
    }
}
