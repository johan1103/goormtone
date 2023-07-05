package com.goormtone.goormtoneServer.domain.test.entity;

import com.goormtone.goormtoneServer.domain.dto.TestDtoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TestEntity {
    @Id @GeneratedValue
    private Long id;

    private String userName;

    public static TestEntity ofTestDtoRequest(TestDtoRequest request){
        return new TestEntity(null, request.getUserName());
    }
}
