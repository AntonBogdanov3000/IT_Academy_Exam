package org.itacademy.tests;

import org.apache.log4j.Logger;
import org.itacademy.browser.Browser;
import org.itacademy.pages.loginPage.LoginPage;
import org.itacademy.pages.mainMenuPage.MainMenuPage;
import org.itacademy.pages.postsPages.CreatePostPage;
import org.itacademy.pages.postsPages.PostsPage;
import org.itacademy.utils.JsonUtil;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PostCreateTest {

    private static final Logger logger = Logger.getLogger(PostCreateTest.class);

    LoginPage loginPage;
    MainMenuPage mainMenuPage;
    PostsPage postsPage;
    CreatePostPage createPostPage;
    JsonUtil json;

    @BeforeClass
    public void driverInit(){
       WebDriver webDriver = Browser.getWebDriver();
       createPostPage = new CreatePostPage(webDriver);
       postsPage = new PostsPage(webDriver);
       loginPage = new LoginPage(webDriver);
       mainMenuPage = new MainMenuPage(webDriver);
       json = new JsonUtil();
    }

    @AfterClass
    public void tearDown(){
        Browser.close();
    }

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
        Browser.takeScreenshot();
        Assert.assertTrue(createPostPage.checkTagIsCreated());
        createPostPage.clickPublishButton();
        Assert.assertTrue(createPostPage.checkPostIsCreated());
        logger.info("Test create post is ended");
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
        logger.info("Test delete post is ended");
    }
}
