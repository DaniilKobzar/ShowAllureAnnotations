package FirstExample;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class SimpleTests {

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
    }

    @AfterAll
    public static void setDown() {
        SelenideLogger.removeListener("Allure");
        closeWebDriver();

    }

    @AfterEach
    public void saveInfo() { attachScreenshot("Last"); }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] attachScreenshot(String attachName) {
        return((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @Test
    public void simpleTestOne() throws InterruptedException {
        open("https://preprod.uxcrowd.ru/");
        Thread.sleep(2000);
        $(byXpath("//a[@id='header-lk-button']")).click();
        $(byXpath("//input[@id='login']")).sendKeys("pflb.test1+28blfp+basic@gmail.com");
        Thread.sleep(2000);
        $(byXpath("//input[@placeholder='Пароль']")).sendKeys("Qw123123");
        Thread.sleep(2000);
        $(byXpath("//form[@id='form_auth']//button[@class='lk-enter-btn']")).click();
        Thread.sleep(2000);
        $(byXpath("//section[2]")).click();
        Thread.sleep(5000);
    }

}

