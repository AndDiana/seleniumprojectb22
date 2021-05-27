package com.cybertek.PracticeAtHome.Practice_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://login.yahoo.com/?.src=ym&pspid=159600001&activity=mail-direct&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");

        driver.manage().window().maximize();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Yahoo";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title as expected. Test PASSED!");
        }else{
            System.out.println("Title not as expected. Test FAILED!");
        }

        driver.findElement(By.id("login-username")).sendKeys("batch22@yahoo.com");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='login-signin']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Feb21@2021");

        Thread.sleep(3000);


        driver.findElement(By.id("login-signin")).click();

        Thread.sleep(3000);

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "(8 unread) - batch22@yahoo.com - Yahoo Mail";

        if(actualTitle2.equals(expectedTitle2)){
            System.out.println("Title as expected. Test PASSED!");
        }else{
            System.out.println("Title not as expected. Test FAILED!");
        }


    }
}
