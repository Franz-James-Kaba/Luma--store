package com.lab.customertests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.lab.base.Setup;


public class LoginTests extends Setup{

   @Test
    public void testSuccessfulLogin() {
        homePage.clickLoginButton();
        loginPage.fillForm();
        String actualWelcomeText = loginPage.getWelcomeText();
        Assertions.assertTrue(actualWelcomeText.contains("Welcome"), "Login failed or customer greeting not found");
    }
    
}
