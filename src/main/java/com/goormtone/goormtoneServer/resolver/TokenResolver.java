package com.goormtone.goormtoneServer.resolver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenResolver {
  public static String resolveMemberIdFromToken(String token){
    int idx=findAndIdx(token);
    return token.substring(idx);
  }

  private static int findAndIdx(String token){
    for(int i=0;i<token.length();i++){
      if(token.charAt(i)=='&')
        return i+1;
    }
    return 0;
  }
}
