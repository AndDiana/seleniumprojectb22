package com.cybertek.utilities.SmartBearUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBear_UtilsClass {

    public static void verifyName(WebDriver driver, String name) {

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@style ='border-width:0px;width:100%;']//tr//td[2]"));

        for (WebElement eachName : allNames) {

            if (eachName.getText().equals(name)){
                Assert.assertTrue(eachName.getText().equals(name));
                return;

            }
        }
    }

    public static void printNamesAndCities(WebDriver driver){

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@style ='border-width:0px;width:100%;']//tr//td[2]"));
        List<WebElement> allCities = driver.findElements(By.xpath("//table[@style ='border-width:0px;width:100%;']//tr//td[7]"));

        int count = 1;
        for (int i = 0, j=0; i < allNames.size(); i++, j++) {

            System.out.println("Name" + count + ": " + allNames.get(i).getText() + " City" + count + ": " + allCities.get(j).getText());
            count++;
        }

    }

}
