package com.cybertek.tests.PracticeAtHome;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements_Meriam_Webster {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.merriam-webster.com/");

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        for (WebElement each : listOfLinks) {
            System.out.println(each.getText());

        }

        int countNoText = 0;
        for (WebElement each : listOfLinks) {
            if (each.getText().isEmpty()){
                countNoText++;
            }
        }

        System.out.println("Number of links without text : " + countNoText);

        int countWithText = 0;
        for (WebElement each : listOfLinks) {
            if (!each.getText().isEmpty()) {
                countWithText++;
            }
        }

        System.out.println("Number of links with text : " + countWithText);

        int numberOfLinks = listOfLinks.size();
        System.out.println("numberOfLinks = " + numberOfLinks);


        }

    }

