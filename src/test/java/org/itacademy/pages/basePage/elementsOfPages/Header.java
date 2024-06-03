package org.itacademy.pages.basePage.elementsOfPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Header extends PageElement{

    private static final By USER_MENU_LOCATOR = By.xpath("//a[@class='ab-item'][text()='Howdy, ']");
    private static final By LOGOUT_BUTTON = By.xpath("//div[@class='ab-sub-wrapper']//li[@id='wp-admin-bar-logout']/*");

    public Header(WebDriver driver) {
        super(driver);
    }

    public void clickAdminMenu(){
        WebElement userMenu = webDriver.findElement(USER_MENU_LOCATOR);
        new Actions(webDriver).moveToElement(userMenu).perform();
    }

    public void clickLogout(){
        WebElement logoutButton = webDriver.findElement(LOGOUT_BUTTON);
        logoutButton.click();
    }
}
