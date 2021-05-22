package com.cybertek.tests.PracticeAtHome;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {
    public static void main(String[] args) {

        //        WebDriverManager.chromedriver().setup();
        //        WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");


       WebElement searchBar=driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("wooden spoon");
        searchBar.submit();

        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle="wooden spoon";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

    }
}

