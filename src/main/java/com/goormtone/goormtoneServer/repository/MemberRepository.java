package com.goormtone.goormtoneServer.repository;

import com.goormtone.goormtoneServer.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {
}
