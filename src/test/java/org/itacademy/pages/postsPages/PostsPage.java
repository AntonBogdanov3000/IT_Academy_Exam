package org.itacademy.pages.postsPages;

import org.apache.log4j.Logger;
import org.itacademy.pages.basePage.BasePage;
import org.itacademy.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PostsPage extends BasePage {

    private Logger logger = Logger.getLogger(PostsPage.class);
    private static final By POSTS_PAGE_LOCATOR = By.xpath("//h2[text()='Filter posts list']");
    private static final By ADD_NEW_BUTTON_LOCATOR = By.xpath("//a[@class='page-title-action']");
    private static final By POSTS_ACTION_LIST_LOCATOR = By.xpath("//select[@name='action']");
    private static final By MOVE_TO_TRASH_ACTION_LOCATOR = By.xpath("//select[@name='action']//option[@value='trash']");
    private static final By APPLY_BUTTON_LOCATOR = By.xpath("//input[@id='doaction']");
    public static WebElement post;
    public static String postId;


    public PostsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened() {
        logger.info("Open Posts page");
        WebElement postsPage = webDriver.findElement(POSTS_PAGE_LOCATOR);
        return postsPage.isDisplayed();
    }

    public void clickAddNewButton(){
        WebElement addNewButton = webDriver.findElement(ADD_NEW_BUTTON_LOCATOR);
        addNewButton.click();
    }

    public void getCreatedPost(){
        String pattern = String.format("//tr[@id='%s']", postId);
        logger.debug("Post from Post page: " + postId + " is recently created");
        post = webDriver.findElement(By.xpath(pattern));
    }

    public void selectCheckbox(WebElement webElement){
        String pattern = String.format("//tr[@id='%s']//input", webElement.getAttribute("id"));
        WebElement checkbox = webDriver.findElement(By.xpath(pattern));
        logger.debug("Select checkbox");
        checkbox.click();
        logger.debug("Post from Post page: " + webElement.getAttribute("id") + " is selected");
    }

    public void clickApplyButton(){
        logger.debug("Looking for Apply button");
        WebElement applyButton = webDriver.findElement(APPLY_BUTTON_LOCATOR);
        logger.debug("Clicking for Apply button");
        applyButton.click();
    }

    public boolean isPostDeleted() throws StaleElementReferenceException {
        logger.debug("Check post is deleted");
        return !post.isDisplayed();
    }

    public void deleteCreatedPost() {
        selectCheckbox(post);
        WebElement actions = webDriver.findElement(POSTS_ACTION_LIST_LOCATOR);
        actions.click();
        WebElement deleteAction = webDriver.findElement(MOVE_TO_TRASH_ACTION_LOCATOR);
        WaitUtil.waitForElementVisibility(deleteAction, 5);
        deleteAction.click();
        logger.debug("Delete " + post.getAttribute("id"));
        clickApplyButton();
        WaitUtil.waitForElementInvisibility(post, 5);
    }
}
