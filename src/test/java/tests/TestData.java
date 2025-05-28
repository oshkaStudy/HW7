package tests;

import static utils.RandomUtils.*;
import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String gender = getRandomGender();
    public static String number = faker.number().digits(10);
    public static String dayOfBirth = getRandomDateOfBirth();
    public static String monthOfBirth = getRandomMonthOfBirth();
    public static String yearOfBirth = getRandomYearOfBirth();
    public static String currentAddress = faker.address().streetAddress();
    public static String subject = getRandomSubject();
    public static String hobby = getRandomHobby();
    public static String picture = getRandomPicture();
    public static String state = getRandomState();
    public static String city = getRandomCityByState(state);

}
