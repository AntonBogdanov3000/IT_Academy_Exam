package org.itacademy.pages.basePage.elementsOfPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SideMenu extends PageElement {

    private static final By MEDIA_BUTTON_LOCATOR = By.xpath("//a[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-media']");
    private static final By POSTS_BUTTON_LOCATOR = By.xpath("//a[@class='wp-has-submenu wp-not-current-submenu menu-top menu-icon-post open-if-no-js menu-top-first']");
    private static final By PAGES_BUTTON_LOCATOR = By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-page']");

    public SideMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickMediaButton(){
        WebElement mediaButton = webDriver.findElement(MEDIA_BUTTON_LOCATOR);
        mediaButton.click();
    }

    public void clickPostsButton(){
        WebElement postsButton = webDriver.findElement(POSTS_BUTTON_LOCATOR);
        postsButton.click();
    }

    public void clickPagesButton(){
        WebElement pagesButton = webDriver.findElement(PAGES_BUTTON_LOCATOR);
        pagesButton.click();
    }
}
