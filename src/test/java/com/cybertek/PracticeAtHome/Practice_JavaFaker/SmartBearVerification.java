package com.cybertek.PracticeAtHome.Practice_JavaFaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearVerification {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void logIn(){

       WebElement usernameField =  driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_username']"));
       usernameField.sendKeys("Tester");
       WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_password']"));
       passwordField.sendKeys("test");
       driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_login_button']")).click();

        List<WebElement> linksOnPage = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of links on landing page: " + linksOnPage.size());

        for (WebElement element : linksOnPage) {
            System.out.println(element.getText());
        }


    }



}
