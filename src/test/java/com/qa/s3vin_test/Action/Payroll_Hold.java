package com.qa.s3vin_test.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = about:blank
public class Payroll_Hold {

    public Payroll_Hold(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//td[contains(@class,'wid-3')])[1]")
    WebElement select_Emp;
    @FindBy(xpath = "//a[@id='hold_btn']")
    WebElement Hold_btn;
    @FindBy(css = "button[class='swal2-confirm swal2-styled']")
    WebElement Confrim_yes_Hold_it;
    @FindBy(css = "tr[class='odd active'] span[class='kt-badge kt-badge--inline kt-badge--pill btn btn-label-warning btn-pill']")WebElement Hold_status;
    @FindBy(xpath = "//*[@id=\"dtbl_payroll_generate_lts_entries\"]/tbody/tr[1]/td[3]/span/div/div/span")WebElement Emp_name;
    @FindBy(xpath = "//label[@for='kt-group-checkable']")WebElement select_all_Emp;
    @FindBy(xpath = "//a[@id='approve_btn']")WebElement Approve_calcuate_btn;

    @FindBy(xpath = "(//label[@for='radiobutton'])[1]")WebElement select_Hold_emp;
    @FindBy(xpath ="(//label[@for='radiobutton'])[2]")WebElement getSelect_Emp;
    public void check_Hold_Emp() throws InterruptedException {
        Thread.sleep(1000);
        select_Emp.click();
    Thread.sleep(10000);
    Hold_btn.click();
    Thread.sleep(1000);
    Confrim_yes_Hold_it.click();
    }

    public void setHold_status() {
        System.out.println("________________________Hold Employee Status_____________________________");
        System.out.println("Employee Name:"+Emp_name.getText());
        System.out.print("Employee status :"+ Hold_status.getText());
    }
    public void check_Approve_calculate_payroll_without_Hold(){
        getSelect_Emp.click();
        Approve_calcuate_btn.click();
    }

}