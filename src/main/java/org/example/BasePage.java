package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }
    public void waitElement(By locator) throws IllegalArgumentException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void click(By locator) throws InterruptedException {
        waitElement(locator);
        find(locator).click();
    }

    public void setText(By locator, String data)throws InterruptedException {
        waitElement(locator);
        find(locator).isEnabled();
        find(locator).clear();
        find(locator).sendKeys(data);
    }
    public String getContent(By locator) throws InterruptedException{
        waitElement(locator);
        return find(locator).getText();
    }

}