package com.cybertek.PracticeAtHome.Practice_DropDowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleSelection {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void TestAllOptions() throws InterruptedException {

        WebElement languagesDropdown = driver.findElement(By.xpath("//select[@name ='Languages']"));
        Select select = new Select(languagesDropdown);

        List<WebElement> options = select.getOptions();
        for (WebElement each : options) {
            Thread.sleep(2000);
            each.click();
            System.out.println(each.getText());
        }

        select.deselectAll();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


