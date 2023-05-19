package com.qa.s3vin_test.Action;

import com.qa.s3vin_test.Wait_functions.Functions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Locale;

// page_url = about:blank
public class Add_new_payroll_Entry {
static WebDriver driver;

    public Add_new_payroll_Entry(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    Functions functions = new Functions((WebDriver) driver);
    JavascriptExecutor js = new JavascriptExecutor() {
        @Override
        public Object executeScript(String s, Object... objects) {
            return null;
        }

        @Override
        public Object executeAsyncScript(String s, Object... objects) {
            return null;
        }
    };

    // Pay Period Configuration
    @FindBy(xpath = "//select[@id='pay_frequency']")
    WebElement Pay_Frequency;
    @FindBy(xpath = "//select[@id='pay_frequency']")
    WebElement select_pay_freq;
    @FindBy(xpath = "//input[@id='pay_period_begin_date']")
    WebElement pay_period_Begin_date;
    @FindBy(xpath = "//input[@id='pay_period_begin_date']")
    WebElement Pay_Period_EndDate;
    @FindBy(xpath = "//input[@id='check_date']")
    WebElement check_data;

    //
    @FindBy(xpath = "//span[.='Select Employee SSN']")
    WebElement Select_EMP_SSN;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement Search_input_field;
    @FindBy(xpath = "(//li[normalize-space()='Carlos Romero Aguilar [306-02-0225]'])[1]")
    WebElement Select_Emp;
    @FindBy(xpath = "//span[@role='textbox']")
    WebElement Emp_name;
    @FindBy(xpath = "(//input[@id='regular_rate_of_pay'])[1]") WebElement Payrate;

    @FindBy(xpath = "(//input[@id='regular_hours'])[1]")
    WebElement Regular_hours;
    @FindBy(xpath = "(//input[@id='overtime_hours'])[1]")
    WebElement Overtime_hours;
    @FindBy(xpath = "(//input[@id='double_time_hours'])[1]")
    WebElement Double_hours;
    @FindBy(xpath = "(//input[@id='sick_hours'])[1]")
    WebElement Sick_hours;
    @FindBy(xpath = "(//input[@id='vacation_hours'])[1]")
    WebElement Vacation_hours;
    @FindBy(xpath = "(//input[@id='covid_hours'])[1]")
    WebElement Covid_hours;
    @FindBy(xpath = "(//input[@id='pto_hours'])[1]")
    WebElement PTO_hours;
    @FindBy(xpath = "(//input[@id='commission'])[1]")
    WebElement Commission;
    @FindBy(xpath = "(//input[@id='bonus'])[1]")
    WebElement Bonus;
    @FindBy(xpath = "//input[@id='salary']")
    WebElement salary;
    @FindBy(xpath = "(//textarea[@id='payroll_entry_notes'])[1]")
    WebElement Payroll_Entry_note;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(15) > div:nth-child(1) > div:nth-child(1) > div:nth-child(15) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > label:nth-child(1)")
    WebElement Jobsite_Txt;
    @FindBy(xpath = "//select[@id='paytype_1']") WebElement Select_Paytype;
    @FindBy(xpath = "(//input[@id='payTypeAmount_1'])[1]")WebElement Pay_amount;
    @FindBy(xpath = "//span[.='Select Jobsite']")
    WebElement Select_job_site;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement input_searchbox;
    @FindBy(xpath ="(//span[@id='select2-workers_company_state-container'])[1]")
   @CacheLookup WebElement workerscompstatecode;
    @FindBy(xpath = "//span[contains(text(),'Select WC Code')]")
    WebElement wc_code;
    @FindBy(xpath = "//input[contains(@role,'searchbox')]")
    WebElement getInput_searchbox;
    @FindBy(xpath = "//i[@class='fa fa-arrow-up']")WebElement scroll_up;
    @FindBy(xpath = "//button[@id='submitFormBtn']")
    WebElement submitFormBtn;
   @CacheLookup @FindBy(xpath = "//button[normalize-space()='Yes, Add it']")WebElement confirm_yes;
    @FindBy(xpath = "//span[contains(text(),'Select Employee SSN')]")WebElement ssn;
    @FindBy(xpath = "//label[@class='kt-checkbox payTypeTimesheetEntry pr-2 ']//span")WebElement switch_btn;
    @FindBy(css = "button[class='swal2-confirm swal2-styled']")WebElement confrim_yes_do_it;

    public void Add_new_payroll_Daily() throws InterruptedException {
        Pay_Frequency.click();
        Thread.sleep(1000);
        Select select_drp = new Select(select_pay_freq);
        select_drp.selectByIndex(0);
        select_drp.selectByVisibleText("Daily");
        //Pay Period Configuration
        pay_period_Begin_date.sendKeys("03/08/2023");
        Pay_Period_EndDate.sendKeys("03/08/2023");
        check_data.sendKeys("03/08/2023");
        Thread.sleep(1000);
        //Employee Details
        Select_EMP_SSN.click();
        Thread.sleep(1000);
        input_searchbox.sendKeys("Carlos Romero Aguilar", Keys.ENTER);
        //Timesheet Details
        Regular_hours.sendKeys("8");
        Overtime_hours.sendKeys("2");
        Double_hours.sendKeys("1");
        Sick_hours.sendKeys("1.5");
        Vacation_hours.sendKeys("1");
        PTO_hours.sendKeys("1");
        Commission.sendKeys("10.50");
        Bonus.sendKeys("5.60");
        Payroll_Entry_note.sendKeys("testing");
        //Jobsite Details
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView();", Jobsite_Txt);
        salary.sendKeys("");
        Select Paytype = new Select(Select_Paytype);
        Paytype.selectByIndex(1);
        Pay_amount.sendKeys("10");
        Thread.sleep(10000);
        Select_job_site.click();
        input_searchbox.sendKeys("CA-2005 - 000002005",Keys.ENTER);
        Thread.sleep(1000);
        workerscompstatecode.click();
        Thread.sleep(1000);
        input_searchbox.sendKeys("California (CA)",Keys.ENTER);
        Thread.sleep(10000);
        wc_code.click();
        input_searchbox.sendKeys("2005",Keys.ENTER);
        Thread.sleep(1000);
        //scroll_up.click();
        submitFormBtn.click();
        Thread.sleep(1000);
        confirm_yes.click();
    }
    public void Pay_Period_Configuration(String startDate,String End_date,String check_date) throws InterruptedException {
        Pay_Frequency.click();
        Thread.sleep(1000);
        Select select_drp = new Select(select_pay_freq);
        select_drp.selectByIndex(0);
        select_drp.selectByVisibleText("Daily");
        //Pay Period Configurationn
        pay_period_Begin_date.sendKeys(startDate);
        Pay_Period_EndDate.sendKeys(End_date);
        check_data.sendKeys(check_date);
        Thread.sleep(1000);
    }
    public void Employee_Details(String Emp_name) throws InterruptedException {
        Select_EMP_SSN.click();
        Thread.sleep(1000);
        input_searchbox.sendKeys(Emp_name);
        //input_searchbox.sendKeys();
        Thread.sleep(1000);
        input_searchbox.sendKeys(Keys.ENTER);
    }
    public void Timesheet_details() throws InterruptedException {
        /*Timesheet.add(Float.valueOf(String.valueOf(Regular_hours)));
        Timesheet.add(Float.valueOf(String.valueOf(Overtime_hours)));*/
     /*   switch_btn.click();
        confrim_yes_do_it.click();
     */   Thread.sleep(1000);
        switch_btn.click();
        confrim_yes_do_it.click();
        functions.wait_forElement(Payrate);
        Payrate.clear();
        Payrate.sendKeys("200.00");
        Regular_hours.sendKeys("8");
        Overtime_hours.sendKeys("2");
        Double_hours.sendKeys("1");
        Sick_hours.sendKeys("1.5");
        Vacation_hours.sendKeys("1");
        Covid_hours.sendKeys("2.22");
        //PTO_hours.sendKeys("1.00");
       // Commission.sendKeys("10.50");
       // Bonus.sendKeys("5.60");
        Payroll_Entry_note.sendKeys("testing");
    }
    public void fill_Jobsite_detail(String jobsite) throws InterruptedException {
        Thread.sleep(10000);
        Select_job_site.click();
        input_searchbox.sendKeys(jobsite,Keys.ENTER);
        Thread.sleep(1000);
        workerscompstatecode.click();
        Thread.sleep(1000);
        input_searchbox.sendKeys("California (CA)",Keys.ENTER);
        Thread.sleep(1000);
        wc_code.click();
        input_searchbox.sendKeys("001",Keys.ENTER);
        Thread.sleep(1000);
        scroll_up.click();
        submitFormBtn.click();
        Thread.sleep(1000);
        confirm_yes.click();
    }
    public void Add_New_Payroll_Entry() throws InterruptedException {
        Thread.sleep(2000);
        ssn.click();
        Thread.sleep(1000);
        input_searchbox.sendKeys("Carlos Romero Aguilar", Keys.ENTER);
        //Timesheet Details
        Regular_hours.sendKeys("8");
        Overtime_hours.sendKeys("2");
        Double_hours.sendKeys("1");
        Sick_hours.sendKeys("1.5");
        Vacation_hours.sendKeys("1");
        PTO_hours.sendKeys("1");
        Commission.sendKeys("10.50");
        Bonus.sendKeys("5.60");
        Payroll_Entry_note.sendKeys("testing");
        //Jobsite Details
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView();", Jobsite_Txt);
        salary.sendKeys("");
        Select Paytype = new Select(Select_Paytype);
        Paytype.selectByIndex(1);
        Pay_amount.sendKeys("10");
        Thread.sleep(10000);
        Select_job_site.click();
        input_searchbox.sendKeys("CA-2005 - 000002005",Keys.ENTER);
        Thread.sleep(1000);
        workerscompstatecode.click();
        Thread.sleep(1000);
        input_searchbox.sendKeys("California (CA)",Keys.ENTER);
        Thread.sleep(10000);
        wc_code.click();
        input_searchbox.sendKeys("2005",Keys.ENTER);
        Thread.sleep(1000);
        scroll_up.click();
        submitFormBtn.click();
        Thread.sleep(1000);
        confirm_yes.click();
    }
    public void Edit_Payroll_Entry() throws NoSuchElementException, InterruptedException {
        Thread.sleep(1000);
        switch_btn.click();
        confrim_yes_do_it.click();
        Thread.sleep(1000);
        Payrate.clear();
        Thread.sleep(1000);
        Payrate.sendKeys("22.00");
        Regular_hours.clear();
        Regular_hours.sendKeys("8.00");
        Overtime_hours.clear();
        Overtime_hours.sendKeys("3.00");
        Double_hours.clear();
        Double_hours.sendKeys("2.00");
        Sick_hours.clear();
        Sick_hours.sendKeys("2.50");
        Vacation_hours.clear();
        Vacation_hours.sendKeys("2.00");
        Covid_hours.clear();
        Covid_hours.sendKeys("3.50");
        PTO_hours.clear();
        PTO_hours.sendKeys("1.50");
        Commission.clear();
        Commission.sendKeys("20.55");
        Bonus.clear();
        Bonus.sendKeys("7.50");
        Payroll_Entry_note.clear();
        Payroll_Entry_note.sendKeys("Updated Entry");
        EMP_Timesheet_Details_get();
        submitFormBtn.click();
        Thread.sleep(1000);
        confirm_yes.click();
    }
    public void EMP_Timesheet_Details_get(){
        System.out.println("________________________Entry update Payroll Enry------------------------");
        System.out.println("Updated payrate:"+Payrate.getAttribute("value"));
        System.out.println("Updated Hour :"+Regular_hours.getAttribute("value"));
        System.out.println("Updated OverTime Hour :"+Overtime_hours.getAttribute("value"));
        System.out.println("Updated DoublTime Hour :"+Double_hours.getAttribute("value"));
        System.out.println("Updated Sick Hour :"+Sick_hours.getAttribute("value"));
        System.out.println("Updated Vacation Hour :"+Vacation_hours.getAttribute("value"));
        System.out.println("Updated Covid Hour :"+Covid_hours.getAttribute("value"));
        System.out.println("Updated PTO Hour :"+PTO_hours.getAttribute("value"));
        System.out.println("Updated Commission :"+Commission.getAttribute("value"));
        System.out.println("Updated Bonus :"+Bonus.getAttribute("value"));
    }

}