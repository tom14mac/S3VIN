package com.qa.s3vin_test.Utitlities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Helper {
static WebDriver driver;
    public static WebDriver lunch_browser (String browsername ,String url){
        if (browsername.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "EmpPaystub_TestBase:\\S3V!N_QA\\S3VIN_Test\\chromedriver.exe");
            Capabilities desiredCapabilities = new DesiredCapabilities();
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else if (browsername.equalsIgnoreCase("ff")) {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
