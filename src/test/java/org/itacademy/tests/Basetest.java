package org.itacademy.tests;

import org.itacademy.browser.Browser;
import org.itacademy.pages.LoginPage;
import org.itacademy.utils.jsonUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Basetest {
    protected WebDriver webDriver;
    protected LoginPage loginPage;
    protected jsonUtil json;

    @BeforeTest
    public void startTest(){
        webDriver = Browser.getWebDriver();
        loginPage = new LoginPage(webDriver);
        json = new jsonUtil();
    }

    @AfterTest
    public void endTest(){
        Browser.close();
    }
}
