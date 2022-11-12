package tests.user;

import com.premsvmm.impls.UserImpl;
import org.testng.annotations.BeforeClass;
import tests.BaseTests;

public class UserBase extends BaseTests {
    protected UserImpl userImpl;

    @BeforeClass(alwaysRun = true)
    public void init(){
        userImpl = new UserImpl();
    }
}
