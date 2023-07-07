package com.goormtone.goormtoneServer.controller.oauth.dto;

import com.goormtone.goormtoneServer.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRenameDto {
  private String id;
  private Integer point;
  private Integer accumulatePoint;
  private String nickname;

  public static MemberRenameDto ofMember(Member member){
    return new MemberRenameDto(member.getId(), member.getPoint(),
            member.getAccumulatePoint()-member.getPoint(), member.getNickname());
  }
}
