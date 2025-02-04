package com.app.testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CuraTestingApplicationTests {

    @Test
    void contextLoads() {

        // Automatically setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Allow cross-origin connections

        // Initialize WebDriver with options
        WebDriver driver = new ChromeDriver(options);


        // Your test code here
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");

        // Close the browser
        driver.quit();

    }

}
