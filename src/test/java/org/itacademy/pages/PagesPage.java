package org.itacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class PagesPage extends BasePage{

    private static final By PAGES_PAGE_POSTS_LIST = By.xpath("//tr[contains(@id, 'post')]");

    private List<WebElement> pagesPostsList = webDriver.findElements(PAGES_PAGE_POSTS_LIST);

    public PagesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened() {
        return false;
    }
}
