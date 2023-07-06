package com.goormtone.goormtoneServer.config.data;

import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.cupstore.CupStoreGroup;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.domain.nonProfit.NonProfitOrganization;
import com.goormtone.goormtoneServer.repository.CupStoreGroupRepository;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import com.goormtone.goormtoneServer.repository.NonProfitOrganizationRepository;
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
  private final NonProfitOrganizationRepository organizationRepository;
  @GetMapping("/create-data")
  @Transactional
  public String create(){
    memberRepository.save(new Member("1234",0,0,"kimTaehyoung"));
    CupStoreGroup group1 = cupStoreGroupRepository.save(new CupStoreGroup(null,"original",10));
    String imageUrl = "https://d12zq4w4guyljn.cloudfront.net/300_300_20221114025716561_photo_79460f6e0b30.jpg";
    CupStore cupStore = cupStoreRepository.save(new CupStore(null,33.4471298,126.913509,"CupStore1"
            ,imageUrl,group1,"07~13",null,"제주 서귀포시"));
    cupStoreRepository.save(new CupStore(null,33.4461298,126.914609,"CupStore2"
            ,imageUrl,group1,"11~17",null,"제주 서귀포시"));
    cupStoreRepository.save(new CupStore(null,33.4491298,126.912709,"CupStore3"
            ,imageUrl,group1,"09~20",null,"제주 제주시"));
    organizationRepository.save(new NonProfitOrganization(null,"제주도",0,1000000));
    return "ok";
  }
}
