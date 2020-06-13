package com.romanceabroad.ui;

import org.testng.annotations.Test;

public class BookTourTests extends BaseUI {

    String currentUrlBookNow;

    @Test
    public void testBookNowButton() {
        bookTourPage.clickBookNow();
        currentUrlBookNow = driver.getCurrentUrl();
        System.out.println(currentUrlBookNow);
        //Assert.assertEquals(currentUrlBookNow, Data.expectedUrlBookNow);

    }

}


