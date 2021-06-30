package com.cybertek.PracticeAtHome.Practice_JavaFaker;

import com.cybertek.utilities.LibraryUtils.LibraryUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Library_Software_LinkVerification {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setUpMethod() {
       LibraryUtilities.logInToLibrary(driver);
    }

    @Test
    public void linkVerification(){


        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Number of links on landing page: " + listOfLinks.size());

        for (WebElement listOfLink : listOfLinks) {
            System.out.println(listOfLink.getText());
        }

    }




    }

