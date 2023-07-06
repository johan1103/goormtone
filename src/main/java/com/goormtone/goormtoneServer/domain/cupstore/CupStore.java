package com.goormtone.goormtoneServer.domain.cupstore;

import com.goormtone.goormtoneServer.domain.comment.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CupStore {
  @Id
  @GeneratedValue
  private Long id;
  private Double latitude;
  private Double longitude;
  private String name;
  private String imageUrl;
  @ManyToOne
  private CupStoreGroup group;
  private String hours;
  @OneToMany(mappedBy = "cupStore")
  private List<Comment> comments;
}
