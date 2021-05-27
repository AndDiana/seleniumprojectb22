package com.cybertek.PracticeAtHome.Practice_DropDowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Simple_Selection {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test(priority = 1)
    public void SelectDropdown() {

        WebElement simpleDropDown = driver.findElement(By.xpath("//select[@id = 'dropdown']"));
        Select select = new Select(simpleDropDown);
        String actualDefaultValue = select.getFirstSelectedOption().getText();
        String expectedDefaultValue = "Please select an option";
        Assert.assertEquals(actualDefaultValue, expectedDefaultValue);

    }

    @Test(priority = 2)
    public void StateDropdown() {

        WebElement stateDropDown = driver.findElement(By.xpath("//select[@id = 'state']"));
        Select select = new Select(stateDropDown);
        String actualDefaultValue = select.getFirstSelectedOption().getText();
        String expectedDefaultValue = "Select a State";
        Assert.assertEquals(actualDefaultValue, expectedDefaultValue);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}


