package com.lab.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage{
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By sizeOptions = By.cssSelector(".swatch-attribute.size .swatch-option.text");
    private final By colorOptions = By.cssSelector(".swatch-attribute.color .swatch-option.color");
    private final By quantityInput = By.id("qty");
    private final By addToCartButton = By.id("product-addtocart-button");
    private final By proceedToCheckoutBtn = By.cssSelector("#top-cart-btn-checkout");
    private final By cartSummary = By.cssSelector("#ui-id-1");
    private final By successMessage = By.cssSelector("#maincontent .page.messages .message-success");
    private final By cartButton = By.cssSelector(".minicart-wrapper > a");

    // ✅ Hardcoded to select size "M"
    public void selectSize() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sizeOptions));
        List<WebElement> sizes = driver.findElements(sizeOptions);
        for (WebElement size : sizes) {
            if ("M".equalsIgnoreCase(size.getDomAttribute("option-label"))) {
                size.click();
                return;
            }
        }
        throw new RuntimeException("Hardcoded size 'M' not found");
    }

    // ✅ Hardcoded to select color "White"
    public void selectColor() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(colorOptions));
        List<WebElement> colors = driver.findElements(colorOptions);
        for (WebElement color : colors) {
            if ("Blue".equalsIgnoreCase(color.getDomAttribute("option-label"))) {
                color.click();
                return;
            }
        }
        throw new RuntimeException("Hardcoded color 'White' not found");
    }

    // ✅ Hardcoded quantity = "1"
    public void enterQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(quantityInput));
        WebElement qtyField = driver.findElement(quantityInput);
        qtyField.clear();
        qtyField.sendKeys("7");
    }

    public CartPage clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
        return new CartPage(driver);
    }
    public void clickCartButton() {
       wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton));
       driver.findElement(cartButton).click();
    }
     public void clickCheckout() {
        try {
            Thread.sleep(7000); // Wait for the cart summary to be visible
        } catch (Exception e) {
            System.out.println("Cart summary not found: " + e.getMessage());
        }
        wait.until(ExpectedConditions.elementToBeClickable(cartSummary));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }
}
