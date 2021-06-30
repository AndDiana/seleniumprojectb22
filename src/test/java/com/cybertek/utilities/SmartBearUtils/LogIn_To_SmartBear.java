package com.cybertek.utilities.SmartBearUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_To_SmartBear {

    public static void loginToSmartBear(WebDriver driver) {
        
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        WebElement usernameField =  driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_username']"));
        usernameField.sendKeys("Tester");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_password']"));
        passwordField.sendKeys("test");
        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_login_button']")).click();


    }



}
