package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MediaPage extends BaseActions {
    public MediaPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickMediaPageLink() {
        driver.findElement(Locators.LINK_MEDIA).click();

    }
}
