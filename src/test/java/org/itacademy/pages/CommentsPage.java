package org.itacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class CommentsPage extends BasePage{

    private static final By COMMENTS_PAGE_COMMENTS_LIST = By.xpath("//tr[contains(@id, 'comment')]");

    private List<WebElement> commentsCommentsList = webDriver.findElements(COMMENTS_PAGE_COMMENTS_LIST);

    public CommentsPage(WebDriver webDriver) {
        super(webDriver);
    }
}
