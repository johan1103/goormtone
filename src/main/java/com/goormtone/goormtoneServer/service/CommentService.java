package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.controller.comment.dto.*;
import com.goormtone.goormtoneServer.controller.detail.dto.CupStoreDetailResponseDto;
import com.goormtone.goormtoneServer.controller.detail.dto.DetailPageCommentDto;
import com.goormtone.goormtoneServer.domain.comment.Comment;
import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.repository.CommentRepository;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
  private final CommentRepository commentRepository;
  private final CupStoreRepository cupStoreRepository;
  private final MemberRepository memberRepository;

  public CommentResponseDto comment(CommentDto commentDto){
    Optional<CupStore> cupStore = cupStoreRepository.findById(commentDto.getCupStoreId());
    Optional<Member> member = memberRepository.findById(commentDto.getMemberId());
    if(member.isEmpty()||cupStore.isEmpty())
      throw new HttpClientErrorException(HttpStatusCode.valueOf(404));
    Comment comment = commentRepository.save(new Comment(null, commentDto.getContent(), member.get(),cupStore.get(),
            LocalDateTime.now(),createCommentNickname(member.get())));
    return CommentResponseDto.ofComment(comment);
  }

  public void setCommentsInfoToDto(CupStoreDetailResponseDto dto, Long cupStoreId){
    List<Comment> comments = commentRepository
            .getCommentsByCupStoreId(cupStoreId, PageRequest.of(0, 10)).getContent().stream().toList();
    List<DetailPageCommentDto> detailPageComments = commentToDetailPageCommentDto(comments);
    dto.setComments(detailPageComments);
    dto.setTotalComments(detailPageComments.size());
  }

  public CommentDeleteResponseDto delete(CommentDeleteDto dto){
    Optional<Comment> comment = commentRepository.findById(dto.getCommentId());
    if(comment.isEmpty())
      throw new HttpClientErrorException(HttpStatusCode.valueOf(404));
    if(Objects.equals(comment.get().getMember().getId(), dto.getMemberId()))
        commentRepository.delete(comment.get());
    return new CommentDeleteResponseDto(dto.getCommentId());
  }

  public CommentPatchResponseDto update(CommentPatchDto dto){
    Optional<Comment> comment = commentRepository.findById(dto.getCommentId());
    if(comment.isEmpty())
      throw new HttpClientErrorException(HttpStatusCode.valueOf(404));
    if(Objects.equals(comment.get().getMember().getId(),dto.getMemberId()))
      changeComment(comment.get(),dto);
    return new CommentPatchResponseDto(dto.getCommentId(), dto.getContent());
  }
  private void changeComment(Comment comment, CommentPatchDto dto){
    comment.updateComment(dto.getContent());
  }
  private List<DetailPageCommentDto> commentToDetailPageCommentDto(List<Comment> comments){
    List<DetailPageCommentDto> detailPageComments = new ArrayList<>();
    for(Comment comment : comments){
      detailPageComments.add(DetailPageCommentDto.ofComment(comment));
    }
    return detailPageComments;
  }
  private String createCommentNickname(Member member){
    return member.getNickname()+"_"+member.getId();
  }

}
