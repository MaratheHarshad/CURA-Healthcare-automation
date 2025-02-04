package com.app.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {



    public By username = By.name("username");
    public By password = By.cssSelector("#txt-password");
    public By loginButton = By.id("btn-login");

    public LoginPage() {

    }

//    Actions we need to perform
    public void enterUsername(WebDriver driver, String name){
        // insert the input name in username field
        driver.findElement(username).sendKeys(name);
    }

    public void enterPassword(WebDriver driver, String pass){
        // insert the input password in password field
        driver.findElement(password).sendKeys(pass);
    }

    public void login(WebDriver driver, String link){
        driver.findElement(loginButton).click();

    }

}
