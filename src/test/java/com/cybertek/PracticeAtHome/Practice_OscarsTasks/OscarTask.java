package com.cybertek.PracticeAtHome.Practice_OscarsTasks;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.DemoSiteUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OscarTask {

    WebDriver driver;

    @BeforeClass
    public void setupMethod(){

        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("demoSite");
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);


    }


    @Test (priority = 0)
    public void checkTitle() {

        Assert.assertEquals(DemoSiteUtils.tabTitle(driver), DemoSiteUtils.expectedTitle);

    }

    @Test (priority = 1)
    public void checkHeader4() {
        Assert.assertEquals(DemoSiteUtils.getHeaderText(driver), DemoSiteUtils.expectedHeader);
    }

    @Test (priority = 2)
    public void checkStatusMessage() {
        Assert.assertEquals(DemoSiteUtils.getStatusMessage(driver), DemoSiteUtils.expectedStatusMessage);
    }

    @Test (priority = 3)
    public void checkInfoMessage() {
        Assert.assertEquals(DemoSiteUtils.getInfoMessage(driver), DemoSiteUtils.expectedInfoMessage);
    }

    @Test (priority = 4)
    public void checkLoginFields() {
        Assert.assertTrue(DemoSiteUtils.getUsernameField(driver).isDisplayed());
        Assert.assertTrue(DemoSiteUtils.getPasswordField(driver).isDisplayed());
        Assert.assertTrue(DemoSiteUtils.getLoginButton(driver).isDisplayed());
    }

    @Test (priority = 5)
    public void testSuccessLogin() {
        Assert.assertEquals(DemoSiteUtils.getSuccessLoginMessage(driver), DemoSiteUtils.expectedSuccesLoginMessage);
    }

    @Test (priority = 6)
    public void testFailedLogin() {
        Assert.assertEquals(DemoSiteUtils.getFailedLoginMessage(driver), DemoSiteUtils.expectedFailedLoginMessage);

    }




}
