package com.goormtone.goormtoneServer.controller.photo.dto;

import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberPointAccumulateDto {
  private String cupStoreName;
  private String memberNickname;
  private Integer memberAccumulatedPoint;
  private Integer memberPoint;
  private Integer gainPoint;
  public static MemberPointAccumulateDto ofMemberAndCupStore(Member member, CupStore cupStore){
    return new MemberPointAccumulateDto(cupStore.getName(),
            member.getNickname(),member.getAccumulatePoint(),member.getPoint(),cupStore.getGroup().getGagePoint());
  }
}
