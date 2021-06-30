package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alerts_Task {

    WebDriver driver;

    @BeforeMethod
    public void setUpClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }

    @Test (priority = 1)
    public void information_alert_test() {

        WebElement jsAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlertButton.click();

        //switching driver's focus to alert, so we cand handle it
        Alert alert = driver.switchTo().alert();
        //clicking to OK button from the alert
        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[.='You successfuly clicked an alert']"));
        Assert.assertTrue(resultText.isDisplayed());

    }

    @Test (priority = 2)
    public void confirmation_alert_test() {

        WebElement jsConfirmButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirmButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement resultText = driver.findElement(By.xpath("//p[.= 'You clicked: Ok']"));
        Assert.assertTrue(resultText.isDisplayed());


    }

    @Test (priority = 3)
    public void information_alert_test2() throws InterruptedException {
        WebElement jsPromptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();


        WebElement resultText = driver.findElement(By.xpath("//p[.= 'You entered: hello']"));
        Assert.assertTrue(resultText.isDisplayed());

    }

}
