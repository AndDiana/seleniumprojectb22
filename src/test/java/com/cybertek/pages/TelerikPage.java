package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelerikPage {

    /*
     WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
     */

    /*
        public WebElement inputEmail;
     */

    public TelerikPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "draggable")
    public WebElement smallCircle;

    @FindBy(id = "droptarget")
    public WebElement bigCircle;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookiesButton;









}
