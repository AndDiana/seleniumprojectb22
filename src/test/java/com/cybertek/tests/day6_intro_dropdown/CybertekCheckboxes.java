package com.cybertek.tests.day6_intro_dropdown;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CybertekCheckboxes {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        System.out.println("Checkbox #1 is not selected by default : " + checkBox1.isSelected());
        System.out.println("Checkbox #2 is not selected by default : " + checkBox2.isSelected() );

        Thread.sleep(2000);
        checkBox1.click();

        Thread.sleep(2000);
        checkBox2.click();

        System.out.println("Checkbox #1 is selected :" + checkBox1.isSelected());
        System.out.println("Checkbox #2 is selected : " + checkBox2.isSelected());


    }
}
