package com.goormtone.goormtoneServer.domain.cupstore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CupStore {
  @Id
  @GeneratedValue
  private Long id;

  private Integer point;
  private Integer maxPoint;
  private Point location;
  private String name;
}
