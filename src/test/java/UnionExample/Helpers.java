package UnionExample;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class Helpers {

    public static void stepXpathClick(String stepName, String Xpath) {
        step(stepName, () -> {
            $(byXpath(Xpath)).click();
        });
    }

    public static void stepXpathSendKeys(String stepName, String Xpath, String text) {
        step(stepName, () -> {
            $(byXpath(Xpath)).sendKeys(text);
        });
    }

    public static void stepXpathClear(String stepName, String Xpath) {
        step(stepName, () -> {
            $(byXpath(Xpath)).clear();
        });
    }

    public static void stepOpenPage(String stepName, String url) {
        step(stepName, () -> {
            open(url);
        });
    }

}
