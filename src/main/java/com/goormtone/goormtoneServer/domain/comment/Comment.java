package com.goormtone.goormtoneServer.domain.comment;

import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
  @Id
  @GeneratedValue
  private Long id;
  public String content;
  @ManyToOne
  public Member member;
  @ManyToOne
  public CupStore cupStore;
  public LocalDateTime createTime;
  public String commentNickname;

  public void updateComment(String content){
    this.content=content;
  }
}
