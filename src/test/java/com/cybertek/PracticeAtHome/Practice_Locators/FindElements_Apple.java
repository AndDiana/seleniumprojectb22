package com.cybertek.PracticeAtHome.Practice_Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements_Apple {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");

        WebElement iphoneTab = driver.findElement(By.xpath("//a[@class = 'ac-gn-link ac-gn-link-iphone']"));
        iphoneTab.click();

        List<WebElement> webElementList = driver.findElements(By.xpath("//body//a"));

        for (WebElement element : webElementList) {
            System.out.println(element.getText());

        }

        int countNoText = 0;
        for (WebElement element : webElementList) {
            if (element.getText().isEmpty()){
                countNoText++;
            }
        }

        System.out.println("Number of links without text : " + countNoText);

        int countWithText = 0;
        for (WebElement element : webElementList) {
            if (!element.getText().isEmpty()) {
                countWithText++;
            }
        }

        System.out.println("Number of links with text : " + countWithText);

        int numberOfLinks = webElementList.size();
        System.out.println("numberOfLinks = " + numberOfLinks);


    }
}
