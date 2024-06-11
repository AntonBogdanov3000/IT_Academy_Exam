package org.itacademy.browser;

import org.apache.log4j.Logger;
import org.itacademy.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserFactory {

    private static Logger logger = Logger.getLogger(BrowserFactory.class);

    public static WebDriver createDriver(BrowserType browserType){
        logger.info("Test try runs on browser : " + browserType);
        WebDriver webDriver = null;
           if (browserType == BrowserType.CHROME_REMOTE) {
               System.setProperty("webdriver.chrome.driver", "/Users/Nastya/tools/chromedriver-mac-x64/chromedriver");
               try {
                   ChromeOptions chromeOptions = new ChromeOptions();
                   webDriver = new RemoteWebDriver(new URL(Configuration.getProperties().getProperty("remoteBrowserUrl")),chromeOptions);
               } catch (MalformedURLException e) {
                   throw new RuntimeException(e);
               }
           }
        logger.debug("Driver " + webDriver);
               return webDriver;
    }
}
