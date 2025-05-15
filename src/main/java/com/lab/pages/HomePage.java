package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By createAccountButton = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a");
    private final By loginButton = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a");

    private final By navWhatsNew = By.cssSelector("#ui-id-3 > span");
    private final By navCart = By.cssSelector("body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a");
    private final By navLogin = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a");

    private final By productNames = By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(1) > div > div > strong > a");
    private final By productThumbnails = By.cssSelector("#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(1) > div > a > span > span > img");
    private final By productPrices = By.cssSelector("#old-price-1556-widget-product-grid > span");
    private final By CartButton = By.cssSelector(".minicart-wrapper ");


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public RegisterPage clickCreateAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
        return new RegisterPage(driver);
    }

    public LoginPage clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new LoginPage(driver);
    }

    public boolean isNavigationMenuVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(navWhatsNew));
        return driver.findElement(navWhatsNew).isDisplayed() &&
               driver.findElement(navCart).isDisplayed() &&
               driver.findElement(navLogin).isDisplayed();
    }

    public boolean isProductListDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productNames));
        return driver.findElements(productNames).size() > 0 &&
               driver.findElements(productThumbnails).size() > 0 &&
               driver.findElements(productPrices).size() > 0;
    }

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(productNames)).click();
    
    }
    public String getProductURL(){
        String Url = driver.getCurrentUrl();
        return Url;
    }
    public void clickCartButton() {
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Error in sleep: " + e.getMessage());
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartButton));
        driver.findElement(CartButton).click();
    }

}
