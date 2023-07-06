package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.controller.photo.dto.MemberPointAccumulateDto;
import com.goormtone.goormtoneServer.controller.photo.dto.PhotoDto;
import com.goormtone.goormtoneServer.controller.photo.dto.PhotoUploadDto;
import com.goormtone.goormtoneServer.domain.cupstore.CupStore;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.repository.CupStoreRepository;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import com.goormtone.goormtoneServer.support.PersistenceContextManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class PhotoUploadService {
  private final MemberRepository memberRepository;
  private final CupStoreRepository cupStoreRepository;
  private final PersistenceContextManager cm;

  public MemberPointAccumulateDto upload(PhotoDto photoDto){
    boolean validation = validatePhoto(photoDto);
    //if (!validation) return new MemberPointAccumulateDto("Error")
    Member updatedMember = updateMemberPoint(photoDto);
    CupStore cupStore = findCupStore(photoDto);
    cm.clearPersistenceContext();
    return MemberPointAccumulateDto.ofMemberAndCupStore(updatedMember,cupStore);
  }
  private CupStore findCupStore(PhotoDto photoDto){
    return cupStoreRepository.findById(photoDto.getCupStoreId()).get();
  }

  private boolean validatePhoto(PhotoDto photoDto){
    //validation
    return true;
  }

  private Member updateMemberPoint(PhotoDto photoDto){
    CupStore cupStore = cupStoreRepository.findById(photoDto.getCupStoreId()).get();
    Member member = memberRepository.findById(photoDto.getMemberId()).get();
    member.plusPoint(cupStore.getGroup().getGagePoint());
    return member;
  }
}
