package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    String formatDay,
            dayLocator;

    SelenideElement monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        formatDay = String.format("%03d", Integer.parseInt(day));
        dayLocator = String.format(".react-datepicker__day--%s:not(.react-datepicker__day--outside-month)", formatDay);

        yearInput.selectOption(year);
        monthInput.selectOption(month);
        $(dayLocator).click();
    }
}
