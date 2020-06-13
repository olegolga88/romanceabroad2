package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePage extends BaseActions {
        public StorePage(WebDriver driver, WebDriverWait wait) {
            super(driver, wait);
        }

    public void clickStoreLink(){
        driver.findElement(Locators.LINK_STORE).click();


}
}

