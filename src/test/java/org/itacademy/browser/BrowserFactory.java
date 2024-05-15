package org.itacademy.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    public static WebDriver createDriver(BrowserType browserType){
        WebDriver driver = null;
        switch (browserType){
            case CHROME : driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
