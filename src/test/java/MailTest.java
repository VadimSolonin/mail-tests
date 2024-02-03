import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailTest extends TestBase {
    @Test
    public void test() {
        ElementsCollection letters = $$x("//a[@tabindex='-1']");
        open("https://mail.ru/");
        $("#mailbox").$(byText("Войти")).click();
        switchTo().frame($("[src*='responsive=compact']"));


        $("#login-content").$(byText("Войти в аккаунт")).shouldBe(visible);
        $x("//input[@name='username']").setValue("ivanpetrov_test1@mail.ru");
        $x("//button[@data-test-id='next-button']").click();
        $x("//input[@name='password']").setValue("UtIUI87ppcs(").pressEnter();
        switchTo().defaultContent();
        int size = letters.size();
        if (size > 0) {
            $x("//span[contains(text(),'sample letter')]").click();
            String text = $x("//div[@class='letter__author']/span").getText();
            String text2 = $x("//div[contains(text(),'example description')]").getText();
            String text3 = $("h2.thread-subject").getText();
            assertEquals("Солонин Вадим", text);
            assertEquals("example description", text2);
            assertEquals("sample letter", text3);
        }
    }
}
