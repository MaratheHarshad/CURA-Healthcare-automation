package com.app.testing.tests;

import com.app.testing.pages.AppointmentPage;
import com.app.testing.pages.LoginPage;
import com.app.testing.utils.WebDriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


class AppointmentPageTests {

    WebDriver driver;
    AppointmentPage appointmentPage;


    String loginLink = "https://katalon-demo-cura.herokuapp.com/profile.php#login";

    @BeforeEach
    public void setup() {
        driver = new WebDriverUtils().getDriver();
        driver.get(loginLink);
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(driver, "John Doe");
        loginPage.enterPassword(driver, "ThisIsNotAPassword");

        loginPage.login(driver,loginLink);
//        WebDriverWait wait = new WebDriverWait(driver, 10);


        appointmentPage = new AppointmentPage(driver);
        PageFactory.initElements(driver, appointmentPage);
    }

    @Test
    void appointmentPageDataFill(){

        appointmentPage.clickHospitalReadmissionCheck();
        appointmentPage.clickfacilityDropdownByIndex(2);
        appointmentPage.clickHealthCareProgramRadio_Medicaid();
        appointmentPage.setStandardInputDate("20/04/2002");
        appointmentPage.setBookAppointmentButton();

        Assertions.assertEquals( "Appointment Confirmation", driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2")).getText());

    }


    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
