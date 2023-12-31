package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.domain.member.LoginRequestDto;
import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.domain.member.MemberDto;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService{
  private final MemberRepository memberRepository;

  private final List<String> randomNickname;
  private static final String secretValue = "goorm";
  private static final int nicknameListLen = 5;

  @PostConstruct
  public void initRandomValue(){
    randomNickname.add("태형");
    randomNickname.add("서윤");
    randomNickname.add("현우");
    randomNickname.add("민규");
    randomNickname.add("지영");
  }

  public MemberDto login(LoginRequestDto loginRequestDto){
    Member member = findOrSaveMember(loginRequestDto);
    String token = createToken(member);
    return MemberDto.ofMemberAndToken(member,token);
  }
  private String createToken(Member member){
    String hashString = member.getId()+secretValue;
    int hashNumber = hashString.hashCode();
    return String.valueOf(hashNumber) + "&" + member.getId();
  }
  private Member findOrSaveMember(LoginRequestDto loginRequestDto){
    String id = loginRequestDto.getId();
    Optional<Member> member = memberRepository.findById(id);
    return member.orElseGet(() -> memberRepository.save(createMember(id)));
  }
  private Member createMember(String id){
    return new Member(id,0,0,createRandomNickname());
  }
  private String createRandomNickname(){
    return randomNickname.get(((int)(Math.random()*100)%nicknameListLen));
  }
}
