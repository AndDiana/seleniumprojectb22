package com.cybertek.tests.PracticeAtHome;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys("wodden spoon" + Keys.ENTER);


    }
}
