package com.qa.s3vin_test.Pages;

import com.codeborne.selenide.impl.WebElementSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import javax.security.auth.x500.X500Principal;
import java.util.List;

// page_url = about:blank
public class Payroll_DetailsTestbase {

    // Repots --> All Export
    @FindBy(xpath = "//a[@id='change_payroll_status_id']")WebElement Payroll_btn_status;
    @FindBy(xpath = "//a[normalize-space()='Reports']")WebElement Reports;
    @FindBy(xpath = "//a[normalize-space()='All PDF Reports']")WebElement All_PDF_reports;
    @FindBy(xpath = "//a[normalize-space()='All Excel Reports']")WebElement All_exl_Export_reports;

    //Check Rgister
    @FindBy(xpath = "//a[normalize-space()='Check Register']")WebElement check_Register;
    @FindBy(xpath = "//div[contains(@class,'dropdown-menu show')]//a[contains(@class,'dropdown-item')][normalize-space()='PDF']")WebElement  check_Register_PDF;
    @FindBy(xpath = "//a[contains(@data-report-name,'CheckRegisterReport')]")WebElement check_Register_Excel;

    // Worker Comp_Report
    @FindBy(xpath = "//a[normalize-space()='Worker Comp. Report']")WebElement Worker_comp_Report;
    @FindBy(xpath = "//div[contains(@class,'dropdown-menu show')]//a[contains(@class,'dropdown-item')][normalize-space()='PDF']")WebElement Worker_comp_Report_PDF;
    @FindBy(xpath = "//a[contains(@data-report-name,'WorkerCompReport')]")WebElement Worker_comp_Report_Excel;

    //Allocation Reports
    @FindBy(xpath = "//li[@class='new-item-add dropdown kt-custom-download-dropdown show']//a[@id='navbarDropdown']")WebElement Allocation_Reports;
    @FindBy(xpath = "//a[@data-report-name='AllocationReport']")WebElement Allocation_Reports_Excel;

    //ACA Reports
    @FindBy(xpath = "//a[normalize-space()='ACA Report']") WebElement ACA_reports;
    @FindBy(xpath = "//div[contains(@class,'dropdown-menu show')]//a[contains(@class,'dropdown-item')][normalize-space()='PDF']")WebElement ACA_reports_PDF;
    @FindBy(xpath = "//a[contains(@data-report-name,'ACAReport')]")WebElement ACA_reports_Export_Excel;

    public Payroll_DetailsTestbase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    /*public WebElement getPayroll_btn_status(){
        return getPayroll_btn_status();
    }*/
    public WebElement Reports(){
        Reports.getText();
        return Reports;
    }
    public WebElement All_PDF_reports() throws InterruptedException {
        Thread.sleep(1000);
        All_PDF_reports.click();
        Thread.sleep(5000);
        return All_PDF_reports;
    }
    public WebElement All_Export_reports() throws InterruptedException {
        Thread.sleep(1000);
        All_exl_Export_reports.click();
        Thread.sleep(1000);
        return  All_exl_Export_reports;
    }
    public WebElement All_excel_Export_reports() throws InterruptedException {
        Thread.sleep(1000);
        All_exl_Export_reports.click();
        return All_exl_Export_reports;
    }
    public WebElement check_Register() throws InterruptedException {
        Thread.sleep(3000);
        check_Register.click();
        check_Register_PDF.click();
        Thread.sleep(1000);
        check_Register.click();
        Thread.sleep(1000);
        check_Register_Excel.click();
        return check_Register;
    }
    public void check_Rgister_Export() throws InterruptedException {
        Thread.sleep(3000);
        check_Register.click();
        Thread.sleep(1000);
        check_Register_PDF.click();
        Thread.sleep(1000);
        check_Register_Excel.click();
    }
    public void check_Worker_Comp_Report_Export() throws InterruptedException {
        Thread.sleep(1000);
        Worker_comp_Report.click();
        Thread.sleep(1000);
        Worker_comp_Report_PDF.click();
        Thread.sleep(1000);
        Worker_comp_Report_Excel.click();
    }
    public void check_ACA_Report_Export() throws InterruptedException {
        Thread.sleep(1000);
        ACA_reports.click();
        Thread.sleep(1000);
        ACA_reports_PDF.click();
        Thread.sleep(1000);
        ACA_reports_Export_Excel.click();
    }

}