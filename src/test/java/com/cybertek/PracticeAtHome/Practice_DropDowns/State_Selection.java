package com.cybertek.PracticeAtHome.Practice_DropDowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class State_Selection {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void StateDropDown() {

        WebElement dropdown = driver.findElement(By.xpath("//select[@id = 'state']"));
        Select select = new Select (dropdown);

        select.selectByIndex(14);
        select.selectByVisibleText("Virginia");
        select.selectByValue("CA");

        String expectedLastValueSelected = "California";
        String actualLastValueSelected = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedLastValueSelected, actualLastValueSelected, "verifying last value selected");

    }

    @BeforeMethod
    public void tearDown() {
        driver.quit();
    }

}
