package com.romanceabroad.ui;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StorePageTests extends BaseUI {
    String currentUrlStore;

    @Test
    public void testStorePage() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_STORE));
        storePage.clickStoreLink();
        currentUrlStore = driver.getCurrentUrl();
        System.out.println(currentUrlStore);
        Assert.assertEquals(currentUrlStore, Data.expectedUrlStore);

    }
}

