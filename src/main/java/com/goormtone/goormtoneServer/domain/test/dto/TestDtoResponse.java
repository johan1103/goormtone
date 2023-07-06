package com.goormtone.goormtoneServer.domain.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestDtoResponse {
    private String welcomeMessage;

    public static TestDtoResponse ofDtoRequest(TestDtoRequest request){
        return new TestDtoResponse(createMessageWithUserName(request.getUserName()));
    }

    private static String createMessageWithUserName(String username){
        return "welcome "+username+"!";
    }
}
