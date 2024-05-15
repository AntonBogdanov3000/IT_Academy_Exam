package org.itacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class MediaPage extends BasePage{

    private static final By MEDIA_PAGE_POSTS_LIST = By.xpath("//tr[contains(@id, 'post')]");

    private List<WebElement> mediaPostsList = webDriver.findElements(MEDIA_PAGE_POSTS_LIST);

    public MediaPage(WebDriver webDriver) {
        super(webDriver);
    }
}
