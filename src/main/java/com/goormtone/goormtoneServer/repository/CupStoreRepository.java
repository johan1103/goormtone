package com.goormtone.goormtoneServer.repository;

import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupStoreRepository extends JpaRepository<CupStore,Long> {

}
