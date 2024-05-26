package org.itacademy.pages;

import org.itacademy.pages.elements.Header;
import org.itacademy.pages.elements.SideMenu;
import org.openqa.selenium.WebDriver;


public abstract class BasePage {

    protected WebDriver webDriver;
    protected Header header;
    protected SideMenu sideMenu;
    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public abstract boolean isOpened();
}
