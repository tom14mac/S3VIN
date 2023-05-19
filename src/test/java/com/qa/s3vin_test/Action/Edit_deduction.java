package com.qa.s3vin_test.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// page_url = about:blank
public class Edit_deduction {
static WebDriver driver;
    public Edit_deduction(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
  // Selection EMP
    @FindBy(xpath = "(//div[@class='round'])[2]")WebElement select_Emp;
    @FindBy(xpath = "//a[normalize-space()='Edit Deduction']")WebElement Edit_deduction;
    @FindBy(xpath = "//a[@class='btn-icon-primary btn-sub-actions ']")WebElement Delete_btn;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")WebElement confirm;
    @FindBy(xpath = "//button[normalize-space()='OK']")WebElement ok_btn;
    @FindBy(xpath = "//a[@data-placement='top']/..")WebElement Delete_btn_list;

    public void check_edit_deduction() throws InterruptedException{
        /*WebDriverWait wait = new WebDriverWait(driver, 15);
        select_Emp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='round'])[2]")));*/
        Thread.sleep(10000);
        select_Emp.click();
        Edit_deduction.click();
        Thread.sleep(10000);
        Delete_btn.click();
        Thread.sleep(1000);
        confirm.click();
        Thread.sleep(1000);
        ok_btn.click();
        try {
            Delete_btn_list.click();
            Thread.sleep(1000);
            ok_btn.click();
        }catch (Exception e){e.getMessage();
        }
    }

}