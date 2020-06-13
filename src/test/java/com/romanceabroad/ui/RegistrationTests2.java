package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests2 extends BaseUI {


    @Test(dataProvider = "Registration2", dataProviderClass = DataProviders.class)
    public void testRegistration2(String email, String nickname, boolean requirement) {
        System.out.println(email);

        mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, Data.password);
        if (!requirement) {
            Reports.log("Error massage is not displayed");
            Assert.assertTrue(driver.findElement(Locators.TOOLTIP_ERROR_MESSAGE_EMAIL).isDisplayed());
        } else {
            mainPage.clickNextButton();
            mainPage.completeSecondPartOfRegistration(nickname, Data.day,
                    Data.month, Data.year, Data.phone, Data.city, Data.location);
            mainPage.clickUnselectedCheckbox(Locators.CHECK_BOX_CONFIRMATION);
        }
    }

}
