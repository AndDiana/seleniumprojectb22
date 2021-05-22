package com.cybertek.tests.PracticeAtHome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_Facebook_Header_Verification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String actualLinkHrefValue = driver.findElement(By.className("_8esh")).getAttribute("href");
        String expectedLinkHrefValue = "registration_form";

        if (actualLinkHrefValue.contains(expectedLinkHrefValue)){
            System.out.println("Href value contains expected text. Test passed!");
        }else{
            System.out.println("Href value does not contain expected text. Test failed!");
        }


    }
}
