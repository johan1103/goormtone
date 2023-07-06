package com.goormtone.goormtoneServer.domain.starRating;

import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StarRating {
  @Id
  @GeneratedValue
  private Long id;
  private Integer rating;
  @ManyToOne
  private CupStore cupStore;
  @ManyToOne
  private Member member;
}
