package com.cybertek.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T6_ZeroBankLinkVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

       String actualLinkText =  driver.findElement(By.className("brand")).getText();
       String expectedLinkText = "Zero Bank";

        if (actualLinkText.contains(expectedLinkText)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        String actualHREF = driver.findElement(By.partialLinkText("Bank")).getAttribute("href");
        String expectedHREFF = "index.html";

        if (actualHREF.contains(expectedHREFF)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }
}