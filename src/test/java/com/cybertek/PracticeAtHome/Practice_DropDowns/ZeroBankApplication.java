package com.cybertek.PracticeAtHome.Practice_DropDowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZeroBankApplication {

    WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");

    }

    @Test (priority = 1)
    public void VerifyTitle() {

        WebElement usernameField = driver.findElement(By.xpath("//input[@id = 'user_login']"));
        usernameField.sendKeys("username");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'user_password']"));
        passwordField.sendKeys("password");

        WebElement signInButton = driver.findElement(By.xpath("//input[@class = 'btn btn-primary']"));
        signInButton.click();

        driver.findElement(By.xpath("//button[@id = 'primary-button']")).click();
        driver.findElement(By.xpath("//span[@id = 'account_activity_link']")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Activity";
        Assert.assertEquals(actualTitle, expectedTitle, "verify the title");

    }

        @Test (priority = 2)
        public void DropDownOptions(){

        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@class = 'input-xlarge']")));

        List<WebElement> dropdownOptions = dropdown1.getOptions();
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("Savings", "Checking", "Savings", "Loan",
                "Credit Card", "Brokerage"));

        List<String> actualOptions = new ArrayList<>();

        for (WebElement each : dropdownOptions) {
            actualOptions.add(each.getText());
        }

        Assert.assertEquals(actualOptions, expectedOptions);

        dropdown1.selectByValue("6");

        String actualBrokerageMessage = driver.findElement(By.xpath("//div[@class = 'well']")).getText();
        String expectedBrokerageMessage = "No results.";

        Assert.assertEquals(actualBrokerageMessage, expectedBrokerageMessage);
    }

    @AfterClass
    public void tearDownClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
