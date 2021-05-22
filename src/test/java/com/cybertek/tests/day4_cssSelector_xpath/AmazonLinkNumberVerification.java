package com.cybertek.tests.day4_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AmazonLinkNumberVerification {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("wooden spoon" + Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedInTitle = "wooden spoon";

        if (actualTitle.contains(expectedInTitle)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

    }
}
