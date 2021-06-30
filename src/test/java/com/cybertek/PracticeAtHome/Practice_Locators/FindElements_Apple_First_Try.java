package com.cybertek.PracticeAtHome.Practice_Locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements_Apple_First_Try {

    public static void main(String[] args) {

        checkLinks("mac");
        checkLinks("ipad");
        checkLinks("iphone");
        checkLinks("watch");
        checkLinks("tv");
        checkLinks("music");
        checkLinks("support");

    }

    public static void checkLinks(String headerName){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.apple.com");

        WebElement selectedTab = driver.findElement(By.xpath("//a[@class = 'ac-gn-link ac-gn-link-" + headerName +"']"));
        selectedTab.click();

        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        List<WebElement> webElementList = driver.findElements(By.xpath("//body//a"));

        int numberOfLinks = webElementList.size();
        System.out.println("Number of links in " +  pageTitle + ": "  + numberOfLinks);

        int countNoText = 0;
        int countWithText = 0;
        for (WebElement element : webElementList) {
            if (element.getText().isEmpty()){
                countNoText++;
            }else{
                countWithText++;
            }
        }

        System.out.println("Number of links without text in " + pageTitle + ": " + countNoText);
        System.out.println("Number of links with text in " + pageTitle + ": " + countWithText);


        driver.quit();


    }
}


