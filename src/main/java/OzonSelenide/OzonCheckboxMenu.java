package OzonSelenide;
// Тут описаны локаторы чекбоксов
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class OzonCheckboxMenu {

    public static SelenideElement checkboxBestsellers() {
        return $(byXpath("//div[@data-test-id = 'filter-block-isbest']"));
    }

    public static SelenideElement checkboxSoftwareLanguages() {
        return $(byXpath("//label[@data-test-id='filter-block-nonfictionbookgenre-item-135805']"));
    }
}