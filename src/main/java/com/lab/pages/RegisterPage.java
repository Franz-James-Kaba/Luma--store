package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private final By FirstName = By.id("firstname");
    private final By LastName = By.id("lastname");
    private final By Email = By.id("email_address");
    private final By Password = By.id("password");
    private final By ConfirmPassword = By.id("password-confirmation");
    private final By CreateAccountButton = By.cssSelector("#form-validate > div > div.primary > button");
    private final By SuccessNotification = By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div > div");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName));
        driver.findElement(FirstName).sendKeys("John1");
        driver.findElement(LastName).sendKeys("Doe");
        driver.findElement(Email).sendKeys("controlled.gecko.wnmzv@letterprotect.com");
        driver.findElement(Password).sendKeys("P@ssw0rd123");
        driver.findElement(ConfirmPassword).sendKeys("P@ssw0rd123");
        driver.findElement(CreateAccountButton).click();

    }
    public String successChecker() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement notificationElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(SuccessNotification)
        );
        return notificationElement.getText();
    }

}