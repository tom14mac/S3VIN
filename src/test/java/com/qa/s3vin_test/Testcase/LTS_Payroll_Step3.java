package com.qa.s3vin_test.Testcase;
import com.qa.s3vin_test.Pages.LTS_PreviewCalculation_TestBase;
import com.qa.s3vin_test.Pages.calculation.EmpPaystub_TestBase;
import com.qa.s3vin_test.Pages.calculation.Hours_Earning_cal;
import io.qameta.allure.Allure;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class LTS_Payroll_Step3 extends LTS_Payroll_Step2{
    LTS_PreviewCalculation_TestBase ltsPreviewCalculationTestbase = new LTS_PreviewCalculation_TestBase(driver);
    Hours_Earning_cal hoursEarningCal =new Hours_Earning_cal(driver);
    EmpPaystub_TestBase deductions = new EmpPaystub_TestBase(driver);
    DecimalFormat df = new DecimalFormat();

    @Override
    public void Verify_Calculation() throws InterruptedException {
         super.Verify_Calculation();
         Thread.sleep(10000);
         driver.getCurrentUrl();
         driver.getTitle();
    }
    @Test(priority = 20,alwaysRun = true)
    public void get_Employee_list_details() throws InterruptedException {
    ltsPreviewCalculationTestbase.Preview_Calculation_get_details();
    ltsPreviewCalculationTestbase.Employee_list();
   // ltsPreviewCalculationTestbase.view_uapproved();
    //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        //action.moveToElement(ltsPreviewCalculationTestbase.getEye_icon_unapproved()).perform();
        //ltsPreviewCalculationTestbase.Download_Reset_Payroll();
    }
    @Test(description = "",priority = 21)
    public void Check_getEmployee_Paystub() throws InterruptedException {
       Thread.sleep(1000);
        ltsPreviewCalculationTestbase.get_Employee_Paystub_details();
        ltsPreviewCalculationTestbase.get_Employee_Taxes();
        Allure.addAttachment("updated Successfully", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Test(priority = 22)
    public void check_store_values() throws InterruptedException {
    ltsPreviewCalculationTestbase.Emp_list_switch();
    driver.navigate().refresh();
    Thread.sleep(10000);
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        js.executeScript("window.scrollBy(0,450)", "");
        //objAdd.setTimesheet_details();
        hoursEarningCal.setTimesheet_details();
        driver.switchTo().window(tabs1.get(1)).close();
        driver.switchTo().window(tabs1.get(0));
        ltsPreviewCalculationTestbase.getEmp_paystub_tab_click();
    }
    @Test(priority = 23)
    public void check_calculation(){
        hoursEarningCal.setTimesheet_calculation();
        hoursEarningCal.VerifiedPrint_values();
        hoursEarningCal.Gross_pay_calculation();
        Assert.assertEquals(String.format("%.2f",hoursEarningCal.get_gorssPay()),hoursEarningCal.getPaystub_GrossPay().getText().substring(1).replace(",",""));
    }
    @Test(priority = 24)
    public void Verify_Deductions() throws InterruptedException ,ArrayIndexOutOfBoundsException{
     deductions.check_deductions();
     deductions.get_Emp_detail();
     deductions.getEmp_SSN();
     //deductions.get_deduction_plan();
        Thread.sleep(1000);
        ArrayList<String> new_tab = new ArrayList<String>(driver.getWindowHandles());
        deductions.get_Emp_detail();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(deductions.set_select_cutomer());
        //deductions.get_Employee_deductionPlan();
    }
    @Test(priority = 25)
    public void Verify_GarnishmentPlan_calaculation() throws InterruptedException,NumberFormatException,ArithmeticException {
      //deductions.check_Garnishment_status();
        ArrayList<String> tab_check = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab_check.get(0));
        String Emp_ssn_get = String.valueOf(deductions.getEmp_SSN());
        driver.switchTo().window(tab_check.get(1));
        deductions.Employe_List_View_Search();
        js.executeScript("document.querySelector(\".la.la-filter\").click();");
        Thread.sleep(10000);
        deductions.getInput_general_search(deductions.EMP_SSN_S);
        Thread.sleep(30000);
        deductions.check_Garnishment_status();
        deductions.get_Employee_Garnishment();
        float Total_Gross_pay = hoursEarningCal.Gross_pay_calculation();
        float Total_Employee_Taxes = ltsPreviewCalculationTestbase.Employee_Taxes_F;
        System.out.println("Total Employee Taxes :"+String.format("%.2f",Total_Employee_Taxes));
        float deducted = Total_Gross_pay -Total_Employee_Taxes;
        System.out.println("Deducted :" +deducted);
        float count_percent = deducted * deductions.Garnishment_Deduction_Percentag;
        System.out.println("Counted percentage : "+count_percent);
        deductions.Garnishment_Deduction_rate_F = count_percent / 100;
        System.out.println("NMSN's For Children (POST) :"+ String.format("%.2f",deductions.Garnishment_Deduction_rate_F));
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(1000);
        driver.switchTo().window(tabs1.get(0));
        Thread.sleep(1000);
        driver.switchTo().window(tabs1.get(1));
        //ltsPreviewCalculationTestbase.getEmp_paystub_tab_click();
        Thread.sleep(10000);
        driver.switchTo().window(tabs1.get(0));
        Assert.assertEquals(String.format("%.2f",deductions.Garnishment_Deduction_rate_F),deductions.getNMSNs_For_Children_POST().getText().substring(1));
        System.out.println("Actual value :" +String.format("%.2f",deductions.Garnishment_Deduction_rate_F).toString());
        System.out.println("Expacted value :"+deductions.getNMSNs_For_Children_POST().getText().substring(1));
    }
    @Test(priority = 26)
    public void Verify_Benefit_program() throws NoSuchElementException {
        try{
            // Verify plan percheck
            ArrayList<String> tabs_Benifit = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs_Benifit.get(1));
            deductions.get_Benifit_pan();
            Assert.assertEquals(String.format("%.2f",deductions.Benefit_pecentage_F),deductions.Benefit_percentage.getText().substring(1));
            System.out.println("Actual value :" +String.format("%.2f",deductions.Benefit_flat_amount_F).toString());
            System.out.println("Expacted value :"+deductions.getBenefit_plan_amount().getText().substring(1));
            driver.switchTo().window(tabs_Benifit.get(0));
            // Verify play pay period amout
            driver.switchTo().window(tabs_Benifit.get(1));
            deductions.get_pay_period_BenefitPlan();
            Assert.assertEquals(String.format("%.2f",deductions.pay_period_Benefit_plan_amout_F),deductions.get_pay_period_plan_amount().getText().substring(1));
            System.out.println("Actual value :" +String.format("%.2f",deductions.pay_period_Benefit_plan_amout_F).toString());
            System.out.println("Expacted value :"+deductions.get_pay_period_plan_amount().getText().substring(1));
            driver.switchTo().window(tabs_Benifit.get(0));
        }catch (Exception exception){exception.printStackTrace();}
    }
    @Test(priority = 26)
    public void Verify_Deductions_Caculation(){
      try{
          ArrayList<String> tabs_Emp_paystub = new ArrayList<String>(driver.getWindowHandles());
          driver.switchTo().window(tabs_Emp_paystub.get(0));
          deductions.Deductions_caculation();
          DecimalFormat df = new DecimalFormat();
          df.setMaximumFractionDigits(2);
          Assert.assertEquals(String.format("%.2f",deductions.Total_Deductions_amout_F).toString(),deductions.Total_deductions().getText().substring(1));
          System.out.println("Actual value :" +String.format("%.2f",deductions.Total_Deductions_amout_F).toString());
          System.out.println("Expacted value :"+deductions.Total_deductions().getText().substring(1));
          }catch (Exception exception){
          exception.printStackTrace();}
    }
    @Test(priority = 27)
    public void Verify_Employee_Contributions(){
        try{
            ArrayList<String> tabs_Emp_paystub_contribution = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(deductions.Customer_view_URL);
            deductions.check_Emplyee_contribution();
            driver.navigate().refresh();
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,650)", deductions.Benefit_contribution_amount);
            deductions.get_Employee_Contribution_value();
            System.out.println("Actual value :" +String.format("%.2f",deductions.Contribution_amout_F).toString());
            System.out.println("Expacted value :"+deductions.Employee_Contribution().getText().substring(1));
        }catch (Exception exception){
            exception.printStackTrace();
            Total_calculation_Employer_Contributions();
        }
    }
    @Test(priority = 28)
    public void Verify_Total_Contributions(){
        driver.navigate().refresh();
        ArrayList<String> tabs_Emp_paystub_contribution1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs_Emp_paystub_contribution1.get(0));
        Assert.assertEquals(String.format("%.2f",deductions.Calculation_Employee_Contributions()).toString(),deductions.Total_contribution().getText().substring(1));
    }
    @Test(priority = 29)
    public void Total_calculation_Employer_Contributions(){
     deductions.Total_contribution();
    }
    @Test(priority = 30)
    public void get_Employee_Taxes2(){

    }
    @Test(priority = 31)
    public void Total_calculation_Employee_Taxes(){

    }
    @Test(priority = 32)
    public void Recalculation_check(){

    }
 }



