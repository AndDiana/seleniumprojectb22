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

public class Date_Selection {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void YearSelection() throws InterruptedException {

        WebElement yearDropdown = driver.findElement(By.xpath("//select[@id ='year']"));
        Select select = new Select(yearDropdown);
        select.selectByVisibleText("1992");

        String actualSelectedYear = select.getFirstSelectedOption().getText();
        String expectedSelectedYear = "1992";
        Assert.assertEquals(actualSelectedYear, expectedSelectedYear);

        Thread.sleep(2000);

    }

    @Test
    public void MonthSelection() throws InterruptedException {

        WebElement monthDropdown = driver.findElement(By.xpath("//select[@id = 'month']"));
        Select select = new Select(monthDropdown);
        select.selectByValue("11");

        String actualSelectedMonth = select.getFirstSelectedOption().getText();
        String expectedSelectedMonth = "December";
        Assert.assertEquals(actualSelectedMonth, expectedSelectedMonth);

        Thread.sleep(2000);

    }

    @Test
    public void DaySelection() throws InterruptedException {

        WebElement dayDropdown = driver.findElement(By.xpath("//select[@id = 'day']"));
        Select select = new Select(dayDropdown);
        select.selectByIndex(19);

        String actualSelectedDay = select.getFirstSelectedOption().getText();
        String expectedSelectedDay = "20";
        Assert.assertEquals(actualSelectedDay, expectedSelectedDay);

        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
