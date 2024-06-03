package org.itacademy.pages.pagesPages;

import org.apache.log4j.Logger;
import org.itacademy.pages.basePage.BasePage;
import org.itacademy.utils.StringUtil;
import org.itacademy.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreatePagePage extends BasePage {

    private Logger logger = Logger.getLogger(CreatePagePage.class);
    private static final By CREATE_PAGE_PAGE_LOCATOR = By.xpath("//div[@class='edit-post-header']");
    private static final By PUBLISH_BUTTON = By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']");
    private static final By VIEW_POSTS_BUTTON = By.xpath("//a[@class='components-button edit-post-fullscreen-mode-close']");


    public CreatePagePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened() {
        WebElement createPagePage = webDriver.findElement(CREATE_PAGE_PAGE_LOCATOR);
        return createPagePage.isDisplayed();
    }

    public void enterTitle(){
        webDriver.switchTo().defaultContent();
        WebElement iframe = webDriver.findElement(By.tagName("iframe"));
        webDriver.switchTo().frame(iframe);
        WebElement element1 = webDriver.findElement(By.className("edit-post-visual-editor__post-title-wrapper"));
        element1.click();
        WebElement element2 = element1.findElement(By.xpath(".//h1[@contenteditable='true']"));
        element2.clear();
        element2.sendKeys("Test-Create page");
        webDriver.switchTo().defaultContent();
    }

    public void clickPublishButton(){
        logger.info("Click Publish button");
        WebElement publishButton = webDriver.findElement(PUBLISH_BUTTON);
        publishButton.click();
    }

    public boolean checkPageIsCreated(){
        logger.info("Check page is created");
        boolean result = false;
        By locator = By.xpath("//div[@class='components-snackbar__content']");
        WaitUtil.waitForElementVisibilityByLocator(locator, 10);
        WebElement element = webDriver.findElement(locator);
        if(element.isDisplayed()){
            result = true;
        }
        PagesPage.postId = StringUtil.getCreatedPostId(webDriver.getCurrentUrl());
        logger.info("Page " + PagesPage.postId + " is created");
        return result;
    }

    public void clickViewPostButton(){
        WebElement viewPostsButton = webDriver.findElement(VIEW_POSTS_BUTTON);
        logger.info("Click View posts");
        viewPostsButton.click();
    }


}
