package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.pages.TelerikPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test
    public void dragAndDropTest() {

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        TelerikPage telerikPage = new TelerikPage();
        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(2);
        telerikPage.acceptCookiesButton.click();

        actions.dragAndDrop(telerikPage.smallCircle,telerikPage.bigCircle).perform();
        String actualText = telerikPage.bigCircle.getText();
        String expectedText = "You did great!";
        Assert.assertEquals(actualText,expectedText);

        Driver.closeDriver();

/*
        2nd way of doing the same thing: LONGER WAY
        actions.moveToElement(telerikPage.smallCircle).clickAndHold(telerikPage.smallCircle)
                .moveToElement(telerikPage.bigCircle).release().perform();
 */



    }

}
