package tests;

import static utils.RandomUtils.*;
import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = getRandomGender();
    public String number = faker.number().digits(10);
    public String dayOfBirth = getRandomDateOfBirth();
    public String monthOfBirth = getRandomMonthOfBirth();
    public String yearOfBirth = getRandomYearOfBirth();
    public String currentAddress = faker.address().streetAddress();
    public String subject = getRandomSubject();
    public String hobby = getRandomHobby();
    public String picture = getRandomPicture();
    public String state = getRandomState();
    public String city = getRandomCityByState(state);

}
