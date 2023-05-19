package com.qa.s3vin_test.Testcase.Import_Testcases;

import com.qa.s3vin_test.Pages.*;
import com.qa.s3vin_test.Pages.calculation.EmpPaystub_TestBase;
import com.qa.s3vin_test.Pages.calculation.Deductions;
import com.qa.s3vin_test.Pages.calculation.Hours_Earning_cal;
import com.qa.s3vin_test.Wait_functions.Functions;
import io.reactivex.rxjava3.functions.Supplier;
import lombok.val;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Testing {
    public WebDriver driver = new ChromeDriver();
    Hours_Earning_cal hoursEarningCal= new Hours_Earning_cal(driver);
    JavascriptExecutor js= (JavascriptExecutor)driver;
    Deductions deductions = new Deductions(driver);
     EmpPaystub_TestBase empPaystubTestBase = new EmpPaystub_TestBase(driver);
    LTS_PreviewCalculation_TestBase ltsPreviewCalculationTestBase = new LTS_PreviewCalculation_TestBase(driver);
    Loginpage_TestBase loginpageTestBase = new Loginpage_TestBase(driver);
    Payroll_LTS_TestBase payrollLtsTestBase = new Payroll_LTS_TestBase(driver);

    LTS_PayDataTestBase lts_payDataTestBase = new LTS_PayDataTestBase(driver);

    Payroll_DetailsTestbase payrollDetailsTestbase = new Payroll_DetailsTestbase(driver);

    EmpPaystub_TestBase deductionTestBase = new EmpPaystub_TestBase(driver);

    LTS_PreviewCalculation_TestBase  ltsPreviewCalculationTestbase = new LTS_PreviewCalculation_TestBase(driver);

    Functions functions = new Functions(driver);

    @Test(priority = 0)
    public void getLoginpageTestBase() {
        driver.get(loginpageTestBase.URL());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginpageTestBase.check_valid_credentials("user1@ustaxandpayrollservices.com","2ytptkr3Gd");
    }
    @Test(priority = 1)
    public void getpayroll() throws InterruptedException {
       /* payrollLtsTestBase.setCompany_name();
        payrollLtsTestBase.setCustomer_name();
        payrollLtsTestBase.setPayroll_tab();
        lts_payDataTestBase.SelectTimesheet("03/08/2023");
        lts_payDataTestBase.Calculate_Payroll();
        lts_payDataTestBase.setCalculate_Payroll();*/
    }
    @Test(priority = 2,enabled = false)
    public void check_garnishment_paln_calculation() throws InterruptedException, ParseException {
      /*  lts_payDataTestBase.check_Approve_calculate_payroll_Emp();
        ltsPreviewCalculationTestbase.Preview_Calculation_get_details();
        ltsPreviewCalculationTestbase.Employee_list();
        ltsPreviewCalculationTestbase.get_Employee_Paystub_details();*/
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/generate-payroll/168?_token=e0nTU3T6KTmzs1krFDSXhfyLvaQu4UvMgPCSC4Td&selectedPayPeriod=5062&companyOnboardingId=168&active_tab_name=LTS&profile_tab=paydata&type=lts") ;Thread.sleep(1000);
        ltsPreviewCalculationTestBase.get_Employee_Paystub_details();
        ltsPreviewCalculationTestBase.Preview_Calculation_get_details();
        Thread.sleep(1000);
        //call Edit values
        ltsPreviewCalculationTestbase.Emp_list_switch();
        driver.navigate().refresh();
        Thread.sleep(10000);
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1));
        js.executeScript("window.scrollBy(0,450)", "");
        //objAdd.setTimesheet_details();
        hoursEarningCal.setTimesheet_details();
        hoursEarningCal.setTimesheet_calculation();
        float Total_Gross_pay =  hoursEarningCal.Gross_pay_calculation();
        System.out.println("Gross pay calculate = "+Total_Gross_pay);;
        driver.switchTo().window(tabs1.get(1)).close();
        driver.switchTo().window(tabs1.get(0));
        ltsPreviewCalculationTestbase.getEmp_paystub_tab_click();
        ArrayList<String> tabs_CLICK = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/customer/employee/profile-tab/195125/1");
        //deductions.check_Garnishment_status();
       float get_percentage = deductions.get_Employee_Garnishment();
       System.out.println("Get percentage" +get_percentage);
       float print = (Total_Gross_pay / 100 * get_percentage);
       System.out.println("toal count "+ print);
       driver.navigate().refresh();
       Thread.sleep(10000);
       deductions.get_Garnishment_all_other_paln();
    }
    @Test(priority = 3,enabled = false)
    public void check_Benifit_plan_Calculation() throws InterruptedException {
        EmpPaystub_TestBase deductionTestBase = new EmpPaystub_TestBase(driver);
        val totalDeductionsAmoutF = deductionTestBase.Total_Deductions_amout_F;
        Supplier<Float> supplier = () -> totalDeductionsAmoutF;
    }
    @Test(priority = 4,enabled = false)
    public void check_Taxes() throws InterruptedException {
        driver.get("http://7.ustaxandpayrollservices.com/staging/public/admin/company/generate-payroll/110?_token=Ntd3Sa1Vb1TeUiadcNJ5XVvswJWd0i5nVOj2wszO&selectedPayPeriod=4497&companyOnboardingId=110&active_tab_name=LTS&profile_tab=paydata&type=lts");
        Thread.sleep(2000);
        ltsPreviewCalculationTestbase.getEmp_paystub_tab_click();
        ltsPreviewCalculationTestbase.get_Employee_Paystub_details();
        ltsPreviewCalculationTestbase.get_Employee_Taxes();
    }
    @Test(priority = 5,enabled = false)
    public void Emp_calculation(){
        deductionTestBase.Emp_Taxes_Negetive_value_check();
        deductionTestBase.Employeer_Taxes_Nagetive_values_check();
    }
    @Test(priority = 6,enabled = false)
    public void Generate_Payroll() throws InterruptedException {
      empPaystubTestBase.Genrate_Payroll_btn_click();
        // explicit wait condition
        Thread.sleep(60000);
        empPaystubTestBase.Go_Payroll_details();
        Thread.sleep(1000);
       /* payrollDetailsTestbase.getPayroll_btn_status();
        System.out.println(payrollDetailsTestbase.getPayroll_btn_status().getText());*/
    }
    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(70000));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }
    @Test(priority = 7)
    public void Verify_Export_Reports() throws InterruptedException {
        try{
            driver.get("http://7.ustaxandpayrollservices.com/staging/public/admin/reports/invoices/110/4497/report");
            payrollDetailsTestbase.Reports();
            payrollDetailsTestbase.All_PDF_reports();
            payrollDetailsTestbase.All_excel_Export_reports();
            waitForPageLoad();
            Thread.sleep(10000);
            driver.navigate().refresh();
            payrollDetailsTestbase.All_Export_reports();
            waitForPageLoad();
            driver.navigate().refresh();
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click()",payrollDetailsTestbase.check_Register());
            waitForPageLoad();
            payrollDetailsTestbase.check_Worker_Comp_Report_Export();
            payrollDetailsTestbase.check_ACA_Report_Export();
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
