package com.goormtone.goormtoneServer;

import com.goormtone.goormtoneServer.domain.member.Member;
import com.goormtone.goormtoneServer.repository.MemberRepository;
import com.goormtone.goormtoneServer.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MemberTest {

    @Mock
    private MemberRepository memberRepository;

    @Test
    public void createTest(){
        //when
        System.out.println("hello test world!");
        MemberService memberService = new MemberService(null, null);
        Member member = new Member(null,0,0,"kim");
    }
}
