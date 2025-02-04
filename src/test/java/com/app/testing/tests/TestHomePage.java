package com.app.testing.tests;

import com.app.testing.pages.HomePage;
import com.app.testing.utils.WebDriverUtils;
import com.google.j2objc.annotations.Weak;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHomePage {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        this.driver = new WebDriverUtils().getDriver();

    }

    @Test
    public void testHomePage() {

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        HomePage homePage = new HomePage();
        String homePageText = homePage.getPagetitle(driver);

        Assertions.assertEquals("CURA Healthcare Service", homePageText);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
