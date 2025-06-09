package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultModalComponent;

@Tag("demoqa")
public class PageObjectTest extends TestBase {

    //Вызов page-объектов
    RegistrationPage registrationPage = new RegistrationPage();
    ResultModalComponent resultModalComponent = new ResultModalComponent();

    //Все атрибуты, позитивный
    @Test
    void fillFormTest() {

        TestData testData = new TestData();

        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.number)
                .setDateOfBirth(testData.dayOfBirth,
                        testData.monthOfBirth,
                        testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.picture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmit();

        resultModalComponent
                .checkModalAppears()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkResult("Date of Birth", testData.dayOfBirth +
                        " " + testData.monthOfBirth +
                        "," + testData.yearOfBirth)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);

    }

    //Минимальное количество атрибутов, позитивный
    @Test
    void fillFormMinimalAttributesTest() {

        TestData testData = new TestData();

        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.number)
                .clickSubmit();

        resultModalComponent
                .checkModalAppears()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number);

    }

    //Негативный, отправка формы без части обязательных атрибутов
    @Test
    void fillFormNegativeTest() {

        TestData testData = new TestData();

        registrationPage
                .openPage()
                .setUserNumber(testData.number)
                .setDateOfBirth(testData.dayOfBirth,
                        testData.monthOfBirth,
                        testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadPicture(testData.picture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmit();

        resultModalComponent
                .checkModalDoNotAppears();

    }

    //Задизейбленный тест
    @Test
    @Disabled("test disabled test")
    void disabledTest() {

        registrationPage
                .openPage();

    }

}
