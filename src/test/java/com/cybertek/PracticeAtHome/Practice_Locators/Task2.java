package com.cybertek.PracticeAtHome.Practice_Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        driver.get("https://www.youtube.com/");

       WebElement search =  driver.findElement(By.xpath("//input[@id = 'search' ]"));
       search.sendKeys("Blue - One Love");
        Thread.sleep(3000);
        search.submit();
        Thread.sleep(3000);

        WebElement rahibSong = driver.findElement(By.xpath("//yt-formatted-string[@class = 'style-scope ytd-video-renderer']"));
        rahibSong.click();

    }
}
