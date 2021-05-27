package com.cybertek.PracticeAtHome.Practice_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AndreiApple {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.apple.com");

        String [] headers = {"Mac","iPad","iPhone","Watch","TV","Music","Support"};

        for( String each : headers){
            WebElement header = driver.findElement(By.xpath("//a[contains(@class,'" + each.toLowerCase() + "')]"));
            header.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println(driver.getTitle());

            int missingLinks = 0;
            int hasText = 0;
            List<WebElement> links = driver.findElements(By.xpath("//body//all"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            int totalLinks = links.size();
            for(WebElement link : links){
                if(link.getText().isEmpty()){
                    missingLinks++;
                }else {
                    hasText++;
                }
            }
            System.out.println(each + " page has " + totalLinks + " links!" );
            System.out.println("Total empty links: " + missingLinks);
            System.out.println("Total text links: " + hasText);
        }
    }
}
