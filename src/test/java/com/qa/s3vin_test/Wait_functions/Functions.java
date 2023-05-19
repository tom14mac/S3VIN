package com.qa.s3vin_test.Wait_functions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.lang.reflect.WildcardType;
import java.time.Duration;
import java.util.function.Function;

public class Functions {
    public WebDriver driver;

    public Functions(WebDriver driver) {
        super();
    }
    public WebElement jsclick(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return element;
    }
    public void Async_Script_Execute(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.querySelector(\".la.la-filter\").click();");
    }
    public WebElement findDynamicElement(WebElement webElement, Duration timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
        return element;
    }
    public void currentElement_fluant_wait(WebElement element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(driver -> {
            return driver.findElement((By) element);
        });
    }
    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }
    public static ExpectedCondition<Boolean> wait_forElement(WebElement element) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                boolean flag = false;
                try {
                    if (element.isEnabled()) {
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

