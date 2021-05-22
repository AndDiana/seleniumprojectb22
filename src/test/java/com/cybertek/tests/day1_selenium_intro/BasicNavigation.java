package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tesla.com");

        System.out.println("Current title: " + driver.getTitle());

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //putting 3 seconds of wait
        Thread.sleep(3000);
        //Going back using navigation
        driver.navigate().back();

        Thread.sleep(3000);
        //Going forward using navigation
        driver.navigate().forward();

        Thread.sleep(3000);
        //Refreshing the page using navigation
        driver.navigate().refresh();

        Thread.sleep(3000);
        //Goind to another url using to() method
        driver.navigate().to("https://www.google.com");

        System.out.println("Current title: " + driver.getTitle());

        currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        //this line will maximize the browser size

        driver.manage().window().maximize();

        driver.close();



    }
}
