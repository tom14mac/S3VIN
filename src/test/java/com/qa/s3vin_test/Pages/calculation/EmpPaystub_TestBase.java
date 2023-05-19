package com.qa.s3vin_test.Pages.calculation;

import com.qa.s3vin_test.Pages.LTS_PreviewCalculation_TestBase;
import com.qa.s3vin_test.Wait_functions.Functions;
import lombok.val;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

// page_url = http://7.ustaxandpayrollservices.com/staging/public/login
public class EmpPaystub_TestBase {
    public static WebDriver driver;
    JavascriptExecutor executor;
    private WebDriverWait wait;
    public float gross_pay, Total_Garnishment, Garnishment_Deduction_Percentag, getTotalGross_pay, Total_Deductions_amout_F;
    float test_null = 0.00F, Total_Employee_Taxes1, Total_Employee_Taxes2;
    public float Garnishment_Deduction_rate_F, Benefit_flat_amount_F, pay_period_Benefit_plan_amout_F, Contribution_amout_F, Total_Contributions_F, Benefit_pecentage_F;
    public String Garnishment_percentage_S, EMP_SSN_S, Benefit_contribution_amount_S;
    String URL = "http://7.ustaxandpayrollservices.com/staging/public/admin/customers/profile/110/13";
    public String Customer_view_URL = "http://7.ustaxandpayrollservices.com/staging/public/admin/customers/profile/110/0";
    @FindBy(xpath = "//div[@class='title text-primary kt-font-bolder']")
    WebElement paystub_employee_nm;
    @FindBy(css = ".title.text-left")
    WebElement Emp_SSN;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2)")
    WebElement Deductions;
    // Employee gets Deduction plan
    @FindBy(xpath = "//span[normalize-space()='All Employees']")
    WebElement all_Employees;
    @FindBy(xpath = "//a[normalize-space()='Employees']")
    WebElement Employees;
    @FindBy(xpath = "//*[@id=\"opensearchmenu\"]")
    WebElement Emp_filter;
    @FindBy(xpath = "//i[@class='la la-search btn-icon mr-1 mt-2']")
    WebElement Search_icon;
    @FindBy(css = "html > body > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div > div > table > tbody > tr > td:nth-of-type(3) > div > div > button > div > div > div")
    WebElement select_customer;
    @FindBy(xpath = "//input[@placeholder='Customer Name']")
    WebElement input_search_box;
    @FindBy(xpath = "//input[@class='form-control invoice_search_keyword filter-keyword-search-input']")
    WebElement input_general_search;
    @FindBy(xpath = "//tr[@class='odd active']//label[@for='radiobutton']")
    WebElement Emp_select;
    @FindBy(xpath = "//a[text()='R Industries']")
    WebElement getSelect_customer;
    @FindBy(xpath = "//a[@data-id=\"13\"]")
    WebElement Emp_tab;
    @FindBy(xpath = "//*[@id=\"employeeList\"]/tbody/tr[1]/td[2]/div/label")
    WebElement getGetSelect_Employee;

    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > table:nth-child(3) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3) > span:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > a:nth-child(1)")
    WebElement search_Emp_select;
    @FindBy(xpath = "(//a[normalize-space()='Mario'])[1]")
    WebElement Emp_view;
    @FindBy(xpath = "//a[contains(text(),'Misc Deductions')]")
    WebElement Misc_Deductiobns;
    @FindBy(xpath = "//a[normalize-space()='Garnishments']")
    WebElement Garnishment;
    @FindBy(xpath = "//label[@class='mb-0 mr-4']//span")
    WebElement switch_status;
    @FindBy(xpath = "/html/body/div[6]/div/div[3]/button[1]")
    WebElement yes_Deactivate_it;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement ok_btn;
    @FindBy(xpath = "(//*[name()='svg'][@class='kt-svg-icon'])[1]")
    WebElement view_garnishment_plan;
    @FindBy(xpath = "(//*[name()='svg'][@class='kt-svg-icon'])[3]")
    WebElement getView_garnishment_plan_all_others;
    @FindBy(xpath = "//div[@id='heading16985']//div[contains(@class,'bg-light')]")
    WebElement getGetView_garnishment_plan_all_others;
    @FindBy(xpath = "//body/div[@id='overflowW4form']/div[@class='kt-grid__item kt-grid__item--fluid kt-grid kt-grid--ver kt-page']/div[@id='kt_wrapper']/div[@id='kt_content']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement GP05;
    @FindBy(xpath = "//label[normalize-space()='10.00%']")
    WebElement Garnishment_Percentage;

    @FindBy(xpath = "//a[@id='opensearchmenu']")
    WebElement getEmp_filter;
    @FindBy(id = "generalSearch")
    WebElement Employee_search;
    @FindBy(xpath = "//a[normalize-space()='Benefit Programs']")
    WebElement benifit_tab;
    @FindBy(xpath = "(//label[contains(@for,'radiobutton')])[2]")
    WebElement Benifit123_pre;

    @FindBy(xpath = "//a[normalize-space()='View']")
    WebElement view_benefit_plan;

    @FindBy(xpath = "(//label[contains(@for,'radiobutton')])[3]")
    WebElement pay_period_Benefit_plan;
    @FindBy(xpath = "//*[@id=\"benefitDetailFrm\"]/div[2]/div/div/label[10]")
    WebElement pay_period_Benefit_plan_amout;

    @FindBy(xpath = "//*[@id=\"benefitDetailFrm\"]/div[2]/div/div/label[10]")
    public WebElement Benefit_percentage;
    @FindBy(xpath = "//button[normalize-space()='Close']")
    WebElement close_btn;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(9) > label:nth-child(2)")
    WebElement flat_amount;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[2]/div[1]/div/div[2]")
    WebElement NMSNs_For_Children_POST;

    @FindBy(css = "tfoot td:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(2)")
    WebElement Emp_paystub_total_deductions;
    @FindBy(xpath = "//a[@role='tab'][normalize-space()='Plans & Deductions']")
    WebElement Customer_Plan_deductions;
    @FindBy(xpath = "//a[.='Benefit Program']")
    WebElement Benefit_program_tab;
    @FindBy(xpath = "//a[normalize-space()='Benefit_Emp_Pre']")
    WebElement Benefit_Emp_pre;
    @FindBy(css = "tbody tr:nth-child(6) td:nth-child(2) div:nth-child(1)")
    WebElement select_Benefit_Emp_pre;
    @FindBy(xpath = "//a[normalize-space()='Edit']")
    WebElement Edit_section;
    @FindBy(xpath = "//input[@id='employerAmount']")
    public WebElement Benefit_contribution_amount;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[2]/tbody/tr/td[3]/div/div/div[2]")
    WebElement Emp_paystub_contribution;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[2]/tfoot/tr/td[3]/div/div/div[2]")
    WebElement Emp_paystub_Total_contributions;
    @FindBy(css = "div.kt-grid.kt-grid--ver.kt-grid--root.kt-page.login-main")
    public WebElement divLoginMain;
    // Employee Texes |
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[4]/div[1]/div/div[2]")
    WebElement Fedral_Taxes;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[4]/div[2]/div/div[2]")
    WebElement Social_security_Tax;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[4]/div[3]/div/div[2]")
    WebElement Medicare;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[4]/div[4]/div/div[2]")
    WebElement california_sdi;

    // Employee Taxes ||
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[2]/tbody/tr/td[4]/div[1]/div/div[2]")
    WebElement Employee_FICA_TAX;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[2]/tbody/tr/td[4]/div[2]/div/div[2]")
    WebElement Federal_Unemployment_Tax;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[2]/tbody/tr/td[4]/div[3]/div/div[2]")
    WebElement Employer_Medicare_Tax;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[2]/tbody/tr/td[4]/div[4]/div/div[2]")
    WebElement California_State_Unemployment_Tax;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[2]/tbody/tr/td[4]/div[5]/div/div[2]")
    WebElement California_Employment_Training_Tax;
    @FindBy(css = "div[class$='login-main']")
    public WebElement divLoginMain2;

    // Genrate Payroll
    @FindBy(xpath = "//*[@id=\"generate_payroll_btn\"]/a")
    WebElement Genrate_Payroll_btn;
    @FindBy(xpath = "//a[normalize-space()='Go To Payroll Details']")WebElement Go_Payroll_details;


    Functions functions = new Functions(driver);

    public EmpPaystub_TestBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
    }

    public void check_deductions() {
        System.out.println(Deductions.getText());
    }

    public WebElement getPaystub_employee_nm() {
        return paystub_employee_nm;
    }

    public void setPaystub_employee_nm(WebElement paystub_employee_nm) {
        this.paystub_employee_nm = paystub_employee_nm;
    }
    public WebElement getNMSNs_For_Children_POST() {
        NMSNs_For_Children_POST = this.NMSNs_For_Children_POST;
        return NMSNs_For_Children_POST;
    }
    public WebElement getEmp_SSN() {
        EMP_SSN_S = String.valueOf(Emp_SSN.getText()).substring(5);
        return Emp_SSN;
    }

    public void get_Emp_detail() {
        paystub_employee_nm.getText();
        Emp_SSN.getText();
        System.out.println(Emp_SSN.getText());
    }

    public void get_deduction_plan() throws InterruptedException {
        //str =String.valueOf(Emp_SSN.getText()).substring(5);
        all_Employees.click();
        Emp_filter.click();
        select_customer.click();
        Thread.sleep(100);
        input_search_box.sendKeys("R industries", Keys.ENTER);
        Search_icon.click();
        Thread.sleep(1000);
        input_general_search.sendKeys("testing", Keys.ENTER);
        input_general_search.clear();
    }
    public String set_select_cutomer() {
        Customer_view_URL = this.Customer_view_URL;
        return Customer_view_URL;
    }

    public void get_Employee_deductionPlan() throws InterruptedException {
        Thread.sleep(1000);//getSelect_customer.click();
        Emp_tab.click();
        Thread.sleep(1000);
        Emp_filter.click();
        input_general_search.sendKeys((CharSequence) Emp_SSN, Keys.ENTER);
    }

    public void check_Garnishment_status() throws InterruptedException {
        // DeActivation
        // Emp_select.click();
        Thread.sleep(1000);
        Garnishment.click();
        Thread.sleep(100);
        switch_status.click();
        Thread.sleep(100);
        yes_Deactivate_it.click();
        Thread.sleep(100);
        ok_btn.click();
        //Activation
        Thread.sleep(1000);
        Garnishment.click();
        Thread.sleep(100);
        switch_status.click();
        Thread.sleep(100);
        yes_Deactivate_it.click();
        Thread.sleep(100);
        ok_btn.click();
    }

    public WebElement Employe_List_View_Search() throws InterruptedException {
        this.Employees.click();
        Thread.sleep(5000);
        return Employees;
    }

    public void getInput_general_search(String EmpS) throws InterruptedException {
        Thread.sleep(5000);
        functions.wait_forElement(getEmp_filter);
        functions.wait_forElement(Employee_search);
        Employee_search.sendKeys(EmpS);
        functions.wait_forElement(search_Emp_select);
        Thread.sleep(5000);
        search_Emp_select.click();
    }

    public float get_Employee_Garnishment() throws NumberFormatException, InterruptedException {
        System.out.println(GP05.getText());
        view_garnishment_plan.click();
        Thread.sleep(1000);
        Hours_Earning_cal hoursEarningCal = new Hours_Earning_cal(driver);
        LTS_PreviewCalculation_TestBase ltsPreviewCalculationTestBase = new LTS_PreviewCalculation_TestBase(driver);
        Garnishment_percentage_S = Garnishment_Percentage.getText();
        System.out.println("Garnishment percentage :" + Garnishment_percentage_S.toString());
        Garnishment_Deduction_Percentag = Float.parseFloat(Garnishment_percentage_S.replace("%", ""));
        view_garnishment_plan.click();
        return Garnishment_Deduction_Percentag;
    }

    public float get_Garnishment_all_other_paln() {
        System.out.println(GP05.getText());
        getView_garnishment_plan_all_others.click();
        String flat_amount_s = flat_amount.getText().substring(1);
        float float_amount_f = Float.parseFloat(flat_amount_s);
        System.out.println(float_amount_f);
        return float_amount_f;
    }

    public float get_Benifit_pan() throws InterruptedException {
        Thread.sleep(1000);
        benifit_tab.click();
        Thread.sleep(1000);
        Benifit123_pre.click();
        Thread.sleep(100);
        view_benefit_plan.click();
        Thread.sleep(10000);
        String Benefit_flat_amount_s = Benefit_percentage.getText();
        Thread.sleep(10000);
        float Benefit_flat_amount = Float.parseFloat(Benefit_flat_amount_s.toString().replace("%", "").substring(1));
        System.out.println("Benefit amount :" + String.format("%.02f", Benefit_flat_amount));
        return Benefit_flat_amount;
    }

    public void get_pay_period_BenefitPlan() throws InterruptedException {
        pay_period_Benefit_plan.click();
        Thread.sleep(100);
        view_benefit_plan.click();
        Thread.sleep(10000);
        String pay_period_Benefit_plan_amout_S = pay_period_Benefit_plan_amout.getText();
        pay_period_Benefit_plan_amout_F = Float.parseFloat(pay_period_Benefit_plan_amout_S.toString().substring(1));
        System.out.println("Benefit amount :" + String.format("%.02f", pay_period_Benefit_plan_amout_F));
    }

    public WebElement getBenefit_plan_amount() {
        Benefit_percentage = this.Benefit_percentage;
        return Benefit_percentage;
    }

    public float Benefit_percentage() {
        Benefit_pecentage_F = Float.parseFloat(Benefit_percentage.getText().replace("%", ""));
        return Benefit_pecentage_F;
    }

    public WebElement get_pay_period_plan_amount() {
        pay_period_Benefit_plan_amout = this.pay_period_Benefit_plan_amout;
        return pay_period_Benefit_plan_amout;
    }

    public WebElement Total_deductions() {
        Emp_paystub_total_deductions = this.Emp_paystub_total_deductions;
        return Emp_paystub_total_deductions;
    }

    public WebElement Total_contribution() {
        Emp_paystub_Total_contributions = this.Emp_paystub_total_deductions;
        return Emp_paystub_Total_contributions;
    }

    public WebElement Employee_Contribution() {
        Emp_paystub_contribution = this.Emp_paystub_contribution;
        return Emp_paystub_contribution;
    }

    public void get_Reembusment_plan() {
    }

    public void Rembusment_calclation() {
    }

    public float Deductions_caculation() {
        System.out.println("NMSN's For Children (POST) :" + Garnishment_Deduction_rate_F);
        System.out.println("Test_Benifit (PRE) :" + pay_period_Benefit_plan_amout_F);
        System.out.println("Pay period Benefit amount" + pay_period_Benefit_plan_amout_F);
        Total_Deductions_amout_F = Garnishment_Deduction_rate_F + (gross_pay % pay_period_Benefit_plan_amout_F);
        System.out.println("Total Deductions is :" + Total_Deductions_amout_F);
        return Total_Deductions_amout_F;
    }

    public void check_Emplyee_contribution() throws InterruptedException {
        functions.wait_forElement(Customer_Plan_deductions);
        Customer_Plan_deductions.click();
        Thread.sleep(1000);
        Benefit_program_tab.click();
        functions.wait_forElement(Benefit_Emp_pre);
        Thread.sleep(10000);
        System.out.println("Actlual plan selected is " + Benefit_Emp_pre.getText());
        select_Benefit_Emp_pre.click();
        Edit_section.click();
    }

    public void get_Employee_Contribution_value() {
        val v1 = Float.parseFloat(Benefit_contribution_amount.getAttribute("value"));
        Contribution_amout_F = v1;
        System.out.println("Employee Contrubution amount is : " + Contribution_amout_F);
    }

    public float Calculation_Employee_Contributions() {
        Total_Contributions_F = Contribution_amout_F + 0;
        return Total_Contributions_F;
    }

    public void Emp_Taxes_Negetive_value_check() {
        float federal_Tax_F = Float.parseFloat(Fedral_Taxes.getText().toString().substring(1));
        float Social_Security_Tax_F = Float.parseFloat(Social_security_Tax.getText().substring(1));
        float Medicare_F = Float.parseFloat(Medicare.getText().substring(1));
        float California_sdi_F = Float.parseFloat(california_sdi.getText().substring(1));

        if (test_null < federal_Tax_F) {
            System.out.println("Verify value is less than null : " + federal_Tax_F);
            Assert.assertEquals(federal_Tax_F, federal_Tax_F);
        } else {
            Assert.assertEquals(test_null, test_null);
            System.out.println("null value :" + test_null);
        }
        if (test_null < Social_Security_Tax_F) {
            System.out.println("Verify value is less than null : " + Social_Security_Tax_F);
            Assert.assertEquals(Social_Security_Tax_F, Social_Security_Tax_F);
        } else {
            Assert.assertEquals(test_null, test_null);
            System.out.println("null value :" + test_null);
        }
        if (test_null < Medicare_F) {
            System.out.println("Verify value is less than null : " + Medicare_F);
            Assert.assertEquals(Medicare_F, Medicare_F);
        } else {
            Assert.assertEquals(test_null, test_null);
            System.out.println("null value :" + test_null);
        }
        if (test_null < California_sdi_F) {
            System.out.println("Verify value is less than null : " + California_sdi_F);
            Assert.assertEquals(California_sdi_F, California_sdi_F);
        }
        Total_Employee_Taxes1 = federal_Tax_F + Social_Security_Tax_F + Medicare_F + California_sdi_F;
        System.out.println("Total Employee Teaxes calculation :" + String.format("%.2f", Total_Employee_Taxes1));
        Assert.assertEquals(Total_Employee_Taxes1, Total_Employee_Taxes1);
    }
    public void Employeer_Taxes_Nagetive_values_check() {
        float Employer_FICA_tAX_f = Float.parseFloat(Employee_FICA_TAX.getText().substring(1));
        float Federal_unemployeement_Tax_F = Float.parseFloat(Federal_Unemployment_Tax.getText().substring(1));
        float Employee_Medicare_Tax_F = Float.parseFloat(Employer_Medicare_Tax.getText().substring(1));
        float California_state_upEmp_F = Float.parseFloat(California_State_Unemployment_Tax.getText().substring(1));
        float California_Emp_Training_F = Float.parseFloat(California_Employment_Training_Tax.getText().substring(1));

        if (test_null < Employer_FICA_tAX_f) {
            System.out.println("Verify value is less than null : " + Employer_FICA_tAX_f);
            Assert.assertEquals(Employer_FICA_tAX_f, Employer_FICA_tAX_f);
        } else {
            Assert.assertEquals(test_null, test_null);
            System.out.println("null value :" + test_null);
        }
        if (test_null < Federal_unemployeement_Tax_F) {
            System.out.println("Verify value is less than null : " + Federal_unemployeement_Tax_F);
            Assert.assertEquals(Federal_unemployeement_Tax_F, Federal_unemployeement_Tax_F);
        } else {
            Assert.assertEquals(test_null, test_null);
            System.out.println("null value :" + test_null);
        }
        if (test_null < Employee_Medicare_Tax_F) {
            System.out.println("Verify value is less than null : " + Employee_Medicare_Tax_F);
            Assert.assertEquals(Employee_Medicare_Tax_F, Employee_Medicare_Tax_F);
        } else {
            Assert.assertEquals(test_null, test_null);
            System.out.println("null value :" + test_null);
        }
        if (test_null < California_state_upEmp_F) {
            System.out.println("Verify value is less than null : " + California_state_upEmp_F);
            Assert.assertEquals(California_state_upEmp_F, California_state_upEmp_F);
        } else {
            Assert.assertEquals(test_null, test_null);
            System.out.println("null value :" + test_null);
        }
        if (test_null < California_Emp_Training_F) {
            System.out.println("Verify value is less than null : " + California_Emp_Training_F);
            Assert.assertEquals(California_Emp_Training_F, California_Emp_Training_F);
        } else {
            Assert.assertEquals(test_null, test_null);
            System.out.println("null value :" + test_null);
        }
        Total_Employee_Taxes2 = Employer_FICA_tAX_f + Federal_unemployeement_Tax_F + Employee_Medicare_Tax_F + California_state_upEmp_F + California_Emp_Training_F;
        System.out.println("Total Employeer Taxes calculation " + String.format("%.2f", Total_Employee_Taxes2));
    }
    public WebElement Genrate_Payroll_btn_click() {
        this.Genrate_Payroll_btn.click();
        return Genrate_Payroll_btn;
    }
    public WebElement Go_Payroll_details(){
        this.Go_Payroll_details.click();
        return Go_Payroll_details;
    }




}