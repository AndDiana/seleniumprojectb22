package com.cybertek.PracticeAtHome.Practice_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SoftSkillsTesting {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://qa3.vytrack.com/user/login");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("user101", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='_password']")).sendKeys("UserUser123");

        driver.findElement(By.xpath("//button[@id = '_submit']")).click();

        String expectedErrorMessage = "Invalid user name or password.";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class ='alert alert-error'] ")).getText();

        String testResult = (actualErrorMessage.equals(expectedErrorMessage)) ? "Message as expected. Test PASSED!" :
                "Message not as expected. Test FAILED!";

        System.out.println(testResult);

    }
}
