package com.goormtone.goormtoneServer.controller.detail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CupStoreDetailResponseDto {
  private String imageUrl;
  private String name;
  private String roadAddress;
  private String hours;
  private Double averageRating;
  private List<DetailPageCommentDto> comments;
  private Integer totalComments;

  public void setAverageRating(Double averageRating) {
    this.averageRating = averageRating;
  }
  public void setTotalComments(Integer totalComments){
    this.totalComments = totalComments;
  }

  public void setComments(List<DetailPageCommentDto> comments) {
    this.comments = comments;
  }
}
