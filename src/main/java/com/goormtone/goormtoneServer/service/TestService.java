package com.goormtone.goormtoneServer.service;

import com.goormtone.goormtoneServer.domain.dto.TestDtoRequest;
import com.goormtone.goormtoneServer.domain.dto.TestDtoResponse;
import org.springframework.stereotype.Service;

@Service
public interface TestService {
    public TestDtoResponse testService(TestDtoRequest request);
}
