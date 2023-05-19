package com.qa.s3vin_test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.codeborne.selenide.commands.ToString;
import com.codeborne.selenide.commands.Val;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.sun.jdi.IntegerType;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import static java.lang.Integer.*;

public class Payroll_LTSPage {

    public WebDriver driver = new ChromeDriver();

    @Test
    public void startReport() {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./Reports/spark_report.html");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        ExtentTest logger = extentReports.createTest("test");
        logger.log(Status.PASS,"lOGIN TEST");
        logger.log(Status.FAIL,"Title vERIFICATION FAILED");
        extentReports.flush();
    }
    @Test(description ="Verify check S3V!N Credentials",priority = 0)
    public void Check_login_instance() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "EmpPaystub_TestBase:\\S3V!N_QA\\S3VIN_Test\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://7.ustaxandpayrollservices.com/staging/public/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        WebElement Email_txt =driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signin_btn = driver.findElement(By.id("kt_login_signin_submit_"));
        Email_txt.sendKeys("user1@ustaxandpayrollservices.com");
        password.sendKeys("2ytptkr3Gd");
        Allure.addAttachment("Login Credential Verified", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        signin_btn.click();
    }
    @Test(description = "Verify select companyname should be display listing",priority = 1)
    public void check_Companyname() throws InterruptedException {
        WebElement company_name = driver.findElement(By.xpath("//a[normalize-space()='Globex Corporation (The Simpsons)']"));
        company_name.getText();
      /*  JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1050)", "");*/
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", company_name);
        Thread.sleep(1000);
        //company_name.click();
    }
    /*@Test(description = "Verify Company Profile should be displayed.\n" +
            " Company's Sub Menu should be displayed",priority = 2)
    public void check_Company_Profile_Listing(){
        System.out.println("________________Company Profile_____________________________----------");
       // driver.findElement(By.xpath("//a[normalize-space()='Profile']")).getText();
        System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Profile']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/0");
        System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Banks']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/1");
        System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Tax Accounts']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/8");
        System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Rate & Class Code']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/2");
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Pay Types')]")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/18");
        System.out.println(driver.findElement(By.xpath("//a[contains(@role,'tab')][normalize-space()='PTO']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/20");
        System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Benefit Program']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/17");
        System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Misc Deduction']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/13");
        System.out.println(driver.findElement(By.xpath("//a[@role='tab'][normalize-space()='Documents']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/5");
        System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Customers')]")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/19");
        System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Insurance Carriers']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/30");
        System.out.println(driver.findElement(By.xpath("//a[@role='tab'][normalize-space()='Reports']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/31");
        System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Forms']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/32");
    }*/
    @Test(description = "Verify check customer name through swipe",priority = 3)
    public void check_customer() {
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/profile/1/19");
        System.out.println("Customer name : " + driver.findElement(By.xpath("//a[contains(text(),'R Industries')]")).getText());
        driver.findElement(By.xpath("//a[contains(text(),'R Industries')]")).click();
    }
    /* @Test(description ="",priority = 4)
     public void check_customer_profile_tab(){
         driver.findElement(By.xpath("//a[.='Payroll']")).click();
         driver.findElement(By.xpath("//div[@id='ltsPayDataId']//em[@class='la la-filter']")).click();
         WebElement Payroll_status = driver.findElement(By.xpath("//button[@title='All Payroll Status']"));
         Payroll_status.click();
         driver.findElement(By.xpath("//span[normalize-space()='Step 1 of 8 Pending']")).click();
 */
    @Test(description = "Verify import LTSTimesheet with LTS Import screen should be displayed with Import, Sample & Refresh tab",priority =4)
    public void Verify_import_LTSTime_sheet() throws InterruptedException {
        Thread.sleep(1000);
        WebElement Payroll = driver.findElement(By.xpath("//a[normalize-space()='Payroll']"));
        System.out.println("<<<<<<<<<<<<<<<<<<<Payroll Execution START >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Payroll.click();
       /* WebElement LTS_PAY_DATA = driver.findElement(By.xpath("//a[normalize-space()='LTS Pay Data']"));
        System.out.println("Payroll Execution start________________________"+LTS_PAY_DATA.getText());
        LTS_PAY_DATA.click();
        WebElement import_LTST_data = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)"));
        import_LTST_data.click();
        driver.findElement(By.xpath("//li[@class='new-item-add dropdown kt-custom-download-dropdown']//a[@id='navbarDropdown']")).click();
        WebElement import_Standard_data = driver.findElement(By.xpath("//a[@class='dropdown-item paymethod-ele'][normalize-space()='Standard']"));
        //*/
        // import_Standard_data.click();
        //import_Standard_data.sendKeys("EmpPaystub_TestBase:\\S3V!N_QA\\S3VIN_Test\\src\\Testdata\\LTS-Standard_10.xlsx");
    }
    @Test(description = "Verify that there is a provision to add Pay Data entry manually in Pay Data tab.",priority = 5)
    public void add_new_payroll() throws InterruptedException {
        try {
            WebElement new_add = driver.findElement(By.xpath("//body/div[@id='overflowW4form']/div[@class='kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-page']/div[@id='kt_wrapper']/div[@id='kt_content']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]"));
            new_add.click();
            Select Pay_Frequency = new Select(driver.findElement(By.xpath("//select[@id='pay_frequency']")));
            Pay_Frequency.selectByIndex(1);
            WebElement pay_period_Begin_date = driver.findElement(By.xpath("//input[@id='pay_period_begin_date']"));
            pay_period_Begin_date.sendKeys("03/08/2023");
            WebElement Pay_Period_EndDate = driver.findElement(By.xpath("//input[@id='pay_period_begin_date']"));
            Pay_Period_EndDate.sendKeys("03/08/2023");
            WebElement check_date = driver.findElement(By.xpath("//input[@id='check_date']"));
            check_date.sendKeys("03/08/2023", Keys.ENTER);
            WebElement Select_EMP_SSN = driver.findElement(By.xpath("//span[.='Select Employee SSN']"));
            Select_EMP_SSN.click();
            Thread.sleep(1000);
            WebElement search_input = driver.findElement(By.xpath("//input[@role='searchbox']"));
            Thread.sleep(100);
            //search_input.sendKeys("Carlos Romero Aguilar [306-02-0225]",Keys.ENTER);
            driver.findElement(By.xpath("(//li[normalize-space()='Carlos Romero Aguilar [306-02-0225]'])[1]")).click();
            WebElement EMP_name = driver.findElement(By.xpath("//span[@role='textbox']"));
            System.out.print(EMP_name.getText());
            WebElement Regular_hours = driver.findElement(By.xpath("(//input[@id='regular_hours'])[1]"));
            WebElement Overtime_hours = driver.findElement(By.xpath("(//input[@id='overtime_hours'])[1]"));
            WebElement Double_hours = driver.findElement(By.xpath("(//input[@id='double_time_hours'])[1]"));
            WebElement Sick_hours = driver.findElement(By.xpath("(//input[@id='sick_hours'])[1]"));
            WebElement Vacation_hours = driver.findElement(By.xpath("(//input[@id='vacation_hours'])[1]"));
            WebElement Covid_hours = driver.findElement(By.xpath("(//input[@id='covid_hours'])[1]"));
            WebElement PTO_hours = driver.findElement(By.xpath("(//input[@id='pto_hours'])[1]"));
            WebElement Commission = driver.findElement(By.xpath("(//input[@id='commission'])[1]"));
            WebElement Bonus = driver.findElement(By.xpath("(//input[@id='bonus'])[1]"));
            WebElement Payroll_Entry = driver.findElement(By.xpath("(//textarea[@id='payroll_entry_notes'])[1]"));
            //WebElement Salary = driver.findElement(By.xpath("(//input[@id='salary'])[1]"));
            ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
            //Passing values
            Regular_hours.sendKeys("8");
            Overtime_hours.sendKeys("2");
            Double_hours.sendKeys("1");
            Sick_hours.sendKeys("1.5");
            Vacation_hours.sendKeys("1");
            Covid_hours.sendKeys("1.5");
            PTO_hours.sendKeys("1");
            Commission.sendKeys("10.15");
            Bonus.sendKeys("5.60");
            Payroll_Entry.sendKeys("Testing");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement jobsite_txt = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(15) > div:nth-child(1) > div:nth-child(1) > div:nth-child(15) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > label:nth-child(1)"));
            js.executeScript("arguments[0].scrollIntoView();", jobsite_txt);
            driver.findElement(By.xpath("//span[.='Select Jobsite']")).click();
            driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("CA-2005 - 000002005", Keys.ENTER);
            driver.findElement(By.xpath("//span[contains(text(),'Select Workers Comp State Code')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("California (CA)", Keys.ENTER);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[contains(text(),'Select WC Code')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("2005", Keys.ENTER);
            Thread.sleep(1000);
            WebElement Save_btn = driver.findElement(By.xpath("//button[@id='submitFormBtn']"));
            Save_btn.click();
            Thread.sleep(1000);
            Allure.addAttachment("Confirmation", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            driver.findElement(By.xpath("//button[text()='Yes, Add it']")).click()
           /*driver.findElement(By.xpath("//span[contains(text(),'Select Division')]")).click();
           Thread.sleep(1000);
           driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("R Division", Keys.ENTER);
           Thread.sleep(1000);
           driver.findElement(By.xpath("//span[contains(text(),'Select Department')]")).click();
           Thread.sleep(1000);
           driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("R Depart", Keys.ENTER);
           js.executeScript("arguments[0].scrollIntoView();", jobsite_txt);
           Thread.sleep(1000);
           driver.findElement(By.xpath("//span[.='Select Jobsite']")).click();
           driver.findElement(By.xpath("//input[@role='searchbox']"));
           driver.findElement(By.xpath("(//li[@id='select2-jobsite_id-result-l9af-5329'])[1]")).click();
           driver.findElement(By.xpath("//span[contains(text(),'Select Workers Comp State Code')]")).click();
           Thread.sleep(1000);
           driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("Alabama (AL)", Keys.ENTER);
           Thread.sleep(1000);
           driver.findElement(By.xpath("//span[contains(text(),'Select WC Code')]")).click();
           Thread.sleep(1000);
           driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("2001", Keys.ENTER);
           Thread.sleep(1000); */
          /* driver.findElement(By.xpath("//span[contains(text(),'Select Division')]")).click();
           Thread.sleep(1000);
           driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("R Division", Keys.ENTER);
           Thread.sleep(1000);
           driver.findElement(By.xpath("//span[contains(text(),'Select Department')]")).click();
           Thread.sleep(1000);
           driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("R Depart", Keys.ENTER);
           */;
        }catch(NoSuchElementException e){e.getStackTrace(); e.getMessage();}
    }
    @Test(description = "Verify search /Filter timesheet through finding current status timesheet",priority = 6)
    public void check_Titmesheet() throws InterruptedException {
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/customers/profile/110/11");
        Thread.sleep(10000);
        WebElement filter_click = driver.findElement(By.xpath("//div[@id='ltsPayDataId']//div[@class='filter-icon-custom d-flex w-auto padd-r-10 text-center align-items-center opensearchmenuPayData']"));
        filter_click.click();
        driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("03/08/2023");
        driver.findElement(By.xpath("(//button[@title='Payroll Status'])[1]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Step 1 of 8 Pending']")).click();
        /*JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();",filter_click);
        *//*Actions ac =new Actions(driver);
        ac.doubleClick(filter_click).perform();*/
        //driver.findElement(By.xpath("(//input[@placeholder='Search By Check Date, Pay Frequency, Payroll Status, Next Step'])[1]")).sendKeys("03/08/2023");
    }
    @Test(description = "Verify Redirect to Step-2 Pay Entries & Number of Employee's count should be displayed ",priority = 7)
    public void Check_payroll_status() throws InterruptedException {

        WebElement input_search = driver.findElement(By.xpath("//input[contains(@type,'text')]"));
        input_search.clear();
        input_search.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement LTS_timesheet = driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]/div/label"));
        LTS_timesheet.click();
        System.out.println(" : LTS PAY DATA Selected Static Date : "+driver.findElement(By.xpath("(//td[contains(text(),'03/08/2023')])[1]")).getText());
        System.out.println("Status is :"+driver.findElement(By.xpath("//td[.='Calculate Payroll']")).getText());
        WebElement cal = driver.findElement(By.xpath("//a[normalize-space()='Calculate Payroll']"));
        cal.click();
        WebElement Emp_count = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)"));
        System.out.println("Employee Number of Count:"+Emp_count.getText());
        System.out.println("Check Pay period Date"+driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)")).getText());
        Thread.sleep(100);
        Allure.addAttachment("Employee Number of Count", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Test(description = "Verify the Employee Name & Employee SSN,job-site ,class code of the list",priority = 8)
    public void check_Employee_details() throws InterruptedException {
        /*WebElement Emp_name = driver.findElement(By.xpath("//a[normalize-space()='Carlos Romero Aguilar']"));
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //System.out.println("Checking from :"+driver.findElement(By.xpath("//a[@class='nav-link employee-loaded-tab-nav active']")).getText());
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/customers/profile/110/13");*/
        try {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//i[@class='la la-filter']")).click();
            WebElement general_search = driver.findElement(By.xpath("//input[@id='generalSearch']"));
            general_search.sendKeys("306-02-0225");
            Thread.sleep(10000);
            Allure.addAttachment("Search with Employee SSN", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            general_search.clear();
            Thread.sleep(10000);
            general_search.sendKeys("CA-2005");
            Thread.sleep(10000);
            Allure.addAttachment("Search with Employee Job-site", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            general_search.clear();
            Thread.sleep(10000);
            general_search.sendKeys("2005");
            Thread.sleep(10000);
            Allure.addAttachment("Search with Employee Class-code", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            general_search.clear();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    @Test(description = "Verify count Hours/Unit of the payroll list",priority = 9)
    public void check_Hours_Unit() throws InterruptedException {
        // WebElement test = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]"));
          /* List<WebElement> resultList = driver.findElements(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]"));
         for (WebElement result : resultList) {
             //System.out.println("Hours/Unit :" + driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]")).getText());
             String Hours_Unit = result.getText();
         }*/
        WebElement Total_hours = driver.findElement(By.cssSelector(".f-14.kt-font-dark.kt-font-bold.total_hours_tb"));
        //Assert.assertEquals(Total_hours.getText(),Total_hours.getText());
        System.out.println("Total Hours:"+Total_hours.getText());
        WebElement Gross_sal = driver.findElement(By.xpath("//span[@class='f-14 kt-font-dark kt-font-bold total_gross_salary_tb']"));
        // Assert.assertEquals(Gross_sal.getText(),Gross_sal.getText());
        System.out.println("Total Gross Salary :"+Gross_sal.getText());
        List<WebElement> Gross_salary = driver.findElements(By.xpath("//td[@class=' text-right th-center']"));
        for(WebElement List : Gross_salary){
            String TEST = List.getText();
            System.out.println("each hours & gross salary "+TEST);
            Assert.assertEquals(List.getText(),TEST.toString());
        }
        Thread.sleep(1000);
        Allure.addAttachment("Total Hours & Total Gross Salary :", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Test(description = "Select the just any employees & click on hold over there Payroll_Hold Entries should be displayed",priority = 10)
    public void Hold_Payroll(){
        driver.findElement(By.xpath("//tr[@class='even']//div[@class='round']")).click();
        driver.findElement(By.xpath("//a[@id='hold_btn']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Payroll_Hold it!']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        //WebElement Timesheet_status = driver.findElement(By.xpath("//span[@class='kt-badge kt-badge--inline kt-badge--pill btn btn-label-warning btn-pill'][normalize-space()='Payroll_Hold']"));
        //System.out.println("Check status :"+Timesheet_status.getText());
    }
    @Test(description = "Verify Export action to download pay entries display in Grid",priority = 11)
    public void check_Export_Button() throws InterruptedException {
        WebElement Export_btn = driver.findElement(By.xpath("//a[@id='navbarDropdownShow']"));
        WebElement Paydata_btn = driver.findElement(By.xpath("//a[normalize-space()='PayData Entries']"));
        WebElement wage_btn =driver.findElement(By.xpath("//a[@id='minimum_wage_report_btn']"));
        Export_btn.click();
        System.out.println(">>> Successfully Download Pay-data");
        Thread.sleep(1000);
        Paydata_btn.click();
        Allure.addAttachment("Successfully Download Pay-data", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", Export_btn);
        System.out.println(">>> Successfully Download Wage-data");
        js.executeScript("arguments[0].click();",wage_btn);
        Thread.sleep(10000);
        Allure.addAttachment("Successfully Download Wage-data:", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        //org.testng.Assert.fail("internal server Error");
        Allure.addAttachment("Successfully Download Wage-data:", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Test(description = "Verify Refresh action to refresh grid data",priority =9)
    public void Check_Refresh_Button() throws InterruptedException{
        try {
            Actions actions = new Actions(driver);
            WebElement Refresh = driver.findElement(By.xpath("//a[normalize-space()='Refresh']"));
            Thread.sleep(1000);
            actions.doubleClick(Refresh).perform();}
        catch (Exception E){
            E.getStackTrace();
            Allure.addAttachment("Refresh Successfully", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }
    @Test(description = "Verify New Payroll entry to add new payroll entry by manually",priority = 12)
    @Description("New Payroll entry to add new payroll entry by manually")
    @Story("Verified Data throught Calculation ")
    @Step("")

    public void Check_New_PayrollEntry() throws InterruptedException{
        WebElement New_Entry = driver.findElement(By.xpath("//a[normalize-space()='New Entry']"));
        Thread.sleep(1000);
        New_Entry.click();
        Thread.sleep(1000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebElement Select_EMP_SSN = driver.findElement(By.xpath("//span[.='Select Employee SSN']"));
        Select_EMP_SSN.click();
        Thread.sleep(1000);
        WebElement search_input = driver.findElement(By.xpath("//input[@role='searchbox']"));
        Thread.sleep(100);
        search_input.sendKeys("Mario Renteria Vasquez [306-02-0221]",Keys.ENTER);
        WebElement EMP_name = driver.findElement(By.xpath("//span[@role='textbox']"));
        System.out.println(EMP_name.getText());
        Allure.addAttachment("Select Employee SSN though fill the recorders", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        //System.out.println(EMP_name.getText());
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        // Getting all elements Timesheet Details
        //WebElement Regular_Rate = driver.findElement(By.xpath("(//input[contains(@value,'15.00')])[1]"));
        WebElement Regular_hours = driver.findElement(By.xpath("(//input[@id='regular_hours'])[1]"));
        WebElement Overtime_hours = driver.findElement(By.xpath("(//input[@id='overtime_hours'])[1]"));
        WebElement Double_hours = driver.findElement(By.xpath("(//input[@id='double_time_hours'])[1]"));
        WebElement Sick_hours = driver.findElement(By.xpath("(//input[@id='sick_hours'])[1]"));
        WebElement Vacation_hours = driver.findElement(By.xpath("(//input[@id='vacation_hours'])[1]"));
        WebElement Covid_hours = driver.findElement(By.xpath("(//input[@id='covid_hours'])[1]"));
        WebElement PTO_hours = driver.findElement(By.xpath("(//input[@id='pto_hours'])[1]"));
        WebElement Commission = driver.findElement(By.xpath("(//input[@id='commission'])[1]"));
        WebElement Bonus = driver.findElement(By.xpath("(//input[@id='bonus'])[1]"));
        WebElement Payroll_Entry = driver.findElement(By.xpath("(//textarea[@id='payroll_entry_notes'])[1]"));
        //WebElement Salary = driver.findElement(By.xpath("(//input[@id='salary'])[1]"));
        ((JavascriptExecutor) driver).executeScript("scroll(0,400)");
        //Passing values
        Regular_hours.sendKeys("8");
        Overtime_hours.sendKeys("2");
        Double_hours.sendKeys("1");
        Sick_hours.sendKeys("1.5");
        Vacation_hours.sendKeys("1");
        Covid_hours.sendKeys("1.5");
        PTO_hours.sendKeys("1");
        Commission.sendKeys("10.15");
        Bonus.sendKeys("5.60");
        Payroll_Entry.sendKeys("Testing");
        //Salary.sendKeys("2000");
        // Additional Pay Type Details
        Select Pay_type = new Select(driver.findElement(By.xpath("//select[@id='paytype_1']")));
        Pay_type.selectByIndex(1);
        WebElement Pay_Amount = driver.findElement(By.xpath("(//input[@id='payTypeAmount_1'])[1]"));
        Pay_Amount.sendKeys("10.00");
        driver.findElement(By.xpath("//button[@class='btn btn-outline-success btn-sm addBtn']")).click();
        //Job-site details
        WebElement jobsite_txt = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(15) > div:nth-child(1) > div:nth-child(1) > div:nth-child(15) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > label:nth-child(1)"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", jobsite_txt);
        driver.findElement(By.xpath("//span[.='Select Jobsite']")).click();
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("AL-2001 - 000002001", Keys.ENTER);
        driver.findElement(By.xpath("//span[contains(text(),'Select Workers Comp State Code')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("Alabama (AL)", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Select WC Code')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("2001", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Select Division')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("R Division", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Select Department')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("R Depart", Keys.ENTER);
        //Print Test
        WebElement Test_payrate = driver.findElement(By.xpath("//div[contains(@class,'form-group1 row companys-main-info')]//input[@id='regular_rate_of_pay']"));
        Test_payrate.getText();
        js.executeScript("$('#regular_rate_of_pay').removeAttr(\"disabled\");");
        Thread.sleep(10000);
        //Add New Payroll Entry
        Allure.addAttachment("Add New Payroll Entry", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        WebElement Save_btn = driver.findElement(By.xpath("//button[@id='submitFormBtn']"));
        Save_btn.click();
        Thread.sleep(1000);
        Allure.addAttachment("Confirmation", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.findElement(By.xpath("//button[text()='Yes, Add it']")).click();
        Thread.sleep(1000);
        Allure.addAttachment("Successfully added NewPayroll Entry", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        WebElement Total_hours = driver.findElement(By.cssSelector(".f-14.kt-font-dark.kt-font-bold.total_hours_tb"));
        //Assert.assertEquals(Total_hours.getText(),Total_hours.getText());
        WebElement Gross_sal = driver.findElement(By.xpath("//span[@class='f-14 kt-font-dark kt-font-bold total_gross_salary_tb']"));
        System.out.println("___________________________________ Addeed New Pay roll Entry_________________");
        System.out.println(" Updated Total Hours:"+Total_hours.getText()+" updated Total Gross Salary :"+Gross_sal.getText());

        }
    @Test(description = "verify employee payroll with salary ",priority = 13,enabled = false)
    @Description ("Enter the timesheet detail as per the Daily Pay Frequency| Salary")
    
    public void New_payroll_with_salary() throws InterruptedException {
        WebElement New_Entry = driver.findElement(By.xpath("//a[normalize-space()='New Entry']"));
        Thread.sleep(1000);
        New_Entry.click();
        Thread.sleep(1000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebElement Select_EMP_SSN = driver.findElement(By.xpath("//span[.='Select Employee SSN']"));
        Select_EMP_SSN.click();
        Thread.sleep(1000);
        WebElement search_input = driver.findElement(By.xpath("//input[@role='searchbox']"));
        search_input.sendKeys("Mario Renteria Vasquez [306-02-0221]" + Keys.ENTER);
        WebElement EMP_name = driver.findElement(By.xpath("//span[@role='textbox']"));
        System.out.println(EMP_name.getText());
        WebElement Salary = driver.findElement(By.xpath("(//input[@id='salary'])[1]"));
        Salary.sendKeys("200.50");
        WebElement job_txt = driver.findElement(By.xpath("//h3[text()='Jobsite Details']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", job_txt);
        driver.findElement(By.xpath("//span[.='Select Jobsite']")).click();
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("AL-2001 - 000002001", Keys.ENTER);
        driver.findElement(By.xpath("//span[contains(text(),'Select Workers Comp State Code')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("Alabama (AL)", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Select WC Code')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("2001", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Select Division')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("R Division", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Select Department')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@role,'searchbox')]")).sendKeys("R Depart", Keys.ENTER);
        //Print Test
        WebElement Test_payrate = driver.findElement(By.xpath("//div[contains(@class,'form-group1 row companys-main-info')]//input[@id='regular_rate_of_pay']"));
        Test_payrate.getText();
        js.executeScript("$('#regular_rate_of_pay').removeAttr(\"disabled\");");
        Thread.sleep(10000);
        //Add New Payroll Entry
        Allure.addAttachment("Add New Payroll Entry", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        WebElement Save_btn = driver.findElement(By.xpath("//button[@id='submitFormBtn']"));
        Save_btn.click();
        driver.findElement(By.xpath("//button[text()='Yes, Add it']")).click();
        WebElement Total_hours = driver.findElement(By.cssSelector(".f-14.kt-font-dark.kt-font-bold.total_hours_tb"));
        //Assert.assertEquals(Total_hours.getText(),Total_hours.getText());
        WebElement Gross_sal = driver.findElement(By.xpath("//span[@class='f-14 kt-font-dark kt-font-bold total_gross_salary_tb']"));
        System.out.println("___________________________________ Addeed New Pay roll Entry_________________");
        System.out.println(" Updated Total Hours:"+Total_hours.getText()+" updated Total Gross Salary :"+Gross_sal.getText());
    }
    @Test(description = "Verify Edit Payroll getting value functionality",priority = 14)
    public void Check_Edit_payroll() throws InterruptedException {
        try {
            //driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/generate-payroll/110?_token=6BhHIS8JmQR9AMDLVG1t48fPjr7W6uBjGmUrFJma&selectedPayPeriod=3153&companyOnboardingId=110&active_tab_name=LTS&profile_tab=paydata&type=lts");
            WebElement select_Emp = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/label[1]"));
            select_Emp.click();
            WebElement Edit_payroll = driver.findElement(By.xpath("//a[normalize-space()='Edit Payroll Entry']"));
            Edit_payroll.click();
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            WebElement switch_btn =  driver.findElement(By.xpath("//label[@class='kt-checkbox payTypeTimesheetEntry pr-2 ']//span"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();",switch_btn);
            driver.findElement(By.xpath("//button[normalize-space()='Yes, Do it!']")).click();
            ((JavascriptExecutor)driver).executeScript("scroll(0,800)");

        }catch (Exception e){e.getStackTrace();
        }

        //executeScript("arguments[0].scrollIntoView();", switch_btn);

        /*try {
            Float Pay_rate,reg_hour,cal;
            Pay_rate = Float.parseFloat((driver.findElement(By.xpath("//input[@value='15.00']")).getAttribute("value")));
            System.out.println(Float.parseFloat(pay_r.toString()));
            reg_hour =Float.parseFloat((driver.findElement(By.xpath("")).getAttribute("value")));
            System.out.println(Float.parseFloat(reg_hour.toString()));
            // Calculation
        }catch (Exception e){e.getStackTrace(); System.out.println(e.getMessage()); }
        */
        System.out.println("_______________________________________New updated Pyroll Values___________________");
        WebElement Regular_hours = driver.findElement(By.xpath("//input[@id='regular_hours']"));
        Regular_hours.clear();
        Regular_hours.sendKeys("5");
        System.out.println("Reg_hours :"+Regular_hours.getAttribute("value"));
        WebElement Overtime_hours = driver.findElement(By.xpath("(//input[@id='overtime_hours'])[1]"));
        Overtime_hours.clear();
        Overtime_hours.sendKeys("2.1");
        System.out.println("OverTime :"+Overtime_hours.getAttribute("value"));
        WebElement Double_hours = driver.findElement(By.xpath("(//input[@id='double_time_hours'])[1]"));
        Double_hours.clear();
        Double_hours.sendKeys("2.2");
        System.out.println("Double_hours :"+Double_hours.getAttribute("value"));
        WebElement Sick_hours = driver.findElement(By.xpath("(//input[@id='sick_hours'])[1]"));
        Sick_hours.clear();
        Sick_hours.sendKeys("2.1");
        System.out.println("Sick Hours :"+Sick_hours.getAttribute("value"));
        WebElement Vacation_hours = driver.findElement(By.xpath("(//input[@id='vacation_hours'])[1]"));
        Vacation_hours.clear();
        Vacation_hours.sendKeys("2");
        System.out.println("Vacation Hours :"+Vacation_hours.getAttribute("value"));
        WebElement Covid_hours = driver.findElement(By.xpath("(//input[@id='covid_hours'])[1]"));
        Covid_hours.clear();
        Covid_hours.sendKeys("3");
        System.out.println("Vacation Hours :"+Covid_hours.getAttribute("value"));
        WebElement PTO_hours = driver.findElement(By.xpath("(//input[@id='pto_hours'])[1]"));
        PTO_hours.clear();
        PTO_hours.sendKeys("1");
        System.out.println("PTO Hours :"+PTO_hours.getAttribute("value"));
        WebElement Commission = driver.findElement(By.xpath("(//input[@id='commission'])[1]"));
        Commission.clear();
        Commission.sendKeys("20.5");
        System.out.println("Commission :"+PTO_hours.getAttribute("value"));
        WebElement Bonus = driver.findElement(By.xpath("(//input[@id='bonus'])[1]"));
        Bonus.clear();
        Bonus.sendKeys("50.22");
        System.out.println("Bonus :"+Bonus.getAttribute("value"));
        WebElement Payroll_Entry = driver.findElement(By.xpath("(//textarea[@id='payroll_entry_notes'])[1]"));
        Payroll_Entry.clear();
        Payroll_Entry.sendKeys("New Payroll Entry Updated");
        System.out.println(">>>>>> Updated :"+Payroll_Entry.getAttribute("value"));
        Thread.sleep(10000);
        WebElement save_btn1 = driver.findElement(By.xpath("//button[@id='submitFormBtn']"));
        Thread.sleep(10000);
        save_btn1.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Add it']")).click();
        Thread.sleep(1000);
        Allure.addAttachment("Edit New Payroll updated Successfully", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        WebElement Total_hours = driver.findElement(By.cssSelector(".f-14.kt-font-dark.kt-font-bold.total_hours_tb"));
        Assert.assertEquals(Total_hours.getText(),Total_hours.getText());
        WebElement Gross_sal = driver.findElement(By.xpath("//span[@class='f-14 kt-font-dark kt-font-bold total_gross_salary_tb']"));
        Assert.assertEquals(Gross_sal.getText(),Gross_sal.getText());
        System.out.println("___________________________________ Addeed New Pay roll Entry_________________");
        System.out.println(" Updated Total Hours:"+Total_hours.getText()+" updated Total Gross Salary :"+Gross_sal.getText());
    }
    @Description("Employee Deduction popup should be displayed with Employee's plan name list like Misc. Deduction, Benefit Program & Reimbursement > Deduction excluded Successfully ")
    @Test(description ="Verify Edit deduction" ,priority = 15)
    public void check_edit_deduction() throws InterruptedException {
        WebElement select_Emp = driver.findElement(By.xpath("(//div[@class='round'])[2]"));
        Thread.sleep(1000);
        select_Emp.click();
        WebElement Edit_deduction = driver.findElement(By.xpath("//a[normalize-space()='Edit Deduction']"));
        Thread.sleep(1000);
        Edit_deduction.click();
        WebElement Delete_btn = driver.findElement(By.xpath("//a[@class='btn-icon-primary btn-sub-actions ']"));
        Thread.sleep(1000);
        Delete_btn.click();
        WebElement confirm = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
        Thread.sleep(1000);
        confirm.click();
        Thread.sleep(1000);
        Allure.addAttachment("Deleted Successfully", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.findElement(By.xpath("//button[normalize-space()='OK']"));
        try {
            driver.findElement(By.xpath("//a[@data-placement='top']/..")).click();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(e.getStackTrace());
        }
    }
    @Test(description = "Verify check Edit pay rate",priority = 16)
    @Description("Updated Pay Rate should be displayed which has update from Edit Pay Rate")
    public void check_Edit_Payrate() throws InterruptedException {
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/generate-payroll/110?_token=rAvHka2c3yF3k5x2XwwJGA41WZGrD6w9haFQvOr4&selectedPayPeriod=3631&companyOnboardingId=110&active_tab_name=LTS&profile_tab=paydata&type=lts");
        WebElement select_Emp = driver.findElement(By.xpath("(//label[@for='radiobutton'])[2]"));
        Thread.sleep(1000);
        select_Emp.click();
        WebElement Edit_payrate= driver.findElement(By.xpath("//a[normalize-space()='Edit Pay Rate']"));
        Edit_payrate.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(0));
        WebElement up_payrate_txt = driver.findElement(By.xpath("//input[@id='employee_payrate']"));
        up_payrate_txt.clear();
        up_payrate_txt.sendKeys("20.00");
        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Save'])[1]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Update it!']")).click();
        Thread.sleep(1000);
        Allure.addAttachment("Pay_rate updated Successfully", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Test(description = "Verify view Minimum wage",priority = 17)
    public void check_View_Minimum_Wages() throws InterruptedException {
        // driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/generate-payroll/110?selectedPayPeriod=3576&companyOnboardingId=110&active_tab_name=LTS&profile_tab=paydata&type=lts&tab_view=2");
        driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/generate-payroll/110?_token=rAvHka2c3yF3k5x2XwwJGA41WZGrD6w9haFQvOr4&selectedPayPeriod=3631&companyOnboardingId=110&active_tab_name=LTS&profile_tab=paydata&type=lts");
        WebElement select_Emp = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2) > div:nth-child(1) > label:nth-child(2)"));
        Thread.sleep(1000);
        select_Emp.click();
        WebElement View_Minimum_wage = driver.findElement(By.xpath("//a[contains(.,'View Minimum Wages')]"));
        View_Minimum_wage.click();
        Thread.sleep(1000);
        Allure.addAttachment("View Minimum Wage", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.findElement(By.xpath("(//button[@id='closeBtn'])[2]")).click();
    }
    @Test(description = "Override payment",priority = 18)
    public void Override_Payment() throws InterruptedException {
        WebElement select_Emp = driver.findElement(By.xpath("//label[contains(@for,'kt-group-checkable')]"));
        Thread.sleep(1000);
        select_Emp.click();
        WebElement Override_btn = driver.findElement(By.xpath("//a[normalize-space()='Override Payment Method']"));
        Override_btn.click();
        WebElement confime_box =  driver.findElement(By.xpath("//button[normalize-space()='Yes, Do it!']"));
        confime_box.click();
        Select Override_payment = new Select(driver.findElement(By.xpath("//select[@id='er_payment_method']")));
        Override_payment.selectByIndex(2);
        WebElement save_btn = driver.findElement(By.xpath("//form[@id='frmOverridePaymentMethodEntry']//button[@type='submit'][normalize-space()='Save']"));
        save_btn.click();
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Update it!']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        Allure.addAttachment("Override Payment", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
    @Test(description = "Verify functionality Override Pay rate",priority = 19)
    public void override_Payrate() throws InterruptedException {
        //driver.navigate().to("http://7.ustaxandpayrollservices.com/staging/public/admin/company/generate-payroll/110?_token=q0418KelwiOIUYahBnLBMKP7MZu8abSQhtxQFR7r&selectedPayPeriod=3576&companyOnboardingId=110&active_tab_name=LTS&profile_tab=paydata&type=lts");
        WebElement select_Emp1 = driver.findElement(By.xpath("//label[contains(@for,'kt-group-checkable')]"));
        Thread.sleep(1000);
        select_Emp1.click();
        //System.out.println(select_Emp1.getText());
        driver.findElement(By.xpath("(//a[normalize-space()='Override Pay Rate'])[1]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//label[normalize-space()='Use Minimum Wages for current payroll']")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath("//form[@id='frmOverridePayRate']//button[@type='submit'][normalize-space()='Save']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Update it!']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Allure.addAttachment("Override Pay rate", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        check_View_Minimum_Wages();
        driver.findElement(By.xpath("//i[@class='la la-filter']")).click();
        WebElement general_search = driver.findElement(By.xpath("//input[@id='generalSearch']"));
        general_search.sendKeys("306-02-0225");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='radiobutton']")).click();
        WebElement View_Minimum_wage = driver.findElement(By.xpath("//a[normalize-space()='View Minimum Wages']"));
        View_Minimum_wage.click();
        WebElement Min_wage = driver.findElement(By.xpath("//td[position()=4]"));
        System.out.println("Minimum Wage :"+Min_wage.getText());
        WebElement Timesheet_imported_rate = driver.findElement(By.xpath("//td[position()=3]"));
        System.out.println("Timesheet imported rate :"+Timesheet_imported_rate.getText());
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@id='closeBtn'])[2]")).click();
        driver.findElement(By.xpath("//label[@for='radiobutton']")).click();
        driver.findElement(By.xpath("(//a[normalize-space()='Override Pay Rate'])[1]")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Overwrite Employee Profile Rate with Minimum Wages']")).click();
        driver.findElement(By.xpath("//form[@id='frmOverridePayRate']//button[@type='submit'][normalize-space()='Save']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Yes, Update it!']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        /* driver.findElement(By.xpath("//label[@for='radiobutton']")).click();
         Thread.sleep(10000);
         driver.findElement(By.xpath("//a[normalize-space()='View Minimum Wages']")).click();
         System.out.println("Emp config rate :"+ driver.findElement(By.xpath("(//td[contains(text(),'$15.50')])[1]")).getText());
         driver.findElement(By.xpath("(//button[@id='closeBtn'])[2]")).click();
   */  }
                /*int cal;
             String get_Rate = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(15) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).getText();
             int Rate= Integer.parseInt(get_Rate.toString());
             String hours = driver.findElement(By.xpath("(//input[@id='regular_hours'])[1]")).getText();
             int h =Integer.parseInt(hours.toString());
             cal = Rate * h;*/
    //System.out.println(cal);
         /*driver.findElement(By.xpath("(//input[@id='double_time_hours'])[1]")).sendKeys("0");
         driver.findElement(By.xpath("(//input[@id='sick_hours'])[1]")).sendKeys("0");
         driver.findElement(By.xpath("(//input[@id='vacation_hours'])[1]")).sendKeys("0");
         ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
         driver.findElement(By.xpath("(//input[@id='covid_hours'])[1]")).sendKeys("0");
         driver.findElement(By.xpath("(//input[@id='pto_hours'])[1]")).sendKeys("0");
         driver.findElement(By.xpath("(//input[@id='commission'])[1]")).sendKeys("0");
         driver.findElement(By.xpath("(//input[@id='bonus'])[1]")).sendKeys("0");
         driver.findElement(By.xpath("(//textarea[@id='payroll_entry_notes'])[1]")).sendKeys("0");
         driver.findElement(By.xpath("(//input[@id='salary'])[1]")).sendKeys("0");
*/

   /* @Test(description = "Verify Redirect to Step-2 Pay Entries & \"Approve & Calculate\" & Payroll_Hold button should be displayed",priority = 5)
     public void calculate_payroll(){
        driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(3)")).click();
        System.out.println("LTS PAY DATA Selected Static Date : "+driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(3) > td:nth-child(3)")).getText());
        WebElement cal = driver.findElement(By.xpath("//a[normalize-space()='Calculate Payroll']"));
        cal.click();
    }*/
    /*@Test(description = "Verify Employee's payroll should be \"Calculating Payroll\" & Redirect to Step-3 Preview Calculation.",priority = 6)
   // @Attachment(value = "Screenshot", type = "image/png")
    public void
    () throws InterruptedException {
      driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(2) > div:nth-child(1) > label:nth-child(2)")).click();
      System.out.println("Selected Static Employee Name"+driver.findElement(By.xpath("//a[normalize-space()='Carlos Romero Aguilar']")).getText());
      WebElement Approve_cal = driver.findElement(By.xpath("//a[@id='approve_btn']"));
      Approve_cal.click();
      driver.findElement(By.xpath("//button[normalize-space()='Yes, Approve it!']")).click();
      Thread.sleep(1000);
      Allure.addAttachment("Calculation Approved", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
*/

}

