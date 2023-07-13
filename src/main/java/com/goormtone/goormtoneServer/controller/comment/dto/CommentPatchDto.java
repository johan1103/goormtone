package com.goormtone.goormtoneServer.controller.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentPatchDto {
    private Long commentId;
    private String content;
    private String memberId;
    public static CommentPatchDto ofCommentPatchRequestDto(CommentPatchRequestDto requestDto, String memberId){
        return CommentPatchDto.builder().commentId(requestDto.getCommentId())
                .content(requestDto.getContent())
                .memberId(memberId)
                .build();
    }
}
