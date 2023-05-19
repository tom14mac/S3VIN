package com.qa.s3vin_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver = new ChromeDriver();

    @Test(description ="Verify check instance URL Valid or not",priority = 0)
    public void Check_login_instance() {
        System.setProperty("webdriver.chrome.driver", "EmpPaystub_TestBase:\\S3V!N_QA\\S3VIN_Test\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://7.ustaxandpayrollservices.com/staging/public/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(description = "Verify all field required validation",priority = 1)
    public void Check_validation() throws InterruptedException {
       Thread.sleep(100);
        WebElement signin_btn = driver.findElement(By.xpath("//button[@id='kt_login_signin_submit_']"));
        signin_btn.click();
    }
    @Test(description = "Verify check Email validation",priority = 2)
    public void check_Email_validation() throws InterruptedException {
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("ciaPD4ZnmFZk");
        WebElement signin_btn = driver.findElement(By.id("kt_login_signin_submit_"));
        signin_btn.click();
        Thread.sleep(1000);
    }
    @Test(description = "Verify check with Invalid Email",priority = 3)
    public void check_invalid_Email(){
        WebElement Email_txt =driver.findElement(By.id("email"));
        Email_txt.sendKeys("test@testing.com");
        WebElement signin_btn = driver.findElement(By.id("kt_login_signin_submit_"));
        signin_btn.click();
    }
    @Test(description = "Verify check with Invalid Password",priority =4)
    public void check_invalid_password() throws InterruptedException {
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("ciaPD4ZnmFZk$%$^#%#$%$#%$#%$#%$#%");
        WebElement signin_btn = driver.findElement(By.id("kt_login_signin_submit_"));
        signin_btn.click();
    }
    @Test(description = "Verify passing invalid Credentials",priority = 5)
    public void check_Invalid_Credentials() throws InterruptedException {
        Thread.sleep(1000);
        WebElement Email_txt =driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signin_btn = driver.findElement(By.id("kt_login_signin_submit_"));
        Email_txt.sendKeys("testing2343924239408920@test.com");
        password.sendKeys("Test@324982034903284920348");
        signin_btn.click();
        Email_txt.clear();
        password.clear();
    }
    @Test(description = "Verify check with Valid Credentials",priority = 6)
    public void check_valid_Credentials() throws InterruptedException {
        Thread.sleep(1000);
        WebElement Email_txt =driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement signin_btn = driver.findElement(By.id("kt_login_signin_submit_"));
        Email_txt.sendKeys("user1@ustaxandpayrollservices.com");
        password.sendKeys("ciaPD4ZnmFZk");
        signin_btn.click();
    }


}
