package org.itacademy.browser;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.itacademy.utils.Configuration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class Browser {

        private static Logger logger = Logger.getLogger(Browser.class);
        private static int DEFAULT_WAIT_IN_SECONDS = 10;
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
            logger.info("Browser is started");
        }

        public static void close(){
            if (webDriver != null){
                webDriver.quit();
                webDriver = null;
            }
            logger.info("Browser is closed");
        }

        @Attachment
        public static byte[] takeScreenshot(){
            File screenShot = new File(Configuration.getScreenShotFolder());

            if(!screenShot.exists()){
                screenShot.mkdirs();
            }

            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss");
            String dateFormat = simpleDateFormat.format(date);
            String fileName = dateFormat + " screenshot.png";
            byte[] bytes = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.BYTES);
            try {
                Files.write(new File(Configuration.getScreenShotFolder() + fileName).toPath(), bytes, StandardOpenOption.CREATE);
            }catch (IOException e){}
            return bytes;
        }
}
