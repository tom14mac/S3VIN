package com.qa.s3vin_test.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.List;

// page_url = about:blank
public class View_Minimum_Wages {

    public View_Minimum_Wages(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//div[@class='round'])[2]") WebElement select_Emp;
    @FindBy(xpath = "(//div[@class='round'])[1]")WebElement Select_all_Emp;
    @FindBy(xpath = "//a[contains(.,'View Minimum Wages')]") WebElement View_Minimum_wage;
    @FindBy(xpath = "//a[normalize-space()='Minimum Wages']")WebElement Export_Minwages_btn;
    @FindBy(xpath = "(//button[@id='closeBtn'])[2]") WebElement closeBtn;
    @FindBy(xpath = "//div[@class='form-group row']//div[@class='col-xl-12']")WebElement Emp_Rate;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3)")WebElement Timesheet_rate;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(4)")WebElement wage_rate;
    public void check_View_Minimum_Wages() throws InterruptedException {
        Thread.sleep(1000);
        select_Emp.click();
        Thread.sleep(1000);
        View_Minimum_wage.click();
        setView_Minimum_wage();
        Thread.sleep(1000);
        closeBtn.click();
    }
    public void setView_Minimum_wage() {
      System.out.println("Employee config Rate:"+Emp_Rate.getText());
      System.out.println("Timesheet config Rate:"+Timesheet_rate.getText());
      System.out.println("MinimumWage :"+wage_rate.getText());
    }
    public void Export_MinimumWages(){
        Select_all_Emp.click();
        Export_Minwages_btn.click();
    }
}