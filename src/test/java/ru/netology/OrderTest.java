package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrderTest {
    @Test
    public void fillingOutTheForm() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[name='name']").setValue("Петров-Водкин Василий");
        $("[name='phone']").setValue("+79003455555");
        $(byText("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй")).click();
        $(byText("Продолжить")).click();
        $("[data-test-id='order-success']").shouldHave(Condition.exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));


    }


}

