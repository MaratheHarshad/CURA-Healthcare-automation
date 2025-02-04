package com.app.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private By homeTitle = By.tagName("h1");
    private By s = By.cssSelector("#btn-make-appointment");


    public HomePage() {

    }

    public void clickMakeAppointment(WebDriver driver) {
        driver.findElement(s).click();
    }

    public String getPagetitle(WebDriver driver){
        String homeText = driver.findElement(homeTitle).getText();
        System.out.println(homeText);
        return homeText;
    }
}
