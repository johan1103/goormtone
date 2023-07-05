package com.goormtone.goormtoneServer.controller;
import com.goormtone.goormtoneServer.domain.Member.LoginRequestDto;
import com.goormtone.goormtoneServer.domain.Member.Member;
import com.goormtone.goormtoneServer.domain.Member.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OAuthController {
  @PostMapping("/api/oauth-redirect")
  public MemberDto oauthLogin(@RequestBody LoginRequestDto loginRequestDto);
  @GetMapping("/api/oauth-test")
  public Member oauth(HttpServletRequest request);
}
