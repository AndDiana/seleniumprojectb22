package com.cybertek.PracticeAtHome.Practice_JavaFaker;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearOrderPlacing {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void logIn() {

        WebElement usernameField = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_username']"));
        usernameField.sendKeys("Tester");
        WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_password']"));
        passwordField.sendKeys("test");
        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_login_button']")).click();

        driver.findElement(By.xpath("//ul[@id ='ctl00_menu']//li[3]")).click();

        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id = 'ctl00_MainContent_fmwOrder_ddlProduct']")));
        dropdown1.selectByValue("FamilyAlbum");

        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_txtQuantity']")).sendKeys("2");

        driver.findElement(By.xpath("//input[@value = 'Calculate']")).click();

        Faker faker = new Faker();

        String fullName = faker.name().fullName();
        String streetName = faker.address().streetAddress();
        String city = faker.address().cityName();
        String state = faker.address().state();
        String zipCode = faker.address().zipCode();

        String cardNumber = faker.business().creditCardNumber();
        String validCardNumber = "";

        for (int i = 0; i < cardNumber.length(); i++){
            if (Character.isDigit(cardNumber.charAt(i))){
                validCardNumber += cardNumber.charAt(i);
            }

        }

        String expirationDate = "25/10";

        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_txtName']")).sendKeys(fullName);
        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys(streetName);
        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(state);
        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(zipCode.substring(0,5));

        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_cardList_0']")).click();
        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(validCardNumber);

        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys(expirationDate);
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();


        WebElement actualMessage = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder']/tbody/tr/td/div/strong"));

        Assert.assertTrue(actualMessage.isDisplayed());



    }
}