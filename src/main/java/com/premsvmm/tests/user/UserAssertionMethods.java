package com.premsvmm.tests.user;

import com.premsvmm.dtos.users.UserRequestDto;
import com.premsvmm.dtos.users.UserResponseDto;
import org.testng.asserts.SoftAssert;

public class UserAssertionMethods {

    public static void assertCreatedResponse(UserResponseDto responseDto){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseDto.getCode(),200);
        softAssert.assertEquals(responseDto.getType(),"unknown");
        softAssert.assertEquals(responseDto.getMessage(),"ok");
        softAssert.assertAll();
    }

    public static void assertUpdateResponse(UserRequestDto userRequestDto,UserResponseDto responseDto){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseDto.getCode(),200);
        softAssert.assertEquals(responseDto.getType(),"unknown");
        softAssert.assertEquals(String.valueOf(userRequestDto.getId()),responseDto.getMessage());
        softAssert.assertAll();

    }

    public static void assertCreateUser(UserRequestDto request, UserResponseDto response) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(request.getId(), response.getId());
        softAssert.assertEquals(request.getUserName(), response.getUserName());
        softAssert.assertEquals(request.getFirstName(), response.getFirstName());
        softAssert.assertEquals(request.getLastName(), response.getLastName());
        softAssert.assertEquals(request.getLastName(), response.getLastName());
        softAssert.assertEquals(request.getEmail(), response.getEmail());
        softAssert.assertEquals(request.getPassword(), response.getPassword());
        softAssert.assertEquals(request.getPhone(), response.getPhone());
        softAssert.assertEquals(request.getUserStatus(), response.getUserStatus());
        softAssert.assertAll();
    }
}