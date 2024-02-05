package utils;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.title;

public class Helpers {
    public static void verifyPageTitle(String pageTitle){
        webdriver().shouldHave(title(pageTitle));
    }
}
