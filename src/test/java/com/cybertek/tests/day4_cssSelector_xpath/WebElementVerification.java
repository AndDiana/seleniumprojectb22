package com.cybertek.tests.day4_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementVerification {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());

        WebElement forgotPasswordHeader = driver.findElement(By.tagName("h2"));
        System.out.println("forgotPasswordHeader.isDisplayed() = " + forgotPasswordHeader.isDisplayed());

        WebElement eMailText  =driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println("eMailText.isDisplayed() = " + eMailText.isDisplayed());

        WebElement eMailInputBox = driver.findElement(By.cssSelector("input[type = 'text']"));
        System.out.println("eMailInputBox.isDisplayed() = " + eMailInputBox.isDisplayed());

        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("i[class = 'icon-2x icon-signin']"));
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());

        WebElement poweredByCybertek = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        System.out.println("poweredByCybertek.isDisplayed() = " + poweredByCybertek.isDisplayed());


    }
}
