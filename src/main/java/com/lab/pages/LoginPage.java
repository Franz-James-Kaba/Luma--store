package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    // Locators
    private final By Email = By.id("email");
    private final By Password = By.cssSelector("#pass");
    private final By LoginButton = By.id("send2");
    private final By welcomeText = By.cssSelector("li.greet.welcome > span");
    
    
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
        driver.findElement(Email).sendKeys("kyhaca@mailinator.com");
        driver.findElement(Password).sendKeys("P@ssw0rd");
        driver.findElement(LoginButton).click();
       
    }

    public String getWelcomeText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
        
        String text = driver.findElement(welcomeText).getText();
        return text;
    }
    


}
