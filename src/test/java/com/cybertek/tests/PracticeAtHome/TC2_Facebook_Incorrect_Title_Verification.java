package com.cybertek.tests.PracticeAtHome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_Facebook_Incorrect_Title_Verification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("andreea@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("12345" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Log into Facebook";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title as expected. Test PASSED!");
        }else{
            System.out.println("Title not as expected. Test FAILED!");
        }

    }
}
