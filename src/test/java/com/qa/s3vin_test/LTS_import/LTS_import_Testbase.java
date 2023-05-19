package com.qa.s3vin_test.LTS_import;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

// page_url = about:blank
public class LTS_import_Testbase {
     @FindBy(xpath = "//div[@id='ltsPayDataId']//li[contains(@class,'payrollLtsAtfTab')]//a[contains(@class,'btn btn-icon-primary btn-sub-actions mr-3')][normalize-space()='Import LTS TimeSheet']")
      WebElement import_LTS;
     @FindBy(xpath = "//li[@class='new-item-add dropdown kt-custom-download-dropdown']//a[@id='navbarDropdown']")WebElement import_btn;
     @FindBy(xpath = "//a[@class='dropdown-item paymethod-ele'][normalize-space()='Standard']")WebElement Standard;@FindBy(xpath = "//tbody/tr[1]/td[2]/div[1]/label[1]")WebElement select_sheet;
     @FindBy(xpath = "//a[contains(@class,'mr-3')][normalize-space()='Column Mapping']")WebElement column_mapping;
     @CacheLookup
     @FindBy(xpath = "//a[@id='navbarDropdown']")WebElement continue_btn;
     @FindBy(xpath = "//div[contains(@class,'d-flex align-items-center bb-1 borderclass')]//button[1]")WebElement Start_validation;
     @FindBy(xpath = "//i[@class='la la-filter']")WebElement filter;
     @FindBy(xpath = "//span[normalize-space()='Required (11)']")WebElement getGetFilter_required;
     @FindBy(xpath = "//button[@title='S3VIN Fields (35)']")WebElement getFilter;
     @FindBy(xpath = "//label[@for='override_address']//span[@class='slider round']")WebElement override_address;
     @FindBy(xpath = "//a[normalize-space()='Import Verified Records']")WebElement import_verified_btn;
     @FindBy(xpath = "//button[normalize-space()='Yes, Start it!']")WebElement Yes_start_it;
     @FindBy(xpath = "//button[text()='OK']")WebElement getOk_btn;
     @FindBy(xpath = "//a[contains(text(),'Pay Data')]")WebElement pay_data;
    public LTS_import_Testbase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void setImport_LTS() {
        import_LTS.click();
        import_btn.click();
        Standard.click();
    }
    public void getImport_LTS() throws InterruptedException, AWTException {
        Thread.sleep(2000);
        Robot robot = new Robot();
        StringSelection filepath = new StringSelection("D:\\s3vinautomation\\src\\Testdata\\LTS_Import_Testdata.xlsx");
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
    }
    public void select_Emp_columm_maping() throws InterruptedException {
        Thread.sleep(2000);
        select_sheet.click();
        column_mapping.click();
    }
    public void Column_Mapping_filter() throws InterruptedException {
        filter.click();
        Thread.sleep(10000);
        //getFilter.click();
        //getGetFilter_required.click();
    }
    public void setStart_validation(){
        continue_btn.click();
        Start_validation.click();
    }
    public void import_Verified_records() throws InterruptedException {
        select_sheet.click();
        import_verified_btn.click();
        Thread.sleep(1000);
        Yes_start_it.click();
        getOk_btn.click();
    }
}