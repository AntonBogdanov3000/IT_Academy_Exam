package org.itacademy.tests;

import org.apache.log4j.Logger;
import org.itacademy.browser.Browser;
import org.itacademy.pages.loginPage.LoginPage;
import org.itacademy.pages.mainMenuPage.MainMenuPage;
import org.itacademy.pages.pagesPages.CreatePagePage;
import org.itacademy.pages.pagesPages.PagesPage;
import org.itacademy.utils.JsonUtil;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PageCreateTest {

    private Logger logger = Logger.getLogger(MediaUploadTest.class);

    LoginPage loginPage;
    MainMenuPage mainMenuPage;
    PagesPage pagesPage;
    CreatePagePage createPagePage;
    JsonUtil json;
    @BeforeClass
    public void driverInit(){
        WebDriver webDriver = Browser.getWebDriver();
        createPagePage = new CreatePagePage(webDriver);
        pagesPage = new PagesPage(webDriver);
        loginPage = new LoginPage(webDriver);
        mainMenuPage = new MainMenuPage(webDriver);
        json = new JsonUtil();
    }

    @AfterClass
    public void tearDown(){
        Browser.close();
    }

    @Test
    public void testCreatePage(){
        logger.info("Test create page is started");
        loginPage.enterUserData(json.getUserModel().getLogin(), json.getUserModel().getPassword());
        loginPage.clickOnLogInButton();
        mainMenuPage.sideMenu.clickPagesButton();
        Assert.assertTrue(pagesPage.isOpened());
        pagesPage.clickAddNewButton();
        Assert.assertTrue(createPagePage.isOpened());
        createPagePage.enterTitle();
        createPagePage.clickPublishButton();
        Browser.takeScreenshot();
        Assert.assertTrue(createPagePage.checkPageIsCreated());
        logger.info("Test create page is ended");
    }


    @Test(expectedExceptions = StaleElementReferenceException.class)
    public void testDeletePage(){
        logger.info("Test delete created page is started");
        createPagePage.clickViewPostButton();
        Assert.assertTrue(pagesPage.isOpened());
        pagesPage.getCreatedPost();
        Browser.takeScreenshot();
        pagesPage.deleteCreatedPost();
        Browser.takeScreenshot();
        Assert.assertTrue(pagesPage.isPageDeleted());
        logger.info("Test delete created page is ended");
    }
}
