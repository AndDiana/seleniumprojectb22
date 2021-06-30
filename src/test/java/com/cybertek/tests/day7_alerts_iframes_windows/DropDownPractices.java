package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class DropDownPractices {

    WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test (priority = 1)
    public void tc1_simple_dropdown_test() {

        Select simpleDropDown = new Select(driver.findElement(By.xpath("//select[@id = 'dropdown']")));

        String actualDefaultSelectedOption = simpleDropDown.getFirstSelectedOption().getText();
        String expectedDefaultSelectedOption = "Please select an option";

        Assert.assertEquals(actualDefaultSelectedOption, expectedDefaultSelectedOption);


        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id = 'state']")));

        String actualTextOfCurrentOption = stateDropDown.getFirstSelectedOption().getText();
        String expectedTextOfCurrentOption = "Select a State";


        Assert.assertEquals(actualTextOfCurrentOption, expectedTextOfCurrentOption);

    }

    @Test (priority = 2)
    public void tc2_simple_dropdown_test() throws InterruptedException {

        Select simpleDropDown2 = new Select(driver.findElement(By.xpath("//select[@id = 'state']")));

        simpleDropDown2.selectByVisibleText("Illinois");
        Thread.sleep(1000);
        simpleDropDown2.selectByValue("VA");
        Thread.sleep(1000);
        simpleDropDown2.selectByIndex(5);

        String lastSelectedOption = simpleDropDown2.getFirstSelectedOption().getText();
        String expectedLastSelectedOption = "California";

        Assert.assertEquals(lastSelectedOption, expectedLastSelectedOption);


    }

    @AfterClass
    public void tearDownClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }


}
