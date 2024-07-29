package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

    SelenideElement tableInput = $(".table-responsive");

    public void checkResultShouldHaveValue(String key, String value) {
        tableInput.$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void tableShouldBeInvisible() {
        tableInput.shouldNotBe(visible);
    }

}
