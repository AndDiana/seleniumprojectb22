package com.cybertek.tests.day4_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleButtons {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();

        String actualDisplayedText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedDisplayedText  = "Clicked on button one!";

        if (actualDisplayedText.equals(expectedDisplayedText)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }


    }
}
