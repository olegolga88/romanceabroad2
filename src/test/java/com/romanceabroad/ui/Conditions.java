package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conditions extends BaseUI {
    @Test
    public void test() {
        String fruit = "orange";
        if (fruit.contains("kiwi")) {
            System.out.println("I found my fruit!");
        } else {
            System.out.println("I did not find my fruit");


        }
    }

    @Test
    public void test1() {
        int number = 10;
        int sum;
        if (number == 10 + 5) {
            sum = 95 + 100;
        } else {
            sum = 100 - 95;
            System.out.println(sum);
        }
    }

    @Test
    public void test3() {
        boolean requirement = false;
        if (!requirement) {
            System.out.println("Boolean is tru");
        } else {
            System.out.println("Boolean is false");
        }

    }

    /* @Test
     public void test4() {
         WebElement tabSearch = driver.findElement(com.romanceabroad.ui.Locators.LINK_SEARCH);
         if (tabSearch.getText().contains("PRETTY WOMEN")) {
             tabSearch.click();
         } else {
             Assert.fail("We can't find PRETTY WOMEN tab");
         }
     }
     @Test
     public void test5() {
         WebElement tabSearch = driver.findElement(com.romanceabroad.ui.Locators.LINK_SEARCH);
         if (tabSearch.isDisplayed()) {
             tabSearch.click();
         } else {
             Assert.fail("We can't find PRETTY WOMEN tab");
         }
     }
     @Test
     public void test6() {
         mainPage.clickJoinButton();
         mainPage.completeFirstPartOfRegistration();
         mainPage.completeSecondPartOfRegistration();
         WebElement checkbox=driver.findElement(com.romanceabroad.ui.Locators.CHECK_BOX_CONFIRMATION);
         if(!checkbox.isSelected()){
             checkbox.click();
             System.out.println("Checkbox is selected");
         }
     }
 */
    @Test
    public void test7() {
        List<String> cranchifyList1 = new ArrayList<String>(Arrays.asList("kiwi", "orange", "melon"));
        String element = cranchifyList1.get(0);
        System.out.println(element);

    }

    @Test
    public void test8() {
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        System.out.println(links.size());

        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            driver.get(Data.mainUrl);
            links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        }
    }
}
