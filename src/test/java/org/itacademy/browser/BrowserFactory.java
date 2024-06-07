package org.itacademy.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserFactory {

    private static Logger logger = Logger.getLogger(BrowserFactory.class);

    public static WebDriver createDriver(BrowserType browserType){
        logger.info("Test try runs on browser : " + browserType);
        WebDriver driver = null;

        if(browserType == BrowserType.CHROME){
            //WebDriverManager.chromedriver().setup();
                WebDriverManager.chromedriver().remoteAddress("172.17.0.2");
                driver = new ChromeDriver();
        }
        logger.debug("Driver " + driver);
        return driver;
    }
}
