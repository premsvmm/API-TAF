package tests.user;

import com.premsvmm.dtos.users.UserResponseDto;
import org.testng.annotations.Test;

import static com.premsvmm.controllers.TestGroups.USER;

public class UserTest extends UserBase {


    @Test(enabled = true, alwaysRun = true, testName = "validateCreateAndUpdateUser", description = "Validate create and update user", groups = {USER})
    public void validateCreateAndUpdateUser() {
        UserResponseDto userResponseDto = userImpl.getUser("user1");
        System.out.println(userResponseDto.getUserName());
    }
}
