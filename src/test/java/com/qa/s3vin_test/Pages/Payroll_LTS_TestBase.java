package com.qa.s3vin_test.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Payroll_LTS_TestBase {
    static WebDriver driver;
    Loginpage_TestBase login_obj = new Loginpage_TestBase(driver);

    public Payroll_LTS_TestBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // Collect Web elements for Login page
    @FindBy(xpath ="//button[@id='kt_login_signin_submit_']") WebElement login;
    @FindBy(xpath = "//input[@id='password']") WebElement Password;
    @FindBy(xpath = "//input[@id='email']") WebElement email;

   //Collect Web element for navigate
    @FindBy(xpath = "//a[normalize-space()='Globex Corporation (The Simpsons)']")WebElement Company_name;
    @FindBy(xpath = "//a[normalize-space()='R Industries']")WebElement customer_name;
    @FindBy(xpath = "//span[@class='kt-menu__link-text menu-icon-heading'][normalize-space()='Customers']")WebElement customer_leftpane;

    // Payroll
    @FindBy(xpath = "//a[normalize-space()='Payroll']")WebElement payroll_tab;
   @CacheLookup
   @FindBy(xpath = "//body/div[@id='overflowW4form']/div[@class='kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-page']/div[@id='kt_wrapper']/div[@id='kt_content']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    WebElement Add_new_Payroll_btn;

    //Timesheet Filter search
    @FindBy(xpath = "//div[@id='ltsPayDataId']//div[@class='filter-icon-custom d-flex w-auto padd-r-10 text-center align-items-center opensearchmenuPayData']")
    WebElement Filter_btn;
    @FindBy(xpath ="//input[contains(@type,'text')]")WebElement input_search;
    @FindBy(xpath = "(//button[@title='Payroll Status'])[1]")WebElement Payroll_status;
    @FindBy(xpath = "//span[normalize-space()='Step 1 of 8 Pending']")WebElement select_pending;

    //Timesheet
   @FindBy(xpath = "(//td)[44]") WebElement LTS_Timesheet;
   @FindBy(xpath = "(//td[contains(text(),'03/08/2023')])[1]")WebElement Select_date;
   @FindBy(xpath = "//td[.='Calculate Payroll']")WebElement status;
   @FindBy(xpath = "//a[normalize-space()='Calculate Payroll']")WebElement calculate_btn;
   @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)")
   WebElement emp_count;
   @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)")
   WebElement Period_of_date;

   // Employee search
    @FindBy(xpath = "//i[@class='la la-filter']")WebElement filter_icon;
    @FindBy(xpath = "//input[@id='generalSearch']")WebElement General_search;

    //EMP count(Total hours/ gross salary)
    @FindBy(css = ".f-14.kt-font-dark.kt-font-bold.total_hours_tb")WebElement Total_hours;
    @FindBy(xpath = "//span[@class='f-14 kt-font-dark kt-font-bold total_gross_salary_tb']")WebElement Total_gross_salary;
    @FindBy(xpath = "//td[@class=' text-right th-center']")WebElement lIST_Gross_sal_hours;

    //Select Emp & Payroll_Hold
    @FindBy(xpath = "//tr[@class='even']//div[@class='round']")WebElement Select_EMP;
    @FindBy(xpath = "//a[@id='hold_btn']")WebElement Hold_btn;

    // Confirmation Box
    @FindBy(xpath = "//button[normalize-space()='Yes, Payroll_Hold it!']")WebElement Confirm_btn;
    @FindBy(xpath = "//button[normalize-space()='OK']")WebElement OK_btn;
    @FindBy(xpath = "//span[@class='kt-badge kt-badge--inline kt-badge--pill btn btn-label-warning btn-pill'][normalize-space()='Payroll_Hold']")WebElement Timesheet_status;

    //Export
    @FindBy(xpath = "//a[@id='navbarDropdownShow']") WebElement Export_btn;
    @FindBy(xpath = "//a[normalize-space()='PayData Entries']")WebElement Paydata_btn;
    @FindBy(xpath = "//a[@id='minimum_wage_report_btn']")WebElement Wagedata_btn;

    //Refresh
    @FindBy(xpath ="//a[normalize-space()='Refresh']")WebElement Refresh;
    @FindBy(xpath = "//a[normalize-space()='New Entry']")WebElement New_payroll_Entry_emp;

    // Employee
    @FindBy(xpath = "//span[.='Select Employee SSN']")WebElement Emp_SSN;
    @FindBy(xpath = "//input[@role='searchbox']")WebElement search_input;
    @FindBy(xpath = "//span[@role='textbox']")WebElement Emp_name;

    // Edit payroll
    @FindBy(xpath = "//a[normalize-space()='Edit Payroll Entry']")WebElement Edit_payroll;
    //--Switch button
    @FindBy(xpath = "//label[@class='kt-checkbox payTypeTimesheetEntry pr-2 ']//span")WebElement switch_btn;

    // View Minimum_wage -- Select EMP
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2) > div:nth-child(1) > label:nth-child(2)")
    WebElement select_emp;
    @FindBy(xpath = "//a[contains(.,'View Minimum Wages')]")WebElement select_Minimum_Wage;
    @FindBy(xpath = "(//button[@id='closeBtn'])[2]")WebElement close_btn;

    public static WebDriver getDriver() {
        return driver;
    }
    public static WebDriver setDriver(String URL){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);
        return driver;
    }
    public void check_instance(String Url){
        driver.getCurrentUrl();
        driver.getTitle();
    }
    public static void setDriver(WebDriver driver) {
        Payroll_LTS_TestBase.driver = driver;
    }
    public void check_valid_credentials(String Email,String pass) {
        email.sendKeys(Email);
        Password.sendKeys(pass);
        login.click();
    }
    public void setCompany_name() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Company_name);
        Thread.sleep(1000);
    }
    public WebElement Company_name() {;
        System.out.println(Company_name.getText());
        return Company_name;
    }
    public void setCustomer_name() throws InterruptedException {
        customer_leftpane.click();
        Thread.sleep(10000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", customer_name);
    }
    public WebElement customer_name() {
        System.out.println(customer_name.getText());
        return customer_name;
    }
    public void setPayroll_tab() {
        //this.payroll_tab = payroll_tab;
        payroll_tab.click();
    }
    public void setAdd_new_Payroll_btn() throws InterruptedException {
       Thread.sleep(1000);
        Add_new_Payroll_btn.click();
    }

    public void check_validCredentials(String e, String p){
        email.sendKeys(e);
        Password.sendKeys(p);
        login.click();
    }
    public void check_Timesheet_status(){
     filter_icon.click();
     input_search.sendKeys("03/08/2023");
     Payroll_status.click();
     select_pending.click();
     System.out.println();
    }
    public void check_Payroll_status(String date){input_search.sendKeys(date);
        input_search.sendKeys(Keys.ENTER);
        LTS_Timesheet.click();
        System.out.println("LTS PAY DATA Selected Static Date :"+Select_date.getText());
        System.out.println("Status is"+status);
        calculate_btn.click();
        System.out.println("Employee Number of Count:"+emp_count.getText());
        System.out.println("Check Pay period Date"+Period_of_date.getText());
    }
    public void Search_Employee_details(String Emp_SSN, String jobsite,String classcode){
        filter_icon.click();
        General_search.sendKeys(Emp_SSN);
        General_search.clear();
        General_search.sendKeys(jobsite);
        General_search.sendKeys(classcode);
    }
    public void check_Hours_Unit(){

    }

}

