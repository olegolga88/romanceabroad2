package com.romanceabroad.ui;

import org.openqa.selenium.By;


public class Locators {
public static final By H1_TITLE= By.xpath("//h1");
    //Photos Page
    public static final By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");
    public static final By BUTTON_ALL = By.xpath("//a[@href='https://romanceabroad.com/media/all']");
    public static final By BUTTON_PHOTO = By.xpath("//a[@href='https://romanceabroad.com/media/photo']");
    public static final By BUTTON_ALBUMS = By.xpath("//a[@href='https://romanceabroad.com/media/albums']");
    public static final By BUTTON_VIDEO = By.xpath("//a[@href='https://romanceabroad.com/media/video']");
    //public static final By LIST_OF_BUTTONS_MEDIA = By.xpath("//ul[@class='b-tabs']//li");
    public static final By LIST_OF_BUTTONS_MEDIA = By.xpath("//ul[@id='gallery_filters']//a");
public static final By FLATTY_BLOCK_ALBUMS_MEDIA = By.xpath("//div[@class='g-flatty-block']");
    public static final By ALBUMS_TITLE_IMAGES_MEDIA= By.xpath("//span[@data-click='album']");
    public static final By INNER_CONTENT_VIDEO_MEDIA= By.xpath("//div[@class='main-inner-content']");
////span[@id='gallery_media_sorter']//select[@class='form-control']
 public static final By FOOTER_MEDIA_PAGE=By.xpath("//li[@class='footer-menu-list-group-item']//a");


    // com.romanceabroad.ui.MainPage-Registration
    public static final By BUTTON_REGISTRATION = By.xpath("//button[@id='show-registration-block']");
    //public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static final By TEXT_FIELD_EMAIL = By.xpath("//input[@id='email']");
   // public static final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static final By TEXT_FIELD_PASSWORD = By.xpath("//input[@id='password']");

    public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By TEXT_FIELD_NICKNAME = By.cssSelector("#nickname");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    public static final By BUTTON_DAY_BIRTH_DATE_FIELD = By.cssSelector("#daySelect");
    public static final By DROP_DOWN_LIST_SELECT_DAY = By.xpath("//li[@data-handler='selectDay']");
    public static final By BUTTON_MONTH_BIRTH_DATE_FIELD = By.cssSelector("#monthSelect");
    public static final By DROP_DOWN_LIST_SELECT_MONTH = By.xpath("//li[@data-handler='selectMonth']");
    public static final By BUTTON_YEAR_BIRTH_DATE_FIELD = By.cssSelector("#yearSelect");
    public static final By DROP_DOWN_LIST_SELECT_YEAR = By.xpath("//li[@data-handler='selectYear']");
    public static final By AUTO_FILLING_FORM_LOCATION = By.xpath("//input[@name='region_name']");
    public static final By CHECK_BOX_CONFIRMATION = By.cssSelector("input#confirmation");
    public static final By LIST_VALUE_LOCATION = By.xpath("//div[@class='dropdown dropdown_location']//ul//li");
    public static final By TOOLTIP_ERROR_MESSAGE_EMAIL = By.xpath("//div[@class='tooltip']");

    //Main Page SignIn
    public static final By BUTTON_SIGN_IN_MAIN_PAGE= By.xpath("//a[@id='ajax_login_link']");
    public static final By TEXT_FIELD_EMAIL_SIGN_IN = By.xpath("//input[@name='email']");
    public static final By TEXT_FIELD_PASSWORD_SIGN_IN= By.xpath("//input[@name='password']");
    public static final By BUTTON_SIGN_IN= By.xpath("//button[@name='logbtn']");


    public static final By ERROR_MESSAGE_EMAIL_OR_PASSWORD_INCORRECT= By.xpath("//div[@class='error alert-danger alert-warning_pop_']");


