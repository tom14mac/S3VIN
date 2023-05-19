package com.qa.s3vin_test.Action;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.x500.X500Principal;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;

// page_url = about:blank
public class Edit_PayRate {
static  WebDriver driver;
    public Edit_PayRate(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    // Select Emp
    @FindBy(xpath = "(//div[@class='round'])[2]")WebElement Select_Emp;
    @FindBy(xpath = "//a[normalize-space()='Edit Pay Rate']") WebElement Edit_pay_rate_btn;
    @FindBy(xpath = "//input[@id='employee_payrate']")WebElement input_pay_rate;
    @FindBy(xpath = "(//button[@type='submit'][normalize-space()='Save'])[1]")WebElement save_btn;
    @FindBy(xpath = "//button[normalize-space()='Yes, Update it!']")WebElement confrim;
    @FindBy(xpath = "//button[normalize-space()='OK']")WebElement ok_btn;

   public void check_PayRate(String Payrate) throws InterruptedException {
       //Select_Emp.click();
       Thread.sleep(10000);
       Edit_pay_rate_btn.click();
       Thread.sleep(1000);
       input_pay_rate.clear();
       input_pay_rate.sendKeys(Payrate);
       save_btn.click();
       confrim.click();
       Thread.sleep(10000);
       ok_btn.click();
   }

}