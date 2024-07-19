package org.itacademy.pages.basePage;

import org.itacademy.pages.basePage.elementsOfPages.Header;
import org.itacademy.pages.basePage.elementsOfPages.SideMenu;
import org.openqa.selenium.WebDriver;


public abstract class BasePage {

    protected WebDriver webDriver;
    public Header header;
    public SideMenu sideMenu;
    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.sideMenu = new SideMenu(webDriver);
        this.header = new Header(webDriver);
    }
    public abstract boolean isOpened();
}
