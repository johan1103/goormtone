package com.goormtone.goormtoneServer.repository;

import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CupStoreRepository extends JpaRepository<CupStore,Long> {
  @Query(value = "select name,image_url,id,latitude,longitude from cup_store c " +
          "where st_distance_sphere (POINT(c.longitude,c.latitude), POINT(:lng,:lat))<:boundary", nativeQuery = true)
  public Slice<Object[]> searchCupStoresInMap(@Param(value = "lng")Double lng,
                                              @Param(value = "lat")Double lat,
                                              @Param(value = "boundary")Double boundary,
                                              Pageable pageable);

}
