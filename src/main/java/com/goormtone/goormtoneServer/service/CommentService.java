package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.controller.comment.dto.CommentDto;
import com.goormtone.goormtoneServer.controller.comment.dto.CommentRequestDto;
import com.goormtone.goormtoneServer.controller.comment.dto.CommentResponseDto;
import com.goormtone.goormtoneServer.domain.comment.Comment;
import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.repository.CommentRepository;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

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
    Comment comment = commentRepository.save(new Comment(null, commentDto.getContent(), member.get(),cupStore.get(),
            LocalDate.now(),createCommentNickname(member.get())));
    return CommentResponseDto.ofComment(comment);
  }
  private String createCommentNickname(Member member){
    return member.getNickname()+"_"+member.getId();
  }

}
