package com.romanceabroad.ui;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(VideoListener.class)

public class RegistrationTests extends BaseUI {

@Video(name ="Registration Test")
    @Test(dataProvider = "Registration", dataProviderClass = DataProviders.class)
    public void testRegistration(String email, String password, String day, String month,
                                 String year, String phone, String city, String location) {

    mainPage.clickJoinButton();
        mainPage.completeFirstPartOfRegistration(email, password);
        mainPage.clickNextButton();
        mainPage.completeSecondPartOfRegistration(mainPage.generateNewNumber(Data.nickname, 5), day,
                month, year, phone, city, location);
        mainPage.javaWaitSec(3);
        mainPage.clickUnselectedCheckbox(Locators.CHECK_BOX_CONFIRMATION);

        /*WebElement checkboxConfirmation= driver.findElement(com.romanceabroad.ui.Locators.CHECK_BOX_CONFIRMATION);
        if(!checkboxConfirmation.isSelected()){
            checkboxConfirmation.click();
            System.out.println("Checkbox is selected");
        }else {
            Assert.fail("Checkbox is already selected!");
        }*/
    }


}
