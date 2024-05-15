package org.itacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver webDriver) {
        super(webDriver);
    }

    public static final By DASHBOARD_ACTIVITY_LOCATOR = By.xpath("//div[@id='dashboard_activity']");
    public static final By DASHBOARD_AT_A_GLANCE_LOCATOR = By.xpath("//div[@id='dashboard_right_now']");
    public static final By DASHBOARD_QUICK_DRAFT_LOCATOR = By.xpath("//div[@id='dashboard_quick_press']");
    public static final By WORDPRESS_EVENTS_AND_NEWS_LOCATOR = By.xpath("//div[@id='dashboard_primary']");

}
