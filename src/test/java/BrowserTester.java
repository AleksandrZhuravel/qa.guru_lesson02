package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class BrowserTester {
    @Test
    void selenideSearchTest() {
        // Открыть google
        open("https://google.com");

        // Ввести Selenide в поиск
        $(byName("q")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("ru.selenide.org"));
    }

    @Test
    void picturePageShouldOpen() {
        // Открыть google
        open("https://google.com");

        // Нажать вкладку "Картинки"
        $("[data-pid='2']").click(); //обращение по кастомному атрибуту

        // Проверить наличие заголовка "Картинки Google"
        $("[title='Картинки Google']").shouldBe(visible); //обращение по атрибуту
    }

    @Test
    void googleApplicationsPopupShouldOpen() {
        // Открыть google
        open("https://google.com");

        // Нажать на ссылку выпадающего списка "Приложения Google"
        $("#gbwa div a").click(); //обращение по CSS-селектору, полученному из XPath

        // Проверить видимость выпадающего списка "Приложения Google"
        $("#gb iframe").shouldBe(enabled); //обращение по CSS-селектору, полученному из XPath
    }

    @Test
    void yandexUnitFrameShouldOpen() {
        // Открыть yandex
        open("https://yandex.ru");

        // Нажать на ссылку "Настройка"
        $(byText("Настройка")).click(); //обращение по содержимому тега a

        // Нажать пункт "Настроить блоки"
        $(byText("Настроить блоки")).click(); //обращение по содержимому тега span

        $(".hidden-blocks-popup__inside").shouldBe(enabled); //обращение по имени класса
    }
}
