package com.qa.s3vin_test.Pages;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// page_url = about:blank
public class LTS_PayDataTestBase {
    static WebDriver driver;

    public LTS_PayDataTestBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@role='tab'][normalize-space()='Payroll']")
    WebElement Payroll_tab;
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[46]/td[2]")
    WebElement Payroll_dateSelect;
    @FindBy(xpath = "//span[normalize-space()='Pending']")
    WebElement Payroll_Pending_Status;
    @FindBy(xpath = "//div[@id='ltsPayDataId']//div[@class='filter-icon-custom d-flex w-auto padd-r-10 text-center align-items-center opensearchmenuPayData']")
    WebElement filter;
    @FindBy(xpath = "//input[contains(@type,'text')]")
    WebElement search_date;
    @FindBy(xpath = "(//button[@title='Payroll Status'])[1]")
    WebElement Payroll_status;
    @FindBy(xpath = "//span[normalize-space()='Step 1 of 8 Pending']")
    WebElement Pending_lst;
    @FindBy(xpath = "(//input[@placeholder='Search By Check Date, Pay Frequency, Payroll Status, Next Step'])[1]")
    WebElement input;
    @FindBy(xpath = "//label[@for='radiobutton']")
    WebElement getPayroll_dateSelect;
    @FindBy(xpath = "//a[normalize-space()='Calculate Payroll']")
    WebElement Calculate_Payroll;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)")
    WebElement checkDate;
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[2]")
    WebElement PayPeriod;
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[2]")
    WebElement Emp_count;
    @FindBy(xpath = "(//span[@class='f-14 kt-font-dark kt-font-bold total_hours_tb'])[1]")
    WebElement Total_Hours;
    @FindBy(xpath = "(//span[@class='f-14 kt-font-dark kt-font-bold total_gross_salary_tb'])[1]")
    WebElement Total_grossSalary;
    @FindBy(xpath = "//td[@class=' text-right th-center']")
    List<WebElement> List_SAL_Hours;
    @FindBy(xpath = "//td[@class=\"sorting_1\"]")
    List<WebElement> Emp_lst;
    @FindBy(xpath = "//a[normalize-space()='New Entry']")
    WebElement New_Entry_Emp;

    @FindBy(xpath = "(//td)[775]")
    WebElement test;

    @FindBy(xpath = "//a[normalize-space()='Edit Payroll Entry']")
    WebElement Edit_PayrollEntry;
    @FindBy(xpath = "(//div[contains(@class,'round')])[4]")
    WebElement select_emp;
    @FindBy(xpath = "//a[@id='navbarDropdownShow']")
    WebElement Export_btn;
    @FindBy(xpath = "//a[normalize-space()='PayData Entries']")
    WebElement Paydata_btn;
    @FindBy(xpath = "//a[@id='minimum_wage_report_btn']")
    WebElement Wage_Paydata;
    @FindBy(xpath = "//a[normalize-space()='Refresh']")
    WebElement Refresh;
    @FindBy(xpath = "//label[@for='kt-group-checkable']")
    WebElement select_all_Emp;
    @FindBy(xpath = "//a[@id='approve_btn']")
    WebElement Approve_calcuate_btn;
    @FindBy(xpath = "//button[normalize-space()='Yes, Approve it!']")
    WebElement confrim_Approve_calcuate_btn;

    public void check_payroll_Tab() throws InterruptedException {
        Thread.sleep(1000);
        Payroll_tab.click();
    }
    public void SelectTimesheet(String Date) throws InterruptedException {
        Thread.sleep(10000);
        filter.click();
        Thread.sleep(1000);
        Payroll_status.click();
        Thread.sleep(1000);
        Pending_lst.click();
        Thread.sleep(1000);
        search_date.sendKeys(Date, Keys.ENTER);
        search_date.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        getPayroll_dateSelect.click();
    }
    public void Calculate_Payroll() {
        Calculate_Payroll.click();
    }
    public void setCalculate_Payroll() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Check Date :" + checkDate.getText());
        System.out.println("Pay Period :" + PayPeriod.getText());
        System.out.println("Employee Count :" + Emp_count.getText());
        // System.out.println(List_SAL_Hours.getText());
        System.out.println("Total Hours :" + Total_Hours.getText());
        System.out.println("Gross Salary:" + Total_grossSalary.getText());
    }
    public void updated_Total_count() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Total Hours :" + Total_Hours.getText());
        System.out.println("Gross Salary:" + Total_grossSalary.getText());
    }
    public void List_Emp() throws InterruptedException {
        Thread.sleep(1000);
        for (WebElement list : List_SAL_Hours) {
            String TEST = list.getText();
            System.out.println("each hours & gross salary " + TEST);
        }
    }
    public void List() throws InterruptedException {
        Thread.sleep(1000);
        for (WebElement l : Emp_lst) {
            String s = l.getText();
            System.out.println("Temp Emp:" + s);
        }
    }
    public void setNew_Entry_Emp() throws InterruptedException {
        New_Entry_Emp.click();
    }
    public void check_Export_button_Paydata() throws InterruptedException {

        Export_btn.click();
        System.out.println(">>> Successfully Download Pay-data");
        System.out.println(">>> Successfully Download Wage-data");
        Paydata_btn.click();
    }
    public WebElement Export_btn() {
        return Export_btn;
    }

    public WebElement Wage_Paydata() {
        return Wage_Paydata;
    }

    public void check_Refresh_button() {
        Refresh.click();
    }

    public void Edit_PayrollEntry() {
        select_emp.click();
        Edit_PayrollEntry.click();
    }

    public void check_Approve_calculate_payroll_Emp() throws InterruptedException,IllegalArgumentException {
       //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        select_all_Emp.click();
        Approve_calcuate_btn.click();
        confrim_Approve_calcuate_btn.click();
    }
  /*  public static ExpectedCondition<Boolean> wait_forElement(WebElement element){
        return  new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                boolean flag = false;
                try {
                    if(element.isDisplayed()){
                        flag=true;
                    }
                }catch (Exception e){
                    System.out.println("inside catch block"+e.getMessage());
                }
                return flag;
            }
        };*/
    }

