package org.itacademy.pages.postsPages;

import org.apache.log4j.Logger;
import org.itacademy.pages.basePage.BasePage;
import org.itacademy.utils.ScrollUtil;
import org.itacademy.utils.StringUtil;
import org.itacademy.utils.WaitUtil;
import org.openqa.selenium.*;


public class CreatePostPage extends BasePage {

    private Logger logger = Logger.getLogger(CreatePostPage.class);
    private static final By CREATE_POST_PAGE_LOCATOR = By.xpath("//div[@class='edit-post-header']");
    private static final By ADD_TAG_INPUT_FIELD_LOCATOR = By.xpath("//div[@class='components-form-token-field__input-container']");
    private static final By SIDE_PANEL_LOCATOR = By.xpath("//div[@class='components-panel']");
    private static final By PUBLISH_BUTTON = By.xpath("//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']");
    private static final By VIEW_POSTS_BUTTON = By.xpath("//a[@aria-label='View Posts']");

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened() {
        WebElement createPostPage = webDriver.findElement(CREATE_POST_PAGE_LOCATOR);
        return createPostPage.isDisplayed();
    }

    public void enterTitle(){
        webDriver.switchTo().defaultContent();
        WebElement iframe = webDriver.findElement(By.tagName("iframe"));
        webDriver.switchTo().frame(iframe);
        WebElement element1 = webDriver.findElement(By.className("edit-post-visual-editor__post-title-wrapper"));
        element1.click();
        WebElement element2 = element1.findElement(By.xpath(".//h1[@contenteditable='true']"));
        element2.clear();
        element2.sendKeys("Test-Create post");
        webDriver.switchTo().defaultContent();
    }

    public void createTag(){
        logger.info("Creating a tag");
        WaitUtil.waitForElementVisibilityByLocator(ADD_TAG_INPUT_FIELD_LOCATOR,5);
        WebElement addTagInput = webDriver.findElement(ADD_TAG_INPUT_FIELD_LOCATOR);
        WebElement sidePanel = webDriver.findElement(SIDE_PANEL_LOCATOR);
        sidePanel.click();
        ScrollUtil.scrollToElement(addTagInput, webDriver);
        addTagInput.click();
        WebElement element = webDriver.findElement(By.xpath("//input[@class='components-form-token-field__input']"));
        element.sendKeys("helloTag");
        element.sendKeys(Keys.RETURN);
    }

    public void clickPublishButton(){
        logger.info("Click Publish");
        WebElement publishButton = webDriver.findElement(PUBLISH_BUTTON);
        publishButton.click();
    }

    public boolean checkTagIsCreated(){
        By removeTag = By.xpath("//span[@class='components-form-token-field__token']");
        WaitUtil.waitForElementVisibilityByLocator(removeTag, 5);
        WebElement tag = webDriver.findElement(removeTag);
        return tag.isDisplayed();
    }

    public boolean checkPostIsCreated(){
        logger.info("Check post is created");
        boolean result = false;
        By locator = By.xpath("//div[@class='components-snackbar__content']");
        WaitUtil.waitForElementVisibilityByLocator(locator, 10);
        WebElement element = webDriver.findElement(locator);
        if(element.isDisplayed()){
            result = true;
        }
        PostsPage.postId = StringUtil.getCreatedPostId(webDriver.getCurrentUrl());
        logger.info("Post " + PostsPage.postId + " is created");
        return result;
    }

    public void clickViewPostButton(){
        WebElement viewPostsButton = webDriver.findElement(VIEW_POSTS_BUTTON);
        logger.info("Click View posts");
        viewPostsButton.click();
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
    }
}
