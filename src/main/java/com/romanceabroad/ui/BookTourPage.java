package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookTourPage extends BaseActions {
    public BookTourPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void clickBookNow() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_BOOK_NOW));
        driver.findElement(Locators.LINK_BOOK_NOW).click();

    }
}