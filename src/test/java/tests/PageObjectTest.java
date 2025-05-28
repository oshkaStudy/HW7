package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultModalComponent;

public class PageObjectTest extends TestBase {

    //Data
    String firstName = "Petr",
        lastName = "Petrov",
        email = "petr@test.com",
        gender = "Male",
        number = "8800555353",
        dayOfBirth = "26",
        monthOfBirth = "January",
        yearOfBirth = "1994",
        subject = "English",
        hobby = "Music",
        picture = "img.png",
        currentAddress = "Some street 1",
        state = "Uttar Pradesh",
        city = "Agra";

    //Вызов page-объектов
    RegistrationPage registrationPage = new RegistrationPage();
    ResultModalComponent resultModalComponent = new ResultModalComponent();


    //Все атрибуты, позитивный
    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        resultModalComponent
                .checkModalAppears()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);

    }

    //Минимальное количество атрибутов, позитивный
    @Test
    void fillFormMinimalAttributesTest() {

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .clickSubmit();

        resultModalComponent
                .checkModalAppears()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number);

    }

    //Негативный, отправка формы без части обязательных атрибутов
    @Test
    void fillFormNegativeTest() {

        registrationPage
                .openPage()
                .setUserNumber(number)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        resultModalComponent
                .checkModalDoNotAppears();

    }

}
