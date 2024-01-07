import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy="eager";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#userName").setValue("David Courtney");
        $("#userEmail").setValue("dcscroot@gmail.com");
        $("#currentAddress").setValue("Some Address 1");
        $("#permanentAddress").setValue("Some Address 2");
        $("#submit").click();
        $("#output").shouldHave(text("David Courtney"), text("dcscroot@gmail.com"), text("Some Address 1"), text("Some Address 2"));
    }
}
