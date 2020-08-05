package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

class BrowserTester {

    @Test
    void yandexLocationPageShouldOpen() {
        // Открыть Yandex
        open("https://yandex.ru");

        // Нажать на название текущего местоположения
        $(".geolink__reg").click(); //обращение по XPath

        // Стереть данные из поля ввода "Город"
        $(".input__control").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); //обращение по имени класса

        // Вставить в поле ввода "Город" название города, отличного от текущего
        $(".input__control").setValue("Нячанг").pressEnter().pressEnter(); /* обращение по имени класса.
       Двойное нажатие на клавишу "Enter" вызвано отсутствием реакции ПО на одинарное нажатие.*/

        // Проверить изменение местоположения
        $(".geolink__reg").shouldHave(text("Нячанг")); //обращение по XPath
    }

    @Test
    void yahooBLMPageShouldOpen() {
        // Открыть Yahoo
        open("https://www.yahoo.com/");

        // Нажать на ссылку "Black Lives Matter"
        $(byText("Black Lives Matter")).click(); //обращение по содержимому атрибута

        // Проверить наличие фразы "Black Lives Matter" в поисковой строке
        $("[id='yschsp']").shouldHave(value("Black Lives Matter")); //обращение по идентификатору

        // Проверить наличие фразы "Black Lives Matter - News" в заголовке страницы
        $x("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3").shouldHave(text("Black Lives Matter - News")); //обращение по XPath
    }

    @Test
    void mailRuShouldShowErrorTitle() {
        // Открыть Mail.ru
        open("https://mail.ru/");

        // Нажать на ссылку "Забыли пароль?"
        $("[id='restore']").click(); //обращение по идентификатору

        switchTo().window(1);

        // Нажать кнопку "Продолжить"
        $("[data-test-id='submit-button']").click(); //обращение по кастомному атрибуту

        // Проверить наличие предупреждающей надписи "Укажите аккаунт" красного цвета
        $("[data-test-id='email-field-error-requiredEmail']").shouldHave(text("Укажите аккаунт")).shouldHave(cssValue("color",
                "rgba(255, 17, 0, 1)")); //обращение по кастомному атрибуту
        // Закрыть главную страницу Mail.ru для успешного прохождения последующих кейсов
        closeWindow();
    }

    @Test
    void bingScreanKeyboardShouldWork() {
        // Открыть Bing
        open("https://www.bing.com/");

        // Нажать на иконку "Поиск с помощью экранной клавиатуры"
        $("[id='vkeyIcon']").click(); //обращение по идентификатору

        // Нажать на кнопку "у" на экранной клавиатуре
        $("[id='key15']").click(); //обращение по идентификатору

        // Проверить наличие символа "у" в поисковой строке
        $("[id='sb_form_q']").shouldHave(value("у")); //обращение по идентификатору
    }

    @Test
    void birtualKeyboardShouldWork() {
        // Открыть DuckDuckGo
        open("https://duckduckgo.com/");

        // Нажать на кнопку "Добавить DuckDuckGo в Chrome"
        $(".badge-link__btn").click(); //обращение по имени класса

        switchTo().window(1);

        // Проверить наличие заголовка "Интернет-магазин Chrome"
        $(".PNF6le").shouldHave(text("Интернет-магазин Chrome")); //обращение по имени класса

        // Проверить наличие названия расширения "DuckDuckGo Privacy Essentials"
        $(".e-f-w").shouldHave(text("DuckDuckGo Privacy Essentials")); //обращение по имени класса
    }
}
