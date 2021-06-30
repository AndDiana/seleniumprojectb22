package com.cybertek.PracticeAtHome.Practice_OscarsTasks.AmazonTask;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class AmazonTests {


    @Test
    public void searchValueTest() {
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonUrl"));
        AmazonMainPage.searchItems();
        AmazonAddToCart.addToCard();
        AmazonOpenCart.checkItem();
        AmazonOpenCart.changeQuantity();

        Driver.closeDriver();

    }

}
