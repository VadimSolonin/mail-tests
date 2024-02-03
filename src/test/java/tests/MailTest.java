package tests;

import exception.NoSuchLetterException;
import org.junit.jupiter.api.Test;
import pages.InboxPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    InboxPage inboxPage = new InboxPage();
    TestData testData = new TestData();

    @Test
    public void test() throws NoSuchLetterException {
        loginPage.openPage("");
        loginPage.clickMailBoxButton("Войти");
        loginPage.authByFrameFieldsFilling
                ("Войти в аккаунт",
                        testData.userEmail,
                        testData.userPassword);
        if (!inboxPage.getLetters().isEmpty()) {
            inboxPage.clickLetterBySubjectText(testData.letterSubject);
            assertEquals(testData.sender, inboxPage.getAuthorName());
            assertEquals(testData.letterDescription, inboxPage.getDescriptionText());
            assertEquals(testData.letterSubject, inboxPage.getLetterSubject());
        } else throw new NoSuchLetterException("Отсутствуют входящие письма");
    }
}
