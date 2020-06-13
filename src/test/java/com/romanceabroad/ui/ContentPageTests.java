package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContentPageTests extends BaseUI {

    String currentUrlContent;

    @Test
    public void testLinkButtonHowWeWork() {
        contentPage.clickLinkContent();
        currentUrlContent = driver.getCurrentUrl();
        System.out.println(currentUrlContent);
        Assert.assertEquals(currentUrlContent, Data.expectedUrlContent);

    }


    @Test(dataProvider ="Contact Us",dataProviderClass = DataProviders.class)
    public void testContactUsPage(String yourName,String yourEmail) {
        contentPage.clickLinkContent();
        contentPage.clickLinkContactUs();
        contentPage.completeContactUsForm(Data.reason, yourName, yourEmail, Data.subject,
                Data.massage, Data.captcha);


    }

    String nameOfArticle;
    String titleOfArticles;
String currentUrl;
    @Test
    public void testArticlesAndTitles() {
        contentPage.clickLinkContent();
            driver.getCurrentUrl();
            currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl);
            Assert.assertEquals(currentUrl,Data.expectedUrlContent);
            contentPage.clickContentMenu();

       List<WebElement> linksOfArticles = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
        System.out.println(linksOfArticles.size());
        for (int i = 0; i < linksOfArticles.size(); i++) {
           contentPage.clickContentMenu();
            WebElement link=linksOfArticles.get(i);
            nameOfArticle = link.getText();

            mainPage.javaWaitSec(1);


           if (nameOfArticle.contains("How it works")) {
            } else if (nameOfArticle.contains("Kharkov dating agency")) {
            } else if (nameOfArticle.contains("Kiev dating agency")) {
            } else if (nameOfArticle.contains("Odessa dating agency")) {
            } else if (nameOfArticle.contains("Mail order girls")) {
            } else if (nameOfArticle.contains("Beautiful urkainian girls")) {
            } else if (nameOfArticle.contains("Real Ukrainian brides")) {
            } else if (nameOfArticle.contains("Eastern European women")) {
            } else if (nameOfArticle.contains("Marriage agency in Ukraine")) {
            } else if (nameOfArticle.contains("Kiev dating site")) {
            } else if (nameOfArticle.contains("Find Ukrainian girlfriend")) {
            } else if (nameOfArticle.contains("Slavic women for marriage")) {
            } else if (nameOfArticle.contains("How to marry Ukrainian lady")) {
            } else if (nameOfArticle.contains("Free Ukrainian dating site")) {
            } else if (nameOfArticle.contains("9 Factors to Keep in Mind When Dating a Ukrainian Woman")) {
            } else if (nameOfArticle.contains("Is There a Difference Between Dating or Courting a Ukrainian Woman?")) {

            } else {

                contentPage.ajaxClick(link);
                titleOfArticles = contentPage.getAnyTitle();
                Assert.assertEquals(nameOfArticle, titleOfArticles);
                contentPage.collectAllLinksOfArticles();

            }
            linksOfArticles=driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
        }

    }
    @Test
    public void testArticlesAndTitles1(){
        contentPage.clickLinkContent();
        driver.getCurrentUrl();
        currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertEquals(currentUrl,Data.expectedUrlContent);
        contentPage.clickContentMenu();

        List<WebElement> linksOfArticles = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
        System.out.println(linksOfArticles.size());
        for (int i = 0; i < linksOfArticles.size(); i++) {
            WebElement link = linksOfArticles.get(i);
            nameOfArticle = link.getText();
            contentPage.ajaxClick(link);
            contentPage.clickContentMenu();
            mainPage.javaWaitSec(1);
            titleOfArticles = contentPage.getAnyTitle();
            linksOfArticles = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
        }
    }
}

