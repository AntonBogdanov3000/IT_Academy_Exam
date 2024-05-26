package org.itacademy.tests;

import org.itacademy.browser.Browser;
import org.itacademy.pages.LoginPage;
import org.itacademy.pages.MainMenuPage;
import org.itacademy.utils.JsonUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Basetest {
    protected WebDriver webDriver;
    protected LoginPage loginPage;
    protected MainMenuPage mainMenuPage;
    protected JsonUtil json;

    @BeforeTest
    public void startTest(){
        webDriver = Browser.getWebDriver();
        loginPage = new LoginPage(webDriver);
        mainMenuPage = new MainMenuPage(webDriver);
        json = new JsonUtil();
    }

    @AfterTest
    public void endTest(){
        Browser.close();
    }
}
