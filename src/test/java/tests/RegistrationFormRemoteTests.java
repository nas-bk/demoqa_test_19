package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class RegistrationFormRemoteTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Tag("demoqa")
    @Test
    void fillFormTest() {
        step("Open form", () -> {
            registrationPage.openPage()
                    .removeFooter();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName("Nastya")
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
                    .setCity("Noida");
        });
        step("Submit form", () -> {
            registrationPage.submit();
        });
        step("Check form results", () -> {
            registrationPage.checkResult("Student Name", "Nastya Bochkareva")
                    .checkResult("Student Email", "test@mail.com")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "1234567899")
                    .checkResult("Date of Birth", "08 February,1994")
                    .checkResult("Subjects", "Computer Science")
                    .checkResult("Hobbies", "Music")
                    .checkResult("Picture", "testPicture.png")
                    .checkResult("Address", "Earth")
                    .checkResult("State and City", "NCR Noida");
        });
    }
}