package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogPageTests extends BaseUI {

String currentUrl;
    @Test
    public void listOfElements() {
        blogPage.clickLinkBlog();
        driver.getCurrentUrl();
        currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertEquals(currentUrl, Data.expectedUrlBlog);
        blogPage.clickBlogMenu();
        blogPage.testBlogPageListOfElements();




    }
    public static void main(String[] args) {
        String input = "Geeks for Geeks";
        BlogPage.reverseWordByStringBuilder(input);
    }

    }






