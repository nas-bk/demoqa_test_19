package utils;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker(Locale.ENGLISH);

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String currentAddress = faker.address().fullAddress();
    public String gender = getGender();
    public String subjects = getSubject();
    public String hobbies = getHobbies();
    public String picture = "testPicture.png";

    public Date dateOfBirth = faker.date().birthday();
    public String dayOfBirth = RandomUtils.getDate(dateOfBirth);
    public String monthOfBirth = RandomUtils.getMonth(dateOfBirth);
    public String yearOfBirth = RandomUtils.getYear(dateOfBirth);

    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getCity();

    public String getCity() {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrit");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            default -> faker.options().option("Jaipur", "Jaiselmer");
        };
    }

    public String getGender() {
        String[] gender = {"Male", "Female", "Other"};

        return RandomUtils.getRandomItemFromArray(gender);
    }

    public String getSubject() {
        String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies", "Biology", "Physics", "Chemistry",
                "Computer Science", "Commerce", "Economics", "Civics", "Hindi", "English", "History"};

        return RandomUtils.getRandomItemFromArray(subjects);
    }

    public String getHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return RandomUtils.getRandomItemFromArray(hobbies);
    }

}
