package UnionExample;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static UnionExample.Helpers.*;

@Epic("Функциональные тесты")
@Feature("Личный кабинет клиента")
public class SimpleTestsFour extends TestBaseUnion {

    Users user = new Users();

    @Story("Авторизация")
    @Description("Авторизоваться клиентом")
    @DisplayName("Проверка авторизации")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Данила Мастер")
    @Link(value = "Uxcrowd", url = "https://preprod.uxcrowd.ru/")
    @Test
    public void scenarioA1() {
        step("1.Открытие начальной страницы", () -> {
        stepOpenPage(
                "1.1 Открыть начальную страницу",
                "https://preprod.uxcrowd.ru/");
        });

        step("2. Авторизация", () -> {
            stepXpathClick(
                    "2.1 Нажать кнопку войти",
                    "//a[@id='header-lk-button']");
            stepXpathSendKeys(
                    "2.2 Ввести логин",
                    "//input[@id='login']",
                    user.login);
            stepXpathSendKeys(
                    "2.3 Ввести пароль",
                    "//input[@placeholder='Пароль']",
                    user.passWord);
            stepXpathClick("2.4 Нажать кнопку войти",
                    "//form[@id='form_auth']//button[@class='lk-enter-btn']");
        });

        step("3. Выход из личного кабинета", () -> {
           stepXpathClick(
                   "3.1 Нажать кнопку Выйти",
                   "//div[@class='settings_block ng-scope']//div[@id='logout']");
        });

    }

    @Story("Изменения данных клиента")
    @Description("Авторизоваться, перейти в профиль клиента, изменить ФИО и сохранить")
    @DisplayName("Проверка изменения ФИО клиента")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner(value = "Данила Мастер")
    @Link(value = "Uxcrowd", url = "https://preprod.uxcrowd.ru/")
    @Test
    public void scenarioB1() throws InterruptedException {
        step("1.Открытие начальной страницы", () ->{
            stepOpenPage(
                    "1.1 Открыть начальную страницу",
                    "https://preprod.uxcrowd.ru/");
        });

        step("2. Авторизация", () -> {
            stepXpathClick(
                    "2.1 Нажать кнопку войти",
                    "//a[@id='header-lk-button']");
            stepXpathSendKeys(
                    "2.2 Ввести логин",
                    "//input[@id='login']",
                    user.login);
            stepXpathSendKeys(
                    "2.3 Ввести пароль",
                    "//input[@placeholder='Пароль']",
                    user.passWord);
            stepXpathClick("2.4 Нажать кнопку войти",
                    "//form[@id='form_auth']//button[@class='lk-enter-btn']");
        });
        Thread.sleep(2000);
        step("3. Перейти в профиль клиента", () -> {
            stepXpathClick(
                    "3.1 Нажать на кнопку Профиль",
                    "//section[2]");
        });

        step("4. Изменение ФИО", () -> {
            stepXpathClear("4.1 Удалить старые ФИО",
                    "//div[@class='uxc_custom_input filled']//input[@name='fio']");
            stepXpathSendKeys("4.2 ВВести новые ФИО",
                    "//div[@class='uxc_custom_input']//input[@name='fio']",
                    "Пупкин Василий Петрович");
        });

        step("5. Сохранение профиля", () -> {
            stepXpathClick("5.1 Выбрать чекбокс Я принимаю Соглашение о конфиденциальности...",
                    "//form[@name='FL']//input[@class='ng-pristine ng-untouched ng-valid ng-empty']");
            stepXpathClick("5.2 Нажать кнопку Сохранить",
                    "//form[@name='FL']//button[@class='new-green-btn']");
        });

        step("6. Выход из личного кабинета", () -> {
            stepXpathClick(
                    "6.1 Нажать кнопку Выйти",
                    "//div[@class='settings_block ng-scope']//div[@id='logout']");
        });

    }


}
