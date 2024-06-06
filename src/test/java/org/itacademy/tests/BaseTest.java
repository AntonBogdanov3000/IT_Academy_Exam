package org.itacademy.tests;

import org.apache.log4j.Logger;
import org.itacademy.browser.Browser;
import org.itacademy.pages.loginPage.LoginPage;
import org.itacademy.pages.mainMenuPage.MainMenuPage;
import org.itacademy.pages.mediaPages.MediaPage;
import org.itacademy.pages.mediaPages.UploadNewMediaPage;
import org.itacademy.pages.pagesPages.CreatePagePage;
import org.itacademy.pages.pagesPages.PagesPage;
import org.itacademy.pages.postsPages.CreatePostPage;
import org.itacademy.pages.postsPages.PostsPage;
import org.itacademy.utils.JsonUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {

    private Logger logger = Logger.getLogger(BaseTest.class);

    WebDriver webDriver ;
    protected LoginPage loginPage;
    protected MainMenuPage mainMenuPage;
    protected MediaPage mediaPage;
    protected UploadNewMediaPage uploadNewMediaPage;
    protected PostsPage postsPage;
    protected CreatePostPage createPostPage;
    protected PagesPage pagesPage;
    protected CreatePagePage createPagePage;
    protected JsonUtil json;


    @BeforeMethod
    public void startTest(){
        logger.info("Before test method");
        webDriver = Browser.getWebDriver();
        loginPage = new LoginPage(webDriver);
        mainMenuPage = new MainMenuPage(webDriver);
        mediaPage = new MediaPage(webDriver);
        uploadNewMediaPage = new UploadNewMediaPage(webDriver);
        postsPage = new PostsPage(webDriver);
        createPostPage = new CreatePostPage(webDriver);
        pagesPage = new PagesPage(webDriver);
        createPagePage = new CreatePagePage(webDriver);
        json = new JsonUtil();
    }

    @AfterMethod
    public void endTest(){
        logger.info("After test method");
        Browser.close();
    }
}
