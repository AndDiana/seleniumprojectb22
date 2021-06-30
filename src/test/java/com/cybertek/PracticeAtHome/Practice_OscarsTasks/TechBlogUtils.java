package com.cybertek.PracticeAtHome.Practice_OscarsTasks;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TechBlogUtils {

    public static List<WebElement> getAllNews(){
        return Driver.getDriver().findElements(By.xpath("//div[@class='river river--homepage ']//a[@class='post-block__title__link']"));

    }

    public static List<WebElement> getAllAuthors() {
        return Driver.getDriver().findElements(By.xpath("//div[@class='river river--homepage ']//a[@aria-label]"));

    }

    public static List<WebElement> getAllImages() {
        return Driver.getDriver().findElements(By.xpath("//div[@class='river river--homepage ']//img"));

    }

    public static String getArticleTitle(int articleIndex) {

        return getAllNews().get(articleIndex).getText();

    }

    public static String getPageTitle(int articleIndex) {

        getAllNews().get(articleIndex).click();
        Driver.getDriver().getTitle();
        return Driver.getDriver().getTitle();

    }



}
