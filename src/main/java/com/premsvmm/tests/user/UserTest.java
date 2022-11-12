package com.premsvmm.tests.user;

import com.premsvmm.dtos.users.UserRequestDto;
import com.premsvmm.dtos.users.UserResponseDto;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.premsvmm.controllers.TestGroups.USER;

public class UserTest extends UserBase {

    @Test(enabled = true, alwaysRun = true, dataProviderClass = UserDataProvider.class, dataProvider = "CreateUserDataProvider", testName = "validateCreateAndUpdateUser", description = "Validate create and update user", groups = {USER})
    public void validateCreateAndUpdateUser(ArrayList<UserRequestDto> userRequestDtos) {
        UserResponseDto userResponseDto = userImpl.createUser(userRequestDtos);
    }
}
