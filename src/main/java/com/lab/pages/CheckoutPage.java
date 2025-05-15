package com.lab.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By firstNameInput = By.cssSelector("#LUIR8P8");
    private By lastNameInput = By.cssSelector("#K4RPIFW");
    private By companyInput = By.cssSelector("#BQ8R9AU");
    private By addressInput = By.cssSelector("#EWLSKKA");
    private By cityInput = By.cssSelector("#HUTY2E2");
    private By stateInput = By.cssSelector("#TK9YT12");
    private By zipInput = By.cssSelector("#TK9YT12");
    private By countryInput = By.cssSelector("#I2RK0K9");
    private By phoneInput = By.cssSelector("#PNRWYXI");
    private By shippingMethodInput = By.cssSelector("#checkout-shipping-method-load > table > tbody > tr:nth-child(1) > td:nth-child(1) > input");
    private By nextButton = By.cssSelector("#shipping-method-buttons-container > div > button > span");
    private By submitBtn = By.id("submit-order");
    private By confirmationMsg = By.cssSelector("#maincontent > div.page-title-wrapper > h1 > span");
    private By addressElement = By.cssSelector(".field.addresses > div > div > div");
    private By placeOrderButton = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void fillCheckoutForm() {
        driver.findElement(firstNameInput).sendKeys("John");
        driver.findElement(lastNameInput).sendKeys("Doe");
        driver.findElement(companyInput).sendKeys("Example Company");
        driver.findElement(addressInput).sendKeys("123 Main St");
        driver.findElement(cityInput).sendKeys("New York");

        Select stateSelect = new Select(driver.findElement(stateInput));
        stateSelect.selectByVisibleText("New York");

        driver.findElement(zipInput).sendKeys("10001");

        Select countrySelect = new Select(driver.findElement(countryInput));
        countrySelect.selectByVisibleText("United States");

        driver.findElement(phoneInput).sendKeys("1234567890");
        driver.findElement(shippingMethodInput).click();
        driver.findElement(nextButton).click();
        driver.findElement(submitBtn).click();
    }

    public boolean isConfirmationDisplayed() {
        return driver.findElement(confirmationMsg).isDisplayed();
    }
    public void selectAddress(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressElement));
        driver.findElement(addressElement).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethodInput));
        driver.findElement(shippingMethodInput).click();
        driver.findElement(nextButton).click();
    }

    public void clickPlaceOrder() {
        try {
            Thread.sleep(7000); // Wait for 7 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton));
        driver.findElement(placeOrderButton).click();
    }
}
