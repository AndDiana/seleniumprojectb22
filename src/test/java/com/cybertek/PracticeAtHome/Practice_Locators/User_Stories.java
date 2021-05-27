package com.cybertek.PracticeAtHome.Practice_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class User_Stories {
    String firstTitleCheck;

    WebDriver driver;

    public void chromSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void UserStory01Title1CheckAndLogin() {

        driver.get("https://qa3.vytrack.com/user/login");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String actualTitle = driver.getTitle();
        String expectedTitle = firstTitleCheck;

        String check = actualTitle.equals(expectedTitle) ? firstTitleCheck : "Failed to detect";
        System.out.println("New Title " + check);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        WebElement rememberMeClick = driver.findElement(By.id("prependedInput2"));
        rememberMeClick.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement userNameLoginSpace = driver.findElement(By.id("prependedInput"));
        userNameLoginSpace.sendKeys("user168");

        WebElement userPasswordSpace = driver.findElement(By.id("prependedInput2"));
        userPasswordSpace.sendKeys("UserUser123" + Keys.ENTER);

    }

    String secondTitleCheck;

    public void UserStory01Title2CheckAfterLogin() {

        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = secondTitleCheck;

        String check2 = actualTitle2.equals(expectedTitle2) ? secondTitleCheck : "Failed to detect";
        System.out.println("New Title " + check2);

    }

    public static void main(String[] args) {

        User_Stories TitleCheck = new User_Stories();
        TitleCheck.firstTitleCheck = "Login";
        TitleCheck.secondTitleCheck = "Dashboard";
        TitleCheck.chromSetup();
        TitleCheck.UserStory01Title1CheckAndLogin();
        TitleCheck.UserStory01Title2CheckAfterLogin();

    }
}
