package org.itacademy.tests;

import org.apache.log4j.Logger;
import org.itacademy.browser.Browser;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MediaUploadTest extends BaseTest {

    private Logger logger = Logger.getLogger(MediaUploadTest.class);

    @Test(priority = 1)
    public void uploadMedia() {
        logger.info("Test upload media is started");
        loginPage.enterUserData(json.getUserModel().getLogin(), json.getUserModel().getPassword());
        loginPage.clickOnLogInButton();
        Assert.assertTrue(mainMenuPage.isOpened());
        mainMenuPage.sideMenu.clickMediaButton();
        Assert.assertTrue(mediaPage.isOpened());
        mediaPage.clickAddNewButton();
        Assert.assertTrue(uploadNewMediaPage.isOpened());
        uploadNewMediaPage.uploadFile();
        Browser.takeScreenshot();
        Assert.assertTrue(mediaPage.isOpened());
        logger.info("Test upload media is ended");
    }

    @Test(priority = 2, expectedExceptions = StaleElementReferenceException.class)
    public void deleteMedia() {
        logger.info("Test delete media is started");
        mediaPage.getCreatedPost();
        mediaPage.deleteCreatedMedia();
        Browser.takeScreenshot();
        Assert.assertTrue(mediaPage.isPostDeleted());
    }
}
