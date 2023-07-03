package com.goormtone.goormtoneServer.controller;

import com.goormtone.goormtoneServer.domain.dto.TestDtoRequest;
import com.goormtone.goormtoneServer.domain.dto.TestDtoResponse;
import com.goormtone.goormtoneServer.domain.entity.TestEntity;
import com.goormtone.goormtoneServer.repository.TestRepository;
import com.goormtone.goormtoneServer.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestControllerV1 implements TestController{
    private final TestService testService;
    private final TestRepository testRepository;
    @Override
    public TestDtoResponse helloWorld(TestDtoRequest testDtoRequest) {
        return testService.testService(testDtoRequest);
    }

    @Override
    public List<TestEntity> getAllEntity() {
        return testRepository.findAllTestEntity(PageRequest.of(0,10)).stream().toList();
    }
}
