package com.cybertek.PracticeAtHome.Practice_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_Basic_Login_Authentication {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        Thread.sleep(1000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title as expected. Test passed!");
        }else{
            System.out.println("Title not as expected. Test failed!");
        }

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        Thread.sleep(1000);
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        Thread.sleep(1000);
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        String loginActualTitle = driver.getTitle();
        String loginExpectedTitle = "Web Orders";

        if (loginActualTitle.equals(loginExpectedTitle)) {
            System.out.println("Title as expected. Test passed!");
        }else{
            System.out.println("Title not as expected. Test failed!");
        }

    }
}
