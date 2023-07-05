package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.domain.dto.TestDtoRequest;
import com.goormtone.goormtoneServer.domain.dto.TestDtoResponse;
import com.goormtone.goormtoneServer.domain.test.entity.TestEntity;
import com.goormtone.goormtoneServer.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class TestServiceV1 implements TestService{

    private final TestRepository testRepository;
    @Override
    public TestDtoResponse testService(TestDtoRequest request) {
        testRepository.save(TestEntity.ofTestDtoRequest(request));
        return TestDtoResponse.ofDtoRequest(request);
    }
}
