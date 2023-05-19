package com.qa.s3vin_test.Pages;

import com.qa.s3vin_test.Action.Add_new_payroll_Entry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.text.DecimalFormat;
import java.util.List;

// page_url = http://7.ustaxandpayrollservices.com/staging/public/admin/company/generate-payroll/110?_token=CUivBq2d7APZ7gjReeg0ekXN85oTE0JV3juDQACB&selectedPayPeriod=3629&companyOnboardingId=110&active_tab_name=LTS&profile_tab=paydata&type=lts
public class LTS_PreviewCalculation_TestBase extends Add_new_payroll_Entry {

   public String total_gross,Employee_Taxes_S;
   public float test_grp,Employee_Taxes_F;

    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)")
    WebElement checkdate;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)")
    WebElement payperiod;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)")
    WebElement PayEntry_count;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)")
    WebElement Employee_Count;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)")
    WebElement Emp_approved;
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)")
    WebElement Emp_unapproved;
    @FindBy(xpath = "//div[@class='main-menu-list sub-menu-list-1 sub-menu-list ml-auto negative_payroll_element text-danger']")
    WebElement Negative_Net_generated;
    @FindBy(xpath = "//span[@class='f-14 kt-font-dark kt-font-bold total_Gross_Pay_tb']")
    WebElement Total_GrossPay;
    @FindBy(xpath = "//span[@class='f-14 kt-font-dark kt-font-bold total_Deductions_tb']")
    WebElement Total_Deducation;
    @FindBy(xpath = "//span[@class='f-14 kt-font-dark kt-font-bold total_Employer_Contributions_tb']")
    WebElement Total_Emp_contribution;
    @FindBy(xpath = "//span[@class='f-14 kt-font-dark kt-font-bold total_Employee_Tax_tb']")
    WebElement Total_Emp_Tax;
    @FindBy(xpath = "//span[@class='f-14 kt-font-dark kt-font-bold total_Net_Pay_tb']")
    WebElement Total_Net_pay;
    @FindBy(css= "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tfoot:nth-child(3) > tr:nth-child(1) > td:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)")
    WebElement Employee_Taxes;
    @FindBy(linkText = "Edit Payroll Entry")WebElement Edit_PayrollEntry;
    @FindBy(xpath = "//*[@id=\"dtbl_payroll_generate_lts_preview\"]/tbody/tr")
    List<WebElement> Emp_lst;
    @FindBy(xpath = "//td[contains(@class,'text-right th-center sorting_1')]")
    List<WebElement> GrossPay_list;
    // Employee paystub Elements
    @FindBy(xpath = "//a[@id='kt_tabs_2']")
    WebElement Emp_paystub_Details;
    @FindBy(xpath = "//a[@id='kt_tabs_1']")
    WebElement Emp_payroll_list;
    @FindBy(css = "body.kt-quick-panel--right.kt-demo-panel--right.kt-offcanvas-panel--right.kt-header--fixed.kt-header-mobile--fixed.kt-subheader--enabled.kt-subheader--transparent.kt-aside--enabled.kt-aside--fixed:nth-child(2) div.kt-grid.kt-grid--hor.kt-grid--root.overflow-hidden:nth-child(3) div.kt-grid__item.kt-grid__item--fluid.kt-grid.kt-grid--ver.kt-page div.kt-grid__item.kt-grid__item--fluid.kt-grid.kt-grid--hor.kt-wrapper div.kt-content.kt-grid__item.kt-grid__item--fluid.kt-grid.kt-grid--hor div.kt-container.kt-container--fluid.kt-grid__item.kt-grid__item--fluid div.tab-content div.tab-pane.active:nth-child(1) div.kt-wizard-v4 div.kt-portlet div.kt-portlet__body.kt-portlet__body--fit div.kt-grid div.kt-grid__item.kt-grid__item--fluid.kt-wizard-v4__wrapper div.kt-form div.kt-wizard-v4__content:nth-child(2) div.kt-form__section.kt-form__section--first div.row div.col-lg-12 div.kt-portlet div.kt-portlet__body div.tab-content:nth-child(3) div.billingProfileTabContent div.row:nth-child(3) div.col-12 div.dataTables_wrapper.dt-bootstrap4.no-footer:nth-child(2) div.row:nth-child(2) div.col-sm-12 table.table.table-striped.table-bordered.table-hover.table-checkable.dataTable.no-footer.dtr-inline tbody:nth-child(2) tr.odd td.wid-3:nth-child(2) > div.round")
    WebElement Emp_select;
    @FindBy(xpath = "//div[@class=\"title text-primary kt-font-bolder\"]")
    WebElement Emp_nm_paystub;
    @FindBy(xpath = "//div[@class=\"uppercase\"]")
    WebElement pay_type;
    @FindBy(xpath = "//div[@class=\"title text-left\"]")
    WebElement Emp_SSN_list;

    //unapproved
    @FindBy(xpath = "(//span[@aria-hidden='true'])[1]")
    WebElement eye_icon_unapproved;
    //Download
    @FindBy(xpath = "//a[normalize-space()='Download and Reset Payroll']")
    WebElement Donwload_Reset_payroll;
    @FindBy(xpath = "//button[normalize-space()='Yes, Reset Payroll']")
    WebElement Yes_Reset_Payroll;

    public LTS_PreviewCalculation_TestBase(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void Preview_Calculation_get_details() throws InterruptedException {
        Thread.sleep(10000);
       /* WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(wait_forElement((Total_GrossPay)));*/
        wait_forElement(checkdate);
        System.out.println("CheckDate:" + checkdate.getText());
        System.out.println("PayPeriod:" + payperiod.getText());
        System.out.println("PayEntry:" + PayEntry_count.getText());
        System.out.println("Employee count" + Employee_Count.getText());
        System.out.println("Employee Approved:" + Emp_approved.getText());
        System.out.println("Employee unApproved:" + Emp_unapproved.getText());
        System.out.println("Total Gross pay:" + Total_GrossPay.getText());
        System.out.println("Total Deduction:" + Total_Deducation.getText());
        System.out.println("Total Employee Contribution:" + Total_Emp_contribution.getText());
        System.out.println("Total Employee Tax:" + Total_Emp_Tax.getText());
        System.out.println("Total Net Pay:" + Total_Net_pay.getText());
    }
    public void setTotal_GrossPay(){
        total_gross = Total_GrossPay.getText().substring(1);
        test_grp = Float.parseFloat(total_gross);
    }
    public void Employee_list() {
        System.out.println("___________________________Employee List____________________________________");
        for (WebElement list : Emp_lst) {
            String Emp_list = list.getText();
            System.out.print(Emp_list.toString());
        }
        for (WebElement grp_list : GrossPay_list) {
            float grplist = Float.parseFloat(grp_list.getText());
            System.out.println("Gross play :" + grplist);
            System.out.println(grplist);
        }
        System.out.println(GrossPay_list);
    }
    public void get_Employee_Paystub_details() throws InterruptedException {
        Emp_paystub_Details.click();
        Thread.sleep(10000);
        System.out.println(">>>>>>>>>> Employee PayStub Details :");wait_forElement(Emp_nm_paystub);
        System.out.println("Employee Name:" + Emp_nm_paystub.getText() + "," + pay_type.getText() + "," + Emp_SSN_list.getText());
    }
    public float get_Employee_Taxes() throws InterruptedException {
        Thread.sleep(1000);
        DecimalFormat decfor = new DecimalFormat("0.00");
        Employee_Taxes_S = Employee_Taxes.getText();
        System.out.println("String value:"+ Employee_Taxes_S.toString().substring(1));
        Employee_Taxes_F = Float.parseFloat(Employee_Taxes_S.toString().substring(1).replace(",",""));
        Employee_Taxes_S = String.format("%.02f",Employee_Taxes_F);
        Employee_Taxes_S= String.valueOf(Employee_Taxes_F);
        System.out.println("Total:"+Employee_Taxes_S);
        System.out.println("Employee Taxes float Value :"+decfor.format(Employee_Taxes_F));
        return Employee_Taxes_F;
    }
    public WebElement getEmp_paystub_tab_click(){
        Emp_paystub_Details.click();
        return Emp_paystub_Details;
    }
    public void view_uapproved() {
        eye_icon_unapproved.click();
    }
    public WebElement getEye_icon_unapproved() {
        eye_icon_unapproved = this.eye_icon_unapproved;
        return eye_icon_unapproved;
    }
    public void Download_Reset_Payroll() throws InterruptedException {
        Thread.sleep(100);
        Donwload_Reset_payroll.click();
        Yes_Reset_Payroll.click();
    }
    public void Emp_list_switch() throws InterruptedException {
     Emp_payroll_list.click();
     Thread.sleep(1000);
     Emp_select.click();
     Thread.sleep(100);
     Edit_PayrollEntry.click();
    }
    public static ExpectedCondition<Boolean> wait_forElement(WebElement element){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                boolean flag = false;
                try {
                    if (element.isDisplayed()) {
                        flag = true;
                    }
                } catch (Exception e) {
                    System.out.println("inside catch block" + e.getMessage());
                }
                return flag;
            }
        };
    }

}