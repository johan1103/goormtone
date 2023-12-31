package com.goormtone.goormtoneServer.domain.cupstore;

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
public class CupStoreGroup {
  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private Integer gagePoint;
}
