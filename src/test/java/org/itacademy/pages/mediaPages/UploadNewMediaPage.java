package org.itacademy.pages.mediaPages;

import org.apache.log4j.Logger;
import org.itacademy.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UploadNewMediaPage extends BasePage {


    private Logger logger = Logger.getLogger(UploadNewMediaPage.class);
    private static final By UPLOAD_NEW_MEDIA_PAGE_LOCATOR = By.xpath("//h1[text()='Upload New Media']");
    private static final By SELECT_FILE_INPUT_LOCATOR = By.xpath("//input[@type='file'][@name='async-upload']");
    private static final By UPLOAD_BUTTON_LOCATOR = By.xpath("//input[@class='button button-primary']");

    public UploadNewMediaPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public boolean isOpened() {
        WebElement uploadNewMediaPage = webDriver.findElement(UPLOAD_NEW_MEDIA_PAGE_LOCATOR);
        return uploadNewMediaPage.isDisplayed();
    }

    public void uploadFile(){
        WebElement fileInput = webDriver.findElement(SELECT_FILE_INPUT_LOCATOR);
        fileInput.sendKeys("/Users/Nastya/new/IT_Academy_Exam/IT_Academy_Exam/src/test/resources/images/bmw.jpeg");
        clickUploadButton();
    }

    public void clickUploadButton(){
        WebElement uploadButton = webDriver.findElement(UPLOAD_BUTTON_LOCATOR);
        uploadButton.click();
    }
}
