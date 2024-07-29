package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openPage()
                .setUserName("Rayne")
                .setUserEmail("Rayne@gmail.com")
                .setCurrentAddress("Street 1")
                .setPermanentAddress("Another street")
                .submit()
                .checkResult("name", "Rayne")
                .checkResult("email", "Rayne@gmail.com")
                .checkResult("currentAddress", "Street 1")
                .checkResult("permanentAddress", "Another street");
    }
}
