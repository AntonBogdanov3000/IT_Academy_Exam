package org.itacademy.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BrowserFactory {

    private static Logger logger = Logger.getLogger(BrowserFactory.class);

    public static WebDriver createDriver(BrowserType browserType){
        logger.info("Test try runs on browser : " + browserType);
           if (browserType == BrowserType.CHROME) {
               WebDriverManager.chromedriver().setup();
               return new ChromeDriver();
           }else
               return null;

        //logger.debug("Driver " + driver);
    }
}
