package com.qa.s3vin_test.Testcase;
import com.qa.s3vin_test.Action.*;
import com.qa.s3vin_test.Pages.LTS_PayDataTestBase;
import com.qa.s3vin_test.Pages.Loginpage_TestBase;
import com.qa.s3vin_test.Pages.Payroll_LTS_TestBase;
import com.qa.s3vin_test.Action.*;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LTS_Payroll_Step2 {

    public static WebDriver driver = new ChromeDriver();
    Loginpage_TestBase loginpage = new Loginpage_TestBase(driver);
    LTS_PayDataTestBase lts_payDataTestBase = new LTS_PayDataTestBase(driver);
    Add_new_payroll_Entry objAdd =new  Add_new_payroll_Entry(driver);
    Payroll_LTS_TestBase objLTS = new Payroll_LTS_TestBase(driver);
    com.qa.s3vin_test.Action.Edit_deduction Edit_deduction = new Edit_deduction(driver);
    Edit_PayRate Edit_Payrate = new Edit_PayRate(driver);
    OverridePayment overridePyment = new OverridePayment(driver);
    Override_Pay_Rate overridePayRate = new Override_Pay_Rate(driver);
    View_Minimum_Wages viewMinimumWages = new View_Minimum_Wages(driver);
    Payroll_Hold hold = new Payroll_Hold(driver);
    JavascriptExecutor js= (JavascriptExecutor)driver;
    //import_Employee_LTS employeeImport = new import_Employee_LTS();

    @BeforeTest(description = "LTS pagge set up intilization")
    @Description("S3VIN sign in page should be displayded")
    public void intilization(){
      /*  ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");*/
          driver.get(loginpage.URL());
        // driver = Helper.lunch_browser("chrome","http://7.ustaxandpayrollservices.com/staging/public/login");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         objLTS =PageFactory.initElements(driver, Payroll_LTS_TestBase.class);
    }
    @Test(description = "Verify Enter the valid Email Address & Password",priority = 0)
    @Description("Valid credentials would be passing Email and Password field clicked on sign in button it successfully logged in & Redirect to Company list Page")
    @Severity(SeverityLevel.NORMAL)@Feature("S3VIN Login functionality ")
    @AllureId("2")
    public void Verify_login_check() {
        loginpage.check_valid_credentials("user1@ustaxandpayrollservices.com", "2ytptkr3Gd");
        Allure.addAttachment("Login successfully", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Test(description = "Verify Select the company & Click on Company name",priority = 1)
    @Description("Select the \"Globex Corporation (The Simpsons)\" company & Click on Company name")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Verify company name")
    public void Check_CompanyName() throws InterruptedException {
      objLTS.setCompany_name();
      Assert.assertEquals(objLTS.Company_name().getText(),"Globex Corporation (The Simpsons)");
    }
    @Test(description = "Click on Customers tab & Select the \"R Industries\" Customer",priority = 2)
    @Description ("Click on Customers tab & Select the \"R Industries\" Customer")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Customer Profile should be displayed with Customer's Sub menu\n")
    public void Check_CustomerName() throws InterruptedException {
        objLTS.setCustomer_name();
        Assert.assertEquals(objLTS.customer_name().getText(),"R Industries");
        objLTS.setPayroll_tab();
    }
    @Test(description = "Verify that there is a provision to add Pay Data entry manually in Pay Data tab.",priority = 3)
    @Description ("Add Pay Data entry form should be displayed on clicking Add button in Pay Data tab.")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Manual Pay Data Entry - LTS Payroll Standard")
    public void Add_new_Payroll_daily() throws InterruptedException {
        objLTS.setAdd_new_Payroll_btn();
        try {
            objAdd.Pay_Period_Configuration("04/16/2023","04/16/2023","04/16/2023");
            objAdd.Employee_Details("Test_employe");
            js.executeScript("window.scrollBy(0,450)", "");
            objAdd.Timesheet_details();
            js.executeScript("window.scrollBy(0,670)", "");
            objAdd.fill_Jobsite_detail("CA-2005 - 000002005");
        }catch (NoSuchElementException e){e.printStackTrace();}
    }
    @Test(description ="verify Payroll Tab check itshould be redirect to payroll listing page",priority = 4)
    @Description("Payroll Type Configuration should display wuith below options")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Payroll tab check")
    public void check_LTSPaydata() throws InterruptedException {
        try {
            lts_payDataTestBase.check_payroll_Tab();
        }catch (Exception exception){exception.printStackTrace();}
    }
    @Test(description = "Verify Selection Timesheet",priority = 5)
    public void select_Timesheet()throws InterruptedException {
       try {
           driver.navigate().refresh();
           lts_payDataTestBase.SelectTimesheet("04/16/2023");
           lts_payDataTestBase.Calculate_Payroll();
       }catch (NoSuchElementException e){e.printStackTrace();}
    }
   /* @Test
    public void check_upaaprove_Employee() throws InterruptedException {
        driver.navigate().refresh();
        lts_payDataTestBase.SelectTimesheet("04/01/2023");
        lts_payDataTestBase.Calculate_Payroll();
    }*/
  @Test(priority = 6,enabled = false)
    public void Check_calculation() throws InterruptedException {
        lts_payDataTestBase.setCalculate_Payroll();
        lts_payDataTestBase.List_Emp();
  }
  @Test(priority = 7,enabled = false)
    public void Add_new_Emp() throws InterruptedException {
        lts_payDataTestBase.setNew_Entry_Emp();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        objAdd.Employee_Details("chintan");
        js.executeScript("window.scrollBy(0,450)", "");
        objAdd.Timesheet_details();
        js.executeScript("window.scrollBy(0,680)", "");
        objAdd.fill_Jobsite_detail("CA-2005 - 000002005");
        ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs1.get(1)).close();
        driver.switchTo().window(tabs1.get(0));
        check_Refresh_button();
  }
  @Test(priority = 8,enabled = false)
    public void Check_DeductionPlan() throws InterruptedException {
      Edit_deduction.check_edit_deduction();
  }
  @Test(priority =9,enabled = false)
    public void Edit_Payrate() throws InterruptedException {
        Edit_Payrate.check_PayRate("15.00");
        Allure.addAttachment("Pay_rate updated Successfully", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
  }
  @Test(priority = 10,enabled = false)
    public void Edit_PayrollEntry() throws InterruptedException {
      lts_payDataTestBase.Edit_PayrollEntry();
      ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
      driver.switchTo().window(tabs1.get(1));
      js.executeScript("window.scrollBy(0,450)", "");
      Thread.sleep(1000);
      objAdd.Edit_Payroll_Entry();
      js.executeScript("window.scrollBy(0,670)", "");
      Thread.sleep(1000);
      driver.switchTo().window(tabs1.get(1)).close();
      driver.switchTo().window(tabs1.get(0));
      lts_payDataTestBase.updated_Total_count();
  }
  @Test(priority = 12,enabled = false)
    public void check_Refresh_button() throws InterruptedException {
        try {
            Actions actions = new Actions(driver);
            lts_payDataTestBase.check_Refresh_button();
        }catch (Exception e){e.printStackTrace();}
  }
  @Test(priority = 13,enabled = false)
    public void check_Override_payment_Method() throws InterruptedException {
        overridePyment.Override_Payment_Eoi_shipped_checks();
        driver.navigate().refresh();
        overridePyment.Override_Payment_EOI_Direct_Diposit_chekes();
        driver.navigate().refresh();
        overridePyment.Override_Payment_Customer_Direct_Diposite_Checks();
        driver.navigate().refresh();
        overridePyment.Override_Payment_Customer_shipped_checks();
  }
  @Test(priority = 14,enabled = false)
    public void check_Override_PayRate() throws InterruptedException {
        overridePayRate.setSelect_wage_check1();
        driver.navigate().refresh();
        Thread.sleep(1000);
        overridePayRate.setSelect_wage_check2();
  }
  @Test(priority = 15,enabled = false)
    public void check_View_Minimum_Wages() throws InterruptedException {
         viewMinimumWages.check_View_Minimum_Wages();
        //viewMinimumWages.setView_Minimum_wage();
         viewMinimumWages.Export_MinimumWages();
         driver.navigate().refresh();
  }
    @Test(priority = 16,enabled = false)
    public void check_Export_Button() throws InterruptedException {
        lts_payDataTestBase.check_Export_button_Paydata();
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();",lts_payDataTestBase.Export_btn());
        js.executeScript("arguments[0].click();",lts_payDataTestBase.Wage_Paydata());
    }
  @Test(priority = 17,enabled = false)
  public void check_Hold_Employee() throws InterruptedException {
        try {
            hold.check_Hold_Emp();
            hold.setHold_status();
        }catch (Exception e){e.printStackTrace();}
  }
  @Test(priority = 18)
    public void check_Approve_calculate_payroll_Employee() throws InterruptedException {
    try {
        lts_payDataTestBase.check_Approve_calculate_payroll_Emp();
    }catch (Exception exception){exception.printStackTrace();}

  }
  @Test(priority = 19)
    public void Verify_Calculation() throws InterruptedException {
        driver.navigate().refresh();
  }

}
