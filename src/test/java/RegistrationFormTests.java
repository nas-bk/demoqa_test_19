import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");

        $("#firstName").setValue("Nastya");
        $("#lastName").setValue("Bochkareva");
        $("#userEmail").setValue("test@mail.com");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567899");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--008").click();

        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();

        $("#uploadPicture").scrollTo();
        $("#uploadPicture").uploadFromClasspath("testPicture.png");

        $("#currentAddress").setValue("Earth");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        $(".table").shouldHave(text("Student Name Nastya Bochkareva"));
        $(".table").shouldHave(text("Student Email test@mail.com"));
        $(".table").shouldHave(text("Gender Female"));
        $(".table").shouldHave(text("Mobile 1234567899"));
        $(".table").shouldHave(text("Date of Birth 08 February,1994"));
        $(".table").shouldHave(text("Subjects Computer Science"));
        $(".table").shouldHave(text("Hobbies Music"));
        $(".table").shouldHave(text("Picture testPicture.png"));
        $(".table").shouldHave(text("Address Earth"));
        $(".table").shouldHave(text("State and City NCR Noida"));
    }
}
