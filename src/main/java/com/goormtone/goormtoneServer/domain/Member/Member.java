package com.goormtone.goormtoneServer.domain.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
}
