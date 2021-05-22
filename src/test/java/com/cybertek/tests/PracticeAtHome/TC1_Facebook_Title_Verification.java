package com.cybertek.tests.PracticeAtHome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_Facebook_Title_Verification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title as expected. Test PASSED!");
        }else{
            System.out.println("Title not as expected. Test FAILED!");
        }

        driver.close();


    }
}
