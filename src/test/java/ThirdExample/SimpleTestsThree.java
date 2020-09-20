package ThirdExample;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Epic("Функциональные тесты")
@Feature("Личный кабинет клиента")
public class SimpleTestsThree extends TestBase {
    AllureSteps step = new AllureSteps();


    @Story("Тест #1 Проверка авторизации")
    @Description("Авторизация")
    @DisplayName("Проверка авторизации")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void scenarioA() throws InterruptedException {
        step.goToWebSite("Шаг 1. Открытие начальной страницы");
        step.authorization("Шаг 2. Авторизация");
        step.logOff("Шаг 3. Выход из кабинета клиента");

    }

    @Story("Тест #2 Проверка изменения ФИО клиента")
    @Description("Авторизоваться, перейти в профиль клиента, изменить ФИО и сохранить")
    @DisplayName("Проверка изменения ФИО клиента")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void scenarioB() throws InterruptedException {
        step.goToWebSite("Шаг 1. Открытие начальной страницы");
        step.authorization("Шаг 2. Авторизация");
        step.goToProfile("Шаг 3. Переход в профиль клиента");
        step.changeFIO("Шаг 4. Изменение ФИО");
        step.clickButtonSave("Шаг 5. Сохранение профиля");
        step.logOff("Шаг 6. Выход из кабинета клиента");

    }

}
