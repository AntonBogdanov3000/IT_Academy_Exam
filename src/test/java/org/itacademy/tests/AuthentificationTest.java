package org.itacademy.tests;

import org.apache.log4j.Logger;
import org.itacademy.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AuthentificationTest extends BaseTest {

    private Logger logger = Logger.getLogger(AuthentificationTest.class);

    @Test
    public void testLogIn(){
        logger.info("Test is started");
        loginPage.enterUserData(json.getUserModel().getLogin(), json.getUserModel().getPassword());
        loginPage.clickOnLogInButton();
        Assert.assertTrue(mainMenuPage.isOpened());
        Browser.takeScreenshot();
        logger.info("Test case is finished");
    }

    @Test
    public void testLogOut(){
        loginPage.enterUserData(json.getUserModel().getLogin(), json.getUserModel().getPassword());
        loginPage.clickOnLogInButton();
        Assert.assertTrue(mainMenuPage.isOpened());
        logger.info("Test case is finished");
        mainMenuPage.header.clickAdminMenu();
        mainMenuPage.header.clickLogout();
        Assert.assertTrue(loginPage.isOpened());
        Browser.takeScreenshot();
    }
}
