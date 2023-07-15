package com.goormtone.goormtoneServer.repository;

import com.goormtone.goormtoneServer.domain.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
}
