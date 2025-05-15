package com.lab.customertests;

import org.junit.jupiter.api.*;
import com.lab.base.Setup;
import static org.junit.jupiter.api.Assertions.*;

public class HomePageTests extends Setup {


    @Test
    void testHomePageLoadsCorrectly() {
        assertTrue(homePage.isNavigationMenuVisible(), "Navigation menu should be visible");
        assertTrue(homePage.isProductListDisplayed(), "Products should be displayed");
    }

    @Test
    void testClickingProductGoesToProductPage() {
        homePage.clickFirstProduct();
        assertTrue(homePage.getProductURL().contains("radiant"), "Should navigate to product detail page");
    }
    @Test
    void testClickingCartButton() {
        homePage.clickCartButton();
    }

}

