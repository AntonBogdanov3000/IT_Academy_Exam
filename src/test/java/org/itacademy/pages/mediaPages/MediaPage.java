package org.itacademy.pages.mediaPages;

import org.apache.log4j.Logger;
import org.itacademy.pages.basePage.BasePage;
import org.itacademy.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class MediaPage extends BasePage {

    private Logger logger = Logger.getLogger(MediaPage.class);
    private static final By MEDIA_PAGE_LOCATOR = By.xpath("//h1[text()='Media Library']");
    private static final By MEDIA_PAGE_POSTS_LIST_LOCATOR = By.xpath("//tr[@id]");
    private static final By ADD_NEW_BUTTON_LOCATOR = By.xpath("//a[@class='page-title-action']");
    private static final By MEDIA_POST_ACTION_LIST_LOCATOR = By.xpath("//select[@name='action']");
    private static final By DELETE_ACTION_LOCATOR = By.xpath("//select[@name='action']//option[@value='delete']");
    private static final By APPLY_BUTTON_LOCATOR = By.xpath("//input[@id='doaction']");
    public static WebElement mediaPost;

    public MediaPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened() {
        logger.info("Check Media page is opened");
        WebElement mediaPage = webDriver.findElement(MEDIA_PAGE_LOCATOR);
        return mediaPage.isDisplayed();
    }

    public void clickAddNewButton(){
        logger.debug("Looking for Add button");
        WebElement addButton = webDriver.findElement(ADD_NEW_BUTTON_LOCATOR);
        logger.debug("Clicking on Add button");
        addButton.click();
    }

    public void clickApplyButton(){
        logger.debug("Looking for Apply button");
        WebElement applyButton = webDriver.findElement(APPLY_BUTTON_LOCATOR);
        logger.debug("Clicking for Apply button");
        applyButton.click();
    }

    public void getCreatedPost(){
        List<WebElement> postsList = webDriver.findElements(MEDIA_PAGE_POSTS_LIST_LOCATOR);
        String pattern = String.format("//tr[@id='%s']",postsList.get(0).getAttribute("id"));
        logger.debug("Post: " + postsList.get(0).getAttribute("id") + " is recently created");
        mediaPost = webDriver.findElement(By.xpath(pattern));
    }

    public void selectCheckbox(WebElement webElement){
        String pattern = String.format("//tr[@id='%s']//input", webElement.getAttribute("id"));
        WebElement checkbox = webDriver.findElement(By.xpath(pattern));
        logger.debug("Select checkbox");
        checkbox.click();
        logger.debug("Post: " + webElement.getAttribute("id") + " is selected");
    }

    public boolean isPostDeleted() throws StaleElementReferenceException{
        logger.debug("Check post is deleted");
       return !mediaPost.isDisplayed();
    }

    public void deleteCreatedMedia(){
        selectCheckbox(mediaPost);
        WebElement actions = webDriver.findElement(MEDIA_POST_ACTION_LIST_LOCATOR);
        actions.click();
        WebElement deleteAction = webDriver.findElement(DELETE_ACTION_LOCATOR);
        WaitUtil.waitForElementVisibility(deleteAction, 5);
        deleteAction.click();
        logger.debug("Delete " + mediaPost.getAttribute("id"));
        clickApplyButton();
        webDriver.switchTo().alert().accept();
        WaitUtil.waitForElementInvisibility(mediaPost, 5);
    }
}
