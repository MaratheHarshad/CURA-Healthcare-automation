package com.app.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {

    WebDriver driver;

    // dropdown
    @FindBy(xpath = "//select[@id=\"combo_facility\"]")
    WebElement facilityDropdown;


    // checkbox

    @FindBy(xpath = "//*[@id=\"chk_hospotal_readmission\"]")
    WebElement hospitalReadmissionCheckbox;


    // radio
    @FindBy(xpath = "(//input[@name=\"programs\"])[1]")
    WebElement healthCareProgramRadio_Medicare;

    @FindBy(xpath = "(//input[@name=\"programs\"])[2]")
    WebElement healthCareProgramRadio_Medicaid;

    @FindBy(xpath = "(//input[@name=\"programs\"])[3]")
    WebElement healthCareProgramRadio_None;


    // Date -> Standard input date
    @FindBy(xpath = "//input[@id=\"txt_visit_date\"]")
    WebElement standardInputDate;


    // Button
    @FindBy(xpath = "//button[@id=\"btn-book-appointment\"]")
    WebElement bookAppointmentButton;

    public void clickHospitalReadmissionCheck() {
         if (hospitalReadmissionCheckbox.isSelected()) {
             hospitalReadmissionCheckbox.click();
         }
    }

    public void setBookAppointmentButton() {
        bookAppointmentButton.click();
    }

    public void clickfacilityDropdownByIndex(int index) {
        Select select = new Select(facilityDropdown);
        select.selectByIndex(index);
    }

    public void setStandardInputDate(String standardInputDate) {
        this.standardInputDate.sendKeys(standardInputDate);
    }


    public void clickHealthCareProgramRadio_Medicaid(){
        if (healthCareProgramRadio_Medicaid.isSelected()) {
            healthCareProgramRadio_Medicaid.click();
        }
    }

    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }



}
