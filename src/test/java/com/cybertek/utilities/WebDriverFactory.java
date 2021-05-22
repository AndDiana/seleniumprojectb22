package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();

            return new ChromeDriver();

        }else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();

            return new FirefoxDriver();

        }else{
            System.out.println("Given browser type does not exist.  Driver = null");
            return null;
        }

    }





//        public static WebDriver getDriver(String browserType) {
//            if (browserType.equals("chrome")) {
//                WebDriverManager.chromedriver().setup();
//                WebDriver driver = new ChromeDriver();
//                return driver;
//
//            } else if (browserType.equals("firefox")) {
//                WebDriverManager.firefoxdriver().setup();
//                WebDriver driver = new FirefoxDriver();
//                return driver;
//            } else {
//                return null;
//            }
//        }

//    public static WebDriver getDriver(String browserType){
//        WebDriver driver = null;
//        if(browserType.equals("chrome")){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//
//        }else if(browserType.equals("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            driver.manage().window().maximize();
//
//        }
//
//        return driver;
//    }



}

