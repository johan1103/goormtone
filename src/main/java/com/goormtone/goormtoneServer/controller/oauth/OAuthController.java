package com.goormtone.goormtoneServer.controller.oauth;
import com.goormtone.goormtoneServer.controller.oauth.dto.MemberRenameDto;
import com.goormtone.goormtoneServer.domain.member.LoginRequestDto;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.domain.member.MemberDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OAuthController {
  @PostMapping("/oauth-redirect")
  public MemberDto oauthLogin(@RequestBody LoginRequestDto loginRequestDto);
  @GetMapping("/oauth-test")
  public MemberRenameDto oauth(HttpServletRequest request);
}
