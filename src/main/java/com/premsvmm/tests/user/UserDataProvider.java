package com.premsvmm.tests.user;

import com.premsvmm.dtos.users.UserRequestDto;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UserDataProvider {
    @DataProvider(name = "CreateUserDataProvider")
    public Iterator<Object[]> createUser() {
        List<Object[]> addToList = new LinkedList<>();
        ArrayList<UserRequestDto> arrayList = new ArrayList<>();

        UserRequestDto.UserRequestDtoBuilder userRequestDtoBuilder = UserRequestDto.builder();
        userRequestDtoBuilder.id(1)
                .userName("user 1")
                .firstName("prem")
                .lastName("kumar")
                .email("test@gmail.com")
                .password("1234")
                .phone("1234567890")
                .userStatus(1);
        arrayList.add(userRequestDtoBuilder.build());

        userRequestDtoBuilder = UserRequestDto.builder();
        userRequestDtoBuilder.id(2)
                .userName("user 2")
                .firstName("prem 2")
                .lastName("kumar 2")
                .email("test2@gmail.com")
                .password("1234")
                .phone("12345678901")
                .userStatus(1);
        arrayList.add(userRequestDtoBuilder.build());

        addToList.add(new Object[]{arrayList});
        return addToList.iterator();
    }
}