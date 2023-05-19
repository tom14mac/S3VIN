package com.qa.s3vin_test.Action;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.lang.String;

// page_url = about:blank
public class testbase {

    static WebDriver driver;
    public void get_instance(String Username,String pass){
        //System.setProperty("webdriver.chrome.driver", "EmpPaystub_TestBase:\\S3V!N_QA\\S3VIN_Test\\chromedriver.exe");
        //driver.get(url);
        //driver.getTitle();
        System.out.println("TEST");
        email.sendKeys(Username);
        Password.sendKeys(pass);
    }
    public void clear(){
        //System.setProperty("webdriver.chrome.driver", "EmpPaystub_TestBase:\\S3V!N_QA\\S3VIN_Test\\chromedriver.exe");
        //driver.get(url);
        //driver.getTitle();
        System.out.println("clear");
        email.clear();
        Password.clear();
    }
    public testbase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void Check_Validation() {
        login.click();
    }

    public void Check_Email_validation(String password) {
        email.sendKeys(password);
        login.click();
    }

    public void check_invalid_password(WebElement password) {
        login.click();
    }

    public void check_invalid_credentials(String Email,String password) {
        email.sendKeys(Email);
        Password.sendKeys(password);
        login.click();
    }
    public void check_valid_credentials(String Email,String pass) {
        email.sendKeys(Email);
        Password.sendKeys(pass);
        login.click();
    }
    public void setCompany_name() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",Company_name);
        Thread.sleep(1000);
    }
    @FindBy(xpath ="//button[@id='kt_login_signin_submit_']")
    WebElement login;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement Password;
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//a[normalize-space()='Globex Corporation (The Simpsons)']")WebElement Company_name;
    @FindBy(xpath = "//a[contains(text(),'R Industries')]")WebElement customer_name;

    // Payroll
    @FindBy(xpath = "//a[normalize-space()='Payroll']")WebElement payroll_tab;
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

    // page_url = about:blank

}