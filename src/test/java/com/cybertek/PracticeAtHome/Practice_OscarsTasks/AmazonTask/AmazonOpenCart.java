package com.cybertek.PracticeAtHome.Practice_OscarsTasks.AmazonTask;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AmazonOpenCart {

    public AmazonOpenCart() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id = 'nav-cart-count']")
    public WebElement viewCart;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    public WebElement getPrice;

    @FindBy(xpath = "//span[@class = 'a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    public WebElement getTotalPrice;

    @FindBy(xpath = "//span[@class = 'a-dropdown-prompt']")
    public WebElement getQuantity;

    @FindBy(xpath = "//select[@name='quantity']")
    public WebElement quantityDropDown2;


    public static void checkItem() {
        AmazonOpenCart checkCart = new AmazonOpenCart();
        checkCart.viewCart.click();

        Double expectedPrice = Double.parseDouble(checkCart.getPrice.getText().substring(1))*
                (Double.parseDouble(checkCart.getQuantity.getText()));
        Double actualPrice = Double.parseDouble(checkCart.getTotalPrice.getText().substring(1));
        Assert.assertEquals(expectedPrice,actualPrice);

        String expectedQuantity = "2";
        String actualQuantity = checkCart.getQuantity.getText();
        Assert.assertEquals(expectedQuantity,actualQuantity);

    }

    public static void changeQuantity() {
        AmazonOpenCart checkCart = new AmazonOpenCart();
        Select dropdown2 = new Select(checkCart.quantityDropDown2);
        dropdown2.selectByVisibleText("1");

        Double expectedPrice = Double.parseDouble(checkCart.getPrice.getText().substring(1))*
                (Double.parseDouble(checkCart.getQuantity.getText()));
        Double actualPrice = Double.parseDouble(checkCart.getPrice.getText().substring(1));
        Assert.assertEquals(expectedPrice,actualPrice);

        String expectedQuantity = "1";
        String actualQuantity = checkCart.getQuantity.getText();
        Assert.assertEquals(expectedQuantity,actualQuantity);


    }

}
