package OzonSelenide;
// В классе генерируется список книг и выбирается случайная книга
// Определяем локаторы для выбранной книги (Название книги, кнопка "В корзину", название книги в корзине)
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Books {

    private static List<SelenideElement> bookList = $$(byClassName("tile-wrapper"));
    private static Random random = new Random();
    private static SelenideElement getRandomBook = bookList.get(random.nextInt(bookList.size()));


    public static SelenideElement getRandomBookName() {
        return getRandomBook.$(byXpath(".//a[@data-test-id='tile-name']"));
    }

    public static SelenideElement getToCartButton() {
       return getRandomBook.$(byXpath(".//button[@class = 'buy-text-button ui-l ui-l9 ui-l4 ui-a ui-a4']"));
    }

    public static SelenideElement getBookInCartName() {
        return $(byXpath("//div[@class='cart-item__column m-main-block']/a/span"));
    }
}
