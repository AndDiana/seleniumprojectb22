package com.cybertek.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_GoogleSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1- Open	a	chrome	browser
        //2- Go	to:	https://google.com
        //3- Write	“apple”	in	search	box
        //4- Click	google	search	button
        //5- Verify	title:
        //Expected:	Title	should	start	with	“apple”	word

        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

        String expectedInTitle = "apple";
        String actualtitle = driver.getTitle();

        if(actualtitle.startsWith(expectedInTitle)){
            System.out.println("Title as expected. Test passed!");
        }else{
            System.out.println("Title not as expected. Test failed");
        }


     driver.quit();


    }
}
