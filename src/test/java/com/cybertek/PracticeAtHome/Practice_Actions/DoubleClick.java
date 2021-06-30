package com.cybertek.PracticeAtHome.Practice_Actions;

/*
TC #16: Double ClickTest1.Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2.Switch to iframe.
3.Double click on the text “Double-click me to change my text color.
”4.Assert: Text’s “style” attribute value contains “red”.
 */

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick {

    @Test
    public void doubleClickTest(){

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement text = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));

        Actions actions  = new Actions(Driver.getDriver());
        actions.doubleClick(text).perform();
        BrowserUtils.sleep(2);

        String actualTextColor = text.getAttribute("style");
        String expectedTextColor = "red";
        Assert.assertTrue(actualTextColor.contains(expectedTextColor));

        Driver.closeDriver();


    }

}
