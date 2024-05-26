package org.itacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class PostsPage extends BasePage{

    private static final By POSTS_PAGE_POSTS_LIST = By.xpath("//tr[contains(@id, 'post')]");

    private List<WebElement> postsPostsList = webDriver.findElements(POSTS_PAGE_POSTS_LIST);

    public PostsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened() {
        return false;
    }
}
