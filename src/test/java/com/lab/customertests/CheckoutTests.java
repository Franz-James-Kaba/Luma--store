package com.lab.customertests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.lab.base.Setup;


public class CheckoutTests extends Setup {
 
    @Test
    void testSuccessfulCheckout() {
        // Step 1: Login
        homePage.clickLoginButton();
        loginPage.fillForm();

        // Step 3: Go to cart and verify item is added
         homePage.clickFirstProduct();
         productPage.selectSize();
         productPage.selectColor();
         productPage.enterQuantity();
         productPage.clickAddToCart();
         productPage.clickCartButton();
         productPage.clickCheckout();


        // Step 5: Select address
        checkoutPage.selectAddress();
        // Step 6: place order
        checkoutPage.clickPlaceOrder();

        // Step 7: Verify confirmation message is displayed
        Assertions.assertTrue(checkoutPage.isConfirmationDisplayed(), "Order confirmation not displayed!");
    }
}
