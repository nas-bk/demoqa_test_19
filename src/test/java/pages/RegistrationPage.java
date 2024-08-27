package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultComponent tableResultComponent = new TableResultComponent();


    public RegistrationPage openPage() {
        step("Открываем главную страницу", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });

        return this;
    }

    public RegistrationPage removeFooter() {
        step("Отчистить footer", () -> {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        step("Ввести имя", () -> {
        firstNameInput.setValue(value);
        });
        return this;
    }

    public RegistrationPage setLastName(String value) {
        step("Ввести фамилию", () -> {
        lastNameInput.setValue(value);
        });

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        step("Ввести email", () -> {
        userEmailInput.setValue(value);
        });

        return this;
    }

    public RegistrationPage setGender(String value) {
        step("Установить гендер", () -> {
        genderWrapper.$(byText(value)).click();
        });

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        step("Ввести телефон", () -> {
        userNumberInput.setValue(value);
        });

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        step("Установить дату рождения", () -> {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        });

        return this;
    }

    public RegistrationPage setSubject(String value) {
        step("Выбрать предмет", () -> {
        subjectsInput.setValue(value).pressEnter();
        });

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        step("Выбрать хобби", () -> {
        hobbiesWrapper.$(byText(value)).click();
        });

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        step("Загрузить картинку", () -> {
        uploadPictureInput.uploadFromClasspath(value);
    });

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        step("Заполнить адрес", () -> {
        currentAddressInput.setValue(value);
        });

        return this;
    }

    public RegistrationPage setState(String value) {
        step("Выбрать Государство", () -> {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        });

        return this;
    }

    public RegistrationPage setCity(String value) {
        step("Выбрать город", () -> {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        });

        return this;
    }

    public RegistrationPage submit() {
        step("Нажать кнопку Отправить", () -> {
        submit.click();
        });

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        step("Проверка, что таблица содержит введеные данные", () -> {
        tableResultComponent.checkResultShouldHaveValue(key, value);
        });

        return this;
    }

    public RegistrationPage checkUserNumberHasError() {
        step("Проверить незаполненое обязательное поле должно иметь красный цвет", () -> {
        String rgbRedColor = "rgb(220, 53, 69)";
        userNumberInput.shouldHave(Condition.cssValue("border-color", rgbRedColor));
        });

        return this;
    }

    public RegistrationPage resultTableInvisible() {
        step("Проверить таблица результатов не открывается если не заполнены все обязательные поля", () -> {
        tableResultComponent.tableShouldBeInvisible();
        });

        return this;
    }

}
