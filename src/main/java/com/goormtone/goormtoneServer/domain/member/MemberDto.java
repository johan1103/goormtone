package com.goormtone.goormtoneServer.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

  private String id;

  private Integer point;

  private Integer accumulatePoint;

  private String nickname;
  private String token;

  public static MemberDto ofMemberAndToken(Member member,String token){
    return new MemberDto(member.getId(),member.getPoint(),member.getAccumulatePoint(),member.getNickname(),token);
  }
}
