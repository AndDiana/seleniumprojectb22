package com.cybertek.PracticeAtHome.Practice_JavaFaker;

import com.cybertek.utilities.SmartBearUtils.LogIn_To_SmartBear;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setupMethod() {
        LogIn_To_SmartBear.loginToSmartBear(driver);
    }


    @Test (priority = 1)
    public void linkVerification() {
        List<WebElement> linksOnPage = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of links on landing page: " + linksOnPage.size());

        for (WebElement element : linksOnPage) {
            System.out.println(element.getText());
        }

    }

    @Test (priority = 2)

    public void orderPlacingTest() {
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

    @Test (priority = 3)
    public void orderVerification() {

        String orderInformation = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody//tr[6]")).getText();
        String expectedNameOrder = "Susan McLaren";
        String expectedDateOrder = "01/05/2010";

        Assert.assertTrue(orderInformation.contains(expectedNameOrder));
        Assert.assertTrue(orderInformation.contains(expectedDateOrder));

    }

}
