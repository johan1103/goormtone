package com.goormtone.goormtoneServer.repository;

import com.goormtone.goormtoneServer.domain.starRating.StarRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StarRatingRepository extends JpaRepository<StarRating,Long> {
  @Query("select s from StarRating s where s.cupStore.id = :cupStoreId and s.member.id = :memberId")
  Optional<StarRating> findStarRatingByMemberIdAndCupStoreId(String memberId, Long cupStoreId);

  @Query("select s from StarRating s where s.cupStore.id = :cupStoreId")
  List<StarRating> findStarRatingsByCupStoreId(Long cupStoreId);
}
