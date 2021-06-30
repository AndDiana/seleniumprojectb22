package com.cybertek.PracticeAtHome.Practice_Actions;
/*
TC #14: UploadTest1.Go tohttp://practice.cybertekschool.com/upload
2.Find some small file from your computer, and get the path of it.
3.Upload the file.
4.Assert: -Fileuploaded text is displayed on the page
 */

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile {

    @Test
    public void testUpload() {

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        String filePath = "/Users/andreeadruga/Downloads/B22 interview questions (3)";
        WebElement chooseFileButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));

        chooseFileButton.sendKeys(filePath);
        BrowserUtils.sleep(2);
        uploadButton.click();
        BrowserUtils.sleep(2);

        WebElement uploadMessage = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(uploadMessage.isDisplayed());

        Driver.closeDriver();


    }


}
