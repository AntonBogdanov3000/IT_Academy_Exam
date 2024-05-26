package org.itacademy.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AuthentificationTest extends Basetest {

    private Logger logger = Logger.getLogger(AuthentificationTest.class);

    @Test
    public void testStart(){
        logger.info("Test is started");
        loginPage.enterUserData(json.getUserModel().getLogin(), json.getUserModel().getPassword());
        loginPage.clickOnLogInButton();
        Assert.assertTrue(mainMenuPage.isOpened());
        logger.info("Test case is finished");
    }
}
