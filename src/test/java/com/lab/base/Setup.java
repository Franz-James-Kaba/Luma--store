package com.lab.base;


import com.lab.pages.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public static void setUp(){
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productPage = new ProductPage(driver);

    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }
}
