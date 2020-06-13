package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BlogPage extends BaseActions {

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    String currentUrl;

    public void clickLinkBlog() {

        driver.findElement(Locators.LINK_BLOG).click();

    }
    public void testBlogPageListOfElements() {

        List<WebElement> links = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            ajaxClick(links.get(i));
            clickBlogMenu();
            links = driver.findElements(Locators.LIST_OF_ELEMENTS_BLOG_PAGE);


        }

    }
    public void clickBlogMenu(){
        ajaxClick(Locators.LEFT_MENU_BLOG_PAGE);
    }
}





