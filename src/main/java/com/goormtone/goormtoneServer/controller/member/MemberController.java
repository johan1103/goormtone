package com.goormtone.goormtoneServer.controller.member;

import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import com.goormtone.goormtoneServer.resolver.TokenResolver;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
  private final MemberRepository memberRepository;
  private final TokenResolver tokenResolver;
  @GetMapping
  public Member findMember(HttpServletRequest request){
    return memberRepository.findById(tokenResolver.resolveMemberIdFromToken(request.getHeader("authorization")))
            .get();
  }
}
