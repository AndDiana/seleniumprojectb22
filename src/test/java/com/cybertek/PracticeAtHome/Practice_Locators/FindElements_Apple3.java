package com.cybertek.PracticeAtHome.Practice_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindElements_Apple3 extends customBaseTest {


    @Parameters({"mac", "ipad", "iphone", "watch", "tv", "music", "support"})

    @Test(priority = 1)
    public void checkLinks(String headerName1, String headerName2, String headerName3, String headerName4, String headerName5,String headerName6, String headerName7 ) {

        getDriver().get("https://www.apple.com");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement selectedTab = getDriver().findElement(By.xpath("//a[@class = 'ac-gn-link ac-gn-link-" + headerName1 +"']"));
        selectedTab.click();

        String expectedTitleMac = getDriver().getTitle();
        System.out.println("Page title is: " + expectedTitleMac);

//
//        WebElement selectedTab2 = getDriver().findElement(By.xpath("//a[@class = 'ac-gn-link ac-gn-link-" + headerName2 +"']"));
//        selectedTab2.click();
    }

}
