package com.cybertek.PracticeAtHome.Practice_Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Soft {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeMethod
    public void setDriver() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://qa3.vytrack.com/user/login");
        Thread.sleep(1000);
    }

    @Test
    public void testLogInFail() throws InterruptedException {


        WebElement usernameField = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameField.sendKeys("user101", Keys.ENTER);
        Thread.sleep(1000);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordField.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id = '_submit']"));
        loginButton.click();

        String actualErrorMessage = driver.findElement(By.xpath("//div[@class ='alert alert-error'] ")).getText();
        String expectedErrorMessage = "Invalid user name or password.";

        Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage));

//
//        String testResult = (actualErrorMessage.equals(expectedErrorMessage)) ? "Message as expected. Test PASSED!" :
//                "Message not as expected. Test FAILED!";
//
//        System.out.println(testResult);

    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();

    }


}
