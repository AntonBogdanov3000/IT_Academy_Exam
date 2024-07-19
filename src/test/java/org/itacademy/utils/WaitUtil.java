package org.itacademy.utils;

import org.itacademy.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class WaitUtil {

    public static void waitForElementVisibility(WebElement element, long seconds){
        WebDriverWait wait = new WebDriverWait(Browser.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementInvisibility(WebElement element, long seconds){
        WebDriverWait wait = new WebDriverWait(Browser.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public static void waitForElementVisibilityByLocator(By locator, long seconds){
        WebDriverWait wait = new WebDriverWait(Browser.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
