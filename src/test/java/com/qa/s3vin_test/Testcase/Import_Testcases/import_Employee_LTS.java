package com.qa.s3vin_test.Testcase.Import_Testcases;

import com.qa.s3vin_test.Action.Add_new_payroll_Entry;
import com.qa.s3vin_test.Employee_import.Employee_import_Testbase;
import com.qa.s3vin_test.LTS_import.LTS_import_Testbase;
import com.qa.s3vin_test.Pages.Payroll_LTS_TestBase;
import com.qa.s3vin_test.Wait_functions.Functions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.URISyntaxException;

public class import_Employee_LTS {
    public static WebDriver driver = new ChromeDriver();
    Functions functions = new Functions(driver);
    JavascriptExecutor js= (JavascriptExecutor)driver;
    Add_new_payroll_Entry addEMP = new Add_new_payroll_Entry(driver);
    Payroll_LTS_TestBase payrollLtsTestBase = new Payroll_LTS_TestBase(driver);
    LTS_import_Testbase ltsImportTestbase = new LTS_import_Testbase(driver);
    Employee_import_Testbase employeeImportTestbase = new Employee_import_Testbase(driver);
    @Test(priority = 0)
    public void login_check(){
        payrollLtsTestBase.check_instance("http://7.ustaxandpayrollservices.com/staging/public/login");
        payrollLtsTestBase.setDriver("http://7.ustaxandpayrollservices.com/staging/public/login");
        payrollLtsTestBase.check_valid_credentials("user1@ustaxandpayrollservices.com","2ytptkr3Gd");
    }
    @Test(priority = 1)
    public void check_company_redirect() throws InterruptedException {
        payrollLtsTestBase.setCompany_name();
        payrollLtsTestBase.setCustomer_name();
    }
    @Test(priority = 3)
    public void Employee_import() throws InterruptedException, URISyntaxException, AWTException {
        employeeImportTestbase.setEmp_lbl();
        employeeImportTestbase.import_Employee_list();
        Thread.sleep(10000);
        driver.navigate().refresh();
        employeeImportTestbase.select_Emp_columm_maping();
        Thread.sleep(1000);
        employeeImportTestbase.Column_Mapping_From();
        Thread.sleep(1000);
        employeeImportTestbase.setSelect_items();
        js.executeScript("window.scrollBy(0,670)", "");
        employeeImportTestbase.setEmp_lst_save();
        Thread.sleep(20000);
        driver.navigate().refresh();
        employeeImportTestbase.import_Verified_records();
        Thread.sleep(1000);
        check_company_redirect();
    }
   @Test(priority = 4)
    public void Employee_detailed_add() throws InterruptedException {
       driver.navigate().refresh();
       employeeImportTestbase.setGo_payroll();
   }
   @Test(priority = 5)
    public void LTS_import() throws InterruptedException, AWTException {
        Thread.sleep(1000);
        ltsImportTestbase.setImport_LTS();
        ltsImportTestbase.getImport_LTS();
        Thread.sleep(10000);
        driver.navigate().refresh();
        ltsImportTestbase.select_Emp_columm_maping();
        ltsImportTestbase.Column_Mapping_filter();
        ltsImportTestbase.setStart_validation();
        Thread.sleep(10000);
        driver.navigate().refresh();
        ltsImportTestbase.import_Verified_records();
        Thread.sleep(1000);
   }
}
