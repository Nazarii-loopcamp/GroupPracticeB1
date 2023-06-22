package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    /*
     * create a static method getDriver
     * Accepts argument String - browserType
     * returns webdriver
     */

    //this is java doc and dont forget it after you create browser

    /**
     *
     * @param browserType
     * @return the browser
     */

    public static WebDriver getDriver (String browserType) {
        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ((browserType.equalsIgnoreCase("safari"))){
            WebDriverManager.firefoxdriver().setup();
            return new SafariDriver();
        } else {
            System.out.println("No driver found");
            System.out.println("Driver is null");
            return null;
        }



    }




}
