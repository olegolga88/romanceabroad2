package com.romanceabroad.ui;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BaseActions {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public static String generateNewNumber(String name, int length) {
        return name + RandomStringUtils.random(length, "1729847557");
    }

    public void getDropDownListByIndex(By locator, int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public void getDropDownListByText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }


    public void getDropDownListByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);

    }

    public void getDropDownListByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void getDropDownListByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


    public void getElementIsDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        boolean elementDisplayed = element.isDisplayed();
        if (element.isDisplayed()) {
            System.out.println(elementDisplayed + " " + "element is displayed");
        } else {
            System.out.println(elementDisplayed + " " + "element is not displayed");
        }
    }

    public void getTextString(By locator, String text) {
        driver.findElement(locator).getText();
        System.out.println(text);
    }

    public void getTextNumber(By locator, int number) {
        driver.findElement(locator).getText();
        System.out.println(number);
    }

    public void getClickByMouse(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void getBackStep() {
        driver.navigate().back();
    }

    public void ajaxClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    public void ajaxClick(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElement(by));
    }

    //Works very good with Chrome, Firefox, not IE
    public void ajaxClick(By by, int index) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElements(by).get(index));
    }

    //Works very good with IE
    public void performClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void performClick(By locator, int index) {
        WebElement element = driver.findElements(locator).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();


    }

    public void performClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void clickUnselectedCheckbox(By checkbox) {
        Reports.log("Create webelement for checkbox");
        WebElement currentCheckbox = driver.findElement(checkbox);
        Reports.log("Click checkbox confirmation");
        if (!currentCheckbox.isSelected()) {
            ajaxClick(currentCheckbox);
        }
    }

    // Scrolls
    public void scrollToBottomOfPage() {
        ((JavascriptExecutor)
                driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void ajaxScroll(WebElement element) {
        ((JavascriptExecutor)
                driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void ajaxScroll(By by, int index) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        ajaxScroll(driver.findElements(by).get(index));
    }

    public void ajaxScrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)", "");
    }

    public void javaWait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void javaWaitSec(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ajaxSendKeys(WebElement element, String text) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute( 'value', ' " + text + " ')", element);
    }

    //Method for random choice from DropDown list
    public void selectItemDropDownRandomOption(By locator, String dropDownName) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(driver.findElement(locator));
            select.selectByIndex((int) (Math.random() * (select.getOptions().size() - 1)) + 1);
            System.out.println(dropDownName + " : " + select.getFirstSelectedOption().getText());
        } catch (NoSuchElementException e) {
        }
    }


    public void checkLinksOnWebPage(String typeElement, String attribute) {
        List<WebElement> links = driver.findElements(By.xpath(typeElement));

        System.out.println("I start taking attributes on page");
        for (int i = 0; i < links.size(); i++) {
            WebElement ele = links.get(i);
            String url = ele.getAttribute(attribute);
            verifyLinkActive(url);

            System.out.println("Total links are" + links.size());

        }
    }

    //Method for link verification
    public void verifyLinkActive(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + "-" + httpURLConnect.getResponseMessage());
            } else if (httpURLConnect.getResponseCode() >= 400 && httpURLConnect.getResponseCode() <= 504) {
                System.out.println(linkUrl + "-" + httpURLConnect.getResponseMessage() + "-" + httpURLConnect.getResponseMessage());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSizeDropDownList(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(driver.findElement(locator));
            return select.getOptions().size();

        } catch (NoSuchElementException e) {
            System.out.println("getSizeDropDownList error");
        }
        return 0;
    }

    public void clickValueOfList(By locator, String text) {
        Reports.log("Collect elements of list");
        List<WebElement> elements = driver.findElements(locator);

        Reports.log("Start using loop with size of loop");
        for (int i = 0; i < elements.size(); i++) {

            Reports.log("Create new webelement of list");
            WebElement elementOfList = elements.get(i);

            Reports.log("Create new string with text from element of list ");
            String value = elementOfList.getText();
            Reports.log("Value of list:" + value);

            if (value.contains(text)) {
                Reports.log("Wait element list is clickable");
                wait.until(ExpectedConditions.elementToBeClickable(elementOfList));

                Reports.log("Click list of elements");
                elementOfList.click();
            }
        }
    }

    public String getAnyTitle() {
        String title = driver.findElement(Locators.H1_TITLE).getText();
        return title;
    }
//Algorithm for reverse word or phrase:
    public static void reverseWordByStringBuilder(String input) {
        StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(input);

        // reverse StringBuilder input1
        input1 = input1.reverse();

        // print reversed String
        System.out.println(input1);
    }

}





