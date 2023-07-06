package com.goormtone.goormtoneServer.domain.nonProfit;

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
public class NonProfitOrganization {
  @Id
  @GeneratedValue
  public Long id;
  private String name;
  private Integer point;
  private Integer maxPoint;

  public void gainPoint(int gainPoint){
    point+=gainPoint;
  }
}
