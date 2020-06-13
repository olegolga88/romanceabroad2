package com.romanceabroad.ui;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class BaseUI {
    public WebDriver driver;
    WebDriverWait wait;
    public MainPage mainPage;
    SearchPage searchPage;
    BlogPage blogPage;
    BookTourPage bookTourPage;
    ContentPage contentPage;
    MediaPage mediaPage;
    StorePage storePage;
    SoftAssert softAssert= new SoftAssert();


    @BeforeMethod(groups = {"user","admin","ie"},alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser, Method method) throws MalformedURLException {
        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());
        // Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            // Create firefox instance
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        // Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            // Set path to chromedriver.exe
            WebDriverManager.chromedriver().setup();
            // Create chrome instance
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");
        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.manage().deleteAllCookies();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");
        }


        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        wait= new WebDriverWait(driver,20);
        mainPage = new MainPage (driver,wait);
        searchPage = new SearchPage(driver,wait);
        blogPage = new BlogPage(driver,wait);
        bookTourPage = new BookTourPage(driver,wait);
        storePage= new StorePage(driver,wait);
        contentPage= new ContentPage(driver,wait);
        mediaPage= new MediaPage(driver,wait);

        driver.manage() .window().maximize();
        driver.get(Data.mainUrl);


    }
    @AfterMethod
    public void afterActions(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE){
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();
        driver.quit();

    }



}
