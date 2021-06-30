package com.cybertek.tests.day14_pom_synchronization;

/*
1. Go to http://practice.cybertekschool.com/dynamic_loading/7
2. Wait until title is “Dynamic title”
3. Assert : Message “Done” is displayed.
4. Assert : Image is displayed.
 */

import com.cybertek.pages.DynamicLoad7Page;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractice {

    @Test
    public void dynamic_loading_7_test() {

//        1. Go to http://practice.cybertekschool.com/dynamic_loading/7

        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

//        2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //use the object to wait for the explicit condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        wait.until(ExpectedConditions.visibilityOf(dynamicLoad7Page.spongeBobImage));

//        3. Assert : Message “Done” is displayed.

        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

//        4. Assert : Image is displayed.
        Assert.assertTrue(dynamicLoad7Page.spongeBobImage.isDisplayed());


    }

    @Test
    public void dynamic_loading_1_test() {

        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        dynamicLoad7Page.startButton.click();


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad7Page.loadingBar));

        Assert.assertTrue(dynamicLoad7Page.usernameField.isDisplayed());

        dynamicLoad7Page.usernameField.sendKeys("tomsmith");
        dynamicLoad7Page.passwordField.sendKeys("incorrectpassword");
        dynamicLoad7Page.submitButton.click();

        Assert.assertTrue(dynamicLoad7Page.invalidPassword.isDisplayed());


        Driver.closeDriver();




    }


}
