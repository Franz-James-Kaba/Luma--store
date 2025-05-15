package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By cartItems = By.cssSelector(".counter-number");
    private final By totalCost = By.id("total-price");
    private final By proceedToCheckoutBtn = By.cssSelector("#top-cart-btn-checkout");
    private final By cartSummary = By.cssSelector("#ui-id-1");
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int getCartItemCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
        return driver.findElements(cartItems).size();
    }

    public String getTotalCost() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalCost));
        return driver.findElement(totalCost).getText();
    }

    public boolean isCheckoutButtonVisible() {
        WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutBtn));
        return checkoutButton.isDisplayed();
    }

    public CheckoutPage clickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartSummary));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
        return new CheckoutPage(driver);
    }
}
