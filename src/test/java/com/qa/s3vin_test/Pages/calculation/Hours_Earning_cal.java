package com.qa.s3vin_test.Pages.calculation;

import lombok.val;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.text.DecimalFormat;

public class Hours_Earning_cal {
    Float payrateF,regular_hourF,overtime_hourF,double_hourF,sick_hoursF,vaction_hourF,covid_hoursF,pto_hoursF,commissionF,bonusF;
    Float overtime_hour_rate,double_hour_rate,vaction_hour_rate,sick_hour_rate,covid_earning;
    Float base_reg = 1F,OT = 1.5F, DT= 2F,Vacation_sick_covid= 1F;
    DecimalFormat decimalFormat = new DecimalFormat("0.##");
    Float Regular_hour_Earning,Overtime_earning,DoubleTime_earning,vacation_earning,sick_earning;
    float Gross_payF; String S_GrossPay;
    int test;
    public Hours_Earning_cal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//label[@class='kt-checkbox payTypeTimesheetEntry pr-2 ']//span")
    WebElement switch_btn;
    @FindBy(xpath = "//button[normalize-space()='Yes, Do it!']")WebElement confrim_yes_do_it;
    @FindBy(xpath = "(//input[@id='regular_rate_of_pay'])[1]")WebElement Payrate;
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

