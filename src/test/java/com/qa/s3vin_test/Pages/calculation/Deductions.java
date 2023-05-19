package com.qa.s3vin_test.Pages.calculation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;

// page_url = about:blank
public class Deductions{
    public static WebDriver driver;
    public float Grp_pay;

    public Deductions(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }
    String URL = "http://7.ustaxandpayrollservices.com/staging/public/admin/customers/profile/110/13";
    @FindBy(xpath = "//div[@class='title text-primary kt-font-bolder']")WebElement paystub_employee_nm;
    @FindBy(css = ".title.text-left")WebElement Emp_SSN;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")
    WebElement Deductions;
    // Employee gets Deduction plan
    @FindBy(xpath = "//span[normalize-space()='All Employees']")WebElement all_Employees;
    @FindBy(xpath = "//i[@class='la la-filter']")WebElement Emp_filter;
    @FindBy(xpath = "//i[@class='la la-search btn-icon mr-1 mt-2']")WebElement Search_icon;
    @FindBy(css = "html > body > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div > div > table > tbody > tr > td:nth-of-type(3) > div > div > button > div > div > div")
    WebElement select_customer;
    @FindBy(xpath = "//input[@placeholder='Customer Name']")WebElement input_search_box;
    @FindBy(xpath = "//input[@class='form-control invoice_search_keyword filter-keyword-search-input']")WebElement input_general_search;
    @FindBy(xpath = "//tr[@class='odd active']//label[@for='radiobutton']")WebElement Emp_select;
    @FindBy(xpath = "//a[text()='R Industries']")WebElement getSelect_customer;
    @FindBy(xpath = "//a[@data-id=\"13\"]")WebElement Emp_tab;
    @FindBy(xpath = "//*[@id=\"employeeList\"]/tbody/tr[1]/td[2]/div/label")WebElement getGetSelect_Employee;
    @FindBy(xpath = "(//a[normalize-space()='Mario'])[1]")WebElement Emp_view;
    @FindBy(xpath = "//a[contains(text(),'Misc Deductions')]")
    WebElement Misc_Deductiobns;
    @FindBy(xpath = "//a[normalize-space()='Garnishments']")WebElement Garnishment;
    @FindBy(xpath = "//div[@id='heading16995']//span[@class='kt-switch kt-switch--sm kt-switch--custom']//span")
    WebElement switch_status;
    @FindBy(css = ".card-title.bg-light.collapsed[data-toggle='collapse'][data-target='#view16985']")WebElement getView_garnishment_plan_all_others;
    @FindBy(xpath = "//div[@id='heading16985']//div[contains(@class,'bg-light')]")WebElement getGetView_garnishment_plan_all;
    @FindBy(css="body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(9) > label:nth-child(2)")
    WebElement flat_amount;
    @FindBy(xpath = "/html/body/div[6]/div/div[3]/button[1]")WebElement yes_Deactivate_it;
    @FindBy(xpath = "//button[normalize-space()='OK']")WebElement ok_btn;
    @FindBy(xpath = "(//*[name()='svg'][@class='kt-svg-icon'])[1]")WebElement view_garnishment_plan;
    @FindBy(xpath = "//body/div[@id='overflowW4form']/div[@class='kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-page']/div[@id='kt_wrapper']/div[@id='kt_content']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement GP05;
    @FindBy(xpath = "//label[normalize-space()='10.00%']")
    WebElement Garnishment_Percentage;

    @FindBy(xpath = "//a[normalize-space()='Benefit Programs']")
    WebElement benifit_tab;
    @FindBy(xpath = "(//label[contains(@for,'radiobutton')])[2]")
    WebElement Benifit123_pre;

    @FindBy(xpath = "//a[normalize-space()='View']")
    WebElement view_benefit_plan;

    @FindBy(xpath = "//*[@id=\"benefitDetailFrm\"]/div[2]/div/div/label[10]")
    WebElement Benrfit_plan_amount;


    // Employee Teaxes
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[4]/div[1]/div/div[2]")WebElement Fedral_Taxes;

    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[4]/div[2]/div/div[2]")WebElement SST;

    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[4]/div[3]/div/div[2]")WebElement Medicare;

    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[4]/div[4]/div/div[2]")WebElement SDI;

    public void check_deductions(){
        System.out.println(Deductions.getText());
    }
    public WebElement getPaystub_employee_nm() {
        return paystub_employee_nm;
    }
    public void setPaystub_employee_nm(WebElement paystub_employee_nm) {
        this.paystub_employee_nm = paystub_employee_nm;
    }
    public WebElement getEmp_SSN() {
        return Emp_SSN;
    }
    public void setEmp_SSN(WebElement emp_SSN) {
        Emp_SSN = emp_SSN;
    }
    public void get_Emp_detail(){
        paystub_employee_nm.getText();
        Emp_SSN.getText();
        System.out.println(Emp_SSN.getText());
    }
    public void get_deduction_plan() throws InterruptedException {
        String str =String.valueOf(Emp_SSN.getText()).substring(5);
        all_Employees.click();
        Emp_filter.click();
        select_customer.click();
        Thread.sleep(100);
        input_search_box.sendKeys("R industries",Keys.ENTER);
        Search_icon.click();
        Thread.sleep(1000);
        input_general_search.sendKeys("testing",Keys.ENTER);
        input_general_search.clear();
        input_general_search.sendKeys(str);
    }
    public void get_Employee_deductionPlan() throws InterruptedException {
        Thread.sleep(1000);
        getSelect_customer.click();
        Emp_tab.click();
        getGetSelect_Employee.click();
        Emp_view.click();
    }
    public void check_Garnishment_status() throws InterruptedException {
        // DeActivation
        Thread.sleep(1000);
        Garnishment.click();
        Thread.sleep(100);
        switch_status.click();
        Thread.sleep(100);
        yes_Deactivate_it.click();
        Thread.sleep(100);
        ok_btn.click();
        //Activation
        Thread.sleep(1000);
        Garnishment.click();
        Thread.sleep(100);
        switch_status.click();
        Thread.sleep(100);
        yes_Deactivate_it.click();
        Thread.sleep(100);
        ok_btn.click();
    }
    public Float get_Employee_Garnishment() throws NumberFormatException, InterruptedException {
       // System.out.println(GP05.getText());
        Thread.sleep(1000);
        Garnishment.click();
        Thread.sleep(1000);
        view_garnishment_plan.click();
        Thread.sleep(1000);
        Hours_Earning_cal hoursEarningCal = new Hours_Earning_cal(driver);
        String Garnishment_percentage_S = Garnishment_Percentage.getText();
        System.out.println(Garnishment_percentage_S.toString());
        float test = Float.parseFloat(Garnishment_percentage_S.replace("%",""));
        System.out.println("Float value print "+test);
        Garnishment_percentage_S = Garnishment_percentage_S.replace("%","");
        System.out.println("Garnishment_percentage 2 ="+Garnishment_percentage_S);
        System.out.println("Testing check print values from Web element : "+Garnishment_Percentage.getText());
        System.out.println("Testing Garnishment_percentage : "+Garnishment_percentage_S);
        Float check_percentage =  Float.parseFloat(Garnishment_percentage_S.replace("%",""));
        System.out.println("Float = "+check_percentage);
        System.out.println("Garnishment Percentage"+Garnishment_percentage_S);
        view_garnishment_plan.click();
        return check_percentage;
    }
    public void get_Garnishment_all_other_paln() throws InterruptedException, ParseException {
       //System.out.println(GP05.getText());
       //currentElement_fluant_wait(getView_garnishment_plan_all_others);
        Thread.sleep(1000);
        getView_garnishment_plan_all_others.click();
        Thread.sleep(1000);
        String flat_amount_s =  flat_amount.getText();
        float flat_amount = Float.parseFloat(flat_amount_s.toString().substring(1));
        System.out.println("Flat amount :"+flat_amount);
    }
    public void get_Benifit_pan() throws InterruptedException {
        Thread.sleep(1000);
        benifit_tab.click();
        Thread.sleep(1000);
        Benifit123_pre.click();
        Thread.sleep(100);
        view_benefit_plan.click();
        Thread.sleep(1000);
        String Benefit_flat_amount_s =  Benrfit_plan_amount.getText();
        float Benefit_flat_amount = Float.parseFloat(Benefit_flat_amount_s.toString().substring(1));
        System.out.println("Benefit amount :"+String.format("%.02f",Benefit_flat_amount));
    }
    public void Emp_Taxes_Negetive_value_check(){
        float test_null = 0.00F;
        float federal_Tax_F = Float.parseFloat(Fedral_Taxes.getText().toString().substring(1));

        if (test_null < federal_Tax_F) {

            System.out.println("Verify value is less than null : "+federal_Tax_F);
            Assert.assertEquals(federal_Tax_F,federal_Tax_F);
        }
       else  {
            Assert.assertEquals(test_null,test_null);
            System.out.println("null value :"+ test_null);
        }
    }
}