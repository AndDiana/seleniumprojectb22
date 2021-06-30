package com.cybertek.PracticeAtHome.Practice_Actions;

/*
TC #17: Context Click –HOMEWORK
1.Go to https://the-internet.herokuapp.com/context_menu
2.Right click to the box.
3.Alert will open.
4.Accept alertNo assertion needed for this practice.
 */

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextClick {

    @Test
    public void contextClickTest(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        WebElement clickBox = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(clickBox).perform();
        BrowserUtils.sleep(3);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        Driver.closeDriver();

    }

}
