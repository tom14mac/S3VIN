package com.qa.s3vin_test.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = about:blank
public class LTS_Payroll_TestBase {

    public WebDriver driver;
    public LTS_Payroll_TestBase(WebDriver driver) {
        //PageFactory.initElements(driver, this);
        this.driver = driver;
    }
     By username = By.xpath("//input[@id='email']");
     By password = By.xpath("//input[@placeholder='Password']");
    public void Login(String e, String p){
        driver.findElement(username).sendKeys(e);
        driver.findElement(password).sendKeys(p);
    }
    }


    // Collect Web elements for Login page
