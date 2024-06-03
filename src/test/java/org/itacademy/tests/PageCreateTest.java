package org.itacademy.tests;

import org.itacademy.browser.Browser;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PageCreateTest extends BaseTest{

    @Test
    public void testCreatePage(){
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
    }

    @Test(expectedExceptions = StaleElementReferenceException.class)
    public void testDeletePage(){
        createPagePage.clickViewPostButton();
        Assert.assertTrue(pagesPage.isOpened());
        pagesPage.getCreatedPost();
        Browser.takeScreenshot();
        pagesPage.deleteCreatedPost();
        Browser.takeScreenshot();
        Assert.assertTrue(pagesPage.isPageDeleted());
    }
}
