package com.goormtone.goormtoneServer.domain.starRating;

import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StarRating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer rating;
  @ManyToOne
  private CupStore cupStore;
  @ManyToOne
  private Member member;

  public void setRating(Integer rating) {
    this.rating = rating;
  }
}
