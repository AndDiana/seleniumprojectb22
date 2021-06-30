package com.cybertek.PracticeAtHome.Practice_JavaFaker;

import com.cybertek.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CybertekRegistration {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = com.cybertek.utilities.WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, java.util.concurrent.TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/registration_form");

    }

    @Test
    public void registrationFormTest() {

        Faker faker = new Faker();
        String firstName = faker.name().firstName();

        String lastName = faker.name().lastName();

        String userName = firstName + "" +lastName;

        String dob = faker.number().numberBetween(1,12) + "/" + faker.number().numberBetween(1,31) +
                "/" + faker.number().numberBetween(1920, 2021);


        String emailAddress = userName+"@gmail.com";

        String password = userName+""+dob.replace("/","");

        String phoneNumber = "000-000-0000";


        driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(emailAddress.toLowerCase());
        driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name = 'phone']")).sendKeys(phoneNumber);

        driver.findElement(By.xpath("//input[@value = 'other']")).click();
        driver.findElement(By.xpath("//input[@name = 'birthday']")).sendKeys(dob);



        Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@name = 'department']")));
        dropdown1.selectByValue("DE");
        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@name = 'job_title']")));
        dropdown2.selectByVisibleText("SDET");

        driver.findElement(By.xpath("//input[@value = 'java']")).click();
        driver.findElement(By.xpath("//button[@id = 'wooden_spoon']")).click();

        WebElement successMessage = driver.findElement(By.tagName("p"));
        Assert.assertTrue(successMessage.isDisplayed());


    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }


}
