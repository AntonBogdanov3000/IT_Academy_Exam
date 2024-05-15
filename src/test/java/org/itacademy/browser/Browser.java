package org.itacademy.browser;

import org.itacademy.utils.Configuration;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


public class Browser {

        private static int DEFAULT_WAIT_IN_SECONDS = 20;
        private static WebDriver webDriver;

        private Browser(){}

        public static WebDriver getWebDriver(){
            if(webDriver == null) {
                init();
            }
            return webDriver;
        }

        public static void init(){
            webDriver = BrowserFactory.createDriver(BrowserType.valueOf(Configuration.getProperties().getProperty("browser")));
            System.setProperty("webdriver.chrome.driver","/Users/Nastya/tools/chromedriver-mac-x64");
            webDriver.get("https://wordpress-test-app-for-selenium.azurewebsites.net/wp-admin");
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_WAIT_IN_SECONDS));
            webDriver.manage().window().maximize();
        }

        public static void close(){
            if (webDriver != null){
                webDriver.quit();
                webDriver = null;
            }
        }

}
