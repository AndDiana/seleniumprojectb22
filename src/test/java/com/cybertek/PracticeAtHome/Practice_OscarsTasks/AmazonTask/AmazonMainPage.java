package com.cybertek.PracticeAtHome.Practice_OscarsTasks.AmazonTask;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AmazonMainPage {

    public AmazonMainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "2zzr7w-d53ee7-e1eor7-6ofy0k")
    public WebElement newReleasesTab;

    @FindBy(id = "2zzr7w-d53ee7-e1eor7-6ofy0k")
    public WebElement booksTab;

    @FindBy(id = "31vf7l-uf2kua-2dd61r-km0dr4")
    public WebElement pharmacyTab;

    @FindBy(id = "m3navr-gnkzw1-e50bjx-jn70xb")
    public WebElement fashionTabs;

    @FindBy(id = "akccdd-fgz7uc-5yt8ug-4e69wk")
    public WebElement giftCard;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement submitButton;

    List<WebElement> displayedTabs;

    public static void searchItems() {
        AmazonMainPage searchItem = new AmazonMainPage();
        String searchValue = ConfigurationReader.getProperty("searchValueAmazon");
        searchItem.searchBox.sendKeys(searchValue);
        searchItem.submitButton.click();
    }

    public void printTabs() {

        displayedTabs = new ArrayList<>();
        displayedTabs.add(newReleasesTab);
        displayedTabs.add(booksTab);
        displayedTabs.add(pharmacyTab);
        displayedTabs.add(fashionTabs);
        displayedTabs.add(giftCard);

        for (WebElement displayedTab : displayedTabs) {
            System.out.println(displayedTab.getText());
        }

    }
}
