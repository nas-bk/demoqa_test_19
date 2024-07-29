package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .removeFooter()
                .setFirstName("Nastya")
                .setLastName("Bochkareva")
                .setUserEmail("test@mail.com")
                .setGender("Female")
                .setUserNumber("1234567899")
                .setDateOfBirth("8", "February", "1994")
                .setSubject("Computer Science")
                .setHobbies("Music")
                .uploadPicture("testPicture.png")
                .setCurrentAddress("Earth")
                .setState("NCR")
                .setCity("Noida")
                .submit()
                .checkResult("Student Name", "Nastya Bochkareva")
                .checkResult("Student Email", "test@mail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567899")
                .checkResult("Date of Birth", "08 February,1994")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "testPicture.png")
                .checkResult("Address", "Earth")
                .checkResult("State and City", "NCR Noida");
    }

    @Test
    void fillRequiredFieldsTest() {
        registrationPage.openPage()
                .removeFooter()
                .setFirstName("Rayne")
                .setLastName("Brimstone")
                .setGender("Other")
                .setUserNumber("0000000000")
                .setDateOfBirth("30", "October", "2002")
                .submit()
                .checkResult("Student Name", "Rayne Brimstone")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "0000000000")
                .checkResult("Date of Birth", "30 October,2002");
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .removeFooter()
                .setFirstName("Rayne")
                .setLastName("Brimstone")
                .setGender("Other")
                .setUserNumber("000")
                .submit()
                .checkUserNumberHasError()
                .resultTableInvisible();
    }

}
