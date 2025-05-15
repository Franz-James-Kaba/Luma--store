package com.lab.customertests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.lab.base.Setup;

public class ProductTest extends Setup {

    @Test
    void testAddProductToCart() {
        homePage.clickFirstProduct();
        productPage.selectSize();
        productPage.selectColor();
        productPage.enterQuantity();
        productPage.clickAddToCart();
        assertTrue(productPage.isSuccessMessageDisplayed());
    }


}
