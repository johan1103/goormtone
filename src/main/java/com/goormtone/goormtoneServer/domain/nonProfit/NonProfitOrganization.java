package com.goormtone.goormtoneServer.domain.nonProfit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NonProfitOrganization {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  private String name;
  private String campaignName;
  private Integer point;
  private Integer maxPoint;
  private String description;
  private LocalDate startDate;
  private LocalDate endDate;

  public void gainPoint(int gainPoint){
    point+=gainPoint;
  }
}
