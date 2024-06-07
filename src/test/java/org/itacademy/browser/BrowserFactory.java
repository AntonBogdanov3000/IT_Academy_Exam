package org.itacademy.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

    private static Logger logger = Logger.getLogger(BrowserFactory.class);

    public static WebDriver createDriver(BrowserType browserType){
        logger.info("Test try runs on browser : " + browserType);
        WebDriver driver = null;

        if(browserType == BrowserType.CHROME){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        logger.debug("Driver " + driver);
        return driver;
    }
}
