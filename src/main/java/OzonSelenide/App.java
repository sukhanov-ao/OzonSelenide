package OzonSelenide;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "D:\\Programs\\chromedriver_win32\\chromedriver.exe");

        Configuration.startMaximized = true;
        Configuration.timeout = 6000;
        open(OzonHeader.URL);
        OzonHeader.CookieClose().click();

        OzonHeader.getCatalogMenu().click();
        OzonHeader.getBooks().hover();
        OzonHeader.getCategory().click();
        OzonCheckboxMenu.checkboxBestsellers().click();
        OzonCheckboxMenu.checkboxSoftwareLanguages().click();
        String randomBookName = Books.getRandomBookName().getText();
        Books.getToCartButton().click();

        if (Books.getToCartButton().isDisplayed()) {
            System.out.println("Книга " + randomBookName + " в корзину не добавлена.");
            close();
        } else {
            System.out.println("Книга " + randomBookName + " добавлена в корзину.");
            OzonHeader.getCart().click();
            String bookInCartName = Books.getBookInCartName().getText();
            if (randomBookName.equals(bookInCartName)) {
                System.out.println("Тест прошел успешно. Книги одинаковые: \n" + randomBookName + "\nи\n" + bookInCartName);
            } else {
                System.out.println("Упс... Что-то пошло не так. Выбранная книга " + randomBookName +
                        " отличается от книги в корзине: " +  bookInCartName);
            }
            close();
        }
    }
}