package com.cybertek.PracticeAtHome.Practice_OscarsTasks.AmazonTask;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonAddToCart {

    public AmazonAddToCart() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//div[@class='a-section aok-relative s-image-tall-aspect'])//img[1]")
    public WebElement firstItem;

    @FindBy(id = "quantity")
    public WebElement quantityDropdown;

    @FindBy(xpath = "//input[@id = 'add-to-cart-button']")
    public WebElement addToCartButton;

    public static void addToCard() {
        AmazonAddToCart addToCart = new AmazonAddToCart();
        addToCart.firstItem.click();
        Select select = new Select(addToCart.quantityDropdown);
        select.selectByVisibleText("2");
        addToCart.addToCartButton.click();

    }



}
