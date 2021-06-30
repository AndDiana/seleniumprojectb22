package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.LibraryUtils.LibraryUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Library_Login {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = com.cybertek.utilities.WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, java.util.concurrent.TimeUnit.SECONDS);
        driver.get("http://library1.cybertekschool.com/login.html");

    }


    @Test
    public void login_link_count_test(){
        //Task #1: Library software link verification
        //loginMethod calling to login Library app
        LibraryUtils.loginToLibrary(driver);

        //6. Print out count of all the links on landing page

        BrowserUtils.sleep(2);

        List<WebElement> allLinks = driver.findElements(org.openqa.selenium.By.xpath("//body//a"));

        System.out.println("allLinks.size() = " + allLinks.size());

        //7. Print out each link text on this page

        for (WebElement each : allLinks) {
            System.out.println(each.getText());
        }

    }

}
