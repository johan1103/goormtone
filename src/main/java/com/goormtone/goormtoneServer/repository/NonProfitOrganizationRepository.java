package com.goormtone.goormtoneServer.repository;

import com.goormtone.goormtoneServer.domain.nonProfit.NonProfitOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonProfitOrganizationRepository extends JpaRepository<NonProfitOrganization, Long> {
}
