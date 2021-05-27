package com.cybertek.PracticeAtHome.Practice_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements2_Apple {

    WebDriver driver;

    public void chromeSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void checkLinks(String headerName){


        driver.get("https://www.apple.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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

    }

    public static void main(String[] args) {


        FindElements2_Apple HeaderCheck = new FindElements2_Apple();

        HeaderCheck.chromeSetup();
        HeaderCheck.checkLinks("mac");
        HeaderCheck.checkLinks("ipad");
        HeaderCheck.checkLinks("iphone");
        HeaderCheck.checkLinks("watch");
        HeaderCheck.checkLinks("tv");
        HeaderCheck.checkLinks("music");
        HeaderCheck.checkLinks("support");

    }

}
