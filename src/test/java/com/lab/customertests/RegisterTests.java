package com.lab.customertests;

import com.lab.base.Setup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterTests extends Setup {


    @Test
    public void testSuccessfulRegister () {
        homePage.clickCreateAccountButton();
        registerPage.fillForm();
        String ActualResult = registerPage.successChecker();
        Assertions.assertEquals("Thank you for registering with Main Website Store.",ActualResult);
    }

}
