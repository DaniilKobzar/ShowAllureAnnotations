package SecondExample;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;




@Epic("Функциональные тесты")
@Feature("Личный кабинет клиента")
public class SimpleTestTwo {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
    }

    @AfterAll
    public static void setDown() { SelenideLogger.removeListener("Allure"); }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @AfterEach
    public void saveInfo() { attachScreenshot("Last"); }


    @Step("Открытие начальной страницы")
    public void goToWebSite() throws InterruptedException {
        open("https://preprod.uxcrowd.ru/");
        Thread.sleep(2000);
        attachScreenshot("foto");
    }

    @Step("Авторизация")
    public void authorization() {
        $(byXpath("//a[@id='header-lk-button']")).click();
        $(byXpath("//input[@id='login']")).sendKeys("pflb.test1+28blfp+basic@gmail.com");
        $(byXpath("//input[@placeholder='Пароль']")).sendKeys("Qw123123");
        attachScreenshot("foto");
        $(byXpath("//form[@id='form_auth']//button[@class='lk-enter-btn']")).click();

    }

    @Step("Переход в профиль клиента")
    public void goToProfile() throws InterruptedException {
        Thread.sleep(2000);
        $(byXpath("//section[2]")).click();
        attachScreenshot("foto");
    }

    @Step("Нажать кнопку выйти")
    public void logOff() throws InterruptedException {
        Thread.sleep(3000);
        $(byXpath("//div[@class='settings_block ng-scope']//div[@id='logout']")).click();
        Thread.sleep(3000);
    }

    @Story("Проверка перехода в профиль клиента")
    @Description("Авторизоваться и перейти в профиль клиента")
    @DisplayName("Проверка перехода в профиль клиента")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void scenarioA() throws InterruptedException {
        goToWebSite();
        authorization();
        goToProfile();
        logOff();
    }

    @Step("Изменение ФИО")
    public void changeFIO() throws InterruptedException {
        $(byXpath("//div[@class='uxc_custom_input filled']//input[@name='fio']")).clear();
        $(byXpath("//div[@class='uxc_custom_input']//input[@name='fio']")).sendKeys("Ten Tests");
        Thread.sleep(2000);
        attachScreenshot("foto");
    }

    @Step("Нажать кнопку \"Сохранить\"")
    public void clickButtonSave() throws InterruptedException {
        $(byXpath("//form[@name='FL']//button[@class='new-green-btn']")).scrollIntoView(true);
        $(byXpath("//form[@name='FL']//input[@class='ng-pristine ng-untouched ng-valid ng-empty']")).click();
        $(byXpath("//form[@name='FL']//button[@class='new-green-btn']")).click();
        Thread.sleep(2000);
        attachScreenshot("foto");
    }

    @Story("Проверка изменения ФИО")
    @Description("Авторизоваться, перейти в профиль клиента, изменить имя и сохранить")
    @DisplayName("Проверка изменения ФИО клиента")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void scenarioB() throws InterruptedException {
        goToWebSite();
        authorization();
        goToProfile();
        changeFIO();
        clickButtonSave();
        logOff();
    }


}
