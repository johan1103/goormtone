package com.goormtone.goormtoneServer.domain.Member;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.geolatte.geom.M;

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
