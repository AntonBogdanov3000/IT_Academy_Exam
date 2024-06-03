package org.itacademy.pages.basePage.elementsOfPages;

import org.openqa.selenium.WebDriver;


public abstract class PageElement {

    protected WebDriver webDriver;

    public PageElement(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
