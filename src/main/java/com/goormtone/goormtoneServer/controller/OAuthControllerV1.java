package com.goormtone.goormtoneServer.controller;

import com.goormtone.goormtoneServer.domain.Member.LoginRequestDto;
import com.goormtone.goormtoneServer.domain.Member.Member;
import com.goormtone.goormtoneServer.domain.Member.MemberDto;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import com.goormtone.goormtoneServer.resolver.TokenResolver;
import com.goormtone.goormtoneServer.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OAuthControllerV1 implements OAuthController{
  private final MemberService memberService;
  private final MemberRepository memberRepository;
  private final TokenResolver resolver;

  @Override
  public MemberDto oauthLogin(@RequestBody LoginRequestDto loginRequestDto) {
    return memberService.login(loginRequestDto);
  }

  @Override
  public Member oauth(HttpServletRequest request) {
    String token = resolveToken(request);
    String id = resolver.resolveMemberIdFromToken(token);
    Optional<Member> member = memberRepository.findById(id);
    return member.get();
  }

  private String resolveToken(HttpServletRequest request){
    return request.getHeader("authorization");
  }
}
