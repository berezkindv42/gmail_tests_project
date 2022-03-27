package tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class GmailTests {

    @Test
    void sendMailTest() {
        open("https://www.google.com/intl/ru/gmail/about/");

        $(".header").$(byText("Войти")).click();

        $("#identifierId").setValue("johnsmithtests64@gmail.com");
        $("#identifierNext").$(byText("Далее")).click();

        $("input[type='password']").setValue("gjstest1234");
        $("#passwordNext").$(byText("Далее")).click();

        $("img[class='gb_Aa gbii']").hover();
        $("div[class='gb_Ne']").shouldHave(text("John Smith"));

        $("div[class='z0']").$(byText("Написать")).click();
        $("textarea[name='to']").setValue("nightkonn@gmail.com");
        $("input[name='subjectbox']").setValue("Test mail");
        $("div[class='Am Al editable LW-avf tS-tW']").setValue("Test message");
        $("div[class='T-I J-J5-Ji aoO v7 T-I-atl L3']").click();

        $("div[class='TN bzz aHS-bnu']").click();
        $("div[class='aeF']").shouldHave(text("Test mail"));

        closeWebDriver();
    }

}
