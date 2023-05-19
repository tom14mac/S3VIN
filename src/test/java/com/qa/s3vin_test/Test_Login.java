package com.qa.s3vin_test;

import com.qa.s3vin_test.Pages.Loginpage_TestBase;
import com.qa.s3vin_test.Utitlities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Login {
    public static WebDriver driver ;
    Loginpage_TestBase l1 = new Loginpage_TestBase(driver);
    @Test
    public void check(){
        WebDriver driver = Helper.lunch_browser("chrome","http://7.ustaxandpayrollservices.com/staging/public/login");
        l1 =PageFactory.initElements(driver, Loginpage_TestBase.class);
        Assert.assertEquals(driver.getTitle(),"Login | S3V!N");
        l1.get_instance("test","test");
    }
    @Test
    public void check_validation(){
        l1.clear();
        l1.Check_Validation();
    }
    @Test
    public void check_Email_validatin(){
        l1.Check_Email_validation("1232343256#@@$@");
    }
    @Test
    public void invalid_credentials_check(){
        l1.check_invalid_credentials("user1@ustaxa0ndpayrollservices.com","ciaPD4ZnmFZk");
        l1.check_invalid_credentials("test@test.com","kjhkjdfhs");
    }
    @Test
    public void check_valid_credentials(){
        l1.clear();
        l1.Check_Email_validation("Test@1234");
        l1.check_valid_credentials("user1@ustaxa0ndpayrollservices.com","ciaPD4ZnmFZk");
    }

}
