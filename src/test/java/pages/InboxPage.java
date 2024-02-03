package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class InboxPage {

    private ElementsCollection lettersInInbox = $$x("//a[@tabindex='-1']");

    SelenideElement authorName = $x("//div[@class='letter__author']/span"),
            descriptionText = $x("//div[contains(text(),'example description')]"),
            letterSubject = $("h2.thread-subject");

    public String getAuthorName() {
        return authorName.getText();
    }

    public ElementsCollection getLetters() {
        return lettersInInbox;
    }

    public String getDescriptionText() {
        return descriptionText.getText();
    }

    public String getLetterSubject() {
        return letterSubject.getText();
    }

    public InboxPage clickLetterBySubjectText(String letterText) {
        $x("//span[contains(text(),'" + letterText + "')]").click();
        return this;
    }
}
