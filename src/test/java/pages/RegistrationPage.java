package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            subjectOption = $("#react-select-2-option-0"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateOption = $("#stateCity-wrapper"),
            city = $("#city"),
            cityOption = $("#stateCity-wrapper"),
            submitButton = $("#submit");;

    CalendarComponent calendarComponent = new CalendarComponent();

    public void tryToRemoveBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('iframe[id^=\"google_ads_iframe\"]').parent().parent().remove();");
        executeJavaScript("$('iframe[id^=\"google_ads_iframe\"]').remove();");
        executeJavaScript("$('div[id^=\"google_ads_iframe\"]').remove();");
        executeJavaScript("$('#cto_banner_content').remove()");
        executeJavaScript("$('#RightSide_Advertisement').parent().parent().remove()");
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text("Student Registration Form"));
        tryToRemoveBanners();
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value);
        subjectOption.click();
        return this;
    }
    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        tryToRemoveBanners();
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        state.click();
        stateOption.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        city.click();
        cityOption.$(byText(value)).click();
        return this;
    }
    public RegistrationPage clickSubmit() {
        tryToRemoveBanners();
        submitButton.click();
        return this;
    }

}
