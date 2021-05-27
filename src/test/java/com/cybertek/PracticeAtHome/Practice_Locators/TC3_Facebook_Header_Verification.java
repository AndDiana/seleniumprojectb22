package com.cybertek.PracticeAtHome.Practice_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_Facebook_Header_Verification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

       String actualHeader = driver.findElement(By.tagName("h2")).getText();
       String expectedHeader = "Connect with friends and the world around you on Facebook.";

       if (actualHeader.equals(expectedHeader)){
           System.out.println("Header as expected. Test Passed!");
       }else{
           System.out.println("Header not as expected. Test Failed!");
       }


    }
}