    //Search Page
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By DROP_DOWN_LIST_MIN_AGE = By.xpath("//select[@id='age_min']");
    public static final By DROP_DOWN_LIST_MAX_AGE = By.xpath("//select[@id='age_max']");
    //public static final By DROP_DOWN_LIST_MAX_AGE = By.cssSelector("select#age_max");
    //public static final By DROP_DOWN_LIST_MIN_AGE = By.cssSelector("select#age_min");
    public static final By BUTTON_SEARCH = By.xpath("//input[@name='main_search_button']");
    public static final By BUTTON_GALLERY_VIEW = By.xpath("//a[@href='javascript:void(0);'][@title='Gallery view']");
    public static final By DROP_DOWN_LIST_BUTTON_MIN_AGE = By.xpath("//div[@class='col-xs-5 no-padding-left']//select[@id='age_min']");
    public static final By GIFT_BUTTON_SEARCH_PAGE = By.xpath("//div[@class='ssil1']//i");
    public static final By BUTTON_FIND_PEOPLE_SEARCH_PAGE = By.xpath("//header[@id='main-menu-container']//button[@id='main_search_button_user_line']");
    public static final By BUTTON_LOGIN_SEARCH_PAGE = By.xpath("//header[@id='main-menu-container']//a[@id='ajax_login_link']");
    public static final By BUTTON_HELP_FOOTER_SEARCH_PAGE = By.xpath("//footer//div//div[@data-id='footer-menu-title-0']");
    public static final By BUTTON_ABOUT_FOOTER_SEARCH_PAGE = By.xpath("//footer//div//div[@data-id='footer-menu-title-1']");
    public static final By INFO_ABOUT_USER = By.xpath("//div[@class='text-overflow']");


    //Main Page
    public static final By VIDEO_FIELD = By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final By VIDEO_BUTTON = By.xpath("//button[@class='ytp-large-play-button ytp-button']");
    public static final By LIST_OF_BUTTONS = By.xpath("//ul[@class='navbar-nav']//li/a");
    public static final By TITLE_OF_PAGE = By.xpath("//h1");
    public static final By IMAGES_ON_MEDIA_PAGE = By.xpath("//a[@class='g-pic-border g-rounded']");
    public static final By LINK_SIGN_IN = By.xpath("//a[@data-action='show-registration-block']");
    //com.romanceabroad.ui.StorePage
    public static final By LINK_STORE = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");


    //com.romanceabroad.ui.ContentPage HowItWorks
    public static final By LINK_CONTENT = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By ARTICLE_ADVERTISING_CONTENT_PAGE = By.xpath("//ul//li//a[@href='https://romanceabroad.com/content/view/advertising']");
    public static final By SLIDE_MENU_BUTTON_CONTENT_PAGE = By.xpath("//header[@id='main-menu-container']//a[@data-slidemenu='#slidemenu']");
public static final By CONTACT_US_BUTTON_FOOTER_FIELD= By.xpath("//a[@href='https://romanceabroad.com/tickets/']//div");
public static final By LIST_OF_ARTICLES_CONTENT_PAGE= By.xpath("//div[@class='col-xs-12 col-md-3']//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li");
    //    // com.romanceabroad.ui.BlogPage
    public static final By LINK_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    public static final By LEFT_MENU_BLOG_PAGE = By.xpath("//div[@class='inside account_menu']");
    public static final By LIST_OF_ELEMENTS_BLOG_PAGE = By.xpath("//div[@class='inside account_menu']//ul//li//a");

//BookTourTests

    public static final By LINK_BOOK_NOW = By.xpath("//a[@href='https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc']");


    //Contact Us Test
    public static final By BUTTON_DROP_DOWN_LIST_REASON_CONTACT_US = By.xpath("//select[@name='id_reason'] ");
    public static final By DROP_DOWN_LIST_REASON_CONTACT_US = By.xpath("//select[@name='id_reason']//option ");
    public static final By YOUR_NAME_FIELD_CONTACT_US = By.xpath("//input[@name='user_name']");
    public static final By EMAIL_FIELD_CONTACT_US = By.xpath("//input[@name='user_email']");
    public static final By SUBJECT_FIELD_CONTACT_US = By.xpath("//input[@name='subject']");
    public static final By MASSAGE_FIELD_CONTACT_US = By.xpath("//textarea[@name='message']");
public static final By SECURITY_CODE_FIELD_CONTACT_US= By.xpath("//input[@id='g-recaptcha-response']");
public static final By BUTTON_SEND_CONTACT_US=By.xpath("//input[@name='btn_save']");
}