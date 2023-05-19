package com.qa.s3vin_test.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

// page_url = about:blank
public class Override_Pay_Rate {

    public Override_Pay_Rate(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="//label[contains(@for,'kt-group-checkable')]") WebElement select_emp;
    @FindBy(xpath = "(//a[normalize-space()='Override Pay Rate'])[1]")WebElement Override_pay_rate;
    @FindBy(xpath = "//label[normalize-space()='Use Minimum Wages for current payroll']")WebElement select_wage_check1;
    @FindBy(xpath = "//label[normalize-space()='Overwrite Employee Profile Rate with Minimum Wages']")WebElement select_wage_check2;
    @FindBy(xpath = "//form[@id='frmOverridePayRate']//button[@type='submit'][normalize-space()='Save']")WebElement save_btn;
    @FindBy(xpath = "//button[normalize-space()='Yes, Update it!']")WebElement confrim_update;
    @FindBy(xpath = "//button[normalize-space()='OK']")WebElement ok_btn;
    @FindBy(xpath = "//i[@class='la la-filter']")WebElement select_filter;
    @FindBy(xpath = "//input[@id='generalSearch']")WebElement general_search;
    @FindBy(xpath = "//label[@for='radiobutton']")WebElement select_redio_btn;
    @FindBy(xpath = "//td[position()=4]")WebElement min_wage_value;
    @FindBy(xpath = "//td[position()=3]")WebElement Timesheet_imported_rate;
    @FindBy(xpath = "(//button[@id='closeBtn'])[2]")WebElement close_btn;
    @FindBy(xpath = "//label[normalize-space()='Overwrite Employee Profile Rate with Minimum Wages']")WebElement select_option2;

    public void setSelect_wage_check1() throws InterruptedException {
        Thread.sleep(1000);
        select_emp.click();
        Thread.sleep(1000);
        Override_pay_rate.click();
        Thread.sleep(1000);
        select_wage_check1.click();
        save_btn.click();
        Thread.sleep(1000);
        confrim_update.click();
        Thread.sleep(1000);
        ok_btn.click();

      /*  select_filter.click();
        general_search.click();
        select_redio_btn.click();
        min_wage_value.click();
        Timesheet_imported_rate.click();
        close_btn.click();
        select_option2.click();*/
    }
    public void setSelect_wage_check2() throws InterruptedException {
        Thread.sleep(1000);
        select_emp.click();
        Override_pay_rate.click();
        Thread.sleep(1000);
        select_wage_check2.click();
        save_btn.click();
        Thread.sleep(1000);
        confrim_update.click();
        Thread.sleep(1000);
        ok_btn.click();
    }
    public WebElement getOk_btn(){
        return ok_btn;
    }
}