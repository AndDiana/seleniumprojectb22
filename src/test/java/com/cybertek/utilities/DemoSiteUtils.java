package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoSiteUtils {

    public static String expectedTitle = "Login example page to test the PHP MySQL online system";
    public static String expectedHeader = "4. Login";
    public static String expectedStatusMessage = "**No login attempted**";
    public static String expectedInfoMessage = "Enter your login details you added on the previous page and test the login.\n" +
            "The success or failure will be shown above.";
    public static String expectedSuccesLoginMessage = "**Successful Login**";
    public static String expectedFailedLoginMessage = "**Failed Login**";


    public static void succesfullLogin(WebDriver driver, String myUsername, String myPassword) {

        driver.get("http://thedemosite.co.uk/login.php");

        WebElement username = driver.findElement(By.xpath("//input[@name = 'username']"));
        username.sendKeys(myUsername);

        WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
        password.sendKeys(myPassword);

        driver.findElement(By.xpath("//input[@name = 'FormsButton2']")).click();

    }

    public static String tabTitle(WebDriver driver) {

        return driver.getTitle();

    }

    public static String getHeaderText(WebDriver driver) {

        return driver.findElement(By.xpath("//a[. = '4. Login']")).getText();

    }

    public static String getStatusMessage(WebDriver driver) {

        return driver.findElement(By.xpath("//td[@class = 'auto-style1']//big/blockquote//b")).getText();

    }

    public static String getInfoMessage (WebDriver driver) {

        return driver.findElement(By.xpath("//td[@class = 'auto-style1']//blockquote//p")).getText();
    }

    public static WebElement getUsernameField(WebDriver driver) {

        return driver.findElement(By.xpath("//input[@name = 'username']"));
    }

    public static WebElement getPasswordField(WebDriver driver) {

        return driver.findElement(By.xpath("//input[@name = 'password']"));
    }

    public static WebElement getLoginButton (WebDriver driver) {

        return driver.findElement(By.xpath("//input[@name = 'FormsButton2']"));
    }

    public static String getSuccessLoginMessage(WebDriver driver) {

        succesfullLogin(driver, "pspspsps", "pspspsps");

        return driver.findElement(By.xpath("//td[@class = 'auto-style1']//blockquote//b")).getText();
    }

    public static String getFailedLoginMessage(WebDriver driver) {

        succesfullLogin(driver, "pspspsps", "pspspsps");

            return driver.findElement(By.xpath("//td[@class = 'auto-style1']//blockquote//b")).getText();
    }





}
