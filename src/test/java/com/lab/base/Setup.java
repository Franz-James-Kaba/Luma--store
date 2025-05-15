package com.lab.base;

import com.lab.pages.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {
    protected static WebDriver driver;
    protected static WebElement element;
    protected static HomePage homePage;
    protected static RegisterPage registerPage;
    protected static LoginPage loginPage;
    protected static AccountPage accountPage;
    protected static CartPage cartPage;
    protected static CheckoutPage checkoutPage;
    protected static ProductPage productPage;

    @BeforeAll
    public static void setUp() {
        // Setup Chrome options for Docker/headless compatibility
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Use 'new' for Chrome 109+
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        // Start driver
        driver = new ChromeDriver(options);

        // Use BASE_URL from environment variable or fallback to default
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "https://magento.softwaretestingboard.com/");
        driver.get(baseUrl);

        // Initialize page objects
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productPage = new ProductPage(driver);
    }

    @AfterAll
    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
