package com.lab.base;


import com.lab.pages.HomePage;
import com.lab.pages.RegisterPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
    protected static WebDriver driver;
    protected static HomePage homePage;
    protected static RegisterPage registerPage;


    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterAll
    public static void quit(){
        driver.quit();
    }
}
