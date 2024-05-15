package org.itacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private static final By LOGIN_FIELD_LOCATOR = By.xpath("//input[@id='user_login']");
    private static final By PASSWORD_FIELD_LOCATOR = By.xpath("//input[@id='user_pass']");
    private static final By LOG_IN_BUTTON_LOCATOR = By.xpath("//input[@type='submit'][@value='Log In']");
    private static final By REMEMBER_ME_CHECKBOX_LOCATOR = By.xpath("//input[@type='checkbox']");


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnLogInButton(){
        WebElement logInButton = webDriver.findElement(LOG_IN_BUTTON_LOCATOR);
        logInButton.click();
    }

    public void clickOnCheckbox(){
        WebElement checkBox = webDriver.findElement(REMEMBER_ME_CHECKBOX_LOCATOR);
        checkBox.click();
    }

    public void enterUserData(String login, String password){
        WebElement loginInput = webDriver.findElement(LOGIN_FIELD_LOCATOR);
        WebElement passwordInput = webDriver.findElement(PASSWORD_FIELD_LOCATOR);
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
    }
}
