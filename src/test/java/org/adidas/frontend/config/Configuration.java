package org.adidas.frontend.config;

public class Configuration {
    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    //////////  Files   //////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    public static final String PURCHASE_LOG_FILE_PATH = "target/log/purchaseLog.txt";

    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    //////////  URLs    //////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    public static final String WEB_URL = "https://www.demoblaze.com/index.html";

    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    //////////  XPATHs  //////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////

    //****************************************************************
    // COMMON_PAGE
    //****************************************************************
    public static final String SECTION_LOCATOR = "//a[@class='nav-link' and contains(text(), '%s')]";

    //****************************************************************
    // HOME_PAGE
    //****************************************************************
    public static final String CATEGORY_LOCATOR = "//a[@id = 'itemc' and contains(text(), '%s')]";
    public static final String PRODUCT_LOCATOR = "//a[@class = 'hrefch' and contains(text(), '%s')]";

    //****************************************************************
    // PRODUCT_PAGE
    //****************************************************************
    public static final String ADD_TO_CART_LOCATOR = "//a[text() = 'Add to cart']";

    //****************************************************************
    // CART_PAGE
    //****************************************************************
    public static final String PRODUCT_LIST_LOCATOR = "//tr/td[2]";
    public static final String DELETE_LIST_LOCATOR = "//a[text() = 'Delete']";
    public static final String PLACE_ORDER_LOCATOR = "//button[text() = 'Place Order']";
    public static final String PLACE_ORDER_TEXT_LOCATOR = "//h5[@id = 'orderModalLabel']";
    public static final String CREDIT_CARD_INPUT_LOCATOR = "//input[@id = 'card']";
    public static final String MONTH_INPUT_LOCATOR = "//input[@id = 'month']";
    public static final String YEAR_INPUT_LOCATOR = "//input[@id = 'year']";
    public static final String NAME_INPUT_LOCATOR = "//input[@id = 'name']";
    public static final String COUNTRY_INPUT_LOCATOR = "//input[@id = 'country']";
    public static final String CITY_INPUT_LOCATOR = "//input[@id = 'city']";
    public static final String PURCHASE_ORDER_LOCATOR = "//button[text() = 'Purchase']";
    public static final String PURCHASE_LOCATOR = "//p[contains(@class, 'lead text-muted')]";
    public static final String TOTAL_AMOUNT_LOCATOR = "//label[@id = 'totalm']";
    public static final String OK_BUTTON_LOCATOR = "//button[text()='OK']";
}