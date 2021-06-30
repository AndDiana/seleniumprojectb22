package com.cybertek.PracticeAtHome.Practice_Actions;

//1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
// 2.Drag and drop the small circle to bigger circle.
// 3.Assert: -Text in big circle changed to: “You did great!”

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {

    @Test
    public void dragAndDropTest() {
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(smallCircle,bigCircle).release().perform();
        BrowserUtils.sleep(4);

        String actualText = bigCircle.getText();
        String expectedText = "You did great!";
        Assert.assertEquals(actualText,expectedText);

        Driver.closeDriver();


    }
}
