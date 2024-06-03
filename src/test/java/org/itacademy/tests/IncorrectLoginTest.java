package org.itacademy.tests;

import org.apache.log4j.Logger;
import org.itacademy.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;


public class IncorrectLoginTest extends BaseTest{

    private Logger logger = Logger.getLogger(IncorrectLoginTest.class);

    @Test
    public void testIncorrectLogIn(){
        logger.info("Test incorrect login is started");
        loginPage.enterUserData(json.getIncorrectUserModel().getLogin(), json.getIncorrectUserModel().getPassword());
        loginPage.clickOnLogInButton();
        Assert.assertTrue(loginPage.isOpened());
        Browser.takeScreenshot();
        logger.info("Test case is finished");
    }
}
