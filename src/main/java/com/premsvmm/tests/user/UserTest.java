package com.premsvmm.tests.user;

import com.premsvmm.dtos.users.UserRequestDto;
import com.premsvmm.dtos.users.UserResponseDto;
import com.premsvmm.exceptions.APIException;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.premsvmm.controllers.TestGroups.USER;

public class UserTest extends UserBase {

    @Test(enabled = true, alwaysRun = true, dataProviderClass = UserDataProvider.class, dataProvider = "CreateUserAndUpdateDataProvider", testName = "ValidateCreateAndUpdateUser", description = "Validate create and update user", groups = {USER})
    public void ValidateCreateAndUpdateUser(ArrayList<UserRequestDto> createUser, ArrayList<UserRequestDto> updateUser) throws APIException {
        UserResponseDto userResponseDto = userImpl.createUser(createUser);
        UserAssertionMethods.assertCreatedResponse(userResponseDto);
        validateCreatedUser(createUser);
        updateUserAndValidate(updateUser);
    }

}
