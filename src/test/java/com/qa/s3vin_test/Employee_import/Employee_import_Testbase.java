package com.qa.s3vin_test.Employee_import;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.URISyntaxException;

// page_url = http://7.ustaxandpayrollservices.com/staging/public/login
public class Employee_import_Testbase {
    public static WebDriver driver;

   public boolean isElementPresent(By selector)
    {
        return driver.findElements(selector).size()>0;
    }
    public Employee_import_Testbase(WebDriver driver) {
       PageFactory.initElements(driver, this);
    }
    @FindBy(xpath= "//a[normalize-space()='Employees']")WebElement Emp_lbl;
    @FindBy(xpath = "//a[.='Employee List']")WebElement Emp_lst;
   @FindBy(xpath = "//a[@id='navbarDropdown']")WebElement Employee_import;
    @FindBy(xpath = "//a[normalize-space()='Import Employee']")WebElement getEmployee_import;
    @FindBy(xpath = "//a[@class='btn btn-icon-primary btn-sub-actions mr-3']")WebElement import_btn;
    @FindBy(xpath = "/html/body/div[7]/div/div[3]/button[1]")WebElement ok_btn;
    @FindBy(xpath = "//tbody/tr[1]/td[2]/div[1]/label[1]")WebElement select_sheet;
    @FindBy(xpath = "//a[contains(@class,'mr-3')][normalize-space()='Column Mapping']")WebElement column_mapping;
    @FindBy(xpath = "//i[@class='la la-filter']")WebElement filter;
    @FindBy(xpath = "//span[normalize-space()='Required (11)']")WebElement getGetFilter_required;
    @FindBy(css = "button[title='S3VIN Fields (171)'] div[class='filter-option-inner-inner']")WebElement getFilter;
    @FindBy(xpath = "//label[@for='override_address']//span[@class='slider round']")WebElement override_address;

    // S3Vin field;
    @FindBy(xpath = "//select[@id='social_security_number']")WebElement SSN_num;
    @FindBy(xpath = "//select[@id='last_name']")WebElement lst_name;
    @FindBy(xpath = "//select[@id='first_name']")WebElement first_name;
    @FindBy(xpath = "//select[@id='birth_date']")WebElement dob;
    @FindBy(xpath = "//select[@id='employee_address']")WebElement Emp_address;
    @FindBy(xpath = "//select[@id='employee_city_id']")WebElement Emp_city;
    @FindBy(xpath = "//select[@id='employee_state_id']")WebElement Emp_state_code;
    @FindBy(xpath = "//select[@id='employee_country_id']")WebElement Emp_country_code;
    @FindBy(xpath = "//select[@id='employee_zip']")WebElement Emp_zip_code;
    @FindBy(xpath = "//select[@id='employer_hire_date']")WebElement Emp_hire_date;
    @FindBy(xpath = "//select[@id='pay_method']")WebElement pay_mathod;
    @FindBy(xpath = "//a[@id='navbarDropdown']")WebElement continue_btn;
    @FindBy(xpath = "//div[contains(@class,'d-flex align-items-center bb-1 borderclass')]//button[1]")WebElement Start_validation;
    @FindBy(xpath = "//a[normalize-space()='Import Verified Records']")WebElement import_verified_btn;
    @FindBy(xpath = "//button[normalize-space()='Yes, Start it!']")WebElement Yes_start_it;
    @FindBy(xpath = "//button[text()='OK']")WebElement getOk_btn;
    @FindBy(xpath = "//a[normalize-space()='R Industries']") WebElement go_companyname;
    @FindBy(xpath = "//a[normalize-space()='Payroll']")WebElement go_payroll;
    public void setEmp_lbl() throws InterruptedException {
        Thread.sleep(1000);
        Emp_lbl.click();
    }
    public void import_Employee_list() throws InterruptedException, URISyntaxException, AWTException {
        Thread.sleep(10000);
        Employee_import.click();
        getEmployee_import.click();
        import_btn.click();
        StringSelection select = new StringSelection("C:\\DemoImage\\Tulips.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
        import_btn.click();
        Thread.sleep(2000);
        Robot robot = new Robot();
        StringSelection filepath = new StringSelection("D:\\s3vinautomation\\src\\Testdata\\Employee_import_Testdata.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath,null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(100);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("file upload.....");
        ok_btn.click();
       /* File file = new File("./Employee_import_Testdata.xlsx");
        System.out.println(file.getAbsolutePath());
        import_btn.sendKeys(file.getAbsolutePath());
        Thread.sleep(100);
        import_btn.sendKeys(file.getAbsolutePath());*/
       // String uploadfullpath = resource.toURI().getPath();
        //import_btn.sendKeys("");
    }
    public void select_Emp_columm_maping() throws InterruptedException {
        Thread.sleep(2000);
        select_sheet.click();
        column_mapping.click();
    }
    public void Column_Mapping_From() throws InterruptedException {
        filter.click();
        getFilter.click();
        getGetFilter_required.click();
        override_address.click();
    }
    public void setSelect_items() throws InterruptedException {
        SSN_num.click();
        Select Social_Security_Number = new Select(SSN_num);
        Social_Security_Number.selectByVisibleText("Social Security Number*");
        // last name
        lst_name.click();
        Select lastname = new Select(lst_name);
        lastname.selectByVisibleText("Last Name*");
        //firstname
        first_name.click();
        Select firstname = new Select(first_name);
        firstname.selectByVisibleText("First Name*");
        //lastname
        dob.click();
        Select Bithday = new Select(dob);
        Bithday.selectByVisibleText("Birth Date*");
        //Employee Address
        Emp_address.click();
        Select Emp_add = new Select(Emp_address);
        Emp_add.selectByVisibleText("Employee Address*");
        // Employee city
        Emp_city.click();
        Select Emp_cities = new Select(Emp_city);
        Emp_cities.selectByVisibleText("Employee City Name*");
        //Employee State
        Emp_state_code.click();
        Select emp_sate = new Select(Emp_state_code);
        emp_sate.selectByVisibleText("Employee State Code*");
        //Employeee country code
        Emp_country_code.click();
        Select Emp_county = new Select(Emp_country_code);
        Emp_county.selectByVisibleText("Employee Country Code*");
        //Employee zipcode
        Emp_zip_code.click();
        Select Emp_zip = new Select(Emp_zip_code);
        Emp_zip.selectByVisibleText("Employee Zip*");
        // Employeee hire Date
        Emp_hire_date.click();
        Select emp_hire_date = new Select(Emp_hire_date);
        emp_hire_date.selectByVisibleText("Employee Hire Date*");
    }
    public void setEmp_lst_save() throws InterruptedException {
        pay_mathod.click();
        Select pay_m =new Select(pay_mathod);
        pay_m.selectByVisibleText("Pay Method*");
        Thread.sleep(1000);
        continue_btn.click();
        Thread.sleep(1000);
        Start_validation.click();
    }
    public void import_Verified_records() throws InterruptedException {
        select_sheet.click();
        import_verified_btn.click();
        Thread.sleep(1000);
        Yes_start_it.click();
        getOk_btn.click();
    }
    public void setGo_payroll() throws InterruptedException {
         Thread.sleep(20000);
        go_companyname.click();
        go_payroll.click();
    }
}