package com.cybertek.tests.day6_intro_dropdown;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppleTask3 {
    public static void main(String[] args) {
        //TC #03: FINDELEMENTS_APPLE
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://www.apple.com
        driver.get("https://www.apple.com");

        //3. Click to all of the headers one by one
        //  a. Mac, iPad, iPhone, Watch, TV, Music, Support
        //  apple Logo
        //  Mac,
        //  iPad,
        //  iPhone,
        //  Watch,
        //  TV,
        //  Music,
        //  Support
        //  search box

        // Storing 9 web elements including "apple" logo, and search box
        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

        for (int eachLink = 1; eachLink < headerLinks.size()-1; eachLink++) {

            //System.out.println(headerLinks.get(eachLink).getText());

            headerLinks.get(eachLink).click();

            headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));


            //4. Print out the titles of the each page

            System.out.println("Current title in the page : " + driver.getTitle());

            //5. Print out total number of links in each page

            List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

            System.out.println("Total number of links: " + allLinks.size());

            //6. While in each page:
            // a. Print out how many link is missing text TOTAL
            // b. Print out how many link has text TOTAL

            int countNoText = 0;
            int countWithText = 0;
            for (WebElement each : allLinks) {
                if (each.getText().isEmpty()){
                    countNoText++;
                }else{
                    countWithText++;
                }
            }

            System.out.println("Number of links without text: " + countNoText);
            System.out.println("Number of links with text: " + countWithText);



        }

    }
}
