package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final By loginButton = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a");
    private final By CreateAccountButton = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage clickCreateAccountButton (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CreateAccountButton));
        driver.findElement(CreateAccountButton).click();
        return new RegisterPage(driver);
    }
}
