package com.cybertek.utilities.LibraryUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LibraryUtilities {

    public static void logInToLibrary(WebDriver driver) {

        driver.get("http://library2.cybertekschool.com/login.html");
        driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys("student11@library ");
        driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("tScBPCUr");
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();

    }

}
