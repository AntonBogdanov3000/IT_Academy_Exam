package org.itacademy.pages.elements;

import org.openqa.selenium.WebDriver;


public abstract class PageElement {
      private WebDriver driver;

    public PageElement(WebDriver driver) {
        this.driver = driver;
    }
}
