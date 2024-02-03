package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement mailboxButton = $("#mailbox"),
                            iFrameContent = $("#login-content"),
                            userNameField = $x("//input[@name='username']"),
                            nextButton = $x("//button[@data-test-id='next-button']"),
                            passwordField = $x("//input[@name='password']");
    public LoginPage openPage(String pageAddress) {
        open(pageAddress);
        return this;
    }
    public LoginPage clickMailBoxButton(String buttonName) {
        mailboxButton.$(byText(buttonName)).click();
        return this;
    }
    public LoginPage authByFrameFieldsFilling(String enterButtonName, String email, String password){
        switchTo().frame($("[src*='responsive=compact']"));
        iFrameContent.$(byText(enterButtonName)).shouldBe(visible);
        userNameField.setValue(email);
        nextButton.click();
        passwordField.setValue(password).pressEnter();
        switchTo().defaultContent();
        return this;
    }
}
