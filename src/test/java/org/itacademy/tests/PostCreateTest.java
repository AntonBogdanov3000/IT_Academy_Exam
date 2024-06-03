package org.itacademy.tests;

import org.apache.log4j.Logger;
import org.itacademy.browser.Browser;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PostCreateTest extends BaseTest {

    private static final Logger logger = Logger.getLogger(PostCreateTest.class);

    @Test
    public void testCreatePost(){
        logger.info("Test create post is started");
        loginPage.enterUserData(json.getUserModel().getLogin(), json.getUserModel().getPassword());
        loginPage.clickOnLogInButton();
        Assert.assertTrue(mainMenuPage.isOpened());
        mainMenuPage.sideMenu.clickPostsButton();
        Assert.assertTrue(postsPage.isOpened());
        postsPage.clickAddNewButton();
        Assert.assertTrue(createPostPage.isOpened());
        createPostPage.enterTitle();
        createPostPage.createTag();
        Assert.assertTrue(createPostPage.checkTagIsCreated());
        createPostPage.clickPublishButton();
        Assert.assertTrue(createPostPage.checkPostIsCreated());
    }

    @Test(expectedExceptions = StaleElementReferenceException.class)
    public void testDeletePost(){
        logger.info("Test delete post is started");
        createPostPage.clickViewPostButton();
        Assert.assertTrue(postsPage.isOpened());
        postsPage.getCreatedPost();
        Browser.takeScreenshot();
        postsPage.deleteCreatedPost();
        Assert.assertTrue(postsPage.isPostDeleted());
        Browser.takeScreenshot();
    }
}
