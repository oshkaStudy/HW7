package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalComponent {

    private final SelenideElement
            modal = $(".modal-content"),
            modalContent = $(".table-responsive");

    public ResultModalComponent checkModalAppears() {
        modal.should(appear);
        return this;
    }
    public void checkModalDoNotAppears() {
        modal.shouldNotBe(visible);
    }
    public ResultModalComponent checkResult(String key, String value) {
        modalContent.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
