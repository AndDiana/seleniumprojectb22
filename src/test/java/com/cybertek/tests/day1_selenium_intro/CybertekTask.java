package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekTask {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://practice.cybertekschool.com/");
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();

        if (url.contains("cybertekschool")){
            System.out.println("URL as expected. Test verified.");
        }else{
            System.out.println("URL is not as expected. Test failed.");
        }

        if (title.equals("Practice")){
            System.out.println("Title is as expected. Test verified.");
        }else{
            System.out.println("Title not as expected. Test failed.");
        }

    }
}
