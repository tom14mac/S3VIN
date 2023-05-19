package com.qa.s3vin_test;

import com.qa.s3vin_test.Pages.Payroll_LTS_TestBase;
import com.qa.s3vin_test.Utitlities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LTSPayroll_Step2 {
    public static WebDriver driver;
    Payroll_LTS_TestBase ltsStep2 = new Payroll_LTS_TestBase(driver);

    @Test
    public void initilization(){
        driver = Helper.lunch_browser("chrome","http://7.ustaxandpayrollservices.com/staging/public/login");
        ltsStep2 = PageFactory.initElements(driver, Payroll_LTS_TestBase.class);
    }
    @Test
    public void check_Login(){

    }
}