    // Hours And Earnings
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[2]/div/div[2]")WebElement paystub_regular_hour;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[2]/div/div[3]")WebElement paystub_payrate;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[2]/div/div[4]")WebElement paystub_Earning_regular;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[3]/div/div[2]")WebElement paystub_overtime;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[3]/div/div[3]")WebElement paystub_overtime_payrate;
    @FindBy(css = "tbody div:nth-child(3) div:nth-child(1) div:nth-child(4)")WebElement paystub_Earning_overtime;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[4]/div/div[2]")WebElement paystub_double_hours;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[4]/div/div[3]")WebElement paystub_double_hour_rate;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[4]/div/div[4]")WebElement paystub_double_Earning;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[5]/div/div[2]")WebElement paystub_vacation_hours;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[5]/div/div[3]")WebElement paystub_vacation_hour_rate;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[5]/div/div[4]")WebElement paystub_vacation_earning;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[6]/div/div[2]")WebElement paystub_sick_hours;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[6]/div/div[3]")WebElement paystub_sick_hour_rate;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[6]/div/div[4]")WebElement paystub_sick_earning;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[7]/div/div[4]")WebElement paystub_covid_earning;
    @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[8]/div/div[3]")WebElement paystub_commision;
   @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tbody/tr/td[1]/div[9]/div/div[3]")WebElement paystub_bonus;
   @FindBy(xpath = "//*[@id=\"payrollDetail\"]/div[1]/div[2]/table[1]/tfoot/tr/td[1]/div/div/div[2]")WebElement paystub_GrossPay;
    public void setTimesheet_details() throws InterruptedException {
        Thread.sleep(1000);
       /* switch_btn.click();
        confrim_yes_do_it.click();
        Thread.sleep(1000);
        switch_btn.click();
        confrim_yes_do_it.click();*/
        val v1 = Float.parseFloat(Payrate.getAttribute("value"));payrateF = v1;
        val v2 = Float.parseFloat(Regular_hours.getAttribute("value")); regular_hourF = v2;
        val v3 = Float.parseFloat(Overtime_hours.getAttribute("value"));overtime_hourF= v3;
        val v4 = Float.parseFloat(Double_hours.getAttribute("value")); double_hourF = v4;
        val v5 = Float.parseFloat(Sick_hours.getAttribute("value"));sick_hoursF = v5;
        val v6 = Float.parseFloat(Vacation_hours.getAttribute("value"));vaction_hourF= v6;
        val v7 = Float.parseFloat(Covid_hours.getAttribute("value"));covid_hoursF=v7;
  // val v8 = Float.parseFloat(PTO_hours.getAttribute("value"));pto_hoursF=v8;
  // val v9 = Float.parseFloat(Commission.getAttribute("value"));commissionF= v9;
  // val v10 =Float.parseFloat(Bonus.getAttribute("value"));bonusF =v10;
    }
    public void VerifiedPrint_values(){
        String S_Regular_hours = String.format("%.02f",regular_hourF);
        String S_Payrate = String.format("%.02f",payrateF);
        String S_Regular_hour_Earning = String.format("%.02f",Regular_hour_Earning);
        String S_overtime = String.format("%.02f",overtime_hourF);
        String S_overtime_payrate = String.format("%.02f",overtime_hour_rate);
        String S_Overtime_earning = String.format("%.02f",Overtime_earning);
        String S_doubletime = String.format("%.02f",double_hourF);
        String S_double_rate = String.format("%.02f",double_hour_rate);
        String S_bouble_earning = String.format("%.02f",DoubleTime_earning);
        String S_vacation_hour = String.format("%.02f",vaction_hourF);
        String S_vacation_rate = String.format("%.02f",vaction_hour_rate);
        String S_Vacation_earning = String.format("%.02f",vacation_earning);
        String S_sick_hours = String.format("%.02f",sick_hoursF);
        String S_sick_hour_rate = String.format("%.02f",sick_hour_rate);
        String S_sick_earning = String.format("%.02f",sick_earning);
        String S_covid_hours = String.format("%.02f",covid_hoursF);
        String S_covid_earning = String.format("%.02f",covid_earning);
       //String S_commission = String.format("%.02f",commissionF);
       //String S_Bonus=String.format("%.02f",bonusF);
        // Verified Stored Values
        Assert.assertEquals(S_Regular_hours, paystub_regular_hour.getText());
        System.out.println(S_Regular_hours+","+paystub_regular_hour.getText());
        Assert.assertEquals(S_Payrate,paystub_payrate.getText().substring(1));
        System.out.println(S_Payrate+","+paystub_payrate.getText());
        Assert.assertEquals(S_Regular_hour_Earning,paystub_Earning_regular.getText().substring(1).replace(",",""));
        System.out.println(S_Regular_hour_Earning+","+paystub_Earning_regular.getText().substring(1));
        Assert.assertEquals(S_overtime,paystub_overtime.getText());
        Assert.assertEquals(S_overtime_payrate,paystub_overtime_payrate.getText().substring(1));
        System.out.println(S_overtime_payrate+","+paystub_overtime_payrate.getText().substring(1));
        Assert.assertEquals(S_Overtime_earning,paystub_Earning_overtime.getText().substring(1));
        Assert.assertEquals(S_doubletime,paystub_double_hours.getText());
        Assert.assertEquals(S_double_rate,paystub_double_hour_rate.getText().substring(1));
        Assert.assertEquals(S_bouble_earning,paystub_double_Earning.getText().substring(1));
        Assert.assertEquals(S_vacation_hour,paystub_vacation_hours.getText());
        Assert.assertEquals(S_vacation_rate,paystub_vacation_hour_rate.getText().substring(1));
        System.out.println(S_vacation_rate+","+paystub_vacation_hour_rate.getText().substring(1));
        Assert.assertEquals(S_Vacation_earning,paystub_vacation_earning.getText().substring(1));
        System.out.println(S_Vacation_earning+","+paystub_vacation_earning.getText().substring(1));
        Assert.assertEquals(S_sick_hours,paystub_sick_hours.getText());
        System.out.println(S_sick_hours+","+paystub_sick_hours.getText());
        Assert.assertEquals(S_sick_hour_rate,paystub_sick_hour_rate.getText().substring(1));
        System.out.println(S_sick_hour_rate+","+paystub_sick_hour_rate.getText().substring(1));
        Assert.assertEquals(S_sick_earning,paystub_sick_earning.getText().substring(1));
        System.out.println(S_sick_earning+","+paystub_sick_earning.getText().substring(1));
        Assert.assertEquals(S_covid_earning,paystub_covid_earning.getText().substring(1));
        System.out.println(S_covid_earning+","+paystub_covid_earning.getText().substring(1));
        //Assert.assertEquals(S_commission,paystub_commision.getText().substring(1));
        //System.out.println(S_commission+","+paystub_commision.getText().substring(1));
        // System.out.println(S_Bonus,paystub_bonus.getText().substring(1))
        //System.out.println(S_Bonus+","+paystub_bonus.getText().substring(1));
    }
    public void setTimesheet_calculation(){
        Regular_hour_Earning = payrateF * regular_hourF;
        System.out.println(Regular_hour_Earning);
        overtime_hour_rate = payrateF * OT;
        System.out.println(overtime_hour_rate);
        Overtime_earning = overtime_hourF * overtime_hour_rate;
        System.out.println(Overtime_earning);
        double_hour_rate = payrateF * DT;
        System.out.println(double_hour_rate);
        DoubleTime_earning = double_hourF * double_hour_rate;
        System.out.println(DoubleTime_earning);
        vaction_hour_rate = Vacation_sick_covid * payrateF;
        System.out.println(vaction_hour_rate);
        vacation_earning = vaction_hourF * vaction_hour_rate;
        System.out.println(vacation_earning);
        sick_hour_rate = Vacation_sick_covid * payrateF;
        System.out.println(sick_hour_rate);
        sick_earning = sick_hoursF * sick_hour_rate;
        System.out.println(sick_earning);
        covid_earning= covid_hoursF * payrateF;
        System.out.println(covid_earning);
    }
    public float Gross_pay_calculation(){
        Gross_payF =  Regular_hour_Earning + Overtime_earning + DoubleTime_earning + vacation_earning+ sick_earning + covid_earning;
        S_GrossPay = String.format("%.02f",Gross_payF);
        S_GrossPay= String.valueOf(Gross_payF);
        System.out.println("Total Gross Play:"+S_GrossPay);
        return Gross_payF;
    }
    public WebElement getPaystub_GrossPay(){
        paystub_GrossPay = this.paystub_GrossPay;
        return paystub_GrossPay;
    }
    public float get_gorssPay() {
        Gross_payF = this.Gross_payF;
        Gross_payF = Float.parseFloat(String.valueOf(Gross_payF));
        System.out.println(Gross_payF);
        return Gross_payF;
    }
}