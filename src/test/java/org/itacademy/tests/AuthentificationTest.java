package org.itacademy.tests;

import org.testng.annotations.Test;


public class AuthentificationTest extends Basetest {

    @Test
    public void testStart(){
        loginPage.enterUserData(json.getUserModel().getLogin(), json.getUserModel().getPassword());
        loginPage.clickOnLogInButton();
    }
}
