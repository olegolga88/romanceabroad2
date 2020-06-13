package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContentPage extends BaseActions {
    public ContentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickLinkContent() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LINK_CONTENT));
        driver.findElement(Locators.LINK_CONTENT).click();


    }

    public void clickLinkContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.CONTACT_US_BUTTON_FOOTER_FIELD));
        driver.findElement(Locators.CONTACT_US_BUTTON_FOOTER_FIELD).click();
    }

    public void completeContactUsForm(String reason, String yourName, String yourEmail,
                                      String subject, String massage, String captcha) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_DROP_DOWN_LIST_REASON_CONTACT_US));
        driver.findElement(Locators.BUTTON_DROP_DOWN_LIST_REASON_CONTACT_US).click();
        clickValueOfList(Locators.DROP_DOWN_LIST_REASON_CONTACT_US, reason);

        driver.findElement(Locators.YOUR_NAME_FIELD_CONTACT_US).sendKeys(yourName);
        driver.findElement(Locators.EMAIL_FIELD_CONTACT_US).sendKeys(yourEmail);
        driver.findElement(Locators.SUBJECT_FIELD_CONTACT_US).sendKeys(subject);
        driver.findElement(Locators.MASSAGE_FIELD_CONTACT_US).sendKeys(massage);
        driver.findElement(Locators.SECURITY_CODE_FIELD_CONTACT_US).sendKeys(captcha);
        driver.findElement(Locators.BUTTON_SEND_CONTACT_US).click();
    }

    public void clickContentMenu() {
        ajaxClick(Locators.LEFT_MENU_BLOG_PAGE);
    }

    public List<WebElement> collectAllLinksOfArticles() {

        List<WebElement> linksOfArticles = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
        for (int i = 0; i < linksOfArticles.size(); i++) {
            String info = linksOfArticles.get(i).getText();
            System.out.println(info);
            ajaxClick(linksOfArticles.get(i));
            clickContentMenu();
            linksOfArticles = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
        }

        return linksOfArticles;
    }
}