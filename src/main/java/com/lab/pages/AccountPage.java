package com.lab.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By registerButton = By.id("register");
    private By successMessage = By.cssSelector(".success-msg");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
