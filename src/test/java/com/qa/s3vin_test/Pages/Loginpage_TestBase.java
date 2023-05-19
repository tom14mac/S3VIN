package com.qa.s3vin_test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = about:blank
public class Loginpage_TestBase {

    static WebDriver driver;
    public void get_instance(String Username,String pass){
        //System.setProperty("webdriver.chrome.driver", "EmpPaystub_TestBase:\\S3V!N_QA\\S3VIN_Test\\chromedriver.exe");
        //driver.get(url);
        //driver.getTitle();
        System.out.println("TEST");
        email.sendKeys(Username);
        Password.sendKeys(pass);
    }
    public void clear(){
        //System.setProperty("webdriver.chrome.driver", "EmpPaystub_TestBase:\\S3V!N_QA\\S3VIN_Test\\chromedriver.exe");
        //driver.get(url);
        //driver.getTitle();
        System.out.println("clear");
        email.clear();
        Password.clear();
    }
    public Loginpage_TestBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void Check_Validation() {
        login.click();
    }
    public String URL(){
        String url = ("http://7.ustaxandpayrollservices.com/staging/public/login");
        return url;
    }

    public void Check_Email_validation(String password) {
        email.sendKeys(password);
        login.click();
    }

    public void check_invalid_password(WebElement password) {
        login.click();
    }

    public void check_invalid_credentials(String Email,String password) {
        email.sendKeys(Email);
        Password.sendKeys(password);
        login.click();
    }
    public void check_valid_credentials(String Email,String pass) {
        email.sendKeys(Email);
        Password.sendKeys(pass);
        login.click();
    }

    public void setLogin() {
        this.login = login;
        login.click();
    }
    @FindBy(xpath ="//button[@id='kt_login_signin_submit_']")
    WebElement login;
    @FindBy(xpath = "//input[@id='password']")
    WebElement Password;
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    // page_url = about:blank
}




