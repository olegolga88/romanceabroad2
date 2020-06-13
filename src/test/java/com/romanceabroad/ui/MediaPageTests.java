package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MediaPageTests extends BaseUI {
    String currentUrlMedia;
    String actualTitle;


    @Test
    public void testMediaPage() {
        mediaPage.clickMediaPageLink();
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);
        //Assert.assertEquals(currentUrlMedia, com.romanceabroad.ui.Data.expectedUrlMedia);
        softAssert.assertEquals(currentUrlMedia, Data.expectedUrlMedia, "Url is wrong");
        softAssert.assertAll();
    }

    @Test
    public void testListOfButtonsMedia() {
        mediaPage.clickMediaPageLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.LIST_OF_BUTTONS_MEDIA));
        List<WebElement> links = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        System.out.println(links.size());

        for (int i = 1; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();
            wait.until(ExpectedConditions.elementToBeClickable(Locators.LIST_OF_BUTTONS_MEDIA));
            links = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        }
    }


    @Test
    public void testUserTabs() {
        mediaPage.clickMediaPageLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
        List<WebElement> userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);

        actualTitle = mediaPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitleAllPhotos);
        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
            actualTitle = mediaPage.getAnyTitle();

            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideo);
            } else if (i == 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleAlbums);
            }
            userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        }
    }

    @Test
    public void testUserTabs1() {
        mediaPage.clickMediaPageLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
        List<WebElement> userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);

        actualTitle = mediaPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitleAllPhotos);
        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
            actualTitle = mediaPage.getAnyTitle();
            if (actualTitle.contains(Data.expectedTitleGallery) ||
                    actualTitle.contains(Data.expectedTitlePhotoGallery) ||
                    actualTitle.contains(Data.expectedTitleVideo) ||
                    actualTitle.contains(Data.expectedTitleAlbums)) {

                System.out.println("Title is valid: " + actualTitle);
            } else {
                Assert.fail("Title is not valid");
            }
            userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        }
    }

    @Test
    public void testUserTabs2() {
        mediaPage.clickMediaPageLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
        List<WebElement> userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);

        actualTitle = mediaPage.getAnyTitle();
        Assert.assertEquals(actualTitle, Data.expectedTitleAllPhotos);
        for (int i = 0; i < userTabs.size(); i++) {
            userTabs.get(i).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(Locators.TITLE_OF_PAGE));
            actualTitle = mediaPage.getAnyTitle();

            if (i == 0) {
                Assert.assertEquals(actualTitle, Data.expectedTitleGallery);
            } else if (i == 1) {
                Assert.assertEquals(actualTitle, Data.expectedTitlePhotoGallery);
            } else if (i == 2) {
                Assert.assertEquals(actualTitle, Data.expectedTitleVideo);
                // mediaPage.ajaxClick(By.xpath("//div[@class='g-flatty-block']"));
                String textMedia = driver.findElement(Locators.FLATTY_BLOCK_ALBUMS_MEDIA).getText();
                // System.out.println(textMedia);
                if (textMedia.contains(Data.textMedia)) {
                    System.out.println("Text media is correct!");
                }

            } else if (i == 3) {
                Assert.assertEquals(actualTitle, Data.expectedTitleAlbums);
                //mediaPage.ajaxClick(Locators.INNER_CONTENT_VIDEO_MEDIA);
                mediaPage.javaWaitSec(2);
                Assert.assertTrue(driver.findElement(Locators.ALBUMS_TITLE_IMAGES_MEDIA).isDisplayed());
            }
            userTabs = driver.findElements(Locators.LIST_OF_BUTTONS_MEDIA);
        }
    }

    @Test
    public void testUserTabsFooter() {
        mediaPage.clickMediaPageLink();
        mediaPage.ajaxScroll(Locators.FOOTER_MEDIA_PAGE, 4);
        List<WebElement> userFooter = driver.findElements(Locators.FOOTER_MEDIA_PAGE);

        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.FOOTER_MEDIA_PAGE));

        System.out.println(userFooter.size());
        for (int i = 0; i < userFooter.size()-1; i++) {
            String info=userFooter.get(i).getText();
           System.out.println(info);
            mediaPage.javaWaitSec(3);
            String getLink = userFooter.get(i).getAttribute("href");
            System.out.println(getLink+"!!!!!");
            mediaPage.ajaxClick(userFooter.get(i));
            wait.until(ExpectedConditions.elementToBeClickable(Locators.FOOTER_MEDIA_PAGE));
            if(!getLink.contains("news")){
            actualTitle = mediaPage.getAnyTitle();
            }
           if (i==0){
               Assert.assertEquals(actualTitle,Data.expectedTitleContactUsFooter);
            }else if(i==1){
               Assert.assertEquals(actualTitle,Data.expectedTitleSiteMapFooter);
            }else if(i==2){
               Assert.assertEquals(actualTitle,Data.expectedTitleHowItWorksFooter);
           }else if(i==4){
               Assert.assertEquals(actualTitle,Data.expectedTitlePolicyFooter);
           }else if(i==5){
               Assert.assertEquals(actualTitle,Data.expectedTitleTermsOfUseFooter);
           }

            userFooter = driver.findElements(Locators.FOOTER_MEDIA_PAGE);

        }}
    }


