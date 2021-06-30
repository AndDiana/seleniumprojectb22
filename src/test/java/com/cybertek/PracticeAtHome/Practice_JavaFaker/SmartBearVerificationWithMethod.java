package com.cybertek.PracticeAtHome.Practice_JavaFaker;

import com.cybertek.utilities.SmartBearUtils.LogIn_To_SmartBear;
import com.cybertek.utilities.SmartBearUtils.SmartBear_UtilsClass;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearVerificationWithMethod {

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

    @Test
    public void verifyName() {

        SmartBear_UtilsClass.verifyName(driver, "Paul Brown");

    }

    @Test
    public void print() {


        SmartBear_UtilsClass.printNamesAndCities(driver);


    }


}
