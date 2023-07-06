package com.goormtone.goormtoneServer.config.data;

import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.cupstore.CupStoreGroup;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.repository.CupStoreGroupRepository;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CreateDatas {
  private final MemberRepository memberRepository;
  private final CupStoreRepository cupStoreRepository;
  private final CupStoreGroupRepository cupStoreGroupRepository;
  @GetMapping("/create-data")
  @Transactional
  public String create(){
    memberRepository.save(new Member("1234",0,0,"kimTaehyoung"));
    CupStoreGroup group1 = cupStoreGroupRepository.save(new CupStoreGroup(null,"original",10));
    cupStoreRepository.save(new CupStore(null,null,"Cupstore1",null,group1));
    return "ok";
  }
}
