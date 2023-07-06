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
import org.springframework.web.bind.annotation.PostMapping;
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
    insertCup();
    organizationRepository.save(new NonProfitOrganization(null,"제주도",0,1000000));
    return "ok";
  }
  private void insertCup(){
    CupStoreGroup group1 = cupStoreGroupRepository.save(new CupStoreGroup(null,"일회용",10));
    CupStoreGroup group2 = cupStoreGroupRepository.save(new CupStoreGroup(null,"스타벅스",20));
    CupStoreGroup group3 = cupStoreGroupRepository.save(new CupStoreGroup(null,"파리바게트",20));
    String imageUrl1 = "https://cdn.foodnews.co.kr/news/photo/202107/92987_53282_3224.jpg";
    String imageUrl2 = "https://www.newsjeju.net/news/photo/202301/385728_461179_4920.jpg";
    String imageUrl3 = "https://cdn.jejusori.net/news/photo/202306/415863_426730_838.jpg";
    cupStoreRepository.save(new CupStore(null,
            33.401357, 126.902719, "재활용도움센터", imageUrl1,
            group1, "09~17", null, "온평포구로62번길 13"));
    cupStoreRepository.save(new CupStore(null,
            33.276275, 126.717216, "재활용도움센터", imageUrl2,
            group1, "09~17", null, "제주특별자치도 서귀포시 남원읍 남태해안로 100"));
    cupStoreRepository.save(new CupStore(null,
            33.220656, 126.247493, "재활용도움센터", imageUrl3,
            group1, "09~15", null, "제주특별자치도 서귀포시 대정읍 신영로36번길 69-11"));
    cupStoreRepository.save(new CupStore(null,
            33.275531, 126.278396, "재활용도움센터", imageUrl1,
            group1, "10~17", null, "제주특별자치도 서귀포시 대정읍 영어도시로 35-3"));
    cupStoreRepository.save(new CupStore(null,
            33.266706, 126.571422 ,"재활용도움센터",imageUrl2,
            group1, "10~17", null, "제주특별자치도 서귀포시 동홍로 162번길 45(동홍동)"));
    cupStoreRepository.save(new CupStore(null,
            33.251039, 126.558711 ,"재활용도움센터", imageUrl3,
            group1, "10~17", null, "제제주특별자치도 서귀포시 서문서로 46-1(서귀동)"));
    cupStoreRepository.save(new CupStore(null,
            33.401249, 126.902730 ,"재활용도움센터", imageUrl3,
            group1, "09~17", null, "제주특별자치도 서귀포시 성산읍 온평포구로62번길 13"));
    cupStoreRepository.save(new CupStore(null,
            33.459913, 126.929787 ,"재활용도움센터", imageUrl2,
            group1, "11~15", null, "제주특별자치도 서귀포시 성산읍 일출로 221"));
    cupStoreRepository.save(new CupStore(null,
            33.256454,126.510223 ,"재활용도움센터", imageUrl1,
            group1, "10~16", null, "제주특별자치도 서귀포시 신서귀로 87(법환동)"));
    cupStoreRepository.save(new CupStore(null,
            33.257938, 126.353734 ,"재활용도움센터", imageUrl3,
            group1, "09~16", null, "제주특별자치도 서귀포시 안덕면 일주서로 1519"));
    cupStoreRepository.save(new CupStore(null,
            33.250358, 126.330568 ,"재활용도움센터", imageUrl1,
            group1, "11~17", null, "제주특별자치도 서귀포시 안덕면 화순로 154-42"));
    cupStoreRepository.save(new CupStore(null,
            33.263629, 126.610189 ,"재활용도움센터", imageUrl1,
            group1, "09~15", null, "제주특별자치도 서귀포시 월라봉로34번길 37(신효동)"));
    cupStoreRepository.save(new CupStore(null,
            33.250041, 126.424074 ,"재활용도움센터", imageUrl1,
            group1, "11~17", null, "제주특별자치도 서귀포시 중문상로17번길 3(중문동)"));
    cupStoreRepository.save(new CupStore(null,
            33.250183, 126.563450 ,"재활용도움센터", imageUrl1,
            group1, "09~16", null, "제주특별자치도 서귀포시 중앙로62번길 18(서귀동)"));
    cupStoreRepository.save(new CupStore(null,
            33.322304, 126.830268 ,"재활용도움센터", imageUrl2,
            group1, "08~16", null, "제주특별자치도 서귀포시 표선면 표선동서로 203-1"));
    cupStoreRepository.save(new CupStore(null,
            33.255253, 126.558328 ,"재활용도움센터", imageUrl2,
            group1, "10~17", null, "제주특별자치도 서귀포시 홍중로 28(서홍동)"));
    cupStoreRepository.save(new CupStore(null,
            33.449713, 126.920618 ,"스타벅스 제주성산 DT점", imageUrl3,
            group2, "09~15", null, "제주특별자치도 서귀포시 일출로 80"));
    cupStoreRepository.save(new CupStore(null,
            33.249712, 126.506842 ,"스타벅스 서귀포 DT점", imageUrl1,
            group2, "10~17", null, "서귀포시 일주서로 11"));
    cupStoreRepository.save(new CupStore(null,
            33.248263, 126.563872 ,"스타벅스 서귀포 올레점", imageUrl2,
            group2, "10~14", null, "제주특별자치도 서귀포시 서귀동 274-6 동명백화점"));
    cupStoreRepository.save(new CupStore(null,
            33.446220, 126.911302 ,"파리바게트 제주 성산점", imageUrl3,
            group3, "08~17", null, "제주특별자치도 서귀포시 성산읍 일주동로 4282"));
    cupStoreRepository.save(new CupStore(null,
            33.399210, 126.785293 ,"이디야커피 제주 성읍점", imageUrl1,
            group3, "09~15", null, "제주특별자치도 서귀포시 성산읍 번영로 2644"));
  }
}
