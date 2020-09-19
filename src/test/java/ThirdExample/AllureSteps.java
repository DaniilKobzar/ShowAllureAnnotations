package ThirdExample;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllureSteps extends  TestBase {

    @Step("{stepName}")
    public void goToWebSite(String stepName) throws InterruptedException {
        open("https://preprod.uxcrowd.ru/");
        Thread.sleep(2000);
        attachScreenshot("foto");
    }

    @Step("{stepName}")
    public void authorization(String stepName) {
        $(byXpath("//a[@id='header-lk-button']")).click();
        $(byXpath("//input[@id='login']")).sendKeys("pflb.test1+28blfp+basic@gmail.com");
        $(byXpath("//input[@placeholder='Пароль']")).sendKeys("Qw123123");
        attachScreenshot("foto");
        $(byXpath("//form[@id='form_auth']//button[@class='lk-enter-btn']")).click();

    }

    @Step("{stepName}")
    public void goToProfile(String stepName) throws InterruptedException {
        Thread.sleep(2000);
        $(byXpath("//section[2]")).click();
        attachScreenshot("foto");
    }

    @Step("{stepName}")
    public void logOff(String stepName) throws InterruptedException {
        Thread.sleep(3000);
        $(byXpath("//div[@class='settings_block ng-scope']//div[@id='logout']")).click();
        Thread.sleep(3000);
    }

    @Step("{stepName}")
    public void changeFIO(String stepName) throws InterruptedException {
        $(byXpath("//div[@class='uxc_custom_input filled']//input[@name='fio']")).clear();
        $(byXpath("//div[@class='uxc_custom_input']//input[@name='fio']")).sendKeys("Ten Tests");
        Thread.sleep(2000);
        attachScreenshot("foto");
    }

    @Step("{stepName}")
    public void clickButtonSave(String stepName) throws InterruptedException {
        $(byXpath("//form[@name='FL']//button[@class='new-green-btn']")).scrollIntoView(true);
        $(byXpath("//form[@name='FL']//input[@class='ng-pristine ng-untouched ng-valid ng-empty']")).click();
        $(byXpath("//form[@name='FL']//button[@class='new-green-btn']")).click();
        Thread.sleep(2000);
        attachScreenshot("foto");
    }

}
