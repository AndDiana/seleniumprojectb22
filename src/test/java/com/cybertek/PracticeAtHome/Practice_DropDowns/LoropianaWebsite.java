package com.cybertek.PracticeAtHome.Practice_DropDowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoropianaWebsite {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://us.loropiana.com/en/");

    }

    @Test
    public void chooseItem() throws InterruptedException {

        WebElement cookiesButton = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookiesButton.click();

        WebElement womenOptions = driver.findElement(By.xpath("//li[@ id = 'New_Woman']"));
        womenOptions.click();

        WebElement category = driver.findElement(By.xpath("//a[@href = 'https://us.loropiana.com/en/c/woman/" +
                "accessories/sunglasses']"));
        category.click();

        WebElement item = driver.findElement(By.xpath("//img[@src = 'https://media.loropiana.com/HYBRIS/FAI/" +
                "FAI4926/A7B3E64A-F2F5-4A2F-BBEA-BEF647CA5F25/FAI4926_8092_SMALL.jpg']"));
        item.click();

        Thread.sleep(2000);

        WebElement chooseColor = driver.findElement(By.xpath("//img[@class = 'colourswatch selected big']"));
        chooseColor.click();

        Thread.sleep(2000);

        WebElement openSizeOptions = driver.findElement(By.xpath("//div[@class = 'sizevalue t-sub-h3-med']"));
        openSizeOptions.click();

        WebElement chooseSize = driver.findElement(By.xpath("//button[@class = 'sizeoption t-sub-h3-med grey']"));
        chooseSize.click();

        WebElement addToBag = driver.findElement(By.xpath("//button[@class = 'main-button t-cta sticky-mobile gold']"));
        addToBag.click();

        WebElement checkout = driver.findElement(By.xpath("//button[@aria-label = 'proceed to checkout']"));
        checkout.click();
        Thread.sleep(2000);

        WebElement usernameField = driver.findElement(By.xpath("//input[@id = 'j_username']"));
        usernameField.sendKeys("batch22@yahoo.com");

        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id = 'j_password']"));
        passwordField.sendKeys("Feb21@2021");

        WebElement loginButton = driver.findElement(By.xpath("//button[@aria-label='login']"));
        loginButton.click();


        }
    }



