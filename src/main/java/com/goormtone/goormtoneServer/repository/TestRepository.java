package com.goormtone.goormtoneServer.repository;

import com.goormtone.goormtoneServer.domain.test.entity.TestEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity,Long>, TestRepositoryCustom{

    @Query(value = "select e from TestEntity e")
    Slice<TestEntity> findAllTestEntity(Pageable pageable);
}
