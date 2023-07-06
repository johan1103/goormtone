package com.goormtone.goormtoneServer.controller;

import com.goormtone.goormtoneServer.domain.test.dto.TestDtoRequest;
import com.goormtone.goormtoneServer.domain.test.dto.TestDtoResponse;
import com.goormtone.goormtoneServer.domain.test.entity.TestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface TestController {
    @GetMapping("/hello-world")
    public TestDtoResponse helloWorld(@RequestBody TestDtoRequest testDtoRequest);
    @GetMapping("/hello-entity")
    public List<TestEntity> getAllEntity();
}
