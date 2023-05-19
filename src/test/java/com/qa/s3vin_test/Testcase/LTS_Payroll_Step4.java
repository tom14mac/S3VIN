package com.qa.s3vin_test.Testcase;

import com.qa.s3vin_test.Pages.Payroll_DetailsTestbase;
import com.qa.s3vin_test.Pages.calculation.EmpPaystub_TestBase;
import com.qa.s3vin_test.Wait_functions.Functions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LTS_Payroll_Step4 extends LTS_Payroll_Step3{
    Functions functions = new Functions(driver);
    Payroll_DetailsTestbase payrollDetailsTestbase = new Payroll_DetailsTestbase(driver);
    EmpPaystub_TestBase empPaystubTestBase = new EmpPaystub_TestBase(driver);
    @Test(description = "Verifying Payroll Generation funtionality ",priority = 33)
    public void Verify_Payroll_Generation() throws InterruptedException {
        empPaystubTestBase.Genrate_Payroll_btn_click();
        Thread.sleep(60000);
        empPaystubTestBase.Go_Payroll_details();
        Thread.sleep(1000);
       // System.out.println(payrollDetailsTestbase.getPayroll_btn_status());
    }
    @Test(description = "Verify Export invoice funtionality Export all PDF Reports & Export all Excel Reports ",priority = 34)
    public void Verify_Export_Reports() throws InterruptedException {
        try{
            payrollDetailsTestbase.Reports();
            payrollDetailsTestbase.All_PDF_reports();
            payrollDetailsTestbase.All_Export_reports();
            payrollDetailsTestbase.check_Rgister_Export();
            payrollDetailsTestbase.check_Worker_Comp_Report_Export();
            payrollDetailsTestbase.check_ACA_Report_Export();
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
