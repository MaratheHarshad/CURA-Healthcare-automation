package com.app.testing.tests;

import com.app.testing.pages.LoginPage;
import com.app.testing.utils.WebDriverUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestLoginPage {


    WebDriver driver;
    private static String loginLink;

    @BeforeEach
    public void setUp() {
        loginLink = "https://katalon-demo-cura.herokuapp.com/profile.php#login";
        this.driver = new WebDriverUtils().getDriver();
    }

    @Test
    public void testLoginCorrectCredentials() {
        driver.get(loginLink);
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(driver, "John Doe");
        loginPage.enterPassword(driver, "ThisIsNotAPassword");
        loginPage.login(driver, loginLink);
        String pageTitle = driver.findElement(By.xpath("/html/body/section/div/div/div/h2")).getText();

        Assertions.assertEquals("Make Appointment", pageTitle);

    }

    @Test
    public void testLoginInCorrectCredentials() {
        driver.get(loginLink);
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(driver, "Wrong");
        loginPage.enterPassword(driver, "ThisIsNotAPassword");
        loginPage.login(driver, loginLink);
        String pageTitle = driver.findElement(By.xpath("/html/body/section/div/div/div/h2")).getText();

        Assertions.assertEquals("Login", pageTitle);

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
