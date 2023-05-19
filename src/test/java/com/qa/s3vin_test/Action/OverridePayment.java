package com.qa.s3vin_test.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

// page_url = about:blank
public class OverridePayment {

    public OverridePayment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//label[contains(@for,'kt-group-checkable')]")WebElement select_emp;
    @FindBy(xpath = "//a[normalize-space()='Override Payment Method']")WebElement Override_btn;
    @FindBy(xpath = "//button[normalize-space()='Yes, Do it!']")WebElement confirm;
    @FindBy(xpath = "//select[@id='er_payment_method']")WebElement Override_payment;
    @FindBy(xpath = "//form[@id='frmOverridePaymentMethodEntry']//button[@type='submit'][normalize-space()='Save']")WebElement Save_btn;
    @FindBy(xpath = "//button[normalize-space()='Yes, Update it!']")WebElement Confirm_save;
    @FindBy(xpath = "//button[normalize-space()='OK']")WebElement ok_btn;
    @FindBy(xpath = "//td[position()=14]")WebElement Payment_method_status;
    @FindBy(xpath = "//select[@id='er_payment_method']")List<WebElement> test;

    public void Override_Payment_Eoi_shipped_checks() throws InterruptedException {
        select_emp.click();
        Thread.sleep(1000);
        Override_btn.click();
        confirm.click();
        Select select_Payment_mathod = new Select(Override_payment);
        Thread.sleep(1000);
        select_Payment_mathod.selectByIndex(1);
        Save_btn.click();
        Thread.sleep(1000);
        Confirm_save.click();
        Thread.sleep(1000);
        ok_btn.click();
    }
    public void Override_Payment_EOI_Direct_Diposit_chekes() throws InterruptedException {
        select_emp.click();
        Thread.sleep(1000);
        Override_btn.click();
        confirm.click();
        Select select_Payment_mathod = new Select(Override_payment);
        Thread.sleep(1000);
        select_Payment_mathod.selectByIndex(2);
        Save_btn.click();
        Thread.sleep(1000);
        Confirm_save.click();
        Thread.sleep(1000);
        ok_btn.click();
    }
    public void Override_Payment_Customer_Direct_Diposite_Checks() throws InterruptedException {
        select_emp.click();
        Thread.sleep(1000);
        Override_btn.click();
        confirm.click();
        Select select_Payment_method = new Select(Override_payment);
        Thread.sleep(1000);
        select_Payment_method.selectByIndex(3);
        Save_btn.click();
        Thread.sleep(1000);
        Confirm_save.click();
        Thread.sleep(1000);
        ok_btn.click();
    }
    public void Override_Payment_Customer_shipped_checks() throws InterruptedException {
        select_emp.click();
        Thread.sleep(1000);
        Override_btn.click();
        confirm.click();
        Select select_Payment_mathod = new Select(Override_payment);
        Thread.sleep(1000);
        select_Payment_mathod.selectByIndex(4);
        Save_btn.click();
        Thread.sleep(1000);
        Confirm_save.click();
        Thread.sleep(1000);
        ok_btn.click();
    }

}