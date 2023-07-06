package com.goormtone.goormtoneServer.domain.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
  @Id
  private String id;
  private Integer point;

  private Integer accumulatePoint;

  private String nickname;

  public void plusPoint(int engagePoint){
    point+=engagePoint;
    accumulatePoint+=engagePoint;
  }

  public void donation(int donationPoint){
    point-=donationPoint;
  }
}
