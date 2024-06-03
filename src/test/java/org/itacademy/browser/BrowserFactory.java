package org.itacademy.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserFactory {

    private static Logger logger = Logger.getLogger(BrowserFactory.class);

    public static WebDriver createDriver(BrowserType browserType){
        logger.info("Test runs on browser : " + browserType);
        WebDriver driver = null;
        switch (browserType){
            case CHROME :
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
