package com.premsvmm.tests.user;

import com.premsvmm.impls.UserImpl;
import com.premsvmm.tests.*;
import org.testng.annotations.BeforeClass;

public class UserBase extends BaseTests{
    protected UserImpl userImpl;

    @BeforeClass(alwaysRun = true)
    public void initUserBase() {
        userImpl = new UserImpl();
    }
}
