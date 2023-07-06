package com.goormtone.goormtoneServer.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class TokenAuthorizationInterceptor implements HandlerInterceptor {
  private static final String secretValue = "goorm";
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if(request.getMethod().equals("OPTIONS"))
      return HandlerInterceptor.super.preHandle(request, response, handler);
    String token = request.getHeader("authorization");
    System.out.println(request.getHeader("authorization"));
    if(validateToken(token))
      return HandlerInterceptor.super.preHandle(request, response, handler);
    else
      return false;
  }

  private boolean validateToken(String token){
    int idx=findAndIdx(token);
    String tmp = token.substring(0, idx-1);
    int hashCode = Integer.parseInt(tmp);
    String memberId = token.substring(idx);
    int originalHashcode = (memberId+secretValue).hashCode();
    return hashCode == originalHashcode;
  }
  private int findAndIdx(String token){
    for(int i=0;i<token.length();i++){
      if(token.charAt(i)=='&')
        return i+1;
    }
    return 0;
  }
}
