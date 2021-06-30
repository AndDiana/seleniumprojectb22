package com.cybertek.PracticeAtHome.Practice_JavaFaker;

import com.cybertek.utilities.SmartBearUtils.LogIn_To_SmartBear;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBear_OrderVerification {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setupMethod() {

        LogIn_To_SmartBear.loginToSmartBear(driver);
    }
    @Test
    public void orderVerification() {

        String orderInformation = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//tr[6]")).getText();
        String expectedNameOrder = "Susan McLaren";
        String expectedDateOrder = "01/05/2010";

        Assert.assertTrue(orderInformation.contains(expectedNameOrder));
        Assert.assertTrue(orderInformation.contains(expectedDateOrder));



    }


}
