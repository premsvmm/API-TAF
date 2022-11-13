package com.premsvmm.tests.user;

import com.premsvmm.dtos.users.UserRequestDto;
import com.premsvmm.dtos.users.UserResponseDto;
import com.premsvmm.exceptions.APIException;
import com.premsvmm.impls.UserImpl;
import com.premsvmm.tests.BaseTests;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

public class UserBase extends BaseTests {
    protected UserImpl userImpl;

    @BeforeClass(alwaysRun = true)
    public void initUserBase() {
        userImpl = new UserImpl();
    }

    protected void updateUserAndValidate(ArrayList<UserRequestDto> updateUser) throws APIException {
        for (UserRequestDto userRequestDto : updateUser) {
            UserResponseDto userResponseDto = userImpl.updateUser(userRequestDto.getUserName(), userRequestDto);
            UserAssertionMethods.assertUpdateResponse(userRequestDto,userResponseDto);
            getUserAndValidate(userRequestDto.getUserName(), userRequestDto);
        }
    }

    protected void validateCreatedUser(ArrayList<UserRequestDto> userRequestDtos) throws APIException {
        for (UserRequestDto userRequestDto : userRequestDtos) {
            getUserAndValidate(userRequestDto.getUserName(), userRequestDto);
        }
    }

    protected void getUserAndValidate(String userName, UserRequestDto userRequestDto) throws APIException {
        UserResponseDto createdUser = userImpl.getUser(userRequestDto.getUserName());
        UserAssertionMethods.assertCreateUser(userRequestDto, createdUser);
    }
}
