package org.itacademy.pages.loginPage;

import org.apache.log4j.Logger;
import org.itacademy.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    private Logger logger = Logger.getLogger(LoginPage.class);

    private static final By LOGIN_FIELD_LOCATOR = By.xpath("//input[@id='user_login']");
    private static final By PASSWORD_FIELD_LOCATOR = By.xpath("//input[@id='user_pass']");
    private static final By LOG_IN_BUTTON_LOCATOR = By.xpath("//input[@type='submit'][@value='Log In']");
    private static final By REMEMBER_ME_CHECKBOX_LOCATOR = By.xpath("//input[@type='checkbox']");


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened() {
        WebElement logInButton = webDriver.findElement(LOG_IN_BUTTON_LOCATOR);
        return logInButton.isDisplayed();
    }

    public void clickOnLogInButton(){
        logger.debug("Looking for Log in button");
        WebElement logInButton = webDriver.findElement(LOG_IN_BUTTON_LOCATOR);
        logger.debug("Clicking on Log in button");
        logInButton.click();
    }

    public void clickOnCheckbox(){
        WebElement checkBox = webDriver.findElement(REMEMBER_ME_CHECKBOX_LOCATOR);
        checkBox.click();
    }

    public void enterUserData(String login, String password){
        logger.debug("looking for Login input field");
        WebElement loginInput = webDriver.findElement(LOGIN_FIELD_LOCATOR);
        logger.debug("looking for Password input field");;
        WebElement passwordInput = webDriver.findElement(PASSWORD_FIELD_LOCATOR);
        logger.debug("Entering login and password");
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
    }
}